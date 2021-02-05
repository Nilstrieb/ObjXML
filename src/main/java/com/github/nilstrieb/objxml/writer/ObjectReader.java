package com.github.nilstrieb.objxml.writer;

import com.github.nilstrieb.objxml.data.Value;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Stream;

public class ObjectReader {

    public Stream<Field> getFields(Class<?> c) {
        Stream<Field> fields = Arrays.stream(c.getDeclaredFields());
        return fields
                .filter(f -> !Modifier.isTransient(f.getModifiers()))
                .peek(f -> f.setAccessible(true));
    }

    public Stream<Value> getValues(Object object) {
        Class<?> clazz = object.getClass();

        if (true) {

        }

        Stream<Field> fields = getFields(clazz);

        return fields.map(f -> {
            try {
                return new Value(f.getName(), String.valueOf(f.get(object)));
            } catch (IllegalAccessException e) {
                return null;
            }
        }).filter(Objects::nonNull);
    }
}