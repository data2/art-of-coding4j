package com.data2.coding4j.guava.collections.googleguava;

import com.data2.coding4j.guava.collections.googleguava.bean.Person;
import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.data2.coding4j.guava.collections.ParentCollection;

import org.junit.Test;

import java.util.List;
import java.util.Map;

/**
 * Created by wanglei on 2016/10/10.
 * ---------------函数式编程---------------
 * JDK8之前Java是不能使用函数式编程的，但是Guava给予了我们这样的能力。
 * JDK7，Java 中也只能通过笨拙冗长的匿名类来达到近似函数式编程的效果。
 */
public class FunctionProgram extends ParentCollection {

    @Test
    public void test() {
        //数据模型中抽取部分数据
        //map function
        Map<Integer, Person> sourceMap = Maps.newHashMap();
        Person p = new Person(1, "Wang", "man");
        Person p2 = new Person(2, "Zhang", "woman");
        sourceMap.put(p.getId(), p);
        sourceMap.put(p2.getId(), p2);
        @SuppressWarnings("unused")
        Map<?, String> trans = Maps.transformValues(sourceMap, new Function<Person, String>() {

            public String apply(Person p1) {
                return p1.getName();
            }
        });
        //printLog(trans);

        //list function.
        List<Person> sourceList = Lists.newArrayList(p, p2);
        List<Integer> listTrans = Lists.transform(sourceList, new Function<Person, Integer>() {
            public Integer apply(Person person) {
                return person.getId();
            }
        });
        //printLog(listTrans);

        //transform返回的list如果add、set操作会抛出异常 java.lang.UnsupportedOperationException
        //listTrans.add(7);
        //listTrans.set(1, 7);
        //若是删除,你以为删除的是id，但是删除的实际是原始数据中的对象；
        listTrans.remove(0);
        printLog(sourceList);
        printLog(listTrans);
    }

}
