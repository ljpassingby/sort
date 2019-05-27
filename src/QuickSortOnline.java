//快速排序
//时间复杂度为O(NlogN)，是一种不稳定算法，但是原地算法
public class QuickSortOnline {
    /**
     * 快速排序
     * @param number 排序数组
     * @param geshu  数组个数-1为数组的最后一个索引位置
     * @return
     */
    public int[] sort(int[] number, int geshu) {
        quickSort(number , 0 , geshu -1 );
        return number;
    }
    /**
     * 进行快速排序的方法
     * @param number  排序数组
     * @param low     排序数组的起始位置索引
     * @param hight   排序数组的终止位置索引
     */
    private void quickSort(int[] number, int low, int hight) {
        int begin = 0;
        int end = 0 ;
        if(low > hight){
            return ;
        }
        begin = low ;
        end = hight ;
        int index = number[low];  //获取到需要排序的第一个位置的内容为基准值
        while(begin < end){
            while(begin < end && number[end] >= index){  //找到比基准小的数
                end-- ;
            }
            if(begin < end){
                number[begin++] = number[end]; //将小于基准的位置的内容换到第一个位置，然后后面的从第二个位置继续开始排序
            }
            while(begin < end && number[begin] < index){
                begin++;      //一直找到不小于基准数的位置，这样的话，前面的都是小于基准的值
            }
            if(begin < end){
                number[end--] = number[begin] ;
            }
        }
        number[begin] = index;
        quickSort(number, low, begin-1);
        quickSort(number, begin+1, hight);

    }

}
