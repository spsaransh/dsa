import java.util.Arrays;

public class LongestPalindromicSubsequence {

    public static int  longestPalindromeSubsequence(String s) {
        // Write your code here.

        String t = reverse(s);
        int n=s.length();
        int m=t.length();

        int dp[][]=new int[n+1][m+1];
        for(int rows[]: dp)
            Arrays.fill(rows,-1);

        for(int i=0;i<=n;i++){
            dp[i][0] = 0;
        }
        for(int i=0;i<=m;i++){
            dp[0][i] = 0;
        }

        for(int ind1=1;ind1<=n;ind1++){
            for(int ind2=1;ind2<=m;ind2++){
                if(s.charAt(ind1-1)==t.charAt(ind2-1)) {
                    dp[ind1][ind2] = 1 + dp[ind1 - 1][ind2 - 1];
                }
                else {
                    dp[ind1][ind2] = 0 + Math.max(dp[ind1 - 1][ind2], dp[ind1][ind2 - 1]);
                }

            }
        }

       return  dp[n][m];


    }

     private static String  reverse(String s)
     {
         char[] med = s.toCharArray();
         int i = 0 , j = s.length()-1;
         while( j> i)
         {
             char temp = med[i];
             med[i] = med[j];
             med[j] = temp;
             i++;
             j--;
         }
         return new String(med);
     }

}
