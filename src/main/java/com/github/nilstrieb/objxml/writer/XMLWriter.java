package com.github.nilstrieb.objxml.writer;

import com.github.nilstrieb.objxml.data.Value;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.stream.Stream;

public class XMLWriter {

    public String writeObject(Class<?> rootClass, Stream<Field> fields, Object object) {
        StringBuilder sb = new StringBuilder();
        FieldWriter fw = new FieldWriter();

        sb.append("<").append(rootClass.getSimpleName()).append(">");

        fields.forEach(f -> {
            try {

                Value fieldV;

                if (f.getType().isArray()) {
                    fieldV = fw.writeArray((Object[]) f.get(object), f);
                } else if (Collection.class.isAssignableFrom(f.getType())) {
                    fieldV = fw.writeCollection((Collection<Object>) f.get(object), f);
                } else {
                    fieldV = fw.writeObject(f.get(object), f.getName());
                }

                sb.append(fw.writeValue(fieldV));

            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        });

        sb.append("\n</").append(rootClass.getSimpleName()).append(">");

        return sb.toString();
    }
}
