package com.example.demo;

import java.io.Serializable;

public class Pet implements Serializable {
    private int age;

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

}
