//时间复杂度为O(NlogN)
//是不稳定排序，是原地排序
public class HeapSort {
    //n表示数据的个数，数组arr中的数据从下标1到n的位置，因为arr[0]这个位置是个空值
    public void sort(int[] arr, int n) {
        buildingHeap(arr, n);
        int k = n;
        while(k > 1) {
            swap(arr, 1, k);
            --k;
            heapify(arr, k, 1);
        }
    }

    private void heapify(int[] arr, int n, int i) {
        while (true) {
            int maxPos = i;
            if (i * 2 <= n && arr[i] < arr[i * 2])
                maxPos = i * 2;
            if (i * 2 + 1 <= n && arr[maxPos] < arr[i * 2 + 1])
                maxPos = i * 2 + 1;
            if (maxPos == i)
                break;
            swap(arr, i , maxPos);
            i = maxPos;
        }
    }

    private void swap(int[] arr, int i, int k) {
        int temp = arr[i];
        arr[i] = arr[k];
        arr[k] = temp;
    }

    private void buildingHeap(int[] arr, int n) {
        for (int i = n / 2; i >= 1; --i) {
            heapify(arr, n, i);
        }
    }
}
