package sml.sort;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 快速排序（对冒泡排序进行的改进），快速排序的思想在于，选取一个中轴值（pivot），然后有俩个索引（左，右）
 * 依次进行，这边需要注意的是，如果选取的为左边值为中轴值，应该从右边索引进行选择，
 * 比中轴值大的数放在右边，比中轴值小的放在左边。
 * 注意：其中有个比较重要的点是，每次交换都是与中轴值进行交换，最后中轴值交换后的地方就是
 * 它应该在的地方。
 */
public class QuickSort {
    public static void sort(int[] array,int left,int right) {

        if(array.length == 0){
            System.out.println("数组不能为空!");
        }

        int l = left;//左边索引
        int r = right;//右边索引
        int pivot = array[left];//中轴值
        while(l<r){//当左边索引小于右边的时候，进行循环，大于的时候退出
            while(l<r && array[r]>pivot){ //l<r的作用是保证l不大于r
                r--; //直到找到比pivot小的数
            }
            while(l<r && array[l]<pivot){
                l++;//直到找到比pivot大的数，第一次l指向的仍然是中轴值
            }
            if(array[l] == array[r] && l<r){//这时说明跟中轴值相等的情况
                l++;//左边+或者右边-
            }else{
                int temp = array[l];
                array[l] = array[r];
                array[r] = temp;
            }
        }
        if(l-1 > left){
            sort(array,left,l-1);
        }
        if(r+1 < right){
            sort(array,r+1,right);
        }
        System.out.println(Arrays.toString(array));
    }
}
