import java.util.Arrays;

public class MaximizeMedianAfterDoingKOperations {
    public int maximizeMedian(int[] arr, int k) {
        // Step 1: Sort the array to easily identify the median position
        // Why? Sorting ensures the median is at index n/2, and we can work with ordered elements.
        Arrays.sort(arr);
        int n = arr.length;

        // Step 2: Initialize binary search range
        // Why? The median can range from the smallest possible value (0 or min(arr)) to a large value
        // where k operations can push it. Using 2*10^9 as an upper bound based on typical constraints.
        int low = 0; // Smallest possible median
        int high = 2000000000; // Largest possible median (adjusted for constraint safety)
        int ans = -1;

        // Step 3: Binary search for the maximum achievable median
        // Why? Efficiently narrows down the possible median values.
        while (low <= high) {
            int mid = low + (high - low) / 2; // Avoid overflow
            if (isValid(arr, k, mid)) {
                ans = mid; // Potential answer, try higher
                low = mid + 1;
            } else {
                high = mid - 1; // Median too high, reduce
            }
        }
        return ans;
    }

    // Step 4: Helper method to check if a median is achievable
    // Why? Determines if k operations can adjust the array to make the median >= mid.
    private boolean isValid(int[] arr, int k, int potentialMedian) {
        int n = arr.length;
        int medianIndex = n / 2; // Median position in 0-based sorted array

        // Step 5: Calculate cost to adjust elements from medianIndex onward
        // Why? Only elements >= medianIndex need to be >= potentialMedian to set the median.
        // Using long to handle potential overflow with large n or k.
        long cost = 0;
        for (int i = medianIndex; i < n; i++) {
            if (arr[i] < potentialMedian) {
                cost += (long)(potentialMedian - arr[i]);
            }
        }

        // Step 6: Check if cost is within k operations
        // Why? If cost <= k, we have enough operations to achieve this median.
        return cost <= k;
    }

    // Main method for testing
    public static void main(String[] args) {
        MaximizeMedianAfterDoingKOperations solution=new MaximizeMedianAfterDoingKOperations();

        // Test Case 1: arr = [2, 3, 4, 5, 6], k = 1
        int[] arr1 = {2, 3, 4, 5, 6};
        int k1 = 1;
        System.out.println("Maximized median for arr1 with k = " + k1 + ": " + solution.maximizeMedian(arr1, k1));

        // Test Case 2: arr = [1, 2, 3, 4, 5], k = 2
        int[] arr2 = {1, 2, 3, 4, 5};
        int k2 = 2;
        System.out.println("Maximized median for arr2 with k = " + k2 + ": " + solution.maximizeMedian(arr2, k2));
    }
}
