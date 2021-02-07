package com.github.nilstrieb.objxml.writer;

import com.github.nilstrieb.objxml.data.Value;
import com.github.nilstrieb.objxml.sampleclasses.ATestData;
import com.github.nilstrieb.objxml.sampleclasses.BTestData;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ObjectReaderTest {

    static ObjectReader reader = new ObjectReader();

    @Test
    void collectFields() {
        Stream<Field> f = reader.getFields(ATestData.class);
        assertEquals(3, f.count());
    }

    @Test
    void ignoreTransient() {
        Stream<Field> f = reader.getFields(BTestData.class);
        assertEquals(2, f.count());
    }
}