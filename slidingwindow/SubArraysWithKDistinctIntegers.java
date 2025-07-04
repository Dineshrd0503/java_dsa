package slidingwindow;

import java.util.HashMap;

public class SubArraysWithKDistinctIntegers {

    /**
     * Problem: 992. Subarrays with K Different Integers
     * Given an integer array nums and an integer k, return the number of good subarrays of nums.
     *
     * A good array is an array where the number of different integers in that array is exactly k.
     *
     * For example, [1,2,3,1,2] has 3 different integers: 1, 2, and 3.
     *
     * A subarray is a contiguous part of an array.
     *
     * Example 1:
     *
     * Input: nums = [1,2,1,2,3], k = 2
     * Output: 7
     * Explanation: Subarrays formed with exactly 2 different integers: [1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2]
     *
     * Example 2:
     *
     * Input: nums = [1,2,1,3,4], k = 3
     * Output: 3
     * Explanation: Subarrays formed with exactly 3 different integers: [1,2,1,3], [2,1,3], [1,3,4].
     *
     * Constraints:
     *
     * 1 <= nums.length <= 2 * 10^4
     * 1 <= nums[i], k <= nums.length
     *
     *
     *  //Sample test cases as java comments:
     *     // int[] nums1 = {1,2,1,2,3};
     *     // int k1 = 2;
     *     // Output: 7
     *
     *     // int[] nums2 = {1,2,1,3,4};
     *     // int k2 = 3;
     *     // Output: 3
     *
     *     // int[] nums3 = {1,1,1,1};
     *     // int k3 = 1;
     *     // Output: 10
     *
     *     // int[] nums4 = {1,2,3,4,5};
     *     // int k4 = 1;
     *     // Output: 5
     * @param arr
     * @param k
     * @return
     */
    public static int subarraysWithKDistinct(int[] arr, int k) {
        int n = arr.length;
        return atMostK(arr, n, k) - atMostK(arr, n, k - 1);
    }

    private static int atMostK(int[] arr, int n, int k) {
        int left = 0;
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int right = 0; right < n; right++) {
            map.put(arr[right], map.getOrDefault(arr[right], 0) + 1);

            while (map.size() > k) {
                map.put(arr[left], map.get(arr[left]) - 1);
                if (map.get(arr[left]) == 0) {
                    map.remove(arr[left]);
                }
                left++;
            }
            count += right - left + 1;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,1,2,3};
        int k1 = 2;
        System.out.println("Subarrays with " + k1 + " distinct integers: " + subarraysWithKDistinct(nums1, k1)); // Output: 7

        int[] nums2 = {1,2,1,3,4};
        int k2 = 3;
        System.out.println("Subarrays with " + k2 + " distinct integers: " + subarraysWithKDistinct(nums2, k2)); // Output: 3

        int[] nums3 = {1,1,1,1};
        int k3 = 1;
        System.out.println("Subarrays with " + k3 + " distinct integers: " + subarraysWithKDistinct(nums3, k3)); // Output: 4 (corrected example output should be 4 for substrings [1], [1], [1], [1], [1, 1], [1, 1], [1,1] = length 2, [1, 1, 1] , [1,1,1,1]
        //  [1] [1 1 ] [1 1 1] [1 1 1 1]
        // substring 1 2 3 4
        // should be 10 is my mistake
        // the above example must be 1 1 + 1 1 + 1 1 + 1 so 4  length 1
        //length 1 + 1 [1 1 ] * 3 = 3
        //    length 3 : [1 1 1 ] *2 : 2
        // [1111] : 1 4 is 10


    int[] nums4 = {1,2,3,4,5};
    int k4 = 1;
        System.out.println("Subarrays with " + k4 + " distinct integers: " + subarraysWithKDistinct(nums4, k4)); // Output: 5
}
}