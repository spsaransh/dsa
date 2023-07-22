import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {

    protected static List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> list = new ArrayList<>();
       if(root == null)
           return  list;
       Queue<Node>  queue = new LinkedList<>();
       queue.add(root);

       while (queue.size() > 0){
           int level = queue.size();
           List<Integer> subArray = new ArrayList<>();
           for (int i = 0 ; i< level; i++){
                Node temp = queue.poll();
                subArray.add(temp.data);

                if(temp.left!= null)
                    queue.offer(temp.left);
                if(temp.right != null)
                    queue.offer(temp.right);

           }
           list.add(subArray);
       }
       return  list;
    }
}
