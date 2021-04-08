package com.data2.coding4j.designpatterns.action.observer;
/**
 * jdk自带观察者模式
 */
import java.util.Observable;
import java.util.Observer;

public class Wolf extends Observable{

	public void bark() {
		System.out.println("wolf barking..");
		this.setChanged();
		this.notifyObservers();
	}
	
	
	public static void main(String[] args) {
		Wolf wolf = new Wolf();
		Sheet sheet1 = new Sheet("1");
		Sheet sheet2 = new Sheet("2");
		wolf.addObserver(sheet1);
		wolf.addObserver(sheet2);
		wolf.bark();
		wolf.deleteObserver(sheet2);
		wolf.bark();
	}

}

class Sheet implements Observer{

	private String name;
	
	public Sheet(String name) {
		this.name = name;
	}
	
	@Override
	public void update(Observable o, Object arg) {
		System.out.println("sheet " + name + " run ");
	}
	
} 
