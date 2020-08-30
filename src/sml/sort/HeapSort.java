package sml.sort;

import java.util.Arrays;

public class HeapSort {
//    public static void main(String[] args) {
//        //要求将数组进行升序（大顶堆小顶堆的区别）
//        int[] arr = {4,6,8,5,9};
//        sort(arr);
//    }

    //编写一个堆排序的方法
    public static void sort(int[] arr){
        System.out.println("堆排序");
        //分步完成
//        adjustHeap(arr,1,arr.length);//->49856
//        System.out.println("第一次调整"+ Arrays.toString(arr));
//        adjustHeap(arr,0,arr.length);
//        System.out.println("第二次调整"+Arrays.toString(arr));
        //完成最终代码，将无序序构建成一个堆
        //  n/2-1,怎么算的？
        //数组最后一个数肯定是叶子节点，他的下标为arr.len-1
        //根据子节点求父节点的公式（n-1）/2
        //则推导出最后一个叶子数的下标为（arr.len-1-1）/2=arr.len/2-1
        for (int i = arr.length/2-1; i >=0 ; i--) {
            adjustHeap(arr,i,arr.length);
        }
        //将堆顶元素与末尾元素交换，将最大元素沉到数组末端
        //重新调整结构，使其满足堆定义，然后继续交换堆顶元素与当前末尾元素，反复执行调整加交换
        for (int i = arr.length-1; i > 0; i--) {
            //交换
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            adjustHeap(arr,0,i);
        }
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 将一个数组（二叉树），调整成一个大顶堆
     * 完成将以i对应的非叶子节点的树调整成大顶堆
     * 举例：int[] arr={4,6,8,5,9} => i=1 =>arr={4,9,8,5,6}
     * 如果我们再次调用adjustHeap 传入的是 i=0 =>{9,6,8,5,4}
     * @param arr 待调整的数组
     * @param i 表示非叶子节点在数组中的索引
     * @param length 表示对多少个元素进行调整，length是在逐渐减少
     */
    public static void adjustHeap(int[] arr,int i,int length){
        int temp = arr[i];//先去出当前元素的值，保存在临时变量
        //开始调整
        //k=i*2+1 k是i节点的左子节点
        for (int k = i*2+1; k < length; k=k*2+1) {
            if(k+1<length && arr[k]<arr[k+1]){//说明左子节点小于右子节点
                k++;//k就指向右子节点
            }
            if(arr[k]>temp){//如果子节点大于父节点
                arr[i] = arr[k];
                i=k;//!!! i指向k继续循环比较
            }else{
                break;
            }
        }
        //当for循环结束后，我们已经将以i为父节点的树的最大值，放在了最顶上（局部）
        arr[i] = temp;//将temp值放到调整后的位置
    }
}
