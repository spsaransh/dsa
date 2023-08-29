import java.util.Arrays;

public class NumberLIS {

    public static int findNumberOfLIS(int[] arr)
    {
       int n = arr.length;
       int[] dp = new int[n];
       int[] cnt = new  int[n];
       int maxi = 1;

       Arrays.fill(dp,1);
       Arrays.fill(cnt, 1);

       for(int i = 0 ; i< n ; i++)
       {
           for(int prev =0 ; prev < i ; prev++)
           {
               if(arr[i]>arr[prev] && 1+dp[prev] > dp[i])
               {

                   dp[i] =  1+ dp[prev];
                   cnt[i] = cnt[prev];
               }
               else if(arr[i]>arr[prev] && 1+dp[prev] == dp[i] ){
                   cnt[i] += cnt[prev];
               }
           }

           maxi = Math.max(maxi, dp[i]);
       }

       int noOfLIS = 0;

       for(int i = 0 ; i< n ; i++)
       {
          if(maxi ==  dp[i]){
              noOfLIS += cnt[i];
          }
       }

       return  noOfLIS;


    }
}
