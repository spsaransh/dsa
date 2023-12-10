import java.util.Arrays;
public class LongestSuccessiveElements {
    public static int longestSuccessiveElements(int []a) {
        // Write your code here.
        Arrays.sort(a);
        int longest = 1 ;
        //current count
        int count = 0;
        //Update last smaller whenever a[i] -1 != lastSmaller to a[i]
        int lastSmaller = Integer.MIN_VALUE;

        for(int i = 0 ; i< a.length; i++)
        {
            if(a[i] == lastSmaller +1)
            {
                count++;
                lastSmaller = a[i];
            }

            else if(lastSmaller != a[i] )
            {
                count =1;
                lastSmaller = a[i];
            }
            longest = Integer.max(longest, count);
        }
        return  longest;
    }
}
