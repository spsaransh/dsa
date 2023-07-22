import java.util.ArrayList;
import java.util.List;

public class SumRootLeafNumbers {
    public  static int sumNumbers(Node root){
     return sumNumbersUtils(root, new ArrayList<>(), new int[1]);
    }

    private static int sumNumbersUtils(Node root, List<Integer> sum , int[] totalSum)
    {
        if(root  == null)
        {
            return 0;
        }
        sum.add(root.data);
        if(root.left == null && root.right == null)
        {
            for (int i = 0; i < sum.size(); i++) {
                totalSum[0] += (int)(Math.pow(10,sum.size()-1-i) )* sum.get(i);
            }
        }

        sumNumbersUtils(root.left, sum, totalSum );

        sumNumbersUtils(root.right, sum, totalSum);
        sum.remove(sum.size()-1);

        return totalSum[0];
    }
}
