package com.github.nilstrieb.objxml.sampleclasses;

import java.util.Arrays;
import java.util.List;

public class CTestData {
    private String name;
    private List<String> list;

    public CTestData(String name, String ... list) {
        this.name = name;
        this.list = Arrays.asList(list);
    }
}
