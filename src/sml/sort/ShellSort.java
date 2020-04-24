package sml.sort;

import java.util.Arrays;

/**
 * 希尔排序
 *  1、选择一个增量序列t1，t2，…，tk，其中ti>tj，tk=1
 *  2、按增量序列个数k，对序列进行k 趟排序
 *  3、每趟排序，根据对应的增量ti，将待排序列分割成若干长度为m 的子序列，分别对各子表进行直接插入排序。
 *     仅增量因子为1 时，整个序列作为一个表来处理，表长度即为整个序列的长度
 */
public class ShellSort {

    public static void sort(int[] array){
        if(array.length == 0)
            System.out.println("数组为空");

        int temp,gap = array.length/2;

        while(gap>0){
            for (int i = gap; i < array.length; i++) {
                temp = array[i];
                int preIndex = temp - i;
                while(preIndex >= 0 && array[preIndex] > temp){
                    array[preIndex + gap] = array[preIndex];
                    preIndex--;
                }
                array[preIndex + gap] = temp;
            }
            gap /= 2;
        }
        System.out.println(Arrays.toString(array));
    }

}
