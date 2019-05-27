//选择排序，每一次从待排序的数据元素中选出最小（或最大）的一个元素，存放在序列的起始位置，
//然后，再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。
/*
1.选择排序是一种原地排序
2.选择排序不稳定
3.选择排序时间复杂度，最好最坏与平均都是O(N2)
*/
public class SelectSort {
    public void selectSort(int[] a, int n) {
        if (n <= 1)
            return;
        for (int i = 0; i < n - 1; ++i) {
            boolean flag = false;
            int min = a[i];
            int index = i + 1;  //查找待排序序列中的最小值索引
            for (int j = i + 1; j < n; ++j) {
                if (min > a[j]) {
                    index = j;
                    min = a[j];
                    flag = true;
                }
            }
            if (flag) {
                //在保证找到最小值后，再将最小值与已排列序列的末尾值a[i]交换
                int temp = a[i];
                a[i] = a[index];
                a[index] = temp;
            }
        }
    }
}
