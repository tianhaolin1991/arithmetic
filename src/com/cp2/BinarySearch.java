package com.cp2;

/**
 * 已知X,和有序数组A,查找X在A中的索引,没有则返回-1,要求时间复杂度为O(logN)
 *
 * @author:tianhaolin
 * @version:1.0
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] a = {1, 3, 4, 6, 8, 12, 15, 18, 19, 23, 25, 28, 30};
        int index = binarySearch(a, 25);
        System.out.println(index);
    }

    private static int binarySearch(int[] a, int x) {
        int length = a.length;
        int low = 0;
        int high = a.length;
        while (low<=high) {
            int mid = (low + high) / 2;
            if (a[mid] > x) {
                high = mid - 1;
            }
            if (a[mid] < x) {
                low = mid + 1;
            }
            if(a[mid] == x){
                return mid;
            }
        }
        return -1;
    }
}
