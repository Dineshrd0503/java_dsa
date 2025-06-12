package arrays;
import java.util.Arrays;
/**
 * Solution to find the k closest elements to a given value x in a sorted array.
 * Uses binary search to find the closest position to x, then expands left and right
 * to select k elements based on minimum difference from x.
 */
public class KClosestElements {
    /**
     * Finds the k closest elements to x in a sorted array.
     * @param array Sorted input array
     * @param k Number of closest elements to find
     * @param x Target value
     * @return Array of k closest elements in ascending order
     */
    public int[] printKClosest(int[] array, int k, int x) {
        int n = array.length;
        // Binary search to find insertion point of x
        int index = Arrays.binarySearch(array, x);

        // If x not found, get insertion point
        if (index < 0) {
            index = -(index + 1);
        }

        // Initialize pointers
        int left = index - 1;
        int right = index;

        // Array to store k closest elements
        int[] result = new int[k];
        int count = 0;

        // Compare elements from left and right based on difference from x
        while (count < k && left >= 0 && right < n) {
            int leftDiff = Math.abs(array[left] - x);
            int rightDiff = Math.abs(array[right] - x);

            // Choose smaller difference; prefer left for ties
            if (leftDiff <= rightDiff) {
                result[count++] = array[left--];
            } else {
                result[count++] = array[right++];
            }
        }

        // Add remaining left elements
        while (count < k && left >= 0) {
            result[count++] = array[left--];
        }

        // Add remaining right elements
        while (count < k && right < n) {
            result[count++] = array[right++];
        }

        // Sort result for ascending order
       if(count<k)
           return Arrays.copyOf(result, count);
        return result;
    }

    /**
     * Main method to test the printKClosest method with static inputs.
     */
    public static void main(String[] args) {
        KClosestElements solution = new KClosestElements();

        // Test Case 1: arr = [1, 2, 3, 4, 5], k = 4, x = 3
        int[] arr1 = {1, 2, 3, 4, 5};
        int k1 = 4;
        int x1 = 3;
        System.out.println("Test Case 1: " + Arrays.toString(solution.printKClosest(arr1, k1, x1)) +
                " (Expected: [1, 2, 3, 4])");

        // Test Case 2: arr = [1, 2, 3, 4, 5], k = 4, x = -1
        int[] arr2 = {1, 2, 3, 4, 5};
        int k2 = 4;
        int x2 = -1;
        System.out.println("Test Case 2: " + Arrays.toString(solution.printKClosest(arr2, k2, x2)) +
                " (Expected: [1, 2, 3, 4])");

        // Test Case 3: arr = [1, 1, 1, 10, 10, 10], k = 1, x = 9
        int[] arr3 = {1, 1, 1, 10, 10, 10};
        int k3 = 1;
        int x3 = 9;
        System.out.println("Test Case 3: " + Arrays.toString(solution.printKClosest(arr3, k3, x3)) +
                " (Expected: [10])");

        // Test Case 4: arr = [2, 4, 5, 6, 9], k = 3, x = 6
        int[] arr4 = {2, 4, 5, 6, 9};
        int k4 = 3;
        int x4 = 6;
        System.out.println("Test Case 4: " + Arrays.toString(solution.printKClosest(arr4, k4, x4)) +
                " (Expected: [4, 5, 6])");

        // Test Case 5: arr = [1], k = 1, x = 1
        int[] arr5 = {1};
        int k5 = 1;
        int x5 = 1;
        System.out.println("Test Case 5: " + Arrays.toString(solution.printKClosest(arr5, k5, x5)) +
                " (Expected: [1])");
    }
}

