import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigZagTraversal {
    public static List<List<Integer>> doZigZagTraversal(Node root) {
        boolean zigzagFlag = false;
        List<List<Integer>> zigzagList = new ArrayList<>();
        if(root == null)
            return  zigzagList;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int level = queue.size();
            List<Integer> tempList = new ArrayList<>();
            for(int i = 0 ; i< level ; i++) {
                Node temp = queue.poll();
                if (temp.left != null) {
                    queue.offer(temp.left);
                }
                if (temp.right != null) {
                    queue.offer(temp.right);
                }

                if (zigzagFlag) {
                  tempList.add(0, temp.data);
                }
                else {
                    tempList.add(temp.data);
                }
            }
            zigzagFlag = !zigzagFlag;
            zigzagList.add(tempList);

        }

        return zigzagList;
    }
}
