package com.wdx.backstage.domain;

import lombok.Data;

@Data
public class Student {
    private Integer id;
    private String name;
    private Integer age;
    private String mouth;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", mouth='" + mouth + '\'' +
                '}';
    }
}