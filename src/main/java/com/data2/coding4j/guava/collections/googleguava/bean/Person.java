package com.data2.coding4j.guava.collections.googleguava.bean;

/**
 * Created by wanglei on 2016/10/10.
 */
public class Person {
    private Integer id;
    private String name;
    private String sex;

    public Person(Integer id) {
        this.id = id;
    }

    public Person(Integer id, String name, String sex) {
        this.id = id;
        this.name = name;
        this.sex = sex;
    }

    public Person() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
