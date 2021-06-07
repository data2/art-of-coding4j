package com.data2.coding4j;

/**
 * 对象创建初始化顺序
 * <p>
 * 1、父类静态代码
 * 2、子类静态代码
 * 3、父类非静态代码块
 * 4、父类默认构造器
 * 5、子类非静态代码块
 * 6、子类有参、无参构造器
 */
public class ObjectInitOrder {
    public static void main(String[] args) {
        new S();
    }
}

class F {
    static int age = 60;

    static {
        System.out.println("父母结婚");
    }

    {
        System.out.println("父母喝了红酒");
    }

    public F() {
        System.out.println("父母嘿嘿嘿");
    }
}

class S extends F {
    static {
        System.out.println("提前给小孩子买了床");
    }

    {
        System.out.println("妈妈怀孕了");
    }

    public S() {
        System.out.println("小孩出生了");
    }
}
