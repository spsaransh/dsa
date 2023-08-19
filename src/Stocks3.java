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


    public static  int maxProfit2Optimized(int[] prices){
        int n = prices.length;

        int[] after = new int[5];
        int[] curr = new int[5];


        for(int ind = 0 ; ind <= n; ind++){
            after[4] =0;
        }

        for(int transaction =0 ; transaction <=4; transaction++){
            after[transaction] = 0;
        }

        for(int ind =n-1 ; ind >= 0; ind--){
            for(int transaction = 3; transaction>=0; transaction--){

                if(transaction % 2 == 0 ){
                    //Buy
                    curr[transaction]= Math.max(-prices[ind] + after[ transaction+1],after[ transaction]);

                }
                else{
                    //sell
                    curr[transaction]=  Math.max(prices[ind] + after[ transaction+1],after[ transaction]);
                }
            }
            after = curr;
        }

        return  after[0];

    }

    public static  int maxProfit2(int[] prices){
        int n = prices.length;
        int[][] dp = new int[n+1][5];


        for(int ind = 0 ; ind <= n; ind++){
            dp[ind][4] =0;
        }

        for(int transaction =0 ; transaction <=4; transaction++){
            dp[n][transaction] = 0;
        }

        for(int ind =n-1 ; ind >= 0; ind--){
            for(int transaction = 3; transaction>=0; transaction--){

                if(transaction % 2 == 0 ){
                    //Buy
                    dp[ind][transaction]= Math.max(-prices[ind] + dp[ind+1][ transaction+1],dp[ind+1][ transaction]);

                }
                else{
                    //sell
                    dp[ind][transaction]=  Math.max(prices[ind] + dp[ind+1][ transaction+1],dp[ind+1][ transaction]);
                }
            }
        }

        return  dp[0][0];

    }
   //Here transaction is 1 buy or 1 sell
    private  static  int maxProfit2Util(int ind , int transaction, int[] prices , int[][]dp){
        if(ind == prices.length || transaction == 4){
            return  0;
        }

        if(dp[ind][transaction] != -1){
            return  dp[ind][transaction];
        }

        if(transaction % 2 == 0 ){
            //Buy
           return Math.max(-prices[ind] + maxProfit2Util(ind+1, transaction+1,prices, dp),maxProfit2Util(ind+1, transaction,prices, dp));

        }
        else{
            //sell
            return Math.max(prices[ind] + maxProfit2Util(ind+1, transaction+1,prices, dp),maxProfit2Util(ind+1, transaction,prices, dp));
        }

    }
}
