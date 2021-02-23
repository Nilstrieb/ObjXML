package com.github.nilstrieb.objxml;

import com.github.nilstrieb.objxml.sampleclasses.ATestData;
import com.github.nilstrieb.objxml.sampleclasses.CTestData;
import com.github.nilstrieb.objxml.sampleclasses.DTestData;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ObjXMLTest {

    ObjXML objXML = new ObjXML();

    @Test
    void simpleObject() {
        ATestData a = new ATestData("hallo", 10, "klar");

        assertEquals("<ATestData><name>hallo</name><age>10</age><adress>klar</adress></ATestData>",
                objXML.parseObject(a));
    }

}