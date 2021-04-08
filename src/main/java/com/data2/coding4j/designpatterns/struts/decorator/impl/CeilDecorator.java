/**
 * FileName:   FloorDecorator.java
 * @Description TODO
 * All rights Reserved, Code by Muskteer
 * Copyright MuskteerAthos@gmail.com
 * @author MuskteerAthos
 */
package com.data2.coding4j.designpatterns.struts.decorator.impl;

import com.data2.coding4j.designpatterns.struts.decorator.Decorator;
import com.data2.coding4j.designpatterns.struts.decorator.HouseDecorator;

/**
 * @author wanglei
 *
 */
public class CeilDecorator extends HouseDecorator {
    Decorator decorator;
    public CeilDecorator(Decorator decorator) {
        this.decorator= decorator;
    }

    @Override
    public void decorate() {
        decorator.decorate();
        this.ceil();
    }

    private void ceil() {
        System.out.println("装修吊顶");
    }

}
