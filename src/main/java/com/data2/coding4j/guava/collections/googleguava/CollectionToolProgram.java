package com.data2.coding4j.guava.collections.googleguava;

import com.data2.coding4j.guava.collections.googleguava.bean.Person;
import com.google.common.collect.*;
import com.google.common.primitives.Ints;
import com.data2.coding4j.guava.collections.ParentCollection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by wanglei on 2016/10/11.
 * ---------------强大的集合工具类---------------
 * 任何对 JDK 集合框架有经验的程序员都熟悉和喜欢 java.util.Collections 包含的工具方法。
 * Guava 沿着这些路线提供了更多的工具方法：适用于所有集合的静态方法。
 * 这是 Guava 最流行和成熟的部分之一。
 * <p>
 * 集合接口	    属于JDK还是Guava	    对应的Guava工具类
 * Collection	JDK	                Collections2：不要和 java.util.Collections 混淆
 * List	        JDK	                Lists
 * Set	        JDK	                Sets
 * SortedSet	JDK	                Sets
 * Map	        JDK	                Maps
 * SortedMap	JDK	                Maps
 * Queue	    JDK             	Queues
 * Multiset	    Guava	            Multisets
 * Multimap	    Guava	            Multimaps
 * BiMap	    Guava	            Maps
 * Table	    Guava	            Tables
 */
public class CollectionToolProgram extends ParentCollection {
    @Test
    public void tool() {
        //1、静态工厂方法
        @SuppressWarnings("unused")
        List<?> list = Lists.newArrayList();
        @SuppressWarnings("unused")
        Set<?> set = Sets.newHashSet();
        @SuppressWarnings("unused")
        Map<?, ?> map = Maps.newLinkedHashMap();
        @SuppressWarnings("unused")
        Multiset<String> multiset = HashMultiset.create();

        //2、指定起始元素
        @SuppressWarnings("unused")
        List<Person> list1 = Lists.newArrayList(new Person(), new Person());
        @SuppressWarnings("unused")
        Set<Person> set1 = Sets.newHashSet(new Person(), new Person());

        //3、指定起始大小
        //通过为工厂方法命名（Effective Java 第一条），我们可以提高集合初始化大小的可读性：
        //Guava 引入的新集合类型没有暴露原始构造器，也没有在工具类中提供初始化方法。而是直接在集合类中提供了静态工厂方法
        @SuppressWarnings("unused")
        List<?> list2 = Lists.newArrayListWithCapacity(100);
        @SuppressWarnings("unused")
        List<?> list3 = Lists.newArrayListWithExpectedSize(100);
        @SuppressWarnings("unused")
        Set<?> set2 = Sets.newHashSetWithExpectedSize(100);

        //4、Iterables
        //Guava 提供的工具方法更偏向于接受 Iterable 而不是 Collection 类型。
        //因此，很多你期望的支持所有集合的操作都在 Iterables 类中
        Iterable<Integer> iterables = Iterables.concat(
                Ints.asList(1, 2, 3),
                Ints.asList(4, 5));

        printLog(Iterables.getFirst(iterables, 2));
        printLog(Iterables.frequency(iterables, 2));
        printLog(Iterables.concat(iterables, iterables));
        printLog(Iterables.getOnlyElement(iterables));

        //与 Collection 方法相似的工具方法
        Iterables.size(iterables);//Collection.size()
        Iterables.contains(iterables, 9);//Collection.contains(Object)
        Iterables.removeAll(iterables, new ArrayList<Object>());//Collection.removeAll(Collection)
        Iterables.isEmpty(iterables);//Collection.isEmpty()


        //5、FluentIterable

        //6、Lists
        //除了静态工厂方法和函数式编程方法，Lists 为 List 类型的对象提供了若干工具方法。
        List<?> zak = Ints.asList(1, 3, 5);
        @SuppressWarnings("unused")
        List<?> kaz = Lists.reverse(zak);
        @SuppressWarnings("unused")
        List<?> group = Lists.partition(zak, 2);//{{1,3}, {5}}

        //7、sets Sets 工具类包含了若干好用的方法。
        Sets.union(Sets.newHashSet(1, 3), Sets.newHashSet(6));
        Sets.intersection(Sets.newHashSet(1, 3), Sets.newHashSet(6));
        Sets.difference(Sets.newHashSet(1, 3), Sets.newHashSet(6));

        //8、maps
        //difference
        Map<String, Integer> left = ImmutableMap.of("a", 1, "b", 2, "c", 3);
        Map<String, Integer> right = ImmutableMap.of("a", 1, "b", 2, "c", 3);
        @SuppressWarnings("unused")
        MapDifference<String, Integer> diff = Maps.difference(left, right);
        //uniqueIndex


        //9、Multisets

        //10、Multimaps

        //11、forMap
        //想在 Map 对象上使用 Multimap 的方法吗？forMap(Map)把 Map 包装成 SetMultimap。
        // 这个方法特别有用，例如，与 Multimaps.invertFrom 结合使用，可以把多对一的 Map 反转为一对多的 Multimap。

        //12、invertFrom
        // Multimap 可以把多个键映射到同一个值（译者注：实际上这是任何 map 都有的特性），
        // 也可以把一个键映射到多个值，反转 Multimap 也会很有用。
        Map<String, Integer> mapd = ImmutableMap.of("a", 1, "b", 1, "c", 2);
        @SuppressWarnings("unused")
        SetMultimap<String, Integer> multimapd = Multimaps.forMap(mapd);
        // multimap：["a" => {1}, "b" => {1}, "c" => {2}]
        //Multimap<Integer, String> inverse = Multimaps.invertFrom(multimapd, HashMultimap<Integer, String>.create());
        // inverse：[1 => {"a","b"}, 2 => {"c"}]


    }
}
