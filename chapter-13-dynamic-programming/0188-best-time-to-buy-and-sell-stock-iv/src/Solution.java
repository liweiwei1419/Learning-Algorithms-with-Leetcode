public class Solution {

    public int maxProfit(int k, int[] prices) {
        int len = prices.length;
        if (k >= len / 2) {
            // 第 122 题贪心算法的代码
            int res = 0;
            for (int i = 0; i < len - 1; i++) {
                int diff = prices[i + 1] - prices[i];
                if (diff > 0) {
                    res += diff;
                }
            }
            return res;
        }

        int[][][] dp = new int[len][k + 1][2];
        for (int i = 0; i < len; i++) {
            for (int j = 1; j <= k; j++) {
                if (i == 0) {
                    dp[0][j][1] = -prices[0];
                    continue;
                }
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
            }
        }
        return dp[len - 1][k][0];
    }
}
