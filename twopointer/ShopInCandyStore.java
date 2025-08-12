package twopointer;

import java.util.ArrayList;
import java.util.Arrays;

/*
Problem Statement:
In a candy store, there are different types of candies available, and prices[i] represents the price of the i-th type of candy.
You are provided with an offer: for every candy you buy, you can get up to k other different candies for free.
Find the minimum and maximum amount of money needed to buy all the candies, taking the maximum number of free candies possible during each purchase.

Constraints:
- 1 ≤ prices.length ≤ 10^5
- 0 ≤ k ≤ prices.length
- 1 ≤ prices[i] ≤ 10^4

Example Test Cases:
1. Input: prices = [3, 2, 1, 4], k = 2
   Output: [3, 7]
   Explanation:
   - Minimum cost: Buy candy worth 1 (get 3, 4 free), buy 2 → Total = 1 + 2 = 3.
   - Maximum cost: Buy candy worth 4 (get 1, 2 free), buy 3 → Total = 4 + 3 = 7.
2. Input: prices = [3, 2, 1, 4, 5], k = 4
   Output: [1, 5]
   Explanation:
   - Minimum cost: Buy candy worth 1 (get 2, 3, 4, 5 free) → Total = 1.
   - Maximum cost: Buy candy worth 5 (get 1, 2, 3, 4 free) → Total = 5.
*/

public class ShopInCandyStore {
    public ArrayList<Integer> minMaxCandy(int[] prices, int k) {
        int n = prices.length;
        Arrays.sort(prices); // Sort the prices array in ascending order

        int minCost = 0;
        int buyIndex = 0;
        int freeIndex = n - 1;

        // Calculate minimum cost: Buy cheapest candies, take k most expensive for free
        while (buyIndex <= freeIndex) {
            minCost += prices[buyIndex];
            buyIndex++;
            freeIndex -= k;
        }

        int maxCost = 0;
        buyIndex = n - 1;
        freeIndex = 0;

        // Calculate maximum cost: Buy most expensive candies, take k cheapest for free
        while (freeIndex <= buyIndex) {
            maxCost += prices[buyIndex];
            buyIndex--;
            freeIndex += k;
        }

        ArrayList<Integer> result = new ArrayList<>();
        result.add(minCost);
        result.add(maxCost);
        return result;
    }

    public static void main(String[] args) {
        ShopInCandyStore solution = new ShopInCandyStore();

        // Static Test Case 1: prices = [3, 2, 1, 4], k = 2
        int[] prices1 = {3, 2, 1, 4};
        int k1 = 2;
        System.out.println("Test Case 1: " + solution.minMaxCandy(prices1, k1)); // Expected: [3, 7]

        // Static Test Case 2: prices = [3, 2, 1, 4, 5], k = 4
        int[] prices2 = {3, 2, 1, 4, 5};
        int k2 = 4;
        System.out.println("Test Case 2: " + solution.minMaxCandy(prices2, k2)); // Expected: [1, 5]
    }
}
