package com.data2.coding4j.guava.collections.googleguava;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.MapDifference;
import com.google.common.collect.Maps;
import com.data2.coding4j.guava.collections.ParentCollection;

import java.util.Map;
import java.util.Set;

/**
 * Created by wanglei on 2016/10/11.
 * ---------------不可变集合---------------
 */
public class ImmutableProgram extends ParentCollection {
    public void immutable() {
        //
        @SuppressWarnings("unused")
        Set<Integer> set = ImmutableSet.of(1, 2, 4);

        Map<String, Integer> left = ImmutableMap.of("a", 1, "b", 2, "c", 3);
        Map<String, Integer> right = ImmutableMap.of("a", 1, "b", 2, "c", 3);
        @SuppressWarnings("unused")
        MapDifference<String, Integer> diff = Maps.difference(left, right);


    }
}
