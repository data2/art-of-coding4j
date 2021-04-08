/**
 * FileName:   SwapAlgorithm.java
 * @Description TODO
 * All rights Reserved, Code by Muskteer
 * Copyright MuskteerAthos@gmail.com
 * @author MuskteerAthos
 */
package com.data2.coding4j.algorithm.math;

import org.junit.Test;

/**
 *判断是否是素数
 *
 *质数（prime number）又称素数，有无限个。
 *
 *质数定义为在大于1的自然数中，除了1和它本身以外不再有其他因数，这样的数称为质数。
 *
 *最小的素数是2
 */
public class PrimeAlgorithm {

    @Test
    public void judgePrime(){
        int n = 100;
        if(n > 1){
            for(int i = 1; i <= Math.sqrt(n) ; i ++){
                if(n % i == 0){
                    System.out.println("no");
                    return;
                }
            }
            System.out.println("yes");
        }
    }
}
