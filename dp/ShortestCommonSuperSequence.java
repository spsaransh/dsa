public class ShortestCommonSuperSequence {


     private static String shortestSupersequence(String a, String b)
    {
        // Write your code here
        int n = a.length();
        int m = b.length();
        String ans = "";

        int dp[][] = new  int [n + 1][m + 1] ;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Integer.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        int i = n, j = m;
        while (i > 0 && j > 0) {
            if (a.charAt(i - 1) == b.charAt(j - 1)) {
                ans += a.charAt(i - 1);
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                ans += a.charAt(i - 1);
                i--;
            } else {
                ans += b.charAt(j - 1);
                j--;
            }
        }

        while (i > 0) {
            ans += a.charAt(i - 1);
            i--;
        }

        while (j > 0) {
            ans += b.charAt(j - 1);
            j--;
        }

        // Reverse the answer string.
        String rev = "";
        for (int k = ans.length() - 1; k >= 0; k--) {
            rev += a.charAt(k - 1);
        }
        return rev;

    }
}
