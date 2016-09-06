public class BuyAndSellStocks {
	
	public static int maximumProfit(int[] stockPrices) {
		int maximumProfit = 0;
		int minPrice = Integer.MAX_VALUE;

		for (int i=0; i<stockPrices.length; i++) {
			if (stockPrices[i]<minPrice) {
				minPrice = stockPrices[i];
			}
			maximumProfit = Math.max(maximumProfit, Math.abs(stockPrices[i]-minPrice));
		}
		return maximumProfit;
	}

	public static int maximumProfitMultipleTransaction(int[] stockPrices) {
		
	}

	public static void main(String[] args) {
		int[] stockPrices = {100, 80, 120, 130, 70, 60, 100, 125};
        System.out.println("maximum profit that could be obtained is: " + maximumProfit(stockPrices));
	}
}