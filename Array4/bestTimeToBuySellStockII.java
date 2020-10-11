//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/solution/

class bestTimeToBuySellStockII {
    public int maxProfit(int[] prices) {
        
        int result = 0;
        
        int min = prices[0];
        int max = prices[0];
        
        
        for(int x : prices) {
            if(x < max) {
                result += max - min;
                min = x;
                max = x;
            }
            else if( x< min) {
                min = x;
                max = x;
            }
            else if( x> max) {
                max = x;
            }

        }
        result += max - min;
        
        return result;
    }
}
