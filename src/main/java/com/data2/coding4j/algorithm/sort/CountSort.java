/**
 * FileName:   CountSort.java
 *
 * @Description TODO
 * All rights Reserved, Code by Muskteer
 * Copyright MuskteerAthos@gmail.com
 * @author MuskteerAthos
 */
package com.data2.coding4j.algorithm.sort;

import java.util.Arrays;

public class CountSort {
    public static void countSort(int[] arr) {
        if (arr == null || arr.length == 0)
            return;

        int max = max(arr);

        int[] count = new int[max + 1];
        Arrays.fill(count, 0);

        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }

        int k = 0;
        for (int i = 0; i <= max; i++) {
            for (int j = 0; j < count[i]; j++) {
                arr[k++] = i;
            }
        }

    }

    public static int max(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int ele : arr) {
            if (ele > max)
                max = ele;
        }

        return max;
    }

    public static void main(String[] args) {
        countSort(new int[]{4, 7, 2, 9, 0});
    }

}