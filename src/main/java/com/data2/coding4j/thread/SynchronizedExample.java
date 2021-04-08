package com.data2.coding4j.thread;

public class SynchronizedExample {

    public static void main(String[] args) {
        //synchronized可以对实例对象（实例方法）和类对象（静态方法）修饰
        Person person = new Person("小一");
        synchronized (person){
            person.setName("小二");
            person.getName();
        }
        person.setName("小二");

    }
}

class Person{
    String name;

    public synchronized void setName(String name) {
        this.name = name;
    }

    public Person(String name){
        this.name = name;
    }

    public void getName(){
        System.out.println(name);
    }
}


