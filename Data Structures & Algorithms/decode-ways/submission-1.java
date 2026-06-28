class Solution {
    public int numDecodings(String s) {
        if(s == null || s.isEmpty() || s.charAt(0) == '0') return 0;

        int n = s.length();
        var dp = new int[n + 1];
        
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            int singleDigit = s.charAt(i - 1) - '0';
            int doubleDigit = Integer.parseInt(s.substring(i - 2, i));

            if (singleDigit != 0) dp[i] = dp[i - 1];
            if (doubleDigit >= 10 && doubleDigit <= 26) dp[i] += dp[i - 2];
        }

        return dp[n];
    }
}
