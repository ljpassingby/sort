//时间复杂度为O(NlogN)
public class HeapSortOnline {
    //堆排序
    public int[] duiNumberWay(int[] number, int geshu) {
        int suoyin=geshu-1;   //数组的最大下标
        for(int i=0;i<geshu;i++){                    //(优化)其实排序的次数为i<geshu-1就可以了，因为最后一趟其实都不用排了
            creatMaxHead(number,suoyin-i);  				//得到每次的最大堆的排序
            getOrderArray(number,0,suoyin-i);               //得到每次最大的数都和之前无序的数组的最后一个无序数组的位置的索引进行替换
        }
        return number;
    }

    /*
     * 将无序的数组逐次变成有序的，每次找到一个最大的，则将最大的放到无序数组的最后一个(这样从后面的就是一个有序的，从大到小的顺序)
     * 参数：start表示的是，因为每次找到的堆中都是数组0的值最大
     *      end表示的是最后一个无序数组的索引
     *      (这个的方法作用和swapMaxVaule的其实是一样都是交换最大的值，只是这样写区分一下，那是对每个小树的值的交换)
     */
    private void getOrderArray(int[] number, int start, int end) {
        int temp=number[end];
        number[end]=number[start];
        number[start]=temp;
    }

    /*
     * 得到每次堆排序的最大数的值，并且都放在索引为0的位置(这是堆排序的精髓的地方)
     */
    private static void creatMaxHead(int[] number, int lastIndex) {
        int currentIndex=0;   //保存当前的索引下标
        int bigMaxIndex=0;
        for(int i=(lastIndex-1)/2;i>=0;i--){
            currentIndex=i;        //当前根的下标
            if((currentIndex*2+1)<=lastIndex){  //判断当前结点是否有子节点
                bigMaxIndex=currentIndex*2+1;    //左结点的下标
                if(bigMaxIndex<lastIndex){     //表示有右结点
                    if(number[bigMaxIndex]<number[bigMaxIndex+1]){  //左结点小于右结点的值
                        bigMaxIndex=bigMaxIndex+1;
                    }
                }
                if(number[currentIndex]<number[bigMaxIndex]){      //用左右结点的大值和根的值进行比较
                    swapMaxVaule(currentIndex,bigMaxIndex,number);       //根结点的值小于左右结点中大的点
                    currentIndex=bigMaxIndex;
                }
            }
        }

    }
    /*
     * 堆排序中，得到每一个小树的最大的值
     */
    private static void swapMaxVaule(int currentIndex, int bigMaxIndex,int[] number) {
        int temp=number[currentIndex];
        number[currentIndex]=number[bigMaxIndex];
        number[bigMaxIndex]=temp;
    }

}
