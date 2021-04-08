package com.data2.coding4j.guava.collections.googleguava;

import com.data2.coding4j.guava.collections.ParentCollection;

/**
 * Created by wanglei on 2016/10/11.
 * ---------------断言---------------
 */
public class PredicateProgram extends ParentCollection {
//    @Test
//    public void predicate() {
//        //断言Predicate,过滤
//        List<Person> persons = Lists.newArrayList(new Person(1, "Wang", "man"), new Person(2, "Lee", "man"));
//        printLog(persons);
//        Predicate<Person> predicate = new Predicate<Person>() {
//            public boolean apply(Person o) {
//                if (o.getName().equalsIgnoreCase("Lee")) {
//                    return false;
//                }
//                return true;
//            }
//        };
//        Collection<Person> filter = Collections2.filter(persons, predicate);
//        printLog(filter);
//
//
//        //sets filter predicate.
//        Set<String> set = Sets.newHashSet("hi", "wang", "lei");
//        Set<String> setFilter = Sets.filter(set, new Predicate<String>() {
//            public boolean apply(String o) {
//                return o.equals("wang") ? false : true;
//            }
//        });
//        printLog(setFilter);
//
//        //map filterKeys.
//        Map<String, Person> map = Maps.newHashMap();
//        map.put("1", new Person(1, "Wang", "man"));
//        map.put("2", new Person(2, "Lei", "man"));
//        Map<String, Person> keysMap = Maps.filterKeys(map, new Predicate<String>() {
//            public boolean apply(String o) {
//                return o.equals("2") ? false : true;
//            }
//        });
//        printLog(keysMap);
//
//        Map<String, Person> valueMap = Maps.filterValues(map, new Predicate<Person>() {
//            public boolean apply(Person o) {
//                return o.getName().equals("Wang") ? false : true;
//            }
//        });
//        printLog(valueMap);
//    }

}
