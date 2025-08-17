package arrays;
import java.util.Arrays;
import java.util.Comparator;

// Problem Statement:
// You are given a number x and array arr[]. Your task is to rearrange the elements of the array according to the absolute difference with x,
// i.e., an element having minimum difference comes first, and so on.
// Note: If two or more elements are at equal distances arrange them in the same sequence as in the given array.
// Examples:
// Input: x = 7, arr[] = [10, 5, 3, 9, 2] -> Output: [5, 9, 10, 3, 2]
// Input: x = 6, arr[] = [1, 2, 3, 4, 5] -> Output: [5, 4, 3, 2, 1]
// Constraints:
// 1 ≤ x ≤ 10^5
// 1 ≤ arr.size() ≤ 10^5
// 1 ≤ arr[i] ≤ 10^5
// Expected Complexities:
// Time Complexity: O(n log n)
// Auxiliary Space: O(1)

public class SortArrayByAbsoluteDifference {
    public void rearrange(int[] arr, int x) {
        // Convert int[] to Integer[] to use Comparator
        Integer[] wrappedArr = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            wrappedArr[i] = arr[i];
        }

        // Define comparator for absolute difference
        Comparator<Integer> comparator = (a, b) -> {
            int diffA = Math.abs(a - x);
            int diffB = Math.abs(b - x);
            if (diffA != diffB) {
                return Integer.compare(diffA, diffB); // Sort by difference
            }
            return 0; // Maintain original order for equal differences
        };

        // Sort the wrapped array
        Arrays.sort(wrappedArr, comparator);

        // Copy back to original array
        for (int i = 0; i < arr.length; i++) {
            arr[i] = wrappedArr[i];
        }
    }

    public static void main(String[] args) {
        SortArrayByAbsoluteDifference solution = new SortArrayByAbsoluteDifference();
        // Test Case 1
        int[] arr1 = {10, 5, 3, 9, 2};
        int x1 = 7;
        solution.rearrange(arr1, x1);
        System.out.print("Output for x = 7, arr = [10, 5, 3, 9, 2]: ");
        for (int num : arr1) {
            System.out.print(num + " ");
        }
        System.out.println();

        // Test Case 2
        int[] arr2 = {1, 2, 3, 4, 5};
        int x2 = 6;
        solution.rearrange(arr2, x2);
        System.out.print("Output for x = 6, arr = [1, 2, 3, 4, 5]: ");
        for (int num : arr2) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
