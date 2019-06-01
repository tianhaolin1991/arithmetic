package com.cp2;

/**此程序用于求一个数组的累加最大值(详见22页)
 * @author:tianhaolin
 * @version:1.0
 */
public class MaxSumRec {
    public static void main(String[] args) {
        int[] a = {1, 2, 4, -1, -2, 3, -10, 8, -1, 12, -4, 8, -5, 13, -10, 5, 2};
        int max = maxSumRec(a, 0, a.length - 1);
        System.out.println(max);

        System.out.println(maxSumRec2(a));
    }

    private static int maxSumRec(int[] a, int left, int right) {

        //边界条件
        if (left == right) {
            if (a[left] > 0) {
                return a[left];
            } else {
                return 0;
            }
        }
        int max = 0;

        int center = (left + right) / 2;
        int maxLeftSum = maxSumRec(a, left, center);
        int maxRightSum = maxSumRec(a, center + 1, right);
        int maxMiddle = maxSumLeft(a, left, center) + maxSumRight(a, center + 1, right);
        max = Math.max(maxLeftSum,maxRightSum);
        max = Math.max(max,maxMiddle);
        return max;
    }


    private static int maxSumLeft(int[] a, int left, int right) {
        int max = 0;
        int sum = 0;
        for (int i = right; i >= left; i--) {
            sum += a[i];
            if(sum>max){
                max = sum;
            }
        }
        if(max>0){
            return max;
        }
        return 0;
    }

    private static int maxSumRight(int[] a, int left, int right) {
        int max = 0;
        int sum = 0;
        for (int i = left; i <= right; i++) {
            sum += a[i];
            if(sum>max){
                max = sum;
            }
        }
        if(max>0){
            return max;
        }
        return 0;
    }

    /**算法2
     * @description
     * @param: null
     * @return
     * @date 2019/6/1 0001 8:57
     */
    private static int maxSumRec2(int[] a){
        int maxSum = 0;
        int currentSum = 0;
        for (int j = 0; j < a.length; j++) {
            currentSum += a[j];
            if(currentSum>maxSum){
                maxSum = currentSum;
            }else if(currentSum<0){
                currentSum = 0;
            }
        }
        return maxSum;
    }
}
