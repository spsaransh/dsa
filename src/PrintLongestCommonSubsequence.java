import java.util.Arrays;

public class PrintLongestCommonSubsequence {

    public static String findLCS(int n, int m, String s1, String s2){
        // Below code is for Memoization ,so commented .
        String[][] dp =  new String[n+1][m +1];

        /*for(String[] row : dp)
        {
            Arrays.fill(row, "-1");
        }
        return  lCSUtil(n, m, s1, s1, "", dp);*/

        String res = "";

        for(int ind2 = 0 ; ind2<= n; ind2++)
        {
            dp[ind2][0] =res;
        }

        for(int ind1 = 0 ; ind1<= m; ind1++)
        {
            dp[0][ind1] =res;
        }

        for(int ind1 = 1 ; ind1 <= n ; ind1++)
        {
            for(int ind2 =1 ; ind2 <= m ; ind2++)
            {
                if(s1.charAt(ind1-1) == s2.charAt(ind2-1))
                {
                    dp[ind1][ind2] = res + s1.charAt(ind1);
                }
                else {
                    String les1 = dp[ind1][ind2 - 1];
                    String les2 = dp[ind1 - 1][ind2];


                     dp[ind1][ind2] = les1.length() > les2.length() ? les1 : les2;
                }
            }
        }
        return  dp[n][m];

    }

    public static String findLCSOptimized(int n, int m, String s1, String s2){

        // Below code is for Memoization ,so commented .
        String[] prev =  new String[m+1];
        String[] curr =  new String[m+1];


        String res = "";


        for(int ind2 = 0 ; ind2<= m; ind2++)
        {
            prev[ind2] =res;
        }

        for(int ind1 = 1 ; ind1 <= n ; ind1++)
        {
            for(int ind2 =1 ; ind2 <= m ; ind2++)
            {
                if(s1.charAt(ind1-1) == s2.charAt(ind2-1))
                {
                    curr[ind2] = res + s1.charAt(ind1);
                }
                else {
                    String les1 = curr[ind2 - 1];
                    String les2 = prev[ind2];


                    curr[ind2] = les1.length() > les2.length() ? les1 : les2;
                }
            }
            prev = curr;
        }
        return  curr[m];


    }

    private static  String lCSUtil(int ind1 , int ind2, String s1 , String s2 ,String res , String[][] dp){

        if(ind1== 0 || ind2 == 0)
        {
            return res ;
        }
       if(dp[ind1][ind2] != "-1")
       {
           return  dp[ind1][ind2];
       }

        if(s1.charAt(ind1-1) == s2.charAt(ind2-1))
             return res + s1.charAt(ind1);


            /*(lCSUtil(s1,s2,ind1,ind2-1, ""),lCSUtil
                    (s1,s2,ind1-1,ind2,""));*/
            String les1 = lCSUtil(ind1, ind2-1 , s1, s2, res,dp);
            String les2 = lCSUtil(ind1-1, ind2, s1, s2, res, dp);

           return dp[ind1][ind2] =les1.length()> les2.length() ? les1: les2;

    }
}
