package com.github.nilstrieb.objxml.writer;


import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.stream.Stream;

public class ObjectReader {

    public Stream<Field> getFields(Class<?> c) {
        Stream<Field> fields = Arrays.stream(c.getDeclaredFields());
        return fields
                .filter(f -> !Modifier.isTransient(f.getModifiers()))
                .peek(f -> f.setAccessible(true));
    }
}