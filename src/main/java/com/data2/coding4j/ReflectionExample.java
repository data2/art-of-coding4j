package com.data2.coding4j;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionExample {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException {
        Field f = Obj.class.getDeclaredField("name");
        Field f2 = Obj.class.getDeclaredField("age");
        System.out.println(f.getName());

        Obj obj = Obj.class.newInstance();
        //f.set(obj,"wanglei");
        //System.out.println(obj.getName());//异常 没有权限访问private name

        f2.set(obj, "19");
        System.out.println(obj.getAge());

        Method m = Obj.class.getDeclaredMethod("setAge",String.class);
        m.invoke(obj, "20");
        System.out.println(obj.getAge());

        System.out.println(m.getReturnType());
    }
}

class Obj{
    private String name;
    public String age;

    public void setAge(String age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }
}
