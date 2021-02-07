package com.github.nilstrieb.objxml.writer;

import com.github.nilstrieb.objxml.sampleclasses.CTestData;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class XMLWriterTest {

    @Test
    void arrayTest(){
        assertDoesNotThrow(() -> {
            CTestData c = new CTestData("hallo", "a", "b", "c", "c");
            Stream<Field> fs = new ObjectReader().getFields(c.getClass());
            new XMLWriter().writeObject(c.getClass(), fs, c);
        });

    }

}