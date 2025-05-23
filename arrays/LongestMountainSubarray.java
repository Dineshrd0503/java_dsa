package arrays;

import java.util.Scanner;

/*
Problem statement:
You are given an array of 'N' integers denoting the heights of the mountains. You need to find the length of the
longest subarray which has the shape of a mountain. A mountain subarray is defined as a subarray which consists
of elements that are initially in ascending order until a peak element is reached and beyond the peak element all
other elements of the subarray are in decreasing order.

Input Format:
The first line of input contains a single integer 'T', representing the number of test cases or queries to be run.
Then the 'T' test cases follow.
The first line of each test case contains a single integer 'N' representing the length of the array.
The second line of each test case contains 'N' space-separated integers denoting the elements of the given array.

Output Format:
For each test case, print the length of the longest subarray which has the shape of a mountain in a separate line.

Sample Input 1:
3
4
1 3 1 4
6
1 3 1 4 3 1
3
3 1 3

Sample Output 1:
3
4
0

Sample Input 2:
3
4
4 5 1 3
5
4 5 6 7 8
4
9 35 4

Sample Output 2:
3
0
3
*/

public class LongestMountainSubarray {

    // Function to find the length of the longest mountain subarray
    public static int longestMountain(int[] arr, int n) {
        int longest = 0;

        for (int i = 1; i < n - 1; i++) {
            // Check if arr[i] is a peak
            if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                int left = i, right = i;

                // Move left pointer to the start of the ascending sequence
                while (left > 0 && arr[left - 1] < arr[left]) {
                    left--;
                }
                // Move right pointer to the end of the descending sequence
                while (right < n - 1 && arr[right + 1] < arr[right]) {
                    right++;
                }

                // Calculate the mountain length
                int mountainLength = right - left + 1;
                longest = Math.max(mountainLength, longest);
            }
        }

        return longest;
    }

    public static void main(String[] args) {
        // Test case 1
        int[] arr1 = {1, 3, 1, 4};
        System.out.println(longestMountain(arr1, arr1.length)); // Expected output: 3

        // Test case 2
        int[] arr2 = {1, 3, 1, 4, 3, 1};
        System.out.println(longestMountain(arr2, arr2.length)); // Expected output: 4

        // Test case 3
        int[] arr3 = {3, 1, 3};
        System.out.println(longestMountain(arr3, arr3.length)); // Expected output: 0

        // Test case 4
        int[] arr4 = {4, 5, 1, 3};
        System.out.println(longestMountain(arr4, arr4.length)); // Expected output: 3

        // Test case 5
        int[] arr5 = {4, 5, 6, 7, 8};
        System.out.println(longestMountain(arr5, arr5.length)); // Expected output: 0

        // Test case 6
        int[] arr6 = {9, 3, 5, 4};
        System.out.println(longestMountain(arr6, arr6.length)); // Expected output: 3
    }
}
