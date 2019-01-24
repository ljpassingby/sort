//冒泡排序
/*
1.冒泡排序是原地排序，数据交换只涉及相邻的常量级的临时空间
2.冒泡排序是稳定排序，因为相同值不会做交换
3.冒泡排序时间复杂度中，最好是O(N)，最坏是O(N2)，平均是O(N2)
*/
public class BubbleSort {
    public static void bubbleSort(int[] arr, int n) {
        if (n <= 1)
            return;
        //i用于限制循环次数，循环n-1次就行
        for (int i = 0; i < n - 1; ++i) {
            //用于提前退出冒泡排序的标志位
            boolean flag = false;
            //这里的冒泡指的是大的数往后冒，每循环一次，最大值一定会冒到最后
            for (int j = 0; j < n - i - 1; ++j) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = true;
                }
            }
            if (!flag)
                break;
        }
    }
}
