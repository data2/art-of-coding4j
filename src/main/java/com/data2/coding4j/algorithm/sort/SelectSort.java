/**
 * FileName:   SelectSort.java
 *
 * @Description 直接选择排序
 * All rights Reserved, Code by Muskteer
 * Copyright MuskteerAthos@gmail.com
 * @author MuskteerAthos
 */
package com.data2.coding4j.algorithm.sort;

public class SelectSort {

    public static void selectSort(int[] arr) {
        if (arr == null || arr.length == 0)
            return;
        int minIndex = 0;
        for (int i = 0; i < arr.length - 1; i++) { // 只需要比较n-1次
            minIndex = i;
            for (int j = i + 1; j < arr.length; j++) { // 从i+1开始比较，因为minIndex默认为i了，i就没必要比了。
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) { // 如果minIndex不为i，说明找到了更小的值，交换之。
                swap(arr, i, minIndex);
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}