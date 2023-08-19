//Problem link - https://www.codingninjas.com/studio/problems/selling-stock_630282
import java.util.Arrays;
public class Stocks1 {
    public static long getMaximumProfit (int n, long[] values) {
        // Your code goes here.

        long[][] dp = new long[n + 1][2];


        dp[n][0] = 0;
        dp[n][1] = 0;
        long profit = 0;
        for (int ind = n - 1; ind >= 0; ind--)
        {
            for (int buy = 1; buy >= 0; buy--)
            {
                if (buy == 1)
                {
                    //choses to buy
                    profit = Math.max(-values[ind] + dp[ind + 1][0],
                            //choses to not buy
                            dp[ind + 1][1]);
                }

                else
                {
                    //choses to sell
                    profit = Math.max(values[ind] + dp[ind + 1][1],
                            //choses not to sell
                            dp[ind+1][0]);
                }

                dp[ind][buy] = profit;
            }
        }
        return dp[0][1];
    }
}
