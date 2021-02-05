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


    @Test
    void getValuesTest() {
        ATestData a = new ATestData("f", 10, "hallo");
        Stream<Value> values = reader.getValues(a);
        Value[] expected = {new Value("name", "f"), new Value("age", "10"), new Value("adress", "hallo")};
        Object[] actual = values.toArray();

        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], actual[i]);
        }
    }
}