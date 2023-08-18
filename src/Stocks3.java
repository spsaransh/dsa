import java.util.Arrays;

public class Stocks3 {

    public static int maxProfit(int []prices) {
        // Write your code here.
        int[][][] dp = new int[prices.length][2][3];

        for (int[][] d: dp) {
            for(int[] rows: d) {
                Arrays.fill(rows, -1);
            }
        }

        return f(0,1,2,prices, dp );
    }

    private static  int f (int ind, int buy , int count ,int[] prices, int[][][] dp)
    {

        //Base Case
        if(ind == prices.length)
            return  0;
        if(count ==0)
            return  0;

        if(dp[ind][buy][count] != -1){
            return  dp[ind][buy][count];
        }
        int profit ;

        if (buy == 1) {
            profit = Math.max(-prices[ind] + f(ind + 1, 0, count, prices,dp), f(ind + 1, 1, count, prices, dp));
        }
        else {
                //sell
            profit = Math.max(prices[ind] + f(ind + 1, 1, count-1, prices, dp), f(ind + 1, 0, count, prices, dp));
        }
        return  dp[ind][buy][count] = profit;
    }
}
