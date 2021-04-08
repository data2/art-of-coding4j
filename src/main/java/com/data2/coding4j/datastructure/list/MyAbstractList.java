/**
 * FileName:   MyAbstractList.java
 * @Description TODO
 * All rights Reserved, Code by Muskteer
 * Copyright MuskteerAthos@gmail.com
 * @author MuskteerAthos
 */
package com.data2.coding4j.datastructure.list;

public abstract class MyAbstractList implements MyList {
    protected int size;

    protected MyAbstractList() {
    }

    protected MyAbstractList(Object[] objects) {
        for (int i = 0; i < objects.length; i++) {
            this.add(objects[i]);
        }
    }

    @Override
    public void add(Object o) {
        add(size,o);
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }
}
