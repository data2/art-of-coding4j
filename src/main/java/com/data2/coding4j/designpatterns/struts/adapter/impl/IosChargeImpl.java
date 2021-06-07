package com.data2.coding4j.designpatterns.struts.adapter.impl;

import com.data2.coding4j.designpatterns.struts.adapter.IosCharger;

public class IosChargeImpl implements IosCharger {

    @Override
    public void charge() {
        System.out.println("ios 充电器开始充电");

    }

}
