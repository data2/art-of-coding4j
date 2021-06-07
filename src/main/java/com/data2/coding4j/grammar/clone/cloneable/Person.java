package com.data2.coding4j.grammar.clone.cloneable;

/**
 * Created by wanglei on 2018/9/19.
 */
public class Person implements Cloneable {
    int age;
    Address addr;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Address getAddr() {
        return addr;
    }

    public void setAddr(Address addr) {
        this.addr = addr;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Person person = (Person) super.clone();
        person.addr = (Address) this.addr.clone();
        return person;
    }
}