package com.github.nilstrieb.objxml;

import com.github.nilstrieb.objxml.data.Value;
import com.github.nilstrieb.objxml.writer.ObjectReader;
import com.github.nilstrieb.objxml.writer.XMLWriter;

import java.util.stream.Stream;

public class ObjXML {

    private ObjectReader reader = new ObjectReader();
    private XMLWriter xw = new XMLWriter();

    public String toXML(Object o){
        Stream<Value> values = reader.getValues(o);
        return xw.writeObject(o.getClass().getSimpleName(), values);
    }
}