package com.github.nilstrieb.objxml.sampleclasses;

/**
 * Simple Test Data
 */
public class ATestData {
    private String name;
    private int age;
    private String adress;

    public ATestData() {
    }

    public ATestData(String name, int age, String adress) {
        this.name = name;
        this.age = age;
        this.adress = adress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }
}
