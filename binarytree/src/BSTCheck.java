public class BSTCheck {

    public static boolean isBst(Node root) {
       return isBSTUtil(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }

    private static boolean isBSTUtil(Node root, long leftRange,long rightRange)
    {
        if(root == null)
            return true;
        if((root.data <= leftRange) || (root.data >= rightRange))
           return  false;
        return isBSTUtil(root.left,leftRange, root.data) && isBSTUtil(root.right,root.data,rightRange);

    }


}

