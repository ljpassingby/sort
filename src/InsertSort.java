//插入排序
/*
1.插入排序是原地排序，只涉及相邻数的常量级交换
2.插入排序是稳定排序，因为相同值不交换
3.插入排序的时间复杂度，最好是O(N)，最坏是O(N2)，平均是O(N2)
*/
public class InsertSort {
    public static void insertSort(int[] a, int n) {
        if (n <= 1)
            return;
        for (int i = 1; i < n; ++i) {
            int value = a[i];
            int j = i - 1;
            //j用于查找要插入的位置
            for (; j >= 0; --j) {
                if (a[j] > value) {
                    a[j + 1] = a[j];    //执行完后执行--j，也就是说当前轮的a[j]或者说下一轮的a[j+1]就是可能要插入的位置
                }else
                    break;  //表示此处的a[j]比value小，可以将退出并执行后面一步的a[j+1]=value。break后不执行--j
            }
            a[j + 1] = value;
        }
    }
}
