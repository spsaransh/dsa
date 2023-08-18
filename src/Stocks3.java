public class Stocks3 {

    public static int maxProfit(int []prices, int n) {
        // Write your code here.

        return f(0,1,2,prices,n);
    }

    private static  int f (int ind, int buy , int count ,int[] prices, int n)
    {

        //Base Case
        if(ind == n)
            return  0;
        if(ind ==  count)
            return  0;
        int profit ;

        if (buy == 1) {
            profit = Math.max(-prices[ind] + f(ind + 1, 0, count, prices,n), f(ind + 1, 1, count, prices,n));
        }
        else {
                //sell
            profit = Math.max(prices[ind] + f(ind + 1, 1, count-1, prices,n), f(ind + 1, 0, count, prices,n));
        }

        
        return  profit;
    }
}
