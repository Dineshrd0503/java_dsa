package slidingwindow;

public class CountSubarrays {
    /*
     * Problem Statement:
     * You are given an array/list consisting of 0 and 1 only. Your task is to find the sum of the number of subarrays
     * that contains only 1 and the number of subarrays that contains only 0.
     * A subarray of array 'D' is obtained by deleting several elements from the beginning and several elements from the end.
     *
     * Input Format:
     * - First line contains T, the number of test cases (1 <= T <= 100).
     * - For each test case:
     *   - First line contains N, the size of the array (1 <= N <= 5000).
     *   - Second line contains N space-separated integers, each either 0 or 1.
     *
     * Output Format:
     * - For each test case, print a single integer: the sum of the number of subarrays containing only 1s and only 0s.
     *
     * Constraints:
     * - 1 <= T <= 100
     * - 1 <= N <= 5000
     * - 0 <= ARR[i] <= 1
     *
     * Sample Input 1:
     * 2
     * 7
     * 1 0 0 0 1 0 1
     * 8
     * 1 0 1 0 1 0 1 0
     *
     * Sample Output 1:
     * 10
     * 8
     *
     * Explanation for Sample Input 1:
     * Test Case 1: ARR = [1, 0, 0, 0, 1, 0, 1]
     * - All-1s subarrays: [1] (index 0), [1] (index 4), [1] (index 6) -> 3 subarrays
     * - All-0s subarrays: [0] (index 1), [0] (index 2), [0] (index 3), [0, 0] (1-2), [0, 0] (2-3), [0, 0, 0] (1-3), [0] (index 5) -> 7 subarrays
     * - Total: 3 + 7 = 10
     *
     * Test Case 2: ARR = [1, 0, 1, 0, 1, 0, 1, 0]
     * - All-1s subarrays: [1] (index 0), [1] (index 2), [1] (index 4), [1] (index 6) -> 4 subarrays
     * - All-0s subarrays: [0] (index 1), [0] (index 3), [0] (index 5), [0] (index 7) -> 4 subarrays
     * - Total: 4 + 4 = 8
     *
     * Sample Input 2:
     * 2
     * 6
     * 1 1 1 1 1 1
     * 8
     * 1 0 0 0 0 0 0 1
     *
     * Sample Output 2:
     * 21
     * 23
     *
     * Explanation for Sample Input 2:
     * Test Case 1: ARR = [1, 1, 1, 1, 1, 1]
     * - All-1s subarrays: [1], [1], [1], [1], [1], [1], [1, 1], [1, 1], [1, 1], [1, 1], [1, 1], [1, 1, 1], [1, 1, 1], [1, 1, 1], [1, 1, 1], [1, 1, 1, 1], [1, 1, 1, 1], [1, 1, 1, 1], [1, 1, 1, 1, 1], [1, 1, 1, 1, 1], [1, 1, 1, 1, 1, 1] -> 21 subarrays
     * - All-0s subarrays: None -> 0 subarrays
     * - Total: 21 + 0 = 21
     *
     * Test Case 2: ARR = [1, 0, 0, 0, 0, 0, 0, 1]
     * - All-1s subarrays: [1] (index 0), [1] (index 7) -> 2 subarrays
     * - All-0s subarrays: [0], [0], [0], [0], [0], [0], [0, 0], [0, 0], [0, 0], [0, 0], [0, 0], [0, 0, 0], [0, 0, 0], [0, 0, 0], [0, 0, 0], [0, 0, 0], [0, 0, 0, 0], [0, 0, 0, 0], [0, 0, 0, 0], [0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0] -> 21 subarrays
     * - Total: 2 + 21 = 23
     */

    public static void main(String[] args) {
        // Static inputs for test cases (Sample Input 1 and Sample Input 2 combined)
        int[][] testCases = {
                {1, 0, 0, 0, 1, 0, 1},           // Sample Input 1, Test Case 1: n = 7
                {1, 0, 1, 0, 1, 0, 1, 0},        // Sample Input 1, Test Case 2: n = 8
                {1, 1, 1, 1, 1, 1},              // Sample Input 2, Test Case 1: n = 6
                {1, 0, 0, 0, 0, 0, 0, 1}         // Sample Input 2, Test Case 2: n = 8
        };

        // Process each test case
        for (int[] arr : testCases) {
            int n = arr.length;
            // Compute and print the result for the current test case
            System.out.println(numberofSubarrays(n, arr));
        }
    }

    public static int numberofSubarrays(int n, int[] arr) {
        // Initialize total count of all-1s and all-0s subarrays
        long totalSubarrays = 0;

        // Initialize length of the current run, starting with the first element
        int currentLength = 1;

        // Iterate through the array starting from the second element
        for (int i = 1; i <= n; i++) {
            // Check if we've reached the end or if the current element differs from the previous
            if (i == n || arr[i] != arr[i - 1]) {
                // Calculate subarrays for the current run: k * (k + 1) / 2
                totalSubarrays += (long) currentLength * (currentLength + 1) / 2;

                // Reset run length for the next run
                currentLength = 1;
            } else {
                // Increment length of the current run of identical elements
                currentLength++;
            }
        }

        // Return total count as integer (no overflow within constraints)
        return (int) totalSubarrays;
    }
}
