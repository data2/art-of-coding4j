package com.data2.coding4j;

/**
 * JAVA是值传递！
 * 方法的传参本质上就是赋值操作=
 *      如果是基本类型（包含包装类 自动拆箱）作为形参不改变实际参数
 *          基本类型（byte short int long float double boolean char）
 *      引用类型作为形参改变实际参数
 *          引用类型（对象引用 数组引用）
 */
public class MethodCallByValueExample {
    public static void main(String[] args) {
        Person person = new Person(19);
        test(person, 20);
    }

    public static void test(Person person, int age){
        System.out.println("小明去年"+person.age);
        person.age=age;
        System.out.println("小明今年"+person.age);
    }

    static class Person{
        int age ;
        public Person(int age){
            this.age = age;
        }
    }
}
