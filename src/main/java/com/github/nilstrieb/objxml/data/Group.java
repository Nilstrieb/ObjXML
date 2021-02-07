package com.github.nilstrieb.objxml.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Group extends Value {
    private final List<Value> values;

    public Group(String name, List<Value> values) {
        super(name, "");
        this.values = new ArrayList<Value>(values);
    }

    public List<Value> getValues() {
        return values;
    }

    public String toString(int i) {
        StringBuilder sb = new StringBuilder();
        //first line <name>
        sb.append("\n").append(t(i)).append("<").append(getName()).append(">");

        //group members
        for (Value value : values) {
            sb.append("\n").append(t(i + 1)).append(value);
        }

        //last line </name>
        sb.append("\n").append(t(i)).append("</").append(getName()).append(">");

        return sb.toString();
    }

    private String t(int indent){
        return "\t".repeat(indent);
    }
}