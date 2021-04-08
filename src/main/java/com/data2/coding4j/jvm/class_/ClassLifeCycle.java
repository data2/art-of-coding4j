/**
 * FileName:   ClassLifeCycle.java
 * @Description 类的生命周期  初始化
 * All rights Reserved, Code by Muskteer
 * Copyright MuskteerAthos@gmail.com
 * @author MuskteerAthos
 */
package com.data2.coding4j.jvm.class_;

import org.junit.Test;

public class ClassLifeCycle {

    /**
     * 解析阶段是虚拟机常量池内的符号引用替换为直接引用的过程。<br/>
     * 
     * static 变量发生在静态解析阶段，也即是初始化之前，此时已经将字段的符号引用转化为了内存引用，也便将它与对应的类关联在了一起，<br/>
     * 由于在子类中没有查找到与 m 相匹配的字段，那么 m 便不会与子类关联在一起，因此并不会触发子类的初始化。<br/>
     * <hr/>
     * 加载、验证、准备和初始化这四个阶段发生的顺序是确定的，而解析阶段则不一定，它在某些情况下可以在初始化阶段之后开始，这是为了支持 Java
     * 语言的运行时绑定（也成为动态绑定或晚期绑定）。
     */
    @Test
    public void parseField() {
        System.out.println(Child.m);
    }

}

class Super {
    public static int m = 11;
    static {
        System.out.println("执行了super类静态语句块");
    }
}

class Father extends Super {
    public static int m = 33;
    static {
        System.out.println("执行了父类静态语句块");
    }
}

class Child extends Father {
    static {
        System.out.println("执行了子类静态语句块");
    }
}
