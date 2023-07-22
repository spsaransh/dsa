import java.util.*;

public class BottomView {
    public static List<Integer> bottomView(Node root){
        List<Integer> nodeValues = new ArrayList<>();
        if(root == null)
            return  new ArrayList<>();
        TreeMap<Integer,Integer> hashMap = new TreeMap<Integer,Integer>();
        Queue<TopView.NodeVL> queue = new LinkedList<>();
        queue.offer(new TopView.NodeVL(root,0));
        while (!queue.isEmpty()){
            TopView.NodeVL nodeVL = queue.poll();
            hashMap.put(nodeVL.getVertical(), nodeVL.getNode().data);
            if(nodeVL.getNode().left!= null) {
                queue.offer(new TopView.NodeVL(nodeVL.getNode().left, nodeVL.getVertical() -1));
            }
            if(nodeVL.getNode().right!= null) {
                queue.offer(new TopView.NodeVL(nodeVL.getNode().right, nodeVL.getVertical() +1));
            }
        }

        for (var item: hashMap.entrySet()) {
            nodeValues.add(item.getValue());
        }
        return  nodeValues;


    }
}
