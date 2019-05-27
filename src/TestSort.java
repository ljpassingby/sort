public class TestSort {
    public static void main(String[] args) {
        int[] arr = {3, 5, 4, 1, 2, 6};
        int[] heap = {0,3, 5, 4, 1, 2, 6};
//        new BubbleSort().sort(arr, arr.length);   //冒泡排序
//        new InsertSort().sort(arr, arr.length);   //插入排序
//        new SelectSort().selectSort(arr, arr.length); //选择排序
//        new mergeSort().sort(arr, arr.length);    //归并排序
//        new QuickSortOnline().sort(arr, arr.length);    //快速排序
//        new HeapSort().sort(heap, heap.length - 1); //堆排序，它要求被排序数组必须首位是一个无关排序位
//        new CountSort().sort(arr, arr.length);  //计数排序
        new QuickSort().sort(arr, 0, arr.length - 1);   //快速排序
        for (int i : arr)
            System.out.println(i);
    }
}
