/**
 * Problem: Maximum Subarray
 *
 * Given an integer array nums, find the subarray with the largest sum, and return its sum.
 *
 * Example 1:
 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * Output: 6
 * Explanation: The subarray [4,-1,2,1] has the largest sum 6.
 *
 * Example 2:
 * Input: nums = [1]
 * Output: 1
 * Explanation: The subarray [1] has the largest sum 1.
 *
 * Example 3:
 * Input: nums = [5,4,-1,7,8]
 * Output: 23
 * Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.
 *
 * Constraints:
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 *
 * Follow up: If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 */
public class  MaximumSubArray {
    /**
     * Kadane's Algorithm
     * Time Complexity: O(n) - Single pass through the array.
     * Space Complexity: O(1) - Constant extra space.
     * @param nums The integer array
     * @return The maximum subarray sum
     */
    public int maxSubArray(int[] nums) {
        int maxSoFar = nums[0]; // Initialize the maximum sum found so far
        int currentMax = nums[0]; // Initialize the current maximum sum ending at the current position

        for (int i = 1; i < nums.length; i++) {
            // The current maximum ending at position i is either the current element itself
            // or the current element added to the previous maximum (if adding the previous maximum is beneficial).
            currentMax = Math.max(nums[i], nums[i] + currentMax);

            // Update maxSoFar if the currentMax is greater.
            maxSoFar = Math.max(maxSoFar, currentMax);
        }

        return maxSoFar;
    }

    public static void main(String[] args) {
        MaximumSubArray solution=new MaximumSubArray();

        // Example 1
        int[] nums1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int result1 = solution.maxSubArray(nums1);
        System.out.println("Example 1: " + result1); // Output: 6

        // Example 2
        int[] nums2 = {1};
        int result2 = solution.maxSubArray(nums2);
        System.out.println("Example 2: " + result2); // Output: 1

        // Example 3
        int[] nums3 = {5, 4, -1, 7, 8};
        int result3 = solution.maxSubArray(nums3);
        System.out.println("Example 3: " + result3); // Output: 23

        // Additional Test Case
        int[] nums4 = {-1, -2, -3};
        int result4 = solution.maxSubArray(nums4);
        System.out.println("Example 4: " + result4); // Output: -1
    }
}
