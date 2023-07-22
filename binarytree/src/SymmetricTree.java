
public class SymmetricTree {
    public boolean isSymmetric(Node root) {
      return  isSymmetricUtil(root.left, root.right);
    }

    private  boolean isSymmetricUtil(Node root1 , Node root2){
        if(root1 == null && root2 == null)
            return  true;
        else if (root1 == null || root2 == null)
            return  false;
        if(root1.data == root2.data ){
           return isSymmetricUtil(root1.left ,root2.right) && isSymmetricUtil(root1.right , root2.left);
        }
        return  false;
    }
}
