package com.github.nilstrieb.objxml.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Group extends Value {
    private final List<Value> values;

    public Group(String name, Value ... values) {
        super(name, "");
        this.values = new ArrayList<>(Arrays.asList(values));
    }

    public List<Value> getValues() {
        return values;
    }
}
