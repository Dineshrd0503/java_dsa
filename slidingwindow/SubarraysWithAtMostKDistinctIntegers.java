package slidingwindow;
import java.util.HashMap;

/**
 * You are given an array arr[] of positive integers and an integer k,
 * find the number of subarrays in arr[] where the count of distinct
 * integers is at most k.
 *
 * Note: A subarray is a contiguous part of an array.
 *
 * Examples:
 *
 * Input: arr[] = [1, 2, 2, 3], k = 2
 * Output: 9
 * Explanation: Subarrays with at most 2 distinct elements are:
 * [1], [2], [2], [3], [1, 2], [2, 2], [2, 3], [1, 2, 2] and [2, 2, 3].
 *
 * Input: arr[] = [1, 1, 1], k = 1
 * Output: 6
 * Explanation: Subarrays with at most 1 distinct element are:
 * [1], [1], [1], [1, 1], [1, 1] and [1, 1, 1].
 *
 * Input: arr[] = [1, 2, 1, 1, 3, 3, 4, 2, 1], k = 2
 * Output: 24
 * Explanation: There are 24 subarrays with at most 2 distinct elements.
 *
 * Constraints:
 * 1 <= arr.size() <= 2*10^4
 * 1 <= k <= 2*10^4
 * 1 <= arr[i] <= 10^9
 */
public class SubarraysWithAtMostKDistinctIntegers
 {

    /**
     * Counts the number of subarrays with at most k distinct integers.
     *
     * @param arr The input array of positive integers.
     * @param k   The maximum number of distinct integers allowed in a subarray.
     * @return The number of subarrays meeting the criteria.
     */
    public static int countAtMostK(int[] arr, int k) {
        int left = 0;
        int count = 0; // Initialize count to store the result
        HashMap<Integer, Integer> freqMap = new HashMap<>();

        for (int right = 0; right < arr.length; right++) {
            // Add the current element to the frequency map
            freqMap.put(arr[right], freqMap.getOrDefault(arr[right], 0) + 1);

            // If the number of distinct elements exceeds k, shrink the window
            while (freqMap.size() > k) {
                freqMap.put(arr[left], freqMap.get(arr[left]) - 1);
                if (freqMap.get(arr[left]) == 0) {
                    freqMap.remove(arr[left]);
                }
                left++;
            }

            // Add the number of subarrays ending at 'right' to the total count
            count += (right - left + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        // Sample Test Cases
        int[] arr1 = {1, 2, 2, 3};
        int k1 = 2;
        System.out.println("Input: arr[] = {1, 2, 2, 3}, k = " + k1);
        System.out.println("Output: " + countAtMostK(arr1, k1)); // Expected: 9

        int[] arr2 = {1, 1, 1};
        int k2 = 1;
        System.out.println("Input: arr[] = {1, 1, 1}, k = " + k2);
        System.out.println("Output: " + countAtMostK(arr2, k2)); // Expected: 6

        int[] arr3 = {1, 2, 1, 1, 3, 3, 4, 2, 1};
        int k3 = 2;
        System.out.println("Input: arr[] = {1, 2, 1, 1, 3, 3, 4, 2, 1}, k = " + k3);
        System.out.println("Output: " + countAtMostK(arr3, k3)); // Expected: 24

        int[] arr4 = {1, 2, 3, 4, 5};
        int k4 = 1;
        System.out.println("Input: arr[] = {1, 2, 3, 4, 5}, k = " + k4);
        System.out.println("Output: " + countAtMostK(arr4, k4)); //Expected: 5

        int [] arr5 = {1, 2, 3};
        int k5 = 3;
        System.out.println("Input: arr[] = {1, 2, 3}, k = " + k5);
        System.out.println("Output: " + countAtMostK(arr5, k5)); //Expected: 6
    }
}