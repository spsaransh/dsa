public class Stocks3 {

    public static int maxProfit(int []prices, int n) {
        // Write your code here.

        return f(0,1,0,prices);
    }

    private static  int f (int ind, int buy , int count ,int[] prices)
    {

        //Base Case
        if(ind == prices.length)
            return  0;
        if(ind ==  count)
            return  0;
        int profit = 0;
        if(count <2) {
            //If a user can buy


            if (buy == 1) {
                profit = Math.max(-prices[ind] + f(ind + 1, 0, count, prices), f(ind + 1, 1, count, prices));
            } else {
                //sell
                profit = Math.max(prices[ind] + f(ind + 1, 1, count-1, prices), f(ind + 1, 1, count, prices));
            }
        }
        
        return  profit;
    }
}
