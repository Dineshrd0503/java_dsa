package arrays;
import java.util.*;

public class CoinChange {

    /**
     * Problem Statement:
     * Given an infinite supply of Indian currency i.e. [1, 2, 5, 10, 20, 50, 100, 500, 1000]
     * valued coins and an amount 'N'.
     *
     * Find the minimum coins needed to make the sum equal to 'N'. You have to
     * return the list containing the value of coins required in decreasing order.
     *
     * For Example:
     * For Amount = 70, the minimum number of coins required is 2 i.e an Rs. 50 coin
     * and a Rs. 20 coin.
     *
     * Note:
     * It is always possible to find the minimum number of coins for the given
     * amount. So, the answer will always exist.
     *
     * Input Format:
     * The only line contains a single integer ‘N’ representing the amount.
     *
     * Output Format:
     * The only line contains the list containing the value of coins required in
     * decreasing order.
     *
     * Note:
     * You do not need to print anything, it has already been taken care of. Just
     * implement the given function.
     *
     * Sample Input 1: 13
     * Sample Output 1: 10 2 1
     * Explanation of Sample Input 1: The minimum number of coins to change is 3 {1,
     * 2, 10}.
     *
     * Sample Input 2: 50
     * Sample Output 2: 50
     *
     * Constraints:
     * 1 <= 'N' <= 10^5
     * Time Limit: 1 sec
     */

    public static List<Integer> MinimumCoins(int n) {
        int[] coins = { 1, 2, 5, 10, 20, 50, 100, 500, 1000 };
        List<Integer> result = new ArrayList<>();

        for (int i = coins.length - 1; i >= 0; i--) {
            while (n >= coins[i]) {
                n -= coins[i];
                result.add(coins[i]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println("Test Case 1: Amount = 13");
        List<Integer> coins1 = MinimumCoins(13);
        System.out.println("Output: " + coins1); // Expected Output: [10, 2, 1]
        System.out.println();

        System.out.println("Test Case 2: Amount = 50");
        List<Integer> coins2 = MinimumCoins(50);
        System.out.println("Output: " + coins2); // Expected Output: [50]
        System.out.println();

        System.out.println("Test Case 3: Amount = 70");
        List<Integer> coins3 = MinimumCoins(70);
        System.out.println("Output: " + coins3); // Expected Output: [50, 20]
        System.out.println();

        System.out.println("Test Case 4: Amount = 1");
        List<Integer> coins4 = MinimumCoins(1);
        System.out.println("Output: " + coins4); // Expected Output: [1]
        System.out.println();

        System.out.println("Test Case 5: Amount = 1234");
        List<Integer> coins5 = MinimumCoins(1234);
        System.out.println("Output: " + coins5); // Expected Output: [1000, 200, 20, 10, 2, 2]
        System.out.println();
    }
}