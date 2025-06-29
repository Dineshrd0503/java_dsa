package arrays;


/*
 * Problem: Split Array Largest Sum
 * Given an array of non-negative integers and an integer k, split the array into
 * at most k non-empty subarrays to minimize the maximum sum of any subarray.
 *
 * Input:
 * - arr: Array of non-negative integers
 * - k: Maximum number of subarrays (1 <= k <= arr.length)
 *
 * Output:
 * - Minimum possible maximum subarray sum
 *
 * Example:
 * Test Case 1: arr = [7, 2, 5, 10, 8], k = 2
 * Output: 18 (Split as [7, 2, 5], [10, 8])
 * Test Case 2: arr = [1, 2, 3, 4, 5], k = 2
 * Output: 9 (Split as [1, 2, 3], [4, 5])
 * Test Case 3: arr = [1, 4, 4], k = 3
 * Output: 4 (Split as [1], [4], [4])
 *
 * Constraints:
 * - 1 <= arr.length <= 1000
 * - 0 <= arr[i] <= 10^6
 * - 1 <= k <= arr.length
 */
public class SplitArrayMaximumSum {
    public int splitArray(int[] arr, int k) {
        int maxele = Integer.MIN_VALUE, sum = 0;
        for (int n : arr) {
            sum += n;
            maxele = Math.max(n, maxele);
        }
        int low = maxele, high = sum;
        int result = sum;
        while (low <= high) {
            int mid = (high + low) / 2;
            if (ispossible(arr, k, mid)) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return result;
    }

    private static boolean ispossible(int[] arr, int k, int mid) {
        int count = 1, sum = 0;
        for (int value : arr) {
            sum += value;
            if (sum > mid) {
                sum = value;
                count++;
                if (count > k) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        SplitArrayMaximumSum sol = new SplitArrayMaximumSum();
        int[][] arrays = {{7, 2, 5, 10, 8}, {1, 2, 3, 4, 5}, {1, 4, 4}};
        int[] kValues = {2, 2, 3};

        for (int t = 0; t < arrays.length; t++) {
            int result = sol.splitArray(arrays[t], kValues[t]);
            System.out.println("Test Case " + (t + 1) + ": " + result);
        }
    }
}
