package com.data2.coding4j.grammar.extend;

public class SuperTest {

    @org.junit.Test
    public void Test() {
        SubClassA a = new SubClassA();
        Super superClass = a;
        superClass.execute();
    }
}

class Super {
    private int i = 10;

    public void execute() {
        System.out.println(i);
    }

    public int getI() {
        return i;
    }
}

class SubClassA extends Super {
    private int i = 20;

    public void execute() {
        System.out.println(i);
    }

    public int getI() {
        return i;
    }
}

class SubClassB extends Super {
    private int i = 30;

    public void execute() {
        System.out.println(i);
    }
}