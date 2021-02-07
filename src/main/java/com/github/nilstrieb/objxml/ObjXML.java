package com.github.nilstrieb.objxml;

import com.github.nilstrieb.objxml.data.Value;
import com.github.nilstrieb.objxml.writer.ObjectReader;
import com.github.nilstrieb.objxml.writer.XMLWriter;

import java.lang.reflect.Field;
import java.util.stream.Stream;

public class ObjXML {

    private ObjectReader reader = new ObjectReader();
    private XMLWriter xw = new XMLWriter();

    public String toXML(Object o){
        Stream<Field> fields = reader.getFields(o.getClass());
        return xw.writeObject(o.getClass(), fields, o);
    }
}