package binarysearch;

/*
 * PROBLEM STATEMENT:
 * ==================
 *
 * Elements in Range [a, b]
 * Difficulty: Medium
 * Accuracy: 63.8%
 * Points: 4
 *
 * Given an unsorted array arr[] and a 2D array queries[][] of size q,
 * where each query is in the form of [a, b]. For each query, count how many
 * elements in arr[] lie within the range [a, b], i.e., elements satisfying
 * a ≤ x ≤ b.
 *
 * Return the results for all queries as a list of integers, where each integer
 * corresponds to the count of elements in the respective query range.
 *
 * EXAMPLE 1:
 * ==========
 * Input: arr[] = [1, 4, 2, 8, 5], queries[][] = [[1, 4], [3, 6], [0, 10]]
 * Output: [3, 2, 5]
 * Explanation:
 *   Query [1, 4]: Elements in range → [1, 4, 2] → Count = 3
 *   Query [3, 6]: Elements in range → [4, 5] → Count = 2
 *   Query [0, 10]: All elements → [1, 4, 2, 8, 5] → Count = 5
 *
 * EXAMPLE 2:
 * ==========
 * Input: arr[] = [10, 20, 30, 40, 50], queries[][] = [[5, 15], [25, 45], [10, 50]]
 * Output: [1, 2, 5]
 * Explanation:
 *   Query [5, 15]: Elements in range → [10] → Count = 1
 *   Query [25, 45]: Elements in range → [30, 40] → Count = 2
 *   Query [10, 50]: Elements in range → [10, 20, 30, 40, 50] → Count = 5
 *
 * CONSTRAINTS:
 * ============
 * 1 ≤ arr.size(), q ≤ 10^5
 * 0 ≤ arr[i] ≤ 10^6
 * 0 ≤ queries[i][0] ≤ queries[i][1] ≤ 10^6
 *
 * TIME COMPLEXITY: O(n log n + q log n)
 * SPACE COMPLEXITY: O(1)
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

    /**
     * Main method to count elements in range for multiple queries
     * Uses binary search approach for optimal time complexity
     */

// Main class to test the solution
public class ElementsInRangeAToB {
        public ArrayList<Integer> cntInRange(int[] arr, int[][] queries) {
            // Sort the array to enable binary search
            Arrays.sort(arr);

            ArrayList<Integer> result = new ArrayList<>();

            // Process each query
            for (int[] query : queries) {
                int a = query[0];  // lower bound (inclusive)
                int b = query[1];  // upper bound (inclusive)

                // Find the leftmost position where element >= a
                int low = lowerbound(arr, a);

                // Find the rightmost position where element <= b
                int high = upperbound(arr, b);

                // Count elements in range [a, b]
                int val = high - low;
                result.add(val);
            }

            return result;
        }

        /**
         * Binary search to find the first element >= target (lower bound)
         * @param arr - sorted array
         * @param target - value to search for
         * @return index of first element >= target
         */
        int lowerbound(int[] arr, int target) {
            int low = 0, high = arr.length;

            while (low < high) {
                int mid = low + (high - low) / 2;
                if (arr[mid] < target) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
            return low;
        }

        /**
         * Binary search to find the count of elements <= target (upper bound)
         * @param arr - sorted array
         * @param target - value to search for
         * @return count of elements <= target
         */
        int upperbound(int[] arr, int target) {
            int low = 0, high = arr.length;

            while (low < high) {
                int mid = low + (high - low) / 2;
                if (arr[mid] <= target) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
            return low;
        }



    public static void main(String[] args) {
        ElementsInRangeAToB solution = new ElementsInRangeAToB();




        System.out.println("====== Elements in Range [a, b] Solution ======\n");

        // Test Case 1
        System.out.println("Test Case 1:");
        int[] arr1 = {1, 4, 2, 8, 5};
        int[][] queries1 = {{1, 4}, {3, 6}, {0, 10}};

        System.out.println("Input array: " + Arrays.toString(arr1));
        System.out.println("Queries: " + Arrays.deepToString(queries1));

        ArrayList<Integer> result1 = solution.cntInRange(arr1, queries1);
        System.out.println("Output: " + result1);
        System.out.println("Expected: [3, 2, 5]");
        System.out.println("Status: " + (result1.toString().equals("[3, 2, 5]") ? "✓ PASS" : "✗ FAIL"));

        System.out.println("\nExplanation:");
        System.out.println("Query [1, 4]: Elements in range → [1, 4, 2] → Count = 3");
        System.out.println("Query [3, 6]: Elements in range → [4, 5] → Count = 2");
        System.out.println("Query [0, 10]: All elements → [1, 4, 2, 8, 5] → Count = 5");

        // Test Case 2
        System.out.println("\n" + "=".repeat(50));
        System.out.println("Test Case 2:");
        int[] arr2 = {10, 20, 30, 40, 50};
        int[][] queries2 = {{5, 15}, {25, 45}, {10, 50}};

        System.out.println("Input array: " + Arrays.toString(arr2));
        System.out.println("Queries: " + Arrays.deepToString(queries2));

        ArrayList<Integer> result2 = solution.cntInRange(arr2, queries2);
        System.out.println("Output: " + result2);
        System.out.println("Expected: [1, 2, 5]");
        System.out.println("Status: " + (result2.toString().equals("[1, 2, 5]") ? "✓ PASS" : "✗ FAIL"));

        System.out.println("\nExplanation:");
        System.out.println("Query [5, 15]: Elements in range → [10] → Count = 1");
        System.out.println("Query [25, 45]: Elements in range → [30, 40] → Count = 2");
        System.out.println("Query [10, 50]: Elements in range → [10, 20, 30, 40, 50] → Count = 5");

        // Test Case 3
        System.out.println("\n" + "=".repeat(50));
        System.out.println("Test Case 3:");
        int[] arr3 = {5, 10, 15, 20, 25};
        int[][] queries3 = {{0, 5}, {10, 15}, {25, 30}};

        System.out.println("Input array: " + Arrays.toString(arr3));
        System.out.println("Queries: " + Arrays.deepToString(queries3));

        ArrayList<Integer> result3 = solution.cntInRange(arr3, queries3);
        System.out.println("Output: " + result3);
        System.out.println("Expected: [1, 2, 1]");
        System.out.println("Status: " + (result3.toString().equals("[1, 2, 1]") ? "✓ PASS" : "✗ FAIL"));

        System.out.println("\nExplanation:");
        System.out.println("Query [0, 5]: Elements in range → [5] → Count = 1");
        System.out.println("Query [10, 15]: Elements in range → [10, 15] → Count = 2");
        System.out.println("Query [25, 30]: Elements in range → [25] → Count = 1");

        System.out.println("\n" + "=".repeat(50));
        System.out.println("All tests completed!");
    }
}
