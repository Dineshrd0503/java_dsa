package geeksforgeeks;

import java.util.Arrays;
//Given an array of integers arr[] representing a permutation, implement the next permutation that rearranges the numbers into the lexicographically next greater permutation. If no such permutation exists, rearrange the numbers into the lowest possible order (i.e., sorted in ascending order).
//
//Note - A permutation of an array of integers refers to a specific arrangement of its elements in a sequence or linear order.
//
//        Examples:
//
//Input: arr = [2, 4, 1, 7, 5, 0]
//Output: [2, 4, 5, 0, 1, 7]
//Explanation: The next permutation of the given array is {2, 4, 5, 0, 1, 7}.
//Input: arr = [3, 2, 1]
//Output: [1, 2, 3]
//Explanation: As arr[] is the last permutation, the next permutation is the lowest one.
//Input: arr = [3, 4, 2, 5, 1]
//Output: [3, 4, 5, 1, 2]
//Explanation: The next permutation of the given array is {3, 4, 5, 1, 2}.


public class NextPermutation {
    static void nextPermutation(int[] a) {
        int index = -1;
        int n = a.length;

        // Step 1: Find the pivot index
        for (int i = n - 2; i >= 0; i--) {
            if (a[i] < a[i + 1]) {
                index = i;
                break;
            }
        }

        // Step 2: If no pivot, reverse the array to get the smallest permutation
        if (index == -1) {
            reverse(a, 0, n - 1);
            return;
        }

        // Step 3: Find the rightmost element greater than the pivot
        for (int i = n - 1; i > index; i--) {
            if (a[i] > a[index]) {
                // Swap the pivot and the rightmost successor
                int temp = a[i];
                a[i] = a[index];
                a[index] = temp;
                break;
            }
        }

        // Step 4: Reverse the suffix
        reverse(a, index + 1, n - 1);
    }

    // Helper function to reverse an array segment
    static void reverse(int[] a, int start, int end) {
        while (start < end) {
            int temp = a[start];
            a[start] = a[end];
            a[end] = temp;
            start++;
            end--;
        }
    }
    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        nextPermutation(a);
        System.out.println(Arrays.toString(a)); // Output: [1, 3, 2]
    }

}
