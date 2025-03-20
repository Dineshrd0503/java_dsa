package dynamicprogramming;

//In daily share trading, a trader buys shares and sells them on the same day. If the trader is allowed to make at most 2 transactions in a day, find out the maximum profit that a share trader could have made.
//
//You are given an array prices[] representing stock prices throughout the day. Note that the second transaction can only start after the first one is complete (buy->sell->buy->sell).
//
//Examples:
//
//Input: prices[] = [10, 22, 5, 75, 65, 80]
//Output: 87
//Explanation:
//Trader will buy at 10 and sells at 22.
//Profit earned in 1st transaction = 22 - 10 = 12.
//Then he buys at 5 and sell at 80.
//Profit earned in 2nd transaction = 80 - 5 = 75.
//Total profit earned = 12 + 75 = 87.
//Input: prices[] = [2, 30, 15, 10, 8, 25, 80]
//Output: 100
//Explanation:
//Trader will buy at 2 and sells at 30.
//Profit earned in 1st transaction = 30 - 2 = 28.
//Then he buys at 8 and sell at 80.
//Profit earned in 2nd transaction = 80 - 8 = 72.
//Total profit earned = 28 + 72 = 100.
//Constraints:
//        1 <= prices.size() <= 105
//        1 <= prices[i] <= 105




public class StockBuyAndSellMax2TranscationsAllowed {
    public static int maxProfit(int[] prices) {
        // code here
        int n=prices.length;
        if(n==0)
            return 0;
        int buy1=Integer.MAX_VALUE;
        int sell1=0;
        int buy2=Integer.MAX_VALUE;
        int sell2=0;
        for(int price:prices){
            buy1=Math.min(buy1,price);
            sell1=Math.max(sell1,price-buy1);
            buy2=Math.min(buy2,price-sell1);
            sell2=Math.max(sell2,price-buy2);
        }
        return sell2;


    }

    public static void main(String[] args) {
        int[] prices = {3,3,5,0,0,3,1,4};
        int result = maxProfit(prices);
        System.out.println("Maximum profit: " + result);
    }
}
