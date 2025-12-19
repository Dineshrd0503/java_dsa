package stacks;
import java.util.Stack;

/*
 * PROBLEM STATEMENT:
 * ==================
 * Given an array of integers arr, find the sum of min(b), where b ranges
 * over every (contiguous) subarray of arr. Since the answer may be large,
 * return the answer modulo 10^9 + 7.
 *
 * Example 1:
 * Input: arr = [3,1,2,4]
 * Output: 17
 * Explanation: Subarrays are [3],[1],[2],[4],[3,1],[1,2],[2,4],
 * [3,1,2],[1,2,4],[3,1,2,4]. Minimums are 3,1,2,4,1,1,2,1,1,1.
 * Sum is 17.
 *
 * Example 2:
 * Input: arr = [11,81,94,43,3]
 * Output: 444
 *
 * Constraints:
 * - 1 <= arr.length <= 3 * 10^4
 * - 1 <= arr[i] <= 3 * 10^4
 *
 * Difficulty: Medium
 * Approach: Monotonic Stack - Calculate contribution of each element
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

public class SumSubarrayMinimums {
    private static final int MOD = 1000000007;

    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        long result = 0;

        // For each element, find:
        // 1. How many subarrays where this element is the minimum
        // 2. This is determined by: elements to left that are >= current
        //    and elements to right that are > current

        Stack<Integer> stack = new Stack<>();
        long[] left = new long[n];   // Count of elements >= arr[i] on left
        long[] right = new long[n];  // Count of elements > arr[i] on right

        // Calculate left array (how far left can we extend with >= current)
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            left[i] = stack.isEmpty() ? i + 1 : i - stack.peek();
            stack.push(i);
        }

        // Clear stack for right calculation
        while (!stack.isEmpty()) stack.pop();

        // Calculate right array (how far right can we extend with > current)
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            right[i] = stack.isEmpty() ? n - i : stack.peek() - i;
            stack.push(i);
        }

        // Calculate result: contribution of each element
        for (int i = 0; i < n; i++) {
            long contribution = (arr[i] * left[i] % MOD * right[i] % MOD) % MOD;
            result = (result + contribution) % MOD;
        }

        return (int) result;
    }

    // Main method with test cases
    public static void main(String[] args) {
        SumSubarrayMinimums solution = new SumSubarrayMinimums();

        // Test Case 1
        int[] arr1 = {3, 1, 2, 4};
        int result1 = solution.sumSubarrayMins(arr1);
        System.out.println("Test Case 1: [3, 1, 2, 4]");
        System.out.println("Output: " + result1);
        System.out.println("Expected: 17");
        System.out.println("Explanation: Minimums from all subarrays: 3+1+2+4+1+1+2+1+1+1 = 17");
        System.out.println();

        // Test Case 2
        int[] arr2 = {11, 81, 94, 43, 3};
        int result2 = solution.sumSubarrayMins(arr2);
        System.out.println("Test Case 2: [11, 81, 94, 43, 3]");
        System.out.println("Output: " + result2);
        System.out.println("Expected: 444");
        System.out.println();

        // Test Case 3: Single element
        int[] arr3 = {5};
        int result3 = solution.sumSubarrayMins(arr3);
        System.out.println("Test Case 3: [5]");
        System.out.println("Output: " + result3);
        System.out.println("Expected: 5");
    }
}
