// Problem statement
// Given an infinite supply of Indian currency i.e. [1, 2, 5, 10, 20, 50, 100, 500, 1000] valued coins and an amount 'N'.



// Find the minimum coins needed to make the sum equal to 'N'. You have to return the list containing the value of coins required in decreasing order.



// For Example
// For Amount = 70, the minimum number of coins required is 2 i.e an Rs. 50 coin and a Rs. 20 coin.
// Note
// It is always possible to find the minimum number of coins for the given amount. So, the answer will always exist.
// Detailed explanation ( Input/output format, Notes, Images )
// Sample Input 1
// 13
// Sample Output 1
// 10 2 1
// Explanation of Sample Input 1
// The minimum number of coins to change is 3 {1, 2, 10}.
// Sample Input 2
// 50
// Sample Output 2
// 50
// Constraints
// 1 <= 'N' <= 10^5

// Time Limit: 1 sec
package codingninjas30daychallenge;

import java.util.ArrayList;
import java.util.List;
public class MinimumCoinChange {

    public static List<Integer> MinimumCoins(int n) {
        // Define the available denominations in descending order
        int[] coins = {1000, 500, 100, 50, 20, 10, 5, 2, 1};
        List<Integer> result = new ArrayList<>();

        // Iterate over each coin
        for (int coin : coins) {
            // While we can use this coin
            while (n >= coin) {
                result.add(coin); // Add coin to result
                n -= coin;       // Reduce n by the coin's value
            }
        }
        
        return result; // Return the list of coins used
    }

    public static void main(String[] args) {
        int amount1 = 13;
        System.out.println(MinimumCoins(amount1)); // Output: [10, 2, 1]

        int amount2 = 50;
        System.out.println(MinimumCoins(amount2)); // Output: [50]
    }
}
