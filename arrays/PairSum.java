package arrays;

public class PairSum {
    /*
     * Problem Statement:
     * Given an array/list 'ARR' consisting of 'N' distinct integers arranged in ascending order
     * and an integer 'TARGET', count all distinct pairs in 'ARR' such that their sum equals 'TARGET'.
     * Note:
     * 1. Pair (x, y) and Pair (y, x) are considered the same pair.
     * 2. If no such pair exists with sum equal to 'TARGET', return -1.
     *
     * Constraints:
     * - 1 <= T <= 100 (number of test cases)
     * - 2 <= N <= 5000 (size of array)
     * - 1 <= ARR[i], TARGET <= 10^5 (array elements and target value)
     *
     * Sample Input 1:
     * T = 2
     * Test Case 1: N = 5, TARGET = 6, ARR = [1, 2, 3, 4, 5]
     * Test Case 2: N = 6, TARGET = 7, ARR = [1, 2, 3, 4, 5, 6]
     * Sample Output 1:
     * 2
     * 3
     * Explanation:
     * - Test Case 1: Pairs with sum 6 are (1, 5) and (2, 4). Output: 2.
     * - Test Case 2: Pairs with sum 7 are (1, 6), (2, 5), and (3, 4). Output: 3.
     *
     * Sample Input 2:
     * T = 2
     * Test Case 1: N = 4, TARGET = 10, ARR = [1, 3, 5, 6]
     * Test Case 2: N = 5, TARGET = 12, ARR = [1, 3, 6, 9, 11]
     * Sample Output 2:
     * -1
     * 2
     * Explanation:
     * - Test Case 1: No pairs sum to 10. Output: -1.
     * - Test Case 2: Pairs with sum 12 are (1, 11) and (3, 9). Output: 2.
     */

    public static int pairSum(int arr[], int n, int target) {
        int i = 0, j = n - 1;
        int count = 0;
        while (i < j) { // Ensure i < j to count each pair (x, y) once
            int sum = arr[i] + arr[j];
            if (sum == target) {
                count++;
                i++;
                j--;
            } else if (sum < target) {
                i++;
            } else {
                j--;
            }
        }
        return count == 0 ? -1 : count; // Return -1 if no pairs found, else return count
    }

    public static void main(String[] args) {
        // Test Case 1 from Sample Input 1
        int[] arr1 = {1, 2, 3, 4, 5};
        int n1 = 5, target1 = 6;
        System.out.println("Sample Input 1, Test Case 1 Output: " + pairSum(arr1, n1, target1)); // Expected: 2

        // Test Case 2 from Sample Input 1
        int[] arr2 = {1, 2, 3, 4, 5, 6};
        int n2 = 6, target2 = 7;
        System.out.println("Sample Input 1, Test Case 2 Output: " + pairSum(arr2, n2, target2)); // Expected: 3

        // Test Case 1 from Sample Input 2
        int[] arr3 = {1, 3, 5, 6};
        int n3 = 4, target3 = 10;
        System.out.println("Sample Input 2, Test Case 1 Output: " + pairSum(arr3, n3, target3)); // Expected: -1

        // Test Case 2 from Sample Input 2
        int[] arr4 = {1, 3, 6, 9, 11};
        int n4 = 5, target4 = 12;
        System.out.println("Sample Input 2, Test Case 2 Output: " + pairSum(arr4, n4, target4)); // Expected: 2
    }
}
