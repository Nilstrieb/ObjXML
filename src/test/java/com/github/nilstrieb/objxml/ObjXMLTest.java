package com.github.nilstrieb.objxml;

import com.github.nilstrieb.objxml.sampleclasses.ATestData;
import org.junit.jupiter.api.Test;

class ObjXMLTest {

    ObjXML objXML = new ObjXML();

    @Test
    void simpleTest() {
        ATestData a = new ATestData("f", 10, "hallo");
        System.out.println(objXML.toXML(a));
    }
}