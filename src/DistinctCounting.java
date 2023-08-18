import java.util.Arrays;

public class DistinctCounting {
    static int prime = (int)(Math.pow(10,9)+7);
    public static int subsequenceCounting(String t, String s, int lt, int ls) {
        // Write your code here..//

        int[][] dp = new int[lt][ls];

        /* for (int[] rows: dp) {
            Arrays.fill(rows, -1);
        }
        return  subSequenceCountingUtil(t,s, lt-1,ls-1, dp );*/
        for(int i = 0 ; i<= lt; i++) {
            dp[i][0] = 1;
        }

        for(int j = 1 ; j<= ls ; j++)
        {
            dp[0][j] = 0;
        }

        for(int i = 1; i<= lt; i++)
        {
            for(int j =1; j<= ls; j++)
            {
                if(t.charAt(i-1) == s.charAt(j-1))
                    dp[i][j]= dp[i-1][j-1] + dp[i-1][j];
                else
                    dp[i][j] = dp[i-1][j];
            }
       }
        return  dp[lt][ls];
    }

    public static int subsequenceCounting2DOptimized(String str, String sub) {
        int lt = str.length();
        int ls = sub.length();

        int[] prev = new int[ls + 1];
        int[] curr = new int[ls + 1];
        prev[0] = 1;
        curr[0] = 1;

        for (int i = 1; i <= lt; i++) {
            for (int j = 1; j <= ls; j++) {
                if (str.charAt(i - 1) == sub.charAt(j - 1))
                    curr[j] = (prev[j - 1] + prev[j]) % prime;
                else
                    curr[j] = prev[j];
            }
            prev = curr;
        }
        return prev[ls];

    }

    public static int subsequenceCounting1DOptimized(String str, String sub) {
        int lt = str.length();
        int ls = sub.length();

        int[] dp = new int[ls + 1];
        dp[0] = 1;
        for (int i = 1; i <= lt; i++) {
            for (int j = ls; j >=1; j--) {
                if (str.charAt(i - 1) == sub.charAt(j - 1))
                    dp[j] = (dp[j - 1] + dp[j]) % prime;
            }
        }
        return dp[ls];
    }

    private  static  int subSequenceCountingUtil(String t, String s, int i , int j, int[][] dp){
         //base case
         if(j< 0)
             return  1;
         if(i< 0)
             return  0;

         if(dp[i][j] != -1)
             return  dp[i][j];

         if(t.charAt(i) == s.charAt(j))
            return dp[i][j]= subSequenceCountingUtil(t,s,i-1,j-1, dp) + subSequenceCountingUtil(t, s, i-1,j, dp);

         return dp[i][j] = subSequenceCountingUtil(t,s , i-1, j, dp);
    }


}
