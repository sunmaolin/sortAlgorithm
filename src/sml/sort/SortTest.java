package sml.sort;

import java.util.Arrays;

public class SortTest {

    public static void main(String[] args) {

        int[] array = {1,1,2,0,0,8,9};

        //测试冒泡排序
//        BubbleSort.sort(array);

        //测试选择排序
//        SelectionSort.sort(array);

        //测试插入排序
//        InsertionSort.sort(array);

        //测试希尔排序
//        ShellSort.sort(array);

        //测试快速排序
//        QuickSort.sort(array,0,array.length-1);

        //测试归并排序
//        MergeSort.sort(array,0,array.length-1,new int[array.length]);
//        System.out.println(Arrays.toString(array));

        //测试基数排序（桶排序）
//        RadixSort.sort(array);

        //测试堆排序
        HeapSort.sort(array);
    }
}
