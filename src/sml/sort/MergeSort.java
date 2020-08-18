package sml.sort;

import java.util.Arrays;

/**
 * 归并排序
 * 先使用递归对数组进行拆分，最后进行合并。
 * 是建立在归并操作上的一种有效的排序算法。该算法是采用分治法（Divide and Conquer）的一个非常典型的应用。
 * 归并排序是一种稳定的排序方法。将已有序的子序列合并，得到完全有序的序列；
 * 即先使每个子序列有序，再使子序列段间有序。若将两个有序表合并成一个有序表，称为2-路归并。
 */
public class MergeSort {

    public static void sort(int[] array,int left,int right,int[] temp){

        if (array.length == 0)
            System.out.println("数组不能为空！");

        if(left<right){
            int mid = (left+right)/2;
            sort(array,left,mid,temp);//左递归
            sort(array,mid+1,right,temp);//右递归
            merge(array,left,mid,right,temp);//合并
        }


    }

    /**
     * 合并过程
     * @param array 需要合并的数组
     * @param left 左边下标
     * @param mid 中间下标
     * @param right 右边下标
     * @param temp 中间数组
     * @return
     */
    public static void merge(int[] array,int left,int mid,int right,int[] temp){
        int i = left;//左边索引
        int j = mid+1;//右边索引
        int t = 0;//中间数组索引
        while(i<=mid && j<=right){//排序后放到中间数组
            if(array[i] <= array[j]){
                temp[t]=array[i];
                t++;
                i++;
            }else{
                temp[t]=array[j];
                t++;
                j++;
            }
        }
        //剩余的其他数放到中间数组中
        while(i<=mid){
            temp[t] = array[i];
            t++;
            i++;
        }
        //剩余的其他数放到中间数组中
        while(j<=right){
            temp[t] = array[j];
            t++;
            j++;
        }
        //将排好序的中间数组放到原来的数组中
        t=0;
        int leftIndex = left;
        while(leftIndex<=right){
            array[leftIndex] = temp[t];
            t++;
            leftIndex++;
        }
    }

}
