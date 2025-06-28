package arrays;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Problem Statement:
 * You are given two unsorted arrays a[] and b[]. Both arrays may contain
 * duplicate elements. For each element in a[], your task is to count how many
 * elements in b[] are less than or equal to that element.
 *
 * Example 1:
 * Input: a[] = [4, 8, 7, 5, 1], b[] = [4, 48, 3, 0, 1, 1, 5]
 * Output: [5, 6, 6, 6, 3]
 * Explanation:
 * For a[0] = 4, there are 5 elements in b (4, 3, 0, 1, 1) that are <= 4.
 * For a[1] = 8 and a[2] = 7, there are 6 elements in b that are <= 8 and <= 7.
 * For a[3] = 5, there are 6 elements in b that are <= 5.
 * For a[4] = 1, there are 3 elements in b (0, 1, 1) that are <= 1.
 *
 * Example 2:
 * Input: a[] = [10, 20], b[] = [30, 40, 50]
 * Output: [0, 0]
 * Explanation:
 * For a[0] = 10 and a[1] = 20, there are no elements in b that are less than or
 * equal to 10 or 20. Hence, the output is [0, 0].
 *
 * Constraints:
 * 1 <= a.length, b.length <= 10^5
 * 0 <= a[i], b[j] <= 10^5
 */
public class CountingElementsInTwoArrays{

    /**
     * Counts the number of elements in array 'b' that are less than or equal to
     * each element in array 'a'.
     *
     * @param a The first array.
     * @param b The second array.
     * @return An ArrayList containing the counts for each element in 'a'.
     */
    public static ArrayList<Integer> countLessEq(int a[], int b[]) {
        ArrayList<Integer> ans = new ArrayList<>();
        Arrays.sort(b); // Sort array b for binary search

        for (int i = 0; i < a.length; i++) {
            int count = binarySearch(b, a[i]);
            ans.add(count);
        }

        return ans;
    }

    /**
     * Performs a binary search on the sorted array 'arr' to find the number of
     * elements less than or equal to 'key'.
     *
     * @param arr The sorted array to search.
     * @param key The value to search for.
     * @return The number of elements in 'arr' that are less than or equal to
     *         'key'.
     */

    private static int binarySearch(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;
        int count = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2; // Prevent overflow

            if (arr[mid] <= key) {
                // If the middle element is less than or equal to key,
                // then all elements to the left of mid are also less than or equal to key.
                // Update count to mid + 1, and search on the right side.
                count = mid + 1;
                low = mid + 1;
            } else {
                // If the middle element is greater than key, search on the left side.
                high = mid - 1;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        // Static Input and Sample Test Cases
        int[] a1 = {4, 8, 7, 5, 1};
        int[] b1 = {4, 48, 3, 0, 1, 1, 5};
        System.out.println("Input: a = " + Arrays.toString(a1) + ", b = " + Arrays.toString(b1));
        System.out.println("Output: " + countLessEq(a1, b1)); // Expected Output: [5, 6, 6, 6, 3]

        int[] a2 = {10, 20};
        int[] b2 = {30, 40, 50};
        System.out.println("Input: a = " + Arrays.toString(a2) + ", b = " + Arrays.toString(b2));
        System.out.println("Output: " + countLessEq(a2, b2)); // Expected Output: [0, 0]

        int[] a3 = {2, 2, 2};
        int[] b3 = {1, 2, 3};
        System.out.println("Input: a = " + Arrays.toString(a3) + ", b = " + Arrays.toString(b3));
        System.out.println("Output: " + countLessEq(a3, b3)); // Expected Output: [1, 1, 1]

        int[] a4 = {1, 2, 3, 4, 5};
        int[] b4 = {5, 4, 3, 2, 1};
        System.out.println("Input: a = " + Arrays.toString(a4) + ", b = " + Arrays.toString(b4));
        System.out.println("Output: " + countLessEq(a4, b4)); // Expected Output: [1, 2, 3, 4, 5]
    }
}
