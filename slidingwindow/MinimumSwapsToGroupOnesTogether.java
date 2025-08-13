package slidingwindow;

import java.util.Arrays;

/*
Problem Statement:
Given an array arr[] of size n containing only 0s and 1s, find the minimum number of swaps required to group all 1s together in any contiguous segment of the array. If there are no 1s, return -1.

Constraints:
- 1 <= n <= 10^5
- arr[i] is either 0 or 1

Sample Test Cases:
1. Input: arr = [1, 0, 1, 0, 1], n = 5
   Output: 1
   Explanation: Swap arr[3]=0 with arr[4]=1 to get [1, 0, 1, 1, 0], grouping 1s at indices 0, 2, 3.
2. Input: arr = [0, 0, 0], n = 3
   Output: -1
   Explanation: No 1s exist, so return -1.
3. Input: arr = [1, 1, 1, 0, 0], n = 5
   Output: 0
   Explanation: 1s are already grouped at indices 0, 1, 2, so no swaps needed.
*/

public class MinimumSwapsToGroupOnesTogether {
    public static int groupAllOneTogether(int arr[], int n) {
        // Count total number of 1s in the array
        int numberOfOnes = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 1) {
                numberOfOnes++;
            }
        }

        // Handle edge case: no 1s in the array
        if (numberOfOnes == 0) {
            return -1;
        }

        // Set window size to the number of 1s
        int windowSize = numberOfOnes;
        // Count 1s in the first window
        int currentOnes = 0;
        for (int i = 0; i < windowSize; i++) {
            if (arr[i] == 1) {
                currentOnes++;
            }
        }
        // Initialize maxOnesInWindow with the first window's count
        int maxOnesInWindow = currentOnes;

        // Slide the window across the array
        for (int i = windowSize; i < n; i++) {
            // Remove the leftmost element of the previous window
            if (arr[i - windowSize] == 1) {
                currentOnes--;
            }
            // Add the next element to the window
            if (arr[i] == 1) {
                currentOnes++;
            }
            // Update the maximum number of 1s found in any window
            maxOnesInWindow = Math.max(maxOnesInWindow, currentOnes);
        }

        // Minimum swaps = total 1s - max 1s in any window
        return numberOfOnes - maxOnesInWindow;
    }

    public static void main(String[] args) {
        // Test Case 1: arr = [1, 0, 1, 0, 1]
        int[] arr1 = {1, 0, 1, 0, 1};
        System.out.println("Test Case 1: " + groupAllOneTogether(arr1, arr1.length)); // Expected: 1

        // Test Case 2: arr = [0, 0, 0]
        int[] arr2 = {0, 0, 0};
        System.out.println("Test Case 2: " + groupAllOneTogether(arr2, arr2.length)); // Expected: -1

        // Test Case 3: arr = [1, 1, 1, 0, 0]
        int[] arr3 = {1, 1, 1, 0, 0};
        System.out.println("Test Case 3: " + groupAllOneTogether(arr3, arr3.length)); // Expected: 0
    }
}
