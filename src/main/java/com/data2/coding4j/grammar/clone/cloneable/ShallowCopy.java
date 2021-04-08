package com.data2.coding4j.grammar.clone.cloneable;

/**
 * Created by wanglei on 2018/9/19.
 */

public class ShallowCopy {
    public static void main(String[] args) throws CloneNotSupportedException {
        Person person = new Person();
        person.setAddr(new Address("bj"));
        person.setAge(20);

        //person2是北京人
        Person person2 = (Person) person.clone();

        //person迁户口到南京了
        person.getAddr().setAddr("nj");

        System.out.println(person2.getAddr().getAddr());

        //两个人引用address没有被深层复制，出问题了

    }

}
