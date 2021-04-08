/**
 * FileName:   MyArrayList.java
 * @Description TODO
 * All rights Reserved, Code by Muskteer
 * Copyright MuskteerAthos@gmail.com
 * @author MuskteerAthos
 */
package com.data2.coding4j.datastructure.list;

public class MyArrayList {
    
    public static final int INITIAL_CAPACITY = 16;
    Object[] data = new Object[INITIAL_CAPACITY];
    int size = 0;
    
    public MyArrayList() {}
    
    public MyArrayList(Object[] objects){
        data = objects;
        size = objects.length;
    }
    
    public void add(int index, Object object) {
        ensureCapacity();
        
        for(int i = size - 1; i >= index; i-- ){
            data[i+1] = data[i];
        }
        
        data[index] = object;
        size++;
    }

    private void ensureCapacity() {
        if(size > data.length){
            Object[] newdata = new Object[data.length * 2];
            System.arraycopy(data, 0, newdata, 0, data.length);
            data = newdata;
        }
        
    }
    
    public void clear() {
        data = new Object[INITIAL_CAPACITY];
    }
    
    public Object get(int index) {
        return data[index];
    }
    
    public void remove(Object object){
        for(int i = 0; i < size ; i++){
            if(object.equals(data[i])){
                for(int j = i; j < size - 1; j++){
                    data[j] = data[j+1];
                }
                size --;
            }
        }
    }
    
    public void remove(int index){
        for (int j = index; j < size - 1; j++) {
            data[j] = data[j + 1];
        }
        size--;
    }
    
}
