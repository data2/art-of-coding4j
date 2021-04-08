/**
 * FileName:   RecursiveTest.java
 * @Description some recursive math
 * All rights Reserved, Code by Muskteer
 * Copyright MuskteerAthos@gmail.com
 * @author MuskteerAthos
 */
package com.data2.coding4j.algorithm.recursive;

/**
 */
public class RecursiveForMath {
    
    public static void main(String[] args) {
        System.out.println(factorial(5));
        System.out.println(Fibonacci(8));
        
    }

    /**
     * 计算 阶乘
     * n!=n*(n-1)!   0!=1
     */
    private static int factorial(int n) {
        if(n == 0){//递归出口
            return 1;
        }else{
            return n*factorial(n-1);
        }
    }
    
    /**
     * 斐波那契序列
     * 1、1、2、3、5、8、13、21、……
     */
    public static int Fibonacci(int n){
        if(n == 1 || n == 2){
            return 1;
        }else{
            return Fibonacci(n-1) + Fibonacci(n-2);
        }
    }
    
}
