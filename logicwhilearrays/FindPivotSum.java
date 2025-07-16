package logicwhilearrays;

import java.util.Arrays;
/*
Problem Statement:
Given an integer array, find the pivot index. The pivot index is the index where the sum of all elements to the left is equal to the sum of all elements to the right. If no such index exists, return -1.

Sample Input 1:
a = {3, 0, 1}
Sample Output 1:
pivot index is 1

Sample Input 2:
a = {1, 7, 3, 6, 5, 6}
Sample Output 2:
pivot index is 3

Sample Input 3:
a = {1, 2, 3}
Sample Output 3:
pivot index is -1
 */

public class FindPivotSum {
    public static void main(String[] args) {
        int[] a={3,0,1};
        int n = a.length;
        System.out.println("pivot index is "+findPivotIndex(a, n));
    }
    public static int findPivotIndex(int[] a, int n) {
        if (n == 0) return -1; // Handle empty array case
        int totalSum = Arrays.stream(a).sum(); // Calculate total sum of the array
        int leftSum = 0; // Initialize left sum
        for(int i=0;i<n;i++){

            if (leftSum == totalSum - leftSum - a[i])
                return i; // Return the pivot index
            leftSum += a[i]; // Update left sum
        }
        return -1;
    }
}
