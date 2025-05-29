package arrays;

/**
 * Problem Statement:
 * Given a 0-indexed integer array nums and two integers target and start, find an index i such that
 * nums[i] == target and abs(i - start) is minimized. Note that abs(x) is the absolute value of x.
 * Return abs(i - start).
 * It is guaranteed that target exists in nums.
 *
 * Constraints:
 * 1 <= nums.length <= 1000
 * 1 <= nums[i] <= 10^4
 * 0 <= start < nums.length
 * target is in nums.
 *
 * Sample Test Cases:
 * Example 1:
 * Input: nums = [1,2,3,4,5], target = 5, start = 3
 * Output: 1
 * Explanation: nums[4] = 5 is the only value equal to target, so the answer is abs(4 - 3) = 1.
 *
 * Example 2:
 * Input: nums = [1], target = 1, start = 0
 * Output: 0
 * Explanation: nums[0] = 1 is the only value equal to target, so the answer is abs(0 - 0) = 0.
 *
 * Example 3:
 * Input: nums = [1,1,1,1,1,1,1,1,1,1], target = 1, start = 0
 * Output: 0
 * Explanation: Every value of nums is 1, but nums[0] minimizes abs(i - start), which is abs(0 - 0) = 0.
 */

import java.util.Arrays;
import java.util.stream.IntStream;

public class MinDistanceToTarget {
    // Static inputs for testing based on sample test cases
    private static final int[][] TEST_NUMS = {
            {1, 2, 3, 4, 5},                  // Example 1
            {1},                              // Example 2
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1}  // Example 3
    };
    private static final int[] TEST_TARGETS = {5, 1, 1};
    private static final int[] TEST_STARTS = {3, 0, 0};
    private static final int[] EXPECTED_OUTPUTS = {1, 0, 0};

    // Provided imperative solution
    public int getMinDistance(int[] nums, int target, int start) {
        int minDistance = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                int distance = Math.abs(i - start);
                minDistance = Math.min(minDistance, distance);
            }
        }
        // If target is not found, minDistance remains Integer.MAX_VALUE
        // Problem constraints guarantee target exists, so this check is for robustness
        return minDistance == Integer.MAX_VALUE ? -1 : minDistance;
    }

    // Alternative functional solution using streams
    public int getMinDistanceFunctional(int[] nums, int target, int start) {
        return IntStream.range(0, nums.length)
                .filter(i -> nums[i] == target)
                .map(i -> Math.abs(i - start))
                .min()
                .orElse(-1); // Constraint guarantees target exists, so this won't return -1
    }

    public static void main(String[] args) {
        MinDistanceToTarget solver = new MinDistanceToTarget();
        System.out.println("Testing MinDistanceToTarget with static inputs:");
        for (int testCase = 0; testCase < TEST_NUMS.length; testCase++) {
            int[] nums = TEST_NUMS[testCase];
            int target = TEST_TARGETS[testCase];
            int start = TEST_STARTS[testCase];
            int expected = EXPECTED_OUTPUTS[testCase];

            // Test imperative solution
            int resultImperative = solver.getMinDistance(nums, target, start);
            System.out.printf("Test Case %d (Imperative): nums=%s, target=%d, start=%d, Expected=%d, Output=%d, %s%n",
                    testCase + 1, Arrays.toString(nums), target, start, expected, resultImperative,
                    resultImperative == expected ? "PASS" : "FAIL");

            // Test functional solution
            int resultFunctional = solver.getMinDistanceFunctional(nums, target, start);
            System.out.printf("Test Case %d (Functional): nums=%s, target=%d, start=%d, Expected=%d, Output=%d, %s%n",
                    testCase + 1, Arrays.toString(nums), target, start, expected, resultFunctional,
                    resultFunctional == expected ? "PASS" : "FAIL");
        }
    }
}