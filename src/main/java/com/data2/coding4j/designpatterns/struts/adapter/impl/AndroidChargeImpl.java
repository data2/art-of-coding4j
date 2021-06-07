package com.data2.coding4j.designpatterns.struts.adapter.impl;

import com.data2.coding4j.designpatterns.struts.adapter.AndroidCharger;

public class AndroidChargeImpl implements AndroidCharger {

    @Override
    public void charge() {
        System.out.println("android 充电器 开始充电");

    }

}
