package com.github.nilstrieb.objxml;

import com.github.nilstrieb.objxml.data.Group;
import com.github.nilstrieb.objxml.data.Value;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ObjXML {

    public String serializeObject(Object o) {
        Stream<String> fields = getRelevantFields(o)
                .map(f -> toValue(f, o)) //: Stream<Value>
                .map(Value::toString);//Stream<String>

        final StringBuilder sb = new StringBuilder();
        sb.append("<").append(o.getClass().getSimpleName()).append(">");
        fields.forEach(sb::append);
        sb.append("</").append(o.getClass().getSimpleName()).append(">");

        return sb.toString();
    }

    private Stream<Field> getRelevantFields(Object o) {
        Stream<Field> fields = Arrays.stream(o.getClass().getDeclaredFields());

        return fields.peek(f -> f.setAccessible(true))
                .filter(this::isTransient);
    }

    private boolean isTransient(Field f) {
        return !Modifier.isTransient(f.getModifiers());
    }

    private Object getValue(Field f, Object o) {
        try {
            return f.get(o);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Illegal Access", e);
        }
    }

    public Value toValue(Field f, Object o) {

        if (f.getType().isArray()) {
            return toGroupFromArray(f, o);
        }

        if (Collection.class.isAssignableFrom(f.getType())) {
            return toGroupFromList(f, o);
        }

        Object attribute = getValue(f, o);
        return new Value(f.getName(), attribute.toString());
    }

    private Group toGroupFromList(Field f, Object o) {
        Collection<?> attribute = (Collection<?>) getValue(f, o);
        return toGroupFromStream(f, attribute.stream());
    }

    private Group toGroupFromArray(Field f, Object o) {
        Object[] attribute = (Object[]) getValue(f, o);
        return toGroupFromStream(f, Arrays.stream(attribute));
    }

    private Group toGroupFromStream(Field f, Stream<?> stream) {
        List<Value> values = stream
                .map(e -> new Value("e", e.toString()))
                .collect(Collectors.toList());

        return new Group(f.getName(), values);
    }
}