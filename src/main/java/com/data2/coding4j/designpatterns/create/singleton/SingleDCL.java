package com.data2.coding4j.designpatterns.create.singleton;

public class SingleDCL {

    static SingleDCL singleDCL;

    private SingleDCL() {
    }

    //基本保证安全，但不能保证绝对安全，反射序列湖仍然可以生成对象
    public static SingleDCL getInstance() {
        if (singleDCL == null) {
            synchronized (SingleDCL.class) {
                if (singleDCL == null) {
                    singleDCL = new SingleDCL();
                }
            }
        }
        return singleDCL;
    }

}
