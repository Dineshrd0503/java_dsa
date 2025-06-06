package arrays;

import java.util.Arrays;

public class LinearSort {

    /*
    Problem Statement:
    You have an array 'A' with 'N' integers and an empty array 'B'.
    In one operation, you will remove the first or last element of array 'A' and push it at the back of the array 'B'.
    You must perform the above operation until the array 'A' becomes empty.
    Your task is to determine if it is possible to have the array 'B' sorted in non-decreasing order after performing all the operations. Return '1' in that case. Otherwise, return '0'.

    Input Format:
    The first line contains an integer 'T', which denotes the number of test cases to be run.
    The first line of each test case contains an integer 'N', denoting the length of the array 'A'.
    The second line of each test case contains 'N' space-separated integers, denoting the elements of the array 'A'.

    Output Format:
    Return '1' if it is possible to have the array 'B' sorted in non-decreasing order after performing all the operations. Otherwise, return '0'.

    Constraints:
    1 <= 'N' <= 10^5
    1 <= 'A[i]' <= 10^5

    Sample Input 1:
    2
    2
    2 1
    4
    1 2 1 2

    Sample Output 1:
    1
    0

    Explanation of Sample Input 1:
    Test case 1: B can be formed as [1, 2] which is sorted.
    Test case 2: It is not possible to form a sorted B.
    */

    // Function to determine if the array B can be sorted in non-decreasing order
    public static int canBeSorted(int n, int[] a) {
        int left = 0;
        int right = n - 1;
        int lastAdded = Integer.MIN_VALUE; // Initialize to the smallest possible value

        while (left <= right) {
            if (a[left] >= lastAdded && a[right] >= lastAdded) {
                // If both elements can be used
                if (a[left] <= a[right]) {
                    lastAdded = a[left]; // Add left element to B
                    left++; // Move left pointer right
                } else {
                    lastAdded = a[right]; // Add right element to B
                    right--; // Move right pointer left
                }
            } else if (a[left] >= lastAdded) {
                // Only the left element is valid
                lastAdded = a[left];
                left++;
            } else if (a[right] >= lastAdded) {
                // Only the right element is valid
                lastAdded = a[right];
                right--;
            } else {
                // Neither element can be taken to maintain order
                return 0; // Impossible to sort
            }
        }
        return 1; // Successfully sorted
    }

    public static void main(String[] args) {
        // Static inputs
        int T = 2; // Number of test cases

        int[][] testCases = {
                {2, 2, 1},               // Test case 1: N = 2, A = [2, 1]
                {4, 1, 2, 1, 2}         // Test case 2: N = 4, A = [1, 2, 1, 2]
        };

        // Process each test case
        for (int t = 0; t < T; t++) {
            int N = testCases[t][0]; // Length of array A from test case
            int[] A = Arrays.copyOfRange(testCases[t], 1, N + 1); // Populate array A

            // Call the function and print the result
            int result = canBeSorted(N, A);
            System.out.println(result); // Output the result for each test case
        }
    }
}
