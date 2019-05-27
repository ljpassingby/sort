//归并排序
/*
1.归并排序是稳定的排序算法：两个分块数组若比较值相同，则先取前边那个
2.归并排序的时间复杂度是O(NlogN)
3.归并排序的空间复杂度是O(N)，不是原地算法，需要大量内存空间
* 这个归并排序在排序的同时计算了整个数组的逆序度number
* */
public class MergeSort {
    private int number = 0;
    public void sort(int[] arr, int n) {
        if (n < 1)
            return;
        mergeSort(arr, 0 , n - 1);
    }

    private void mergeSort(int[] arr, int p, int r) {
        if (p >= r)
            return;
        int q = (p + r) / 2;
        mergeSort(arr, p, q);
        mergeSort(arr, q + 1, r);
        merge(arr, p, q, r);
    }

    private void merge(int[] arr, int p, int q, int r) {
        int i = p, j = q + 1, k = 0;
        int[] temp = new int[r - p + 1];
        while (i <= q && j <= r) {
            if (arr[i] < arr[j])
                temp[k++] = arr[i++];
            else {
                number += q - i + 1;    //统计p到q之间，比a[j]大的元素个数
                temp[k++] = arr[j++];
            }
        }
        while (i <= q)
            temp[k++] = arr[i++];   //处理剩下的
        while (j <= r)
            temp[k++] = arr[j++];   //处理剩下的
        for (i = 0; i < temp.length; ++i) {
            arr[p + i] = temp[i];   //写成p+i的形式是考虑到对数组的后半段进行拷贝回去
        }
    }

    public int getNumber() {
        return this.number;
    }
}
