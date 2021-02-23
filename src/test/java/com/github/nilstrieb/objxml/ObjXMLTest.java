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
        ATestData a = new ATestData("hallo", 10, "strasse12");

        String expected = "<ATestData><name>hallo</name><age>10</age><adress>strasse12</adress></ATestData>";
        String actual = objXML.serializeObject(a);
        System.out.println(actual);
        assertEquals(expected, actual);
    }

    @Test
    void arrayField() {
        CTestData a = new CTestData("hallo", "1", "2", "3", "4");

        String expected = "<CTestData><name>hallo</name><list><e>1</e><e>2</e><e>3</e><e>4</e></list></CTestData>";
        String actual = objXML.serializeObject(a);
        System.out.println(actual);
        assertEquals(expected, actual);
    }

    @Test
    void listField() {
        DTestData a = new DTestData("hallo", "1", "2", "3", "4");

        String expected = "<DTestData><name>hallo</name><list><e>1</e><e>2</e><e>3</e><e>4</e></list></DTestData>";
        String actual = objXML.serializeObject(a);
        System.out.println(actual);
        assertEquals(expected, actual);
    }

}