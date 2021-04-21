package com.data2.coding4j.guava.collections.googleguava;

import com.data2.coding4j.guava.collections.ParentCollection;
import com.data2.coding4j.guava.collections.googleguava.bean.Person;
import com.google.common.collect.*;
import org.junit.Test;

/**
 * Created by wanglei on 2016/10/11.
 * ---------------新集合类型---------------
 * Guava引进了JDK里没有的，但是非常有用的一些新的集合类型。所有这些新集合类型都能和JDK里的集合平滑集成。
 * Guava集合非常精准地实现了JDK定义的接口。Guava中定义的新集合有：
 * 　　Multiset
 * 　　SortedMultiset
 * 　　Multimap
 * 　　ListMultimap
 * 　　SetMultimap
 * 　　BiMap
 * 　　ClassToInstanceMap
 * 　　Table
 */
public class NewCollectionTypeProgram extends ParentCollection {

    @Test
    public void newCollectionType() {
        //Multiset. 统计次数
        Multiset<String> multiset = HashMultiset.create();
        multiset.addAll(Lists.newArrayList("wang", "lei", "wang", "wang"));
        for (Object s : multiset.elementSet()) {
            printLog(s.toString() + " : 出现次数 " + multiset.count(s));
        }

        //Multimap
        Multimap<String, Person> multimap = ArrayListMultimap.create();
        for (int i = 0; i < 20; i++) {
            Person person = new Person();
            person.setId(i + 1);
            person.setSex("man");
            person.setName("wang" + i);
            multimap.put("persons", person);
        }
        //printLog(multimap.size()+"");
        //printLog(multimap.keys());
        //printLog(multimap.keySet());
        //printLog(multimap.get("persons"));

        //BiMap 双向映射
        BiMap<String, String> biMap = HashBiMap.create();
        biMap.put("18", "成人");
        biMap.put("14", "未成年");
        printLog((String) biMap.inverse().get("成人"));
        biMap.forcePut("20", "成人");
        printLog(biMap);


    }
}
