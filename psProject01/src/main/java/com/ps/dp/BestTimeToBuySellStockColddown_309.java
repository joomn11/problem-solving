package com.ps.dp;

public class BestTimeToBuySellStockColddown_309 {

    // time complexity - o(n)
    // dynamic programming - buttom up
    public int maxProfit(int[] prices) {

        int len = prices.length;
        if (len <= 1) {
            return 0;
        }
        int[] buy = new int[len];
        int[] sell = new int[len];

        buy[0] = -prices[0];

        for (int i = 1; i < len; i++) {
            if (i == 1) {
                buy[i] = Math.max(buy[i - 1], 0 - prices[i]);
            } else {
                buy[i] = Math.max(buy[i - 1], sell[i - 2] - prices[i]);
            }
            // buy[i] = Math.max(buy[i - 1], sell[i - 2] - prices[i]);
            sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
        }

        return sell[len - 1];
    }

    public int maxProfit_2(int[] prices) {

        int len = prices.length;
        int[] buy = new int[len + 1];
        int[] sell = new int[len + 1];

        buy[0] = -prices[0];

        for (int i = 1; i < len; i++) {
            if (i == 1) {
                buy[i] = Math.max(buy[i - 1], -prices[i]);
            } else {
                buy[i] = Math.max(buy[i - 1], sell[i - 2] - prices[i]);
            }

            sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
        }
        return sell[len - 1];
    }

    public int maxProfit_3(int[] prices) {
        int days = prices.length;

        int[] sell = new int[days];
        int[] buy = new int[days];

        buy[0] = -prices[0];

        for (int i = 0; i < days; i++) {

            sell[i] = Math.max(sell[i - 1], prices[i] + buy[i - 1]);

            if (i == 1) {
                buy[i] = Math.max(buy[i - 1], 0 - prices[i]);
            } else {
                buy[i] = Math.max(buy[i - 1], sell[i - 2] - prices[i]);
            }
        }
        return sell[days - 1];
    }
}
