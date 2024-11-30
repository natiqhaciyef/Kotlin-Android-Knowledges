package com.natiqhaciyef.technical_skills_java.leetcode.interview;

public class BestTimeToBuyAndSellStock {

    public int maxProfit(int[] prices) {
        int diff = 0;
        int min = prices[0];

        for (int i = 0; i < prices.length; i++) {
            if (i != prices.length - 1 && prices[i] < min) {
                min = prices[i];
            }

            if (prices[i] - min > diff) {
                diff = prices[i] - min;
            }
        }


        return diff;
    }

}
