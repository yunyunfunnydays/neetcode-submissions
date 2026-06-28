class Solution {
    public int climbStairs(int n) {
        if (n < 0) return 0;
        if (n <= 2) return n;

        // 從 n == 3 開始處理
        int prev1 = 2, prev2 = 1;
        int currWays = 0;

        for (int i = 3; i <= n; i++) {
            currWays = prev1 + prev2;
            prev2 = prev1;
            prev1 = currWays;
        }
        return currWays;
    }
}
