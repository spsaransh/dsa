public class MaxPathSum {

    public static int maxPathSum(Node root) {
    int[] arr = new int[1];
    arr[0] = Integer.MIN_VALUE;
    maxPathSumUtil(root, arr);
    return arr[0];
    }


    private static  int maxPathSumUtil(Node root , int[] max){

        if(root == null)
            return  0;
        int lhSum = Math.max(0,(maxPathSumUtil(root.left,max)));
        int rhSum= Math.max(0,(maxPathSumUtil(root.right,max)));

        max[0] = Math.max(lhSum +rhSum +root.data, max[0]);

        return Math.max(lhSum,rhSum) + root.data;
    }
}
