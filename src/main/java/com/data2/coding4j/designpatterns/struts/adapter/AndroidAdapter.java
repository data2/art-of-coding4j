package com.data2.coding4j.designpatterns.struts.adapter;

/**
 * @author data2
 */
public class AndroidAdapter implements AndroidCharger {

    private IosCharger iosCharger;

    public AndroidAdapter(IosCharger iosCharger) {
        this.iosCharger = iosCharger;
    }

    @Override
    public void charge() {
        iosCharger.charge();
    }

}
