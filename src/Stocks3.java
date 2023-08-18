import java.util.Arrays;

public class Stocks3 {

    public static int maxProfit(int []prices) {
        // Write your code here.
        int n = prices.length;
        int[][][] dp = new int[n+1][2][3];

      //We can ignore the base case  .Feel free to comment the couple of for loops
      for(int count =0 ; count <2; count++){
          dp[n-1][0][count] =0;
          dp[n-1][1][count] =0;
      }

      for(int ind = 0 ; ind < prices.length; ind ++){
          dp[ind][0][0] = 0;
          dp[ind][1][0] = 0;
      }

      for(int ind= n-1 ; ind>=0; ind--)
      {
          for(int buy = 0; buy <=1; buy++ )
          {
              // count = 0 will give Index out of bound exception
              for(int count = 1 ; count <=2 ; count++)
              {
                  int profit ;

                  if (buy == 1) {
                      profit = Math.max(-prices[ind] + dp[ind + 1][ 0][ count], dp[ind + 1] [1] [count]);
                  }
                  else {
                      //sell
                      profit = Math.max(prices[ind] + dp[ind + 1][ 1][ count-1], dp[ind + 1] [0] [count]);

                  }
                    dp[ind][buy][count] = profit;
              }
          }
      }

     return  dp[0][1][2];
    }

    public  static  int maxProfitOptimized1(int []prices){
        int n = prices.length;
        int[][] after = new int[2][3];
        int[][] curr = new int[2][3];



        for(int ind= n-1 ; ind>=0; ind--)
        {
            for(int buy = 0; buy <=1; buy++ )
            {
                // count = 0 will give Index out of bound exception
                for(int count = 1 ; count <=2 ; count++)
                {
                    int profit ;

                    if (buy == 1) {
                        profit = Math.max(-prices[ind] + after[ 0][ count], after[1] [count]);
                    }
                    else {
                        //sell
                        profit = Math.max(prices[ind] + after[ 1][ count-1], after[0] [count]);

                    }
                    curr[buy][count] = profit;
                }
            }
            after = curr;
        }

        return  after[1][2];
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
