/**
 * FileName:   InsertSort.java
 *
 * @Description TODO
 * All rights Reserved, Code by Muskteer
 * Copyright MuskteerAthos@gmail.com
 * @author MuskteerAthos
 */
package com.data2.coding4j.algorithm.sort;

public class InsertSort {
    public static void insertSort(int[] numbers) {
        int size = numbers.length;
        int temp = 0;
        int j = 0;

        for (int i = 0; i < size; i++) {
            temp = numbers[i];
            // 假如temp比前面的值小，则将前面的值后移
            for (j = i; j > 0 && temp < numbers[j - 1]; j--) {
                numbers[j] = numbers[j - 1];
            }
            numbers[j] = temp;
        }
    }

    public static void main(String[] args) {
        insertSort(new int[]{4, 7, 2, 0, 5});
    }
}
