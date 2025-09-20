package binarysearch;

public class LongestSubarrayLength {

    /**
     * Finds the length of the longest subarray where all elements are less than or equal to the subarray's length.
     * This method uses binary search on the possible answer lengths.
     *
     * @param arr The input array of integers.
     * @return The length of the longest valid subarray.
     */
    public static int longestSubarray(int[] arr) {
        int n = arr.length;
        int low = 0;
        int high = n;
        int ans = 0;

        while (low <= high) {
            // 'mid' is the potential length we are checking
            int mid = low + (high - low) / 2;

            if (check(arr, mid)) {
                // If a subarray of length 'mid' exists, it's a possible answer.
                // We then try to find an even longer one.
                ans = mid;
                low = mid + 1;
            } else {
                // If not, 'mid' is too large. We need to check for shorter lengths.
                high = mid - 1;
            }
        }

        return ans;
    }

    /**
     * Helper function to check if a valid subarray of a given length 'k' exists.
     * A subarray is valid if it has length 'k' and all its elements are <= k.
     * This check is performed in O(n) time.
     *
     * @param arr The input array.
     * @param k   The length to check for.
     * @return True if a valid subarray of length k exists, false otherwise.
     */
    private static boolean check(int[] arr, int k) {
        // A subarray of length 0 is always possible (the empty subarray).
        if (k == 0) {
            return true;
        }

        // This counts consecutive elements that are valid for length 'k' (i.e., value <= k).
        int consecutiveCount = 0;

        for (int value : arr) {
            if (value <= k) {
                consecutiveCount++;
            } else {
                // If a value is > k, it breaks the streak.
                consecutiveCount = 0;
            }

            // If we find a streak of 'k' or more valid elements, we have found our answer.
            if (consecutiveCount >= k) {
                return true;
            }
        }

        // If we finish the loop without finding a long enough streak, it's not possible.
        return false;
    }
    public static void main(String[] args) {
        // Test cases
        int[] arr1 = {0, 1, 2, 3, 4};
        System.out.println("Test Case 1: " + longestSubarray(arr1)); // Expected Output: 5

        int[] arr2 = {2, 3, 4, 5, 6};
        System.out.println("Test Case 2: " + longestSubarray(arr2)); // Expected Output: 3

        int[] arr3 = {1, 2, 1, 2, 1};
        System.out.println("Test Case 3: " + longestSubarray(arr3)); // Expected Output: 3

        int[] arr4 = {5, 6, 7, 8};
        System.out.println("Test Case 4: " + longestSubarray(arr4)); // Expected Output: 0

        int[] arr5 = {3, 3, 3, 3, 3};
        System.out.println("Test Case 5: " + longestSubarray(arr5)); // Expected Output: 3
    }
}