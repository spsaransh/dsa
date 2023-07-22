public class EvaluateBooleanTree {
    public boolean evaluateTree(Node root) {

        if(isLeafNode(root)){
            return root.data == 0 ? false : true ;
        }
        boolean a = evaluateTree(root.left);
        boolean b = evaluateTree(root.right);

        if(root.data == 2)
        {
            return a || b;
        }
        else if(root.data == 3){
            return a && b;
        }
        else {
            return false;
        }

    }

    private boolean isLeafNode(Node root)
    {
        if(root.left == null && root.right == null){
            return true;
        }
        return false;
    }
}
