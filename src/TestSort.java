import java.util.Arrays;

public class TestSort {
    public static void main(String[] args) {
        int[] arr = {3, 5, 4, 1, 2, 6};
//        BubbleSort.bubbleSort(arr, arr.length);
//        InsertSort.insertSort(arr, arr.length);
        InsertSort.insertSort(arr, arr.length);
        for (int i : arr)
            System.out.println(i);
    }
}
