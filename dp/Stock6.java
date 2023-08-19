public class Stock6 {
    public static int maximumProfit(int[] prices, int n, int fee) {
        // Write your code here.
        int[] ahead = new int[2];
        int[] curr = new int[2];


        for (int ind = n - 1; ind >= 0; ind--)
        {
            curr[1] = Math.max(-prices[ind] + ahead[0], ahead[1]);

            curr[0] = Math.max(prices[ind] -fee + ahead[1], ahead[0]);

            ahead = curr;
        }
        return curr[1];

    }
}
