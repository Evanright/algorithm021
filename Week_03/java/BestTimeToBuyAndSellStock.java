public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int[][] dp = new int[len][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for(int i=1;i<len;i++){
            dp[i][1] = Math.max(dp[i-1][1], -prices[i]);
            dp[i][0] = Math.max(dp[i-1][0], prices[i]+dp[i-1][1]);
        }
        return Math.max(dp[len-1][0], dp[len-1][1]);
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock bestTimeToBuyAndSellStock = new BestTimeToBuyAndSellStock();
        int[] prices = new int[]{7,6,4,3,1};
        System.out.println(bestTimeToBuyAndSellStock.maxProfit(prices));

    }
}
