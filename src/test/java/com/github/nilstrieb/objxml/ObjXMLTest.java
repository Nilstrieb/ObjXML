package com.github.nilstrieb.objxml;

import com.github.nilstrieb.objxml.sampleclasses.ATestData;
import com.github.nilstrieb.objxml.sampleclasses.CTestData;
import com.github.nilstrieb.objxml.sampleclasses.DTestData;
import org.junit.jupiter.api.Test;

class ObjXMLTest {

    ObjXML objXML = new ObjXML();

    @Test
    void simpleTest() {
        ATestData a = new ATestData("f", 10, "hallo");
        System.out.println(objXML.toXML(a));
    }

    @Test
    void arrayTest() {
        CTestData a = new CTestData("f", "a", "b", "c", "d");
        System.out.println(objXML.toXML(a));
    }

    @Test
    void listTest() {
        DTestData a = new DTestData("f", "a", "b", "c", "d");
        System.out.println(objXML.toXML(a));
    }
}