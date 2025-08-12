package arrays;

import java.util.Arrays;

/*
Problem Statement (LeetCode 1833: Maximum Ice Cream Bars):
Given an array costs[] where costs[i] is the cost of the i-th ice cream bar, and an integer coins representing the total money available, find the maximum number of ice cream bars you can buy. You can buy the bars in any order, but you cannot buy a bar if its cost exceeds your remaining coins.

Constraints:
- 1 <= costs.length <= 10^5
- 1 <= costs[i] <= 10^5
- 1 <= coins <= 10^8

Example Test Cases:
1. Input: costs = [1,3,2,4,1], coins = 7
   Output: 4
   Explanation: Buy bars with costs 1, 1, 2, 3 (total = 7) to get 4 bars.
2. Input: costs = [10,6,8,7,7,8], coins = 5
   Output: 0
   Explanation: No bar can be bought as the minimum cost (6) exceeds coins (5).
3. Input: costs = [1,6,3,1,2,5], coins = 20
   Output: 6
   Explanation: Buy all bars (total cost = 1+1+2+3+5+6 = 18 <= 20).
*/

public class MaximumIceCreamBars {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs); // Sort costs in ascending order
        int count = 0;
        int totalCost = 0;

        for (int cost : costs) {
            if (totalCost + cost <= coins) {
                totalCost += cost;
                count++;
            } else {
                break; // Stop if remaining coins are insufficient
            }
        }

        return count;
    }

    public static void main(String[] args) {
        MaximumIceCreamBars solution = new MaximumIceCreamBars();
        // Static Test Case 1: costs = [1,3,2,4,1], coins = 7
        int[] costs1 = {1, 3, 2, 4, 1};
        int coins1 = 7;
        System.out.println("Test Case 1: " + solution.maxIceCream(costs1, coins1)); // Expected: 4

        // Static Test Case 2: costs = [10,6,8,7,7,8], coins = 5
        int[] costs2 = {10, 6, 8, 7, 7, 8};
        int coins2 = 5;
        System.out.println("Test Case 2: " + solution.maxIceCream(costs2, coins2)); // Expected: 0

        // Static Test Case 3: costs = [1,6,3,1,2,5], coins = 20
        int[] costs3 = {1, 6, 3, 1, 2, 5};
        int coins3 = 20;
        System.out.println("Test Case 3: " + solution.maxIceCream(costs3, coins3)); // Expected: 6
    }
}
