class Solution {
    public int maxProfit(int[] prices) {
        // min = +infinity
        // maxPorfit = 0           
        // FOR p in prices
            // IF p < min
                // min = p
            // ELSE
                // maxPorfit = max(maxPorfit, p - min)
            // END IF
            // r++
        // END FOR
        // RETURN max
        
        int min = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int p : prices) {
            if (p < min) {
                min = p;
            } else {
                maxProfit = Math.max(maxProfit, p - min);
            }
        }
        return maxProfit;



    }
}
