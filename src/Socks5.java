
public class Socks5 {
    //StockProfit with colling period
    //Problem link - https://www.codingninjas.com/studio/problems/highway-billboards_3125969
        public static int getMaximumProfit ( int[] prices) {
        // Your code goes here.
        int n = prices.length;
        int[][] dp = new int[n + 2][2];

        dp[n][0] = 0;
        dp[n][1] = 0;

        for (int ind = n - 1; ind >= 0; ind--)
        {

            //choses to buy
            dp[ind][1] = Math.max(-prices[ind] + dp[ind + 1][0],
                    //choses to not buy
                    dp[ind + 1][1]);



            //choses to sell
            dp[ind][0] = Math.max(prices[ind] + dp[ind + 2][1],
                    //choses not to sell
                    dp[ind+1][0]);

        }
        return dp[0][1];
    }

    public static int getMaximumProfitOptimized ( int[] prices) {
        // Your code goes here.
        int n = prices.length;
        int[] front2 = new int[2];
        int[] front1 = new int[2];
        int[] curr = new int[2];


        for (int ind = n - 1; ind >= 0; ind--)
        {

            //choses to buy
            curr[1] = Math.max(-prices[ind] + front1[0],
                    //choses to not buy
                    front1[1]);



            //choses to sell
            curr[0] = Math.max(prices[ind] + front2[1],
                    //choses not to sell
                    front1[0]);


            front2 = (int[])(front1.clone());
            front1 = (int [])(curr.clone());

        }

        return front1[1];
    }
    }


