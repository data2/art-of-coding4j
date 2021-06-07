package com.data2.coding4j.designpatterns.create.factorymethod;

interface PhoneFactory {
    Phone phone();
}

public class FactoryMethodModel {
    public static void main(String[] args) {
        PhoneFactory factory = new AppleFactory();
        Phone phone = factory.phone();
    }

}

class AppleFactory implements PhoneFactory {
    public Phone phone() {
        return new ApplePhone();
    }
}

class HuaweiFactory implements PhoneFactory {
    public Phone phone() {
        return new HuaweiPhone();
    }
}

class Phone {
}

class ApplePhone extends Phone {
}

class HuaweiPhone extends Phone {
}
