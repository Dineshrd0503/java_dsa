package logicwhilearrays;
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

public class StockBuyAndSellMaxOneTranscationAllowed {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        int maxProfit = maxProfit(prices);
        System.out.println("Maximum profit from one transaction: " + maxProfit);
    }
    public static int maxProfit(int[] price){
        int minprice=price[0];
        int maxprofit=0;
        for(int i=1;i<price.length;i++){
            if(price[i]<minprice)
                minprice=price[i];
            else
                maxprofit=Math.max(maxprofit, price[i]-minprice);
        }
        return maxprofit;
    }
}
