package sml.sort;

public class SortTest {

    public static void main(String[] args) {

        int[] array = {2,5,1,14,32,12,68,49,6};

        //测试冒泡排序
        BubbleSort.sort(array);

        //测试选择排序
        SelectionSort.sort(array);

        //测试插入排序
        InsertionSort.sort(array);

        //测试希尔排序
        ShellSort.sort(array);


    }
}
