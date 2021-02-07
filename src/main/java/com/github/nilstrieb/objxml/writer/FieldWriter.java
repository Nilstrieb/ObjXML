package com.github.nilstrieb.objxml.writer;

import com.github.nilstrieb.objxml.data.Group;
import com.github.nilstrieb.objxml.data.Value;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class FieldWriter {

    public Group writeArray(Object[] arr, Field field) {
        List<Value> list = new ArrayList<>();

        for (Object o : arr) {
            list.add(new Value("e", o.toString()));
        }

        return new Group(field.getName(), list);
    }

    public Value writeCollection(Collection<Object> collection, Field f) {
        return writeArray(collection.toArray(), f);
    }

    public Value writeObject(Object o, String name) {
        return new Value(name, o.toString());
    }

    public String writeValue(Value value) {
        if (value instanceof Group) {
            return (((Group) value).toString(1));
        } else {
            return "\n\t" + value;
        }
    }
}
