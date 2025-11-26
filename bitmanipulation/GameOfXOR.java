package bitmanipulation;

/*
 * Problem Statement: Game of XOR
 *
 * You are given an integer array arr[].
 * The value of a subarray is defined as the bitwise XOR of all elements in that subarray.
 * Your task is to compute the bitwise XOR of the values of all possible subarrays of arr[].
 *
 * Example:
 * Input: arr[] = [1, 2, 3]
 * Output: 2
 * Explanation:
 * All possible subarrays:
 * [1] -> 1
 * [2] -> 2
 * [3] -> 3
 * [1,2] -> 1^2 = 3
 * [2,3] -> 2^3 = 1
 * [1,2,3] -> 1^2^3 = 0
 * XOR of all subarray XOR values = 1^2^3^3^1^0 = 2
 */

public class GameOfXOR {
    // Function to compute the XOR of values of all possible subarrays
    public static int subarrayXor(int[] arr) {
        int n = arr.length;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            int freq = (i + 1) * (n - i);
            // Include arr[i] if it appears in odd number of subarrays
            if (freq % 2 == 1) {
                ans ^= arr[i];
            }
        }
        return ans;
    }

    // Main method
    public static void main(String[] args) {
        int[] arr = {1, 2, 3}; // Example input
        int result = subarrayXor(arr);
        System.out.println("Output: " + result); // Output: 2
    }
}
