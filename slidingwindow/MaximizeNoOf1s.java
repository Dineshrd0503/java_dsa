package slidingwindow;

// Problem Statement:
// Given a binary array arr[] consisting of 0s and 1s, and an integer k, find the length of the longest subarray
// that can be made consisting entirely of 1s by flipping at most k 0s to 1s.
//
// Examples:
// Input: arr[] = [1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0], k = 2
// Output: 6
// Explanation: Flip the two 0s at indices 3 and 4 to get [1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0],
// the longest subarray of length 6 (indices 0 to 5) is all 1s.
//
// Input: arr[] = [0, 0, 1, 1, 0], k = 1
// Output: 4
// Explanation: Flip the 0 at index 0 to get [1, 0, 1, 1, 0], the longest subarray of length 4
// (indices 0 to 3) can be made all 1s.
//
// Constraints:
// 1 <= arr.length <= 10^5
// 0 <= k <= arr.length
// arr[i] is either 0 or 1

public class MaximizeNoOf1s {
    public int maxOnes(int[] arr, int k) {
        int n = arr.length;
        int left = 0;
        int zeroCount = 0;
        int maxLen = 0;

        for (int right = 0; right < n; right++) {
            if (arr[right] == 0) {
                zeroCount++;
            }

            while (zeroCount > k) {
                if (arr[left] == 0) {
                    zeroCount--;
                }
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        MaximizeNoOf1s solution = new MaximizeNoOf1s();

        // Test Case 1
        int[] arr1 = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        int k1 = 2;
        System.out.println("Maximum length of subarray with k = " + k1 + ": " + solution.maxOnes(arr1, k1)); // Expected: 6

        // Test Case 2
        int[] arr2 = {0, 0, 1, 1, 0};
        int k2 = 1;
        System.out.println("Maximum length of subarray with k = " + k2 + ": " + solution.maxOnes(arr2, k2)); // Expected: 4
    }
}