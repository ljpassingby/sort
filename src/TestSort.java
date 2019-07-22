import org.junit.Test;

import java.util.Arrays;

public class TestSort {
    public static void main(String[] args) {
        int[] arr = {3, 5, 4, 1, 2, 6};
        int[] heap = {0,3, 5, 4, 1, 2, 6};
//        new BubbleSort().sort(arr, arr.length);   //冒泡排序
//        new InsertSort().sort(arr, arr.length);   //插入排序
//        new SelectSort().selectSort(arr, arr.length); //选择排序
//        new mergeSort().sort(arr, arr.length);    //归并排序
//        new QuickSortOnline().sort(arr, arr.length);    //快速排序
        new HeapSort().sort(heap, heap.length - 1); //堆排序，它要求被排序数组必须首位是一个无关排序位
//        new CountSort().sort(arr, arr.length);  //计数排序
//        new QuickSort().sort(arr, 0, arr.length - 1);   //快速排序
        for (int i : heap)
            System.out.println(i);
    }

    @Test
    public void test() {
        int[] arr = {3, 5, 4, 1, 2, 6, 5};
        sort(arr, 0, arr.length - 1);
        System.out.print(Arrays.toString(arr));
    }

    public void sort(int[] arr, int start, int end) {
        if (start < end) {
            int index = core(arr, start, end);
            sort(arr, start, index - 1);
            sort(arr, index + 1, end);
        }
    }

    public int core(int[] arr, int start, int end) {
        int index = start;
        int ref = arr[end];
        for (int i = start; i < end; ++i) {
            if (arr[i] <= ref) {
                swap(arr, i, index);
                ++index;
            }
        }
        swap(arr, index, end);
        return index;
    }

    public void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}
