import java.util.*;

public class VerticalSum {
    public ArrayList<Integer> verticalSum(Node root) {
        // add your code here
        TreeMap<Integer,Integer> verticalMap = new TreeMap<>();
        ArrayList<Integer> verticalArray = new ArrayList<>();
        Queue<TopView.NodeVL> queue = new LinkedList<>();
        queue.offer(new TopView.NodeVL(root,0));
        while (!queue.isEmpty()){
            var temp = queue.poll();
            verticalMap.put(temp.getVertical(), verticalMap.getOrDefault(temp.getVertical(),0) + temp.getNode().data);

            if(temp.getNode().left != null){
               queue.offer(new TopView.NodeVL(temp.getNode().left,temp.getVertical() -1));
            }
            if(temp.getNode().right != null){
                queue.offer(new TopView.NodeVL(temp.getNode().right,temp.getVertical() +1));
            }
        }

        for (Map.Entry<Integer,Integer> item: verticalMap.entrySet()){

            verticalArray.add(item.getValue());
        }
       return  verticalArray;
    }
}
