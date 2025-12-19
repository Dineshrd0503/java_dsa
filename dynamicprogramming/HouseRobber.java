package dynamicprogramming;

/*
 * PROBLEM: House Robber (LeetCode #198)
 *
 * You are a professional robber planning to rob houses along a street.
 * Each house has a certain amount of money stashed, the only constraint
 * stopping you from robbing each of them is that adjacent houses have
 * security systems connected and it will automatically contact the police
 * if two adjacent houses were broken into on the same night.
 *
 * Given an integer array nums representing the amount of money of each house,
 * return the maximum amount of money you can rob tonight without alerting the police.
 *
 * Constraint: You cannot rob two adjacent houses.
 *
 * Example 1:
 * Input: nums = [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 * Total = 1 + 3 = 4
 *
 * Example 2:
 * Input: nums = [2,7,9,3,1]
 * Output: 12
 * Explanation: Rob house 1 (money = 2), house 3 (money = 9), house 5 (money = 1).
 * Total = 2 + 9 + 1 = 12
 *
 * Approach: Dynamic Programming
 * dp[i] = maximum money that can be robbed from houses 0 to i
 * dp[i] = max(dp[i-1], dp[i-2] + nums[i])
 *   - Either skip house i and take max from i-1
 *   - Or rob house i and add to max from i-2 (since adjacent houses can't be robbed)
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n) or O(1) if optimized
 */

public class HouseRobber {

    public static int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        // dp[i] represents maximum money that can be robbed up to house i
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        // Fill the dp array using recurrence relation
        for (int i = 2; i < nums.length; i++) {
            // Either rob current house + max from i-2, or don't rob and take max from i-1
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }

        return dp[nums.length - 1];
    }

    // Space-optimized version (O(1) space)
    public static int robOptimized(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int prev2 = nums[0];      // dp[i-2]
        int prev1 = Math.max(nums[0], nums[1]); // dp[i-1]
        int current;

        for (int i = 2; i < nums.length; i++) {
            current = Math.max(prev1, prev2 + nums[i]);
            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }

    // Main method for testing
    public static void main(String[] args) {
        System.out.println("===== House Robber - Dynamic Programming =====\n");

        // Test Case 1: [1,2,3,1]
        System.out.println("Test Case 1:");
        int[] nums1 = {1, 2, 3, 1};
        System.out.println("Input: [1, 2, 3, 1]");
        System.out.println("Explanation: Rob house 1 (1) and house 3 (3) = 1 + 3 = 4");
        System.out.println("Output: " + rob(nums1));
        System.out.println("Expected: 4");
        System.out.println("Output (Optimized): " + robOptimized(nums1));
        System.out.println();

        // Test Case 2: [2,7,9,3,1]
        System.out.println("Test Case 2:");
        int[] nums2 = {2, 7, 9, 3, 1};
        System.out.println("Input: [2, 7, 9, 3, 1]");
        System.out.println("Explanation: Rob house 1 (2), house 3 (9), house 5 (1) = 2 + 9 + 1 = 12");
        System.out.println("Output: " + rob(nums2));
        System.out.println("Expected: 12");
        System.out.println("Output (Optimized): " + robOptimized(nums2));
        System.out.println();

        // Test Case 3: [5,3,4,11,2]
        System.out.println("Test Case 3:");
        int[] nums3 = {5, 3, 4, 11, 2};
        System.out.println("Input: [5, 3, 4, 11, 2]");
        System.out.println("Explanation: Rob house 1 (5), house 3 (4), house 4 (11) = 5 + 4 + 11 = 20");
        System.out.println("Output: " + rob(nums3));
        System.out.println("Expected: 20");
        System.out.println("Output (Optimized): " + robOptimized(nums3));
        System.out.println();

        // Test Case 4: [2,1]
        System.out.println("Test Case 4:");
        int[] nums4 = {2, 1};
        System.out.println("Input: [2, 1]");
        System.out.println("Explanation: Rob house 1 (2) = 2");
        System.out.println("Output: " + rob(nums4));
        System.out.println("Expected: 2");
        System.out.println("Output (Optimized): " + robOptimized(nums4));
        System.out.println();

        // Test Case 5: [5]
        System.out.println("Test Case 5:");
        int[] nums5 = {5};
        System.out.println("Input: [5]");
        System.out.println("Explanation: Only one house, rob it = 5");
        System.out.println("Output: " + rob(nums5));
        System.out.println("Expected: 5");
        System.out.println("Output (Optimized): " + robOptimized(nums5));
        System.out.println();

        // Test Case 6: [40,2,4,10]
        System.out.println("Test Case 6:");
        int[] nums6 = {40, 2, 4, 10};
        System.out.println("Input: [40, 2, 4, 10]");
        System.out.println("Explanation: Rob house 1 (40) and house 4 (10) = 40 + 10 = 50");
        System.out.println("Output: " + rob(nums6));
        System.out.println("Expected: 50");
        System.out.println("Output (Optimized): " + robOptimized(nums6));
    }
}
