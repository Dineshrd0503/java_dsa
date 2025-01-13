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