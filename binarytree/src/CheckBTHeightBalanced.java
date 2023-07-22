public class CheckBTHeightBalanced {

    public boolean isBalanced(Node root){
        if(root == null)
            return true;
        int lh = heightUtil(root.left);
        int rh = heightUtil(root.right);

        if((Math.abs(lh-rh)<=1) && isBalanced(root.left ) && isBalanced(root.right))
            return  true;
        return  false;
    }

    private  int heightUtil(Node root){
        if(root == null)
            return  -1;
        return Integer.max(heightUtil(root.left), heightUtil(root.right))+1;
    }

    private  static  int traverseUtil(Node root){
        if(root == null)
            return 0;
        int leftHeight = traverseUtil(root.left);
        if(leftHeight == -1)
            return -1;
        int rightHeight = traverseUtil(root.right);
        if(rightHeight == -1)
            return  -1;

        if(Math.abs(leftHeight-rightHeight)>1)
            return -1;

        return  Math.max(leftHeight, rightHeight)+1;
    }

}
