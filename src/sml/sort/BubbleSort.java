package sml.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 * 描述：
 *  1、比较相邻的元素，如果第一个比第二个大，就交换他们俩个
 *  2、对每对相邻的元素做同样的工作，从开始第一对到结尾的最后一队，这样在最后的元素应该会是最大数
 *  3、针对所有元素重复以上步骤，除了最后一个
 *  4、重复步骤1-3，直到排序完成
 */
public class BubbleSort {

    public static void sort(int[] array){

        //临时变量，交换时用作中间体
        int temp = 0;
        //对算法进行优化,当第n次排序没有发生变化时则说明已经排序完成
        boolean flag = false;

        if (array.length == 0)
            System.out.println("空数组");
        for (int i = 0; i < array.length; i++) {
            //循环出最大值与最后一个数不需要比较
            for (int j = 0; j < array.length - i - 1; j++) {
                if(array[j] > array[j+1]){
                    flag = true;
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
            if(!flag){
                break;
            }else{
                flag = false;
            }
        }

        System.out.println(Arrays.toString(array));


    }

}
