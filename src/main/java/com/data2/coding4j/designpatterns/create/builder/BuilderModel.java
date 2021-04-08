package com.data2.coding4j.designpatterns.create.builder;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

public class BuilderModel {
    public static void main(String[] args) {
        Builder builder = new PcBuilder();
        builder.buildCpu();
        builder.buildKeybard();
        Director director = new Director(builder);
        Pc pc = director.getPc();

        Cache<Object, Object> cache = CacheBuilder
                .newBuilder()
                .maximumSize(10)
                .build();
    }
}
class Pc{
    String cpu;
    String keybard;
}
abstract class Builder{
    abstract void buildCpu();
    abstract void buildKeybard();
    abstract Pc getPc();
}
class PcBuilder extends Builder{
    Pc pc = new Pc();
    public void buildCpu(){}
    public void buildKeybard(){}
    public Pc getPc() { return pc;}
}
class Director{
    Builder builder;

    public Director (Builder builder) {
        this.builder = builder;
    }

    Pc getPc(){
        return builder.getPc();
    }
}


