package logicwhileloops;
/*
Problem Statement:
Given an array of stock prices where each element represents the price of a stock on a given day, find the maximum profit you can achieve by buying on one day and selling on another later day. If no profit is possible, return 0.

Sample Input 1:
prices = {7, 1, 5, 3, 6, 4}
Sample Output 1:
Maximum profit: 5

Sample Input 2:
prices = {7, 6, 4, 3, 1}
Sample Output 2:
Maximum profit: 0

Sample Input 3:
prices = {2, 4, 1}
Sample Output 3:
Maximum profit: 2
 */
public class StockSelling {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        
        int minPrice = prices[0];

        int maxProfit = 0;
        
        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            } else if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice;
            }
        }
        
        return maxProfit;
    }

    public static void main(String[] args) {
        StockSelling maxProfit = new StockSelling();
        int[] prices = {7, 1, 5, 3, 6, 4};
        int result = maxProfit.maxProfit(prices);
        System.out.println("Maximum profit: " + result);
    }
}