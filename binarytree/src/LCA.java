public class LCA {

    public static Node lca(Node root, int v1, int v2) {
        // Write your code here.
        if(root == null)
            return null;
        if(root.data == v1 || root.data ==v2)
            return root;

       Node left = lca(root.left, v1, v2);
       Node right = lca(root.right,v1,v2);

       //BackTracking steps
        if(left != null){
            if(right == null)
            {
                return  left;
            }
            else{
                return  root;
            }
        }
        else{
            return  right;
        }
    }
}
