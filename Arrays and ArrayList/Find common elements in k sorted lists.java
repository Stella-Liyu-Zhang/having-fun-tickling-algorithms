/*
 * Ex:
    for k=4
    [[1,2,3,3,4],[2,3,3,5],[1,2,3,3,5,6,7],[1,2,3,3,6,7,8,9]]
    should return [2,3,3]

    In-place approach:
    You can use slightly changed in-place merge algorithm of two sorted arrays 
    for finding an intersection in-place. We will have N-1 (N is the number of arrays) iterations.
     On every iteration we will merge first array with array with i+1 index. 
     The result will be written in the first array. Something like this:
 */

import java.util.*;
import java.lang.*;
import java.io.*;

class Ideone {
    private static int intersect(int[] a, int alen, int[] b) {
        int resLen = 0, bIndex = 0;
        for (int aIndex = 0; aIndex < alen; ++aIndex) {
            while (bIndex < b.length && a[aIndex] > b[bIndex])
                ++bIndex;
            if (bIndex == b.length)
                break;

            if (a[aIndex] == b[bIndex]) {
                a[resLen] = a[aIndex];
                ++resLen;
                ++bIndex;
            }
        }
        return resLen;
    }

    private static int intersectArrays(int[][] arrays) {
        int len = arrays[0].length;
        for (int i = 1; i < arrays.length; ++i) {
            len = intersect(arrays[0], len, arrays[i]);
        }
        return len;
    }

    public static void main(String[] args) throws java.lang.Exception {
        int[][] arr = { { 1, 2, 3, 3, 4 }, { 2, 3, 3, 5 }, { 1, 2, 3, 3, 5, 6, 7 }, { 1, 2, 3, 3, 6, 7, 8, 9 } };
        int len = intersectArrays(arr);
        for (int i = 0; i < len; ++i)
            System.out.print(arr[0][i] + " ");
    }
}