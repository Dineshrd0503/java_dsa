package arrays;

public class FindSmallestMissingPositiveInteger {

    /**
     * You are given an integer array arr[]. Your task is to find the smallest positive number missing from the array.
     *
     * Note: Positive number starts from 1. The array can have negative integers too.
     *
     * Examples:
     *
     * Input: arr[] = [2, -3, 4, 1, 1, 7]
     * Output: 3
     * Explanation: Smallest positive missing number is 3.
     *
     * Input: arr[] = [5, 3, 2, 5, 1]
     * Output: 4
     * Explanation: Smallest positive missing number is 4.
     *
     * Input: arr[] = [-8, 0, -1, -4, -3]
     * Output: 1
     * Explanation: Smallest positive missing number is 1.
     *
     * Constraints:
     * 1 ≤ arr.size() ≤ 10^5
     * -10^6 ≤ arr[i] ≤ 10^6
     *
     * Time Complexity: O(n)
     * Auxiliary Space: O(1)
     * @param arr
     * @return
     */
    public int missingNumber(int[] arr) {
        int n = arr.length;

        // Cyclic sort to place each number at its correct index (if possible)
        for (int i = 0; i < n; i++) {
            while (arr[i] > 0 && arr[i] <= n && arr[i] - 1 >= 0 && arr[i] - 1 < n && arr[i] != arr[arr[i] - 1]) {
                swap(arr, i, arr[i] - 1);
            }
        }

        // Find the first index where the number is not equal to index + 1
        for (int i = 0; i < n; i++) {
            if (arr[i] != i + 1) {
                return i + 1;
            }
        }

        // If all numbers 1 to n are present, then the missing number is n + 1
        return n + 1;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        FindSmallestMissingPositiveInteger solution = new FindSmallestMissingPositiveInteger();

        // Test cases
        int[] arr1 = {2, -3, 4, 1, 1, 7};
        System.out.println("Smallest missing positive for [2, -3, 4, 1, 1, 7]: " + solution.missingNumber(arr1)); // Output: 3

        int[] arr2 = {5, 3, 2, 5, 1};
        System.out.println("Smallest missing positive for [5, 3, 2, 5, 1]: " + solution.missingNumber(arr2)); // Output: 4

        int[] arr3 = {-8, 0, -1, -4, -3};
        System.out.println("Smallest missing positive for [-8, 0, -1, -4, -3]: " + solution.missingNumber(arr3)); // Output: 1

        int[] arr4 = {1, 2, 0};
        System.out.println("Smallest missing positive for [1, 2, 0]: " + solution.missingNumber(arr4)); // Output: 3

        int[] arr5 = {3, 4, -1, 1};
        System.out.println("Smallest missing positive for [3, 4, -1, 1]: " + solution.missingNumber(arr5)); // Output: 2

        int[] arr6 = {7,8,9,11,12};
        System.out.println("Smallest missing positive for [7,8,9,11,12]: " + solution.missingNumber(arr6)); // Output: 1
    }
}
