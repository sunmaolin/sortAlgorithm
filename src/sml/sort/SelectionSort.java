package sml.sort;

import java.util.Arrays;

/**
 * 选择排序
 * 描述：
 *  1、初始状态：无序区R[1...n]，有序区为空
 *  2、第i趟排序(i=1,2,3…n-1)开始时，当前有序区和无序区分别为R[1…i-1]和R(i…n）。
 *     该趟排序从当前无序区中-选出关键字最小的记录 R[k]，将它与无序区的第1个记录R交换，
 *     使R[1…i]和R[i+1…n)分别变为记录个数增加1个的新有序区和记录个数减少1个的新无序区
 *  3、n-1趟结束，数组有序化了
 */
public class SelectionSort {

    public static void sort(int[] array){

        if(array.length == 0)
            System.out.println("数组为空");
        for (int i = 0; i < array.length -1; i++) {
            int minIndex = i;
            //与冒泡排序相似，这里找到的最小值无需循环
            for (int j = i; j < array.length; j++) {
                if (array[j] < array[minIndex]){ //找到最小的数
                    minIndex = j; //将最小数的索引保存
                }
            }
            if(minIndex != i){ //插入优化
                int temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
            }
        }

        System.out.println(Arrays.toString(array));

    }
}
