package com.data2.coding4j.grammar.clone.cloneable;

/**
 * Created by wanglei on 2018/9/19.
 */
public class DeepCopy {
    public static void main(String[] args) throws CloneNotSupportedException {
        Person person = new Person();
        person.setAddr(new Address("bj"));
        person.setAge(20);

        //person2是北京人
        Person person2 = (Person) person.clone();

        //person迁户口到南京了
        person.getAddr().setAddr("nj");

        System.out.println(person2.getAddr().getAddr());

        //此时Person中的基本类型值拷贝，引用类型也进行了重写克隆方法，是深拷贝，不会出现问题
        // person2还是bj人。

    }

}
