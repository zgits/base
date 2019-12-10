package sort;

import java.util.Arrays;

/**
 * @Description: 排序的主要测试类
 * @Author: zjf
 * @Date: 2019/12/10 15:22.
 */
public class MainTest {

    public static void main(String[] args) {

        int[] arrs = {12, 15, 1, 0, -7, 88, 75, 42, 113, 20, 57, 54, 15};

        System.out.println(Arrays.toString(arrs));

        long startTime = System.currentTimeMillis(); //获取开始时间


//        bubbleSort(arrs);//调用冒泡排序

//        selectSort(arrs);//调用选择排序

//        insertSort(arrs);//调用插入排序

//        shellSort(arrs);//调用希尔排序

        mergeSort(arrs,0,arrs.length-1);//调用归并排序

        long endTime = System.currentTimeMillis(); //获取结束时间

        System.out.println(Arrays.toString(arrs));

        System.out.println("程序运行时间：" + (endTime - startTime) + "ms"); //输出程序运行时间

    }

    private static void swap(int[] arrs, int i, int j) {
        int temp = arrs[i];
        arrs[i] = arrs[j];
        arrs[j] = temp;
    }

    /**
     * 冒泡排序
     *
     * @param arrs
     * @return
     */
    private static void bubbleSort(int[] arrs) {

        for (int i = 0; i < arrs.length; i++) {
            for (int j = 0; j < arrs.length - 1 - i; j++) {
                if (arrs[j + 1] < arrs[j]) {
                    swap(arrs, j + 1, j);
                }

            }
        }
    }


    /**
     * 选择排序
     *
     * @param arrs
     * @return
     */
    private static void selectSort(int[] arrs) {

        for (int i = 0; i < arrs.length; i++) {
            int maxIndex = i;
            for (int j = i; j < arrs.length; j++) {
                if (arrs[j] > arrs[maxIndex]) {
                    maxIndex = j;
                }
            }
            swap(arrs, i, maxIndex);
        }

    }


    /**
     * 插入排序
     *
     * @param arrs
     * @return
     */
    private static void insertSort(int[] arrs) {
        for (int i = 1; i < arrs.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arrs[j] < arrs[j - 1]) {
                    swap(arrs, j - 1, j);
                } else {
                    break;
                }
            }
        }
    }


    /**
     * 希尔排序
     *
     * @param arrs
     * @return
     */
    private static void shellSort(int[] arrs) {

        for (int gap = arrs.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arrs.length; i++) {
                int temp = arrs[i];
                int j = i;
                while (j - gap >= 0 && temp < arrs[j - gap]) {
                    arrs[j] = arrs[j - gap];
                    j = j - gap;
                }
                arrs[j] = temp;
            }
        }
    }


    /**
     * 归并排序
     * @param arrs 待排序数组
     * @param L 指向数组的第一个元素
     * @param R 指向数组的最后一个元素
     */
    private static void mergeSort(int[] arrs,int L,int R){

        if(L==R){
            return;
        }else{
            // 取中间的数进行拆分
            int M=(L+R)/2;
            mergeSort(arrs,L,M);
            mergeSort(arrs,M+1,R);
            merge(arrs,L,M+1,R);
        }

    }

    /**
     * 合并数组
     * @param arrs
     * @param L 指向数组的第一个元素
     * @param M 指向数组分隔的元素
     * @param R 指向数组最后的元素
     */
    private static void merge(int[] arrs,int L,int M,int R){
        int[] leftArray=new int[M-L];//左边数组的大小
        int[] rightArray=new int[R-M+1];//右边数组的大小

        //往两个数组填充数据
        for (int i=L;i<M;i++){
            leftArray[i-L]=arrs[i];
        }
        for (int i=M;i<=R;i++){
            rightArray[i-M]=arrs[i];
        }

        int i=0,j=0;
        int k=L;

        while (i<leftArray.length&&j<rightArray.length){
            if(leftArray[i]<rightArray[j]){
                arrs[k]=leftArray[i];
                i++;
                k++;
            }else{
                arrs[k]=rightArray[j];
                j++;
                k++;
            }
        }
        for (; i < leftArray.length; i++) {
            arrs[k]=leftArray[i];
            k++;
        }
        for (; j < rightArray.length; j++) {
            arrs[k]=rightArray[j];
            k++;
        }

    }






}
