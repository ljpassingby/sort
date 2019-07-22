//快速排序
//时间复杂度为O(NlogN)，是一种不稳定算法，但是原地算法
//以下这个是从大到小排序
public class QuickSort {
    public void sort(int[] a,int start,int end){
        if(start < end){
            //这个p索引对应数组值大小一定是介于大区间和小区间之间的中间值
            // 即小于大区间，大于小区间
            int p=core(a,start,end);
            sort(a,start,p-1);
            sort(a,p+1,end);
        }
    }
    private int core(int[] a,int start,int end)
    {
        int ref = a[end];   //x作为索引
        int index = start;
        for(int i = start; i <= end - 1; i++){
            if(a[i] >= ref){
                swap(a, i, index);
                index++;//变量i用于划分大值和小值的区间，小于等于i的位置为大值，大于i的位置为小值
            }
        }
        swap(a,index,end);
        return index;
    }

    private void swap(int[] a,int i,int j)
    {
        int tmp=a[i];
        a[i]=a[j];
        a[j]=tmp;
    }
}
