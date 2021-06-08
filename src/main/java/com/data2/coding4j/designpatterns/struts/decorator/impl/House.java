/**
 * FileName:   House.java
 *
 * @Description TODO
 * All rights Reserved, Code by Muskteer
 * Copyright MuskteerAthos@gmail.com
 * @author MuskteerAthos
 */
package com.data2.coding4j.designpatterns.struts.decorator.impl;

import com.data2.coding4j.designpatterns.struts.decorator.Decorator;

/**
 * @author wanglei
 */
public class House implements Decorator {

    @Override
    public void decorate() {
        System.out.println("房子的基本装修");
    }


}
