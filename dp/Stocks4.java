public class Stocks4 {
   //Problem link -https://www.codingninjas.com/studio/problems/best-time-to-buy-and-sell-stock_1080698
    public static  int maxProfit2Optimized(int[] prices ,int k ){
        int n = prices.length;
        int[] after = new int[2*k +1];
        int[] curr = new int[2*k +1];

        for(int ind =n-1 ; ind >= 0; ind--){
            for(int transaction = 2*k -1; transaction>=0; transaction--){

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
}
