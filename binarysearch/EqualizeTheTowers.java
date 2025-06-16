package binarysearch;


/*
 * Problem Statement:
 * Given an array heights[] representing tower heights and cost[] representing the cost of modifying each tower's
 * height by 1 unit, find the minimum cost to equalize all towers to the same height by adding or removing blocks.
 * Modifying tower i's height by 1 costs cost[i].
 *
 * Constraints:
 * - 1 ≤ heights.length = cost.length ≤ 10^5
 * - 1 ≤ heights[i] ≤ 10^4
 * - 1 ≤ cost[i] ≤ 10^3
 *
 * Examples:
 * Example 1:
 * Input: heights = [1, 2, 3], cost = [10, 100, 1000]
 * Output: 120
 * Explanation: Equalize to height 3: cost = |1-3|*10 + |2-3|*100 + |3-3|*1000 = 20 + 100 + 0 = 120.
 *
 * Example 2:
 * Input: heights = [7, 1, 5], cost = [1, 1, 1]
 * Output: 6
 * Explanation: Equalize to height 5: cost = |7-5|*1 + |1-5|*1 + |5-5|*1 = 2 + 4 + 0 = 6.
 */
public class EqualizeTheTowers {
    /*
     * Finds the minimum cost to equalize all tower heights.
     * @param heights Array of tower heights
     * @param cost Array of modification costs per unit
     * @return Minimum total cost
     */
    public int minCost(int[] heights, int[] cost) {
        // Find min and max heights to set binary search bounds
        int minHeight = Integer.MAX_VALUE;
        int maxHeight = Integer.MIN_VALUE;
        for (int h : heights) {
            minHeight = Math.min(minHeight, h);
            maxHeight = Math.max(maxHeight, h);
        }

        // Binary search for optimal height
        long minCost = Long.MAX_VALUE;
        int left = minHeight, right = maxHeight;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            long costMid = getCost(heights, cost, mid);
            // Update minimum cost
            minCost = Math.min(minCost, costMid);

            // Check cost at mid + 1 to determine slope
            if (mid < maxHeight) {
                long costNext = getCost(heights, cost, mid + 1);
                if (costNext > costMid) {
                    // Cost increases, minimum is at or below mid
                    right = mid - 1;
                } else {
                    // Cost decreases, minimum is above mid
                    left = mid + 1;
                }
                minCost = Math.min(minCost, costNext);
            } else {
                break; // No higher height to check
            }
        }
        return (int) minCost;
    }

    /*
     * Computes total cost to set all towers to height h.
     * @param heights Array of tower heights
     * @param cost Array of modification costs
     * @param h Target height
     * @return Total cost
     */
    private long getCost(int[] heights, int[] cost, int h) {
        long total = 0;
        for (int i = 0; i < heights.length; i++) {
            total += (long) Math.abs(heights[i] - h) * cost[i];
        }
        return total;
    }

    /*
     * Main method to test minCost with static inputs.
     */
    public static void main(String[] args) {
        EqualizeTheTowers solution = new EqualizeTheTowers();

        // Test Case 1: Example 1
        int[] heights1 = {1, 2, 3};
        int[] cost1 = {10, 100, 1000};
        System.out.println("Test Case 1: heights = [1, 2, 3], cost = [10, 100, 1000]");
        System.out.println("Output: " + solution.minCost(heights1, cost1)); // Expected: 120

        // Test Case 2: Example 2
        int[] heights2 = {7, 1, 5};
        int[] cost2 = {1, 1, 1};
        System.out.println("\nTest Case 2: heights = [7, 1, 5], cost = [1, 1, 1]");
        System.out.println("Output: " + solution.minCost(heights2, cost2)); // Expected: 6

        // Test Case 3: Edge case with large heights
        int[] heights3 = {10000, 1};
        int[] cost3 = {1000, 1000};
        System.out.println("\nTest Case 3: heights = [10000, 1], cost = [1000, 1000]");
        System.out.println("Output: " + solution.minCost(heights3, cost3)); // Expected: 9999000
    }
}
