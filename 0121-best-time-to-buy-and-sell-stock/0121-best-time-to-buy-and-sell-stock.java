class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int minValue = prices[0];

        for(int price : prices){
            minValue = Math.min(minValue, price);

            profit = Math.max(profit, price-minValue);
        }
        return profit;
    }
}