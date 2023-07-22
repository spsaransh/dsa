public class BinaryTreeHeight {

    public static  int heightBinaryTree(Node root){
        if(root == null)
            return  -1;
        return  Integer.max( heightBinaryTree(root.left),heightBinaryTree(root.right))+1;
    }
}
