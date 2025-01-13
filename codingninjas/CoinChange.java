package codingninjas;

import java.util.*;
//Given an infinite supply of Indian currency i.e. [1, 2, 5, 10, 20, 50, 100, 500, 1000] valued coins and an amount 'N'.
//
//
//
//Find the minimum coins needed to make the sum equal to 'N'. You have to return the list containing the value of coins required in decreasing order.
//
//
//
//        For Example
//        For Amount = 70, the minimum number of coins required is 2 i.e an Rs. 50 coin and a Rs. 20 coin.
//        Note
//It is always possible to find the minimum number of coins for the given amount. So, the answer will always exist.
//        Detailed explanation ( Input/output format, Notes, Images )
//Sample Input 1
//        13
//Sample Output 1
//        10 2 1
//Explanation of Sample Input 1
//The minimum number of coins to change is 3 {1, 2, 10}.
//Sample Input 2
//        50
//Sample Output 2
//        50

public class CoinChange {
    public static List<Integer> MinimumCoins(int n) {
        List<Integer> result = new ArrayList<>();

        int[] coins = {1000, 500, 100, 50, 20, 10, 5, 2, 1};  // sorted in descending order
        for (int coin : coins) {
            while (n >= coin) { // use the coin as many times as possible
                result.add(coin);
                n -= coin; // subtract coin value from n
            }
        }

        return result; // result will have coins in descending order
    }

    public static void main(String[] args) {
        int amount = 13;
        System.out.println("Coins used: " + MinimumCoins(amount));
    }
}
