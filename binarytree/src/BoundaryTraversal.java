import java.util.ArrayList;
import java.util.List;

public class BoundaryTraversal {

    public static List<Integer> doBoundaryTraversal(Node root){
        List<Integer> result = new ArrayList<>();
        if(root == null)
            return result;
        if(!isLeafNode(root)){
            result.add(root.data);
        }
        doLeftTraversal(root.left, result);
        doLeafTraversal(root,result);
        doRightTraversal(root.right,result);
        return  result;

    }

    private static  boolean isLeafNode(Node root){
        return (root.left == null && root.right ==  null);
    }

   private  static  void doLeafTraversal(Node root, List<Integer> result){

        if(isLeafNode(root)){
            result.add(root.data);
            return;
        }
       if(root.left!= null)
           doLeafTraversal(root.left,result);
       if(root.right!= null)
           doLeafTraversal(root.right, result);
   }

    private static void doLeftTraversal (Node root , List<Integer> result) {
        while (root != null) {
            if (!isLeafNode(root))
                result.add(root.data);
            if(root.left != null)
                root = root.left;
            else
                root = root.right;
        }
    }

    private static void doRightTraversal(Node root, List<Integer> result){
        List<Integer> list = new ArrayList<>();
        while (root != null)
        {
            if(!isLeafNode(root))
                list.add(root.data);
            if(root.right != null)
            {
                root = root.right;
            }
            else {
                root = root.left;
            }
        }
        for (int i = list.size()-1; i>=0 ; i--){
            result.add(list.get(i));
        }
    }
}
