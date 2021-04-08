package com.data2.coding4j.designpatterns.struts.adapter;

public class Adapter implements AndroidCharger{
	
	private IosCharger iosCharger;
	
	public Adapter(IosCharger iosCharger) {
		this.iosCharger = iosCharger;
	}

	@Override
	public void charge() {
		iosCharger.charge();
		
	}

}
