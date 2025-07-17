package logicwhilearrays;

import java.util.*;
import java.io.*;

public class LongestMountainSubArray {

    /**
     *  Problem Statement:
     *  You are given an array of 'N' integers denoting the heights of the mountains.
     *  You need to find the length of the longest subarray which has the shape of a mountain.
     *
     *  A mountain subarray is defined as a subarray which consists of elements that are
     *  initially in ascending order until a peak element is reached and beyond the peak
     *  element all other elements of the subarray are in decreasing order.
     *
     *  Example:
     *  If the given array is: [1, 3, 1, 4].  The longest mountain subarray would be 3.
     *  This is because the longest mountain is  [1, 3, 1] having length 3.
     *
     *  Constraints:
     *  1 <= N <= 10^5
     *  1 <= Ai <= 10^9
     *
     *  Time Limit : 1 sec
     */
    public static int longestMountain(int a[], int n) {
        if (n < 3) return 0;
        int maxlen = 0;
        for (int i = 1; i < n - 1; i++) {
            if (a[i] > a[i - 1] && a[i] > a[i + 1]) {
                int left = i - 1, right = i + 1;
                int leftcount = 0, rightcount = 0;

                while (left >= 0 && a[left] < a[left + 1]) {
                    left--;
                    leftcount++;
                }

                while (right < n && a[right] < a[right - 1]) {
                    right++;
                    rightcount++;
                }

                if (leftcount > 0 && rightcount > 0)
                    maxlen = Math.max(maxlen, leftcount + rightcount + 1);
            }
        }
        return maxlen;
    }


    public static void main(String[] args) {
        // Static Input Arrays
        int[][] testArrays = {
                {1, 3, 1, 4},       // Expected Output: 3
                {1, 3, 1, 4, 3, 1},    // Expected Output: 4
                {3, 1, 3},          // Expected Output: 0
                {4, 5, 1, 3},       // Expected Output: 3
                {4, 5, 6, 7, 8},       // Expected Output: 0
                {9, 3, 5, 4}        // Expected Output: 3
        };

        // Process each test array and print the result
        for (int i = 0; i < testArrays.length; i++) {
            int[] arr = testArrays[i];
            int result = longestMountain(arr, arr.length);
            System.out.println("Test Case " + (i + 1) + ": Longest mountain subarray is: " + result);
        }

     /* //Scanner scanner = new Scanner(System.in);  <- Commented out scanner code
        //System.out.println("Enter the number of mountians:");
        //int n = scanner.nextInt();
           //int [] arr = new int [n];
        //System.out.println("Enter the element:");
       //for(int i =0;i<n;i++) {
         //  arr[i] = scanner.nextInt();
       //}

       //int result = longestMountain(arr, arr.length);
        //System.out.println("Longest mountain subarray is: "+ result);*/
    }
}