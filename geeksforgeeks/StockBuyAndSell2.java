package geeksforgeeks;
//The cost of stock on each day is given in an array price[]. Each day you may decide to either buy or sell the stock i at price[i], you can even buy and sell the stock on the same day. Find the maximum profit that you can get.
//
//Note: A stock can only be sold if it has been bought previously and multiple stocks cannot be held on any given day.
//
//        Examples:
//
//Input: prices[] = [100, 180, 260, 310, 40, 535, 695]
//Output: 865
//Explanation: Buy the stock on day 0 and sell it on day 3 => 310 – 100 = 210. Buy the stock on day 4 and sell it on day 6 => 695 – 40 = 655. Maximum Profit = 210 + 655 = 865.
public class StockBuyAndSell2 {
    public static int maximumProfit(int prices[]) {
        int n=prices.length;
        if(n==0)
            return 0;
        int maxprofit=0;
        for(int i=1;i<n;i++){
            if(prices[i]>prices[i-1])
                maxprofit+=prices[i]-prices[i-1];
        }
        return maxprofit;

        // code here
    }
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println("Maximum profit is " + maximumProfit(prices));
    }

}
