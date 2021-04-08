package com.data2.coding4j;

public class CloneExample {
    public static void main(String[] args) throws CloneNotSupportedException {
        Person p1 = new Person();
        p1.addr = new Address("bj");
        p1.name = "p1";

        Person p2 = p1.clone();
        System.out.println(p2.name);
        System.out.println(p2.addr.city);
    }
}

class Person implements Cloneable{
    String name;
    Address addr;
    public Person clone() throws CloneNotSupportedException {
        Person person = (Person) super.clone();
        person.addr = this.addr.clone();
        return person;
    }
}
class Address implements Cloneable{
    String city;
    public Address(String city){
        this.city = city;
    }
    public Address clone() throws CloneNotSupportedException {
        return (Address) super.clone();
    }
}
