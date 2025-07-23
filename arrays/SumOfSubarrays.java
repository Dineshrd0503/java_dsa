package arrays;

public class SumOfSubarrays {

    /*
     * Given an array arr[], find the sum of all the subarrays of the given array.
     *
     * Note: It is guaranteed that the total sum will fit within a 32-bit integer
     * range.
     *
     * Examples:
     *
     * Input: arr[] = [1, 2, 3]
     * Output: 20
     * Explanation: All subarray sums are: [1] = 1, [2] = 2, [3] = 3, [1, 2] = 3,
     * [2, 3] = 5, [1, 2, 3] = 6. Thus total sum is 1 + 2 + 3 + 3 + 5 + 6 = 20.
     *
     * Input: arr[] = [1, 3]
     * Output: 8
     * Explanation: All subarray sums are: [1] = 1, [3] = 3, [1, 3] = 4. Thus total
     * sum is 1 + 3 + 4 = 8.
     *
     * Constraints :
     * 1 <= arr.size() <= 10^5
     * 0 <= arr[i] <= 10^4
     *
     * Expected Complexities
     * Time Complexity: O(n)
     * Auxiliary Space: O(1)
     */

    public static int subarraySum(int[] arr) {
        int n = arr.length;
        long totalSum = 0; // Use long to avoid potential overflow

        for (int i = 0; i < n; i++) {
            totalSum += (long) arr[i] * (i + 1) * (n - i);
        }

        return (int) totalSum; // Cast back to int as problem statement guarantees fit in 32-bit integer
    }

    public static void main(String[] args) {
        // Test cases
        int[] arr1 = { 1, 2, 3 };
        System.out.println("Input: [1, 2, 3], Output: " + subarraySum(arr1)); // Expected Output: 20

        int[] arr2 = { 1, 3 };
        System.out.println("Input: [1, 3], Output: " + subarraySum(arr2)); // Expected Output: 8

        int[] arr3 = { 1 };
        System.out.println("Input: [1], Output: " + subarraySum(arr3)); // Expected Output: 1

        int[] arr4 = { 1, 2, 3, 4, 5 };
        System.out.println("Input: [1, 2, 3, 4, 5], Output: " + subarraySum(arr4)); // Expected Output: 65

        int[] arr5 = { 10000, 10000 }; //testing potential overflow
        System.out.println("Input: [10000, 10000], Output: " + subarraySum(arr5)); // Expected Output: 60000
    }
}
