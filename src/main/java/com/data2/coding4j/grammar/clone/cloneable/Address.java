package com.data2.coding4j.grammar.clone.cloneable;

/**
 * Created by wanglei on 2018/9/19.
 */
public class Address implements Cloneable{
    String addr;

    public Address(String addr) {
        this.addr = addr;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}