package logicwhilearrays;

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
