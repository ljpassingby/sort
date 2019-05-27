//计数排序
//时间复杂度为O(N)
public class CountSort {
    // 计数排序，a 是数组，n 是数组大小。假设数组中存储的都是非负整数。
    public void sort(int[] a, int n) {
        if(n <= 1)
            return;
        //查找数组中数据范围
        int max = a[0];
        for(int i = 1; i < a.length; ++i) {
            if(max < a[i])
                max = a[i];
        }

        int[] c = new int[max + 1]; //申请一个数组c，下标范围为[0, max]
        for(int i = 0; i <= max; ++i) {
            c[i] = 0;
        }

        //计算待排序的每个值的个数，放入数组c中
        for (int i = 0; i < n; ++i) {
            c[a[i]]++;
        }

        //依次累加
        for (int i = 1; i <= max; ++i)	{
            c[i] =  c[i] + c[i - 1];
        }

        //存放排序结果的数组r
        int[] r = new int[n];
        //计算排序结果
        for (int i = n - 1; i >= 0; --i) {
            int index = c[a[i]] - 1;
            r[index] = a[i];
            c[a[i]]--;
        }

        //将排序结果返回给原数组a
        for (int i = 0; i < n; ++i) {
            a[i] = r[i];
        }
    }
}
