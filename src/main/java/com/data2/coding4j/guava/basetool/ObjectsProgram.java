package com.data2.coding4j.guava.basetool;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import org.junit.Test;

/**
 * Created by wanglei on 2016/10/12.
 */
public class ObjectsProgram {
    @Test
    public void objects() {
        //equal
        Preconditions.checkArgument(Objects.equal("a", "a"));
//        Preconditions.checkArgument(Objects.equal(null, "a"));
        Preconditions.checkArgument(Objects.equal(null, null));

        //hashCode
        System.out.println(Objects.hashCode("3456789232322323", "456789023258"));

//        //toString
//        System.out.println(Objects.toStringHelper("person").add("x",1).toString());

    }
}
