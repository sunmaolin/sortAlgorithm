package sml.sort;

import java.util.Arrays;

/**
 * 基数排序（桶排序）
 */
public class RadixSort {
    public static void sort(int[] array){
        //首先new个二维数组代表十个桶
        int[][] bucket = new int[10][array.length];
        //在new个一维数组代表每个桶的元素个数
        int[] bucketElementsCount = new int[10];
        //最长的数的位数就是循环的次数
        int max = array[0];//假设第一个为最大的数
        for (int i = 1; i < array.length; i++) {
            if(max < array[i]){
                max = array[i];
            }
        }
        //找到最大的数之后判断它的长度
        int maxLength = (max+"").length();
        for (int i = 0,n = 1; i < maxLength; i++,n*=10) {
            for (int j = 0; j < array.length; j++) {
                //每一位的数
                int digitOfElement = array[j] / n % 10;
                //根据位数，判断第几个桶，bucketElementsCount[digitOfElement]代表第几个桶的第几个数
                bucket[digitOfElement][bucketElementsCount[digitOfElement]]=array[j];
                //放进一个数需要将记录这个桶的数据个数加一
                bucketElementsCount[digitOfElement]++;
            }
            //代表原数组的下标
            int index = 0;
            //放好桶里之后需要在按照桶的顺序放到原数组中
            for (int j = 0; j < bucket.length; j++) {
                //如果桶里有数，将数取出
                if(bucketElementsCount[j]>0){
                    for (int k = 0; k < bucketElementsCount[j]; k++) {
                        array[index++] = bucket[j][k];
                    }
                    bucketElementsCount[j]=0;//取完之后置0，用于下次使用
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }
}
