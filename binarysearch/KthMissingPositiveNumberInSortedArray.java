package binarysearch;

/*
================================================================================
PROBLEM STATEMENT:
================================================================================
Given a sorted array of distinct positive integers arr[], you need to find
the kth positive number that is missing from the arr[].

EXAMPLES:
1. Input: arr[] = [2, 3, 4, 7, 11], k = 5
   Output: 9
   Explanation: Missing are 1, 5, 6, 8, 9, 10… and 5th missing number is 9.

2. Input: arr[] = [1, 2, 3], k = 2
   Output: 5
   Explanation: Missing are 4, 5, 6… and 2nd missing number is 5.

3. Input: arr[] = [3, 5, 9, 10, 11, 12], k = 2
   Output: 2
   Explanation: Missing are 1, 2, 4, 6… and 2nd missing number is 2.

CONSTRAINTS:
- 1 ≤ arr.size() ≤ 10^5
- 1 ≤ k ≤ 10^5
- 1 ≤ arr[i] ≤ 10^6

EXPECTED COMPLEXITIES:
- Time Complexity: O(log n)
- Auxiliary Space: O(1)

APPROACH: Binary Search
================================================================================
*/

public class KthMissingPositiveNumberInSortedArray {

    /**
     * Binary Search Approach
     *
     * Algorithm:
     * 1. Use binary search to find the position where kth missing number should be
     * 2. At each step, calculate how many numbers are missing up to arr[mid]
     * 3. Missing count = arr[mid] - (mid + 1)
     *    This works because if no numbers were missing, arr[mid] should equal mid+1
     * 4. If missing count < k, kth missing is to the right (left = mid + 1)
     * 5. Else, kth missing is to the left (right = mid - 1)
     * 6. Final answer: left + k
     *
     * Why left + k works at the end?
     * - 'left' becomes the position after all elements we've checked
     * - We still need 'k' more positive integers from that position
     * - So the answer is left + k
     */
    public static int kthMissing(int[] arr, int k) {
        int left = 0;
        int right = arr.length - 1;

        // Binary search loop
        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Count how many numbers are missing up to arr[mid]
            // arr[mid] should be at position (mid + 1) if no numbers were missing
            int missingCount = arr[mid] - (mid + 1);

            if (missingCount < k) {
                // kth missing is to the right, need to search further
                left = mid + 1;
            } else {
                // kth missing is to the left or before this position
                right = mid - 1;
            }
        }

        // left is the insertion position for kth missing number
        // Answer = left + k (starting position + k missing numbers needed)
        return left + k;
    }

    /**
     * Main method with test cases
     */
    public static void main(String[] args) {
        System.out.println("=".repeat(70));
        System.out.println("Kth Missing Positive Number in a Sorted Array");
        System.out.println("=".repeat(70));

        // Test Case 1
        System.out.println("\nTest Case 1:");
        int[] arr1 = {2, 3, 4, 7, 11};
        int k1 = 5;
        int result1 = kthMissing(arr1, k1);
        System.out.println("Input: arr = " + java.util.Arrays.toString(arr1) + ", k = " + k1);
        System.out.println("Output: " + result1);
        System.out.println("Expected: 9");
        System.out.println("Explanation: Missing are 1, 5, 6, 8, 9, 10... and 5th missing = 9");
        System.out.println("Status: " + (result1 == 9 ? "✓ PASS" : "✗ FAIL"));

        // Test Case 2
        System.out.println("\n" + "-".repeat(70));
        System.out.println("Test Case 2:");
        int[] arr2 = {1, 2, 3};
        int k2 = 2;
        int result2 = kthMissing(arr2, k2);
        System.out.println("Input: arr = " + java.util.Arrays.toString(arr2) + ", k = " + k2);
        System.out.println("Output: " + result2);
        System.out.println("Expected: 5");
        System.out.println("Explanation: Missing are 4, 5, 6... and 2nd missing = 5");
        System.out.println("Status: " + (result2 == 5 ? "✓ PASS" : "✗ FAIL"));

        // Test Case 3
        System.out.println("\n" + "-".repeat(70));
        System.out.println("Test Case 3:");
        int[] arr3 = {3, 5, 9, 10, 11, 12};
        int k3 = 2;
        int result3 = kthMissing(arr3, k3);
        System.out.println("Input: arr = " + java.util.Arrays.toString(arr3) + ", k = " + k3);
        System.out.println("Output: " + result3);
        System.out.println("Expected: 2");
        System.out.println("Explanation: Missing are 1, 2, 4, 6... and 2nd missing = 2");
        System.out.println("Status: " + (result3 == 2 ? "✓ PASS" : "✗ FAIL"));

        // Test Case 4 - Edge Case
        System.out.println("\n" + "-".repeat(70));
        System.out.println("Test Case 4 (Edge Case - Single Element):");
        int[] arr4 = {5};
        int k4 = 3;
        int result4 = kthMissing(arr4, k4);
        System.out.println("Input: arr = " + java.util.Arrays.toString(arr4) + ", k = " + k4);
        System.out.println("Output: " + result4);
        System.out.println("Expected: 3");
        System.out.println("Explanation: Missing are 1, 2, 3, 4... and 3rd missing = 3");
        System.out.println("Status: " + (result4 == 3 ? "✓ PASS" : "✗ FAIL"));

        // Test Case 5 - Edge Case
        System.out.println("\n" + "-".repeat(70));
        System.out.println("Test Case 5 (Edge Case - k = 1):");
        int[] arr5 = {2, 4, 5};
        int k5 = 1;
        int result5 = kthMissing(arr5, k5);
        System.out.println("Input: arr = " + java.util.Arrays.toString(arr5) + ", k = " + k5);
        System.out.println("Output: " + result5);
        System.out.println("Expected: 1");
        System.out.println("Explanation: First missing number is 1");
        System.out.println("Status: " + (result5 == 1 ? "✓ PASS" : "✗ FAIL"));

        System.out.println("\n" + "=".repeat(70));
        System.out.println("Time Complexity: O(log n) - Binary Search");
        System.out.println("Space Complexity: O(1) - No extra space used");
        System.out.println("=".repeat(70));
    }
}
