package binarysearch;

import java.util.Arrays;

public class KokoEatingBananas {
    /**
     * Koko Eating Bananas
     *
     * Koko is given an array `arr[]`, where each element represents a pile of bananas.
     * She has exactly `k` hours to eat all the bananas.
     *
     * Each hour, Koko can choose one pile and eat up to `s` bananas from it.
     *
     *  If the pile has at least `s` bananas, she eats exactly `s` bananas.
     *  If the pile has fewer than `s` bananas, she eats the entire pile in that hour.
     *
     * Koko can only eat from one pile per hour.
     *
     * Your task is to find the minimum value of `s` (bananas per hour) such that
     * Koko can finish all the piles within `k` hours.
     *
     * Examples:
     *
     * Input: arr[] = [5, 10, 3], k = 4
     * Output: 5
     * Explanation: Koko eats at least 5 bananas per hour to finish all piles within
     * 4 hours, as she can consume each pile in 1 + 2 + 1 = 4 hours.
     *
     * Input: arr[] = [5, 10, 15, 20], k = 7
     * Output: 10
     * Explanation: At 10 bananas per hour, Koko finishes in 6 hours, just within
     * the limit 7.
     *
     * Constraint:
     * 1 <= arr.size() <= 10^5
     * 1 <= arr[i] <= 10^6
     * arr.size() <= k <= 10^6
     *
     * Expected Complexities
     * Time Complexity: O(n log(max(arr[i])))
     * Auxiliary Space: O(1)
     *
     */
    public int kokoEat(int[] arr, int k) {
        int low = 1;
        int high = Arrays.stream(arr).max().getAsInt();  // Find max element to set the search space
        int ans = high; //Initialize with max as a default

        while (low <= high) {
            int mid = low + (high - low) / 2; //To avoid integer overflow
            int hours = calculateHours(arr, mid);

            if (hours <= k) {
                ans = mid; // Store the current mid as a potential answer
                high = mid - 1; // Try to find a smaller 's' (bananas per hour)
            } else {
                low = mid + 1; // Need a larger 's' to finish within 'k' hours
            }
        }

        return ans;
    }

    private int calculateHours(int[] arr, int s) {
        int totalHours = 0;
        for (int pile : arr) {
            totalHours += (int) Math.ceil((double) pile / s);  //Round up to account for partial hours
        }
        return totalHours;
    }

    public static void main(String[] args) {
        KokoEatingBananas solution = new KokoEatingBananas();


        // Test cases
        int[] arr1 = {5, 10, 3};
        int k1 = 4;
        System.out.println("Input: arr = " + Arrays.toString(arr1) + ", k = " + k1 + ", Output: " + solution.kokoEat(arr1, k1)); // Expected: 5

        int[] arr2 = {5, 10, 15, 20};
        int k2 = 7;
        System.out.println("Input: arr = " + Arrays.toString(arr2) + ", k = " + k2 + ", Output: " + solution.kokoEat(arr2, k2)); // Expected: 10

        int[] arr3 = {3,6,7,11};
        int k3 = 8;
        System.out.println("Input: arr = " + Arrays.toString(arr3) + ", k = " + k3 + ", Output: " + solution.kokoEat(arr3, k3)); // Expected: 4

        int[] arr4 = {30,11,23,4,20};
        int k4 = 5;
        System.out.println("Input: arr = " + Arrays.toString(arr4) + ", k = " + k4 + ", Output: " + solution.kokoEat(arr4, k4)); // Expected: 30

        int[] arr5 = {1,1,1,1};
        int k5 = 4;
        System.out.println("Input: arr = " + Arrays.toString(arr5) + ", k = " + k5 + ", Output: " + solution.kokoEat(arr5, k5)); // Expected : 1

    }
}
