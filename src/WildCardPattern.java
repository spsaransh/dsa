import java.util.Arrays;

public class WildCardPattern {
    public static boolean wildcardMatching(String pattern, String text) {
        // Write your code here.
        int n = pattern.length();
        int m = text.length();
        boolean[][] dp = new boolean[n+1][m+1];

        dp[0][0] = true;
        for(int i = 1; i<= m ; i++){
            dp[0][i] = false;
        }

        for(int i = 1; i<=n ; i++)
        {
            dp[i][0] = isAllStars(i, pattern);
        }

        for(int i = 1 ; i<=n ; i++)
        {
            for(int j =1 ; j<=m ; j++)
            {
                if(pattern.charAt(i-1) == text.charAt(j-1) || pattern.charAt(i-1) == '?'){
                   dp[i][j] = dp[i-1][j-1];
                }
                else if (pattern.charAt(i-1) == '*')
                {
                   dp[i][j]= dp[i][j-1]  || dp[ i-1][j] ;
                }
                else{
                    dp[i][j] = false;
                }
            }
        }
     return  dp[n][m];

    }

    public static boolean wildcardMatchingSO(String pattern, String text) {
        int n = pattern.length();
        int m = text.length();
        boolean[] prev = new boolean[m+1];
        boolean[] cur = new boolean[m+1];


        prev[0] = true;
        for(int i = 1 ; i<= m ; i++){
            prev[i] = false;
        }



        for(int i = 1 ; i<=n ; i++)
        {
            cur[0] = isAllStars(i, pattern);
            for(int j =1 ; j<=m ; j++)
            {
                if(pattern.charAt(i-1) == text.charAt(j-1) || pattern.charAt(i-1) == '?'){
                    cur[j] = prev[j-1];
                }
                else if (pattern.charAt(i-1) == '*')
                {
                    cur[j]= cur[j-1]  || prev[j] ;
                }
                else{
                    cur[j] = false;
                }
            }
            prev = cur;
        }
        return  prev[m];

    }

        private  static  boolean isAllStars(int n, String a)
        {
            for(int i =1 ; i<= n ; i++){
                if(a.charAt(i-1) != '*')
                    return  false;
            }
            return  true;
        }

        private static boolean f(String p , String t , int i , int j, int[][] dp){
            if(i==0  && j== 0)
                return true;
            if(i==0 && j > 0)
                return false;
            if(i>0 && j== 0)
            {
                return isAllStars( i,p);
            }


            if(dp[i][j]!=-1)
                return dp[i][j] == 1 ? true: false;

            if(p.charAt(i-1) == t.charAt(j-1) || p.charAt(i-1) == '?'){
                boolean res = f(p,t,i-1,j-1, dp);
                dp[i][j] = res ? 1 : 0;
                return res;
            }

            if(p.charAt(i-1) == '*')
            {
                boolean res =  f(p, t, i, j-1, dp) || f(p, t, i-1,j, dp);
                dp[i][j] = res ? 1 : 0;
                return res;
            }
            return false;
        }
}
