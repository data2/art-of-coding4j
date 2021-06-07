package com.data2.coding4j.designpatterns.create.abstractfactory;

public class AbstractFactoryModel {
    public static void main(String[] args) {
        ElectricFactory factory = new HuaweiFactory();
        Phone phone = factory.phone();
        Pc pc = factory.pc();
    }
}

abstract class ElectricFactory {
    abstract Phone phone();

    abstract Pc pc();
}

class HuaweiFactory extends ElectricFactory {
    @Override
    public Phone phone() {
        return new HuaweiPhone();
    }

    public Pc pc() {
        return new HuaweiPc();
    }
}

class AppleFactory extends ElectricFactory {
    @Override
    public Phone phone() {
        return new ApplePhone();
    }

    public Pc pc() {
        return new ApplePc();
    }
}

class Phone {
}

class HuaweiPhone extends Phone {
}

class ApplePhone extends Phone {
}

class Pc {
}

class HuaweiPc extends Pc {
}

class ApplePc extends Pc {
}
