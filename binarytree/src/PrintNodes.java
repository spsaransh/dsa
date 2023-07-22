import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PrintNodes {

    public static List<Integer> distanceKFromRoot(Node root,  int k) {

        List<Integer> res = new ArrayList<>();
        distanceUtil(root,k);
        return res;
        /*int level = 0;
        List<Integer> list = new ArrayList<>();

        Queue<Node> queue = new LinkedList<>();
        if(root == null) {
            return null ;
        }
        queue.add(root);

        while (!queue.isEmpty()){
            Node temp = queue.poll();

            if(temp.left != null)
                queue.offer(temp.left);
            if(temp.right != null)
                queue.offer(temp.right);
        }

        return  null;*/
    }


   private  static  void distanceUtil(Node root , int k){
        if(root == null )
            return ;

       if(k == 0){
           System.out.println(root.data);
           return;
       }

        distanceUtil(root.left,k -1);
        distanceUtil(root.right,k-1);
   }

    public List<Integer> distanceK(Node root, Node target, int k) {

        return  null;
    }
}
