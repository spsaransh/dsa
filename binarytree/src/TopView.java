import com.sun.source.tree.Tree;

import java.util.*;

public class TopView {
  public static class NodeVL{
      public Node getNode() {
          return node;
      }

      public void setNode(Node node) {
          this.node = node;
      }

      public int getVertical() {
          return vertical;
      }

      public void setVertical(int vertical) {
          this.vertical = vertical;
      }

      private Node node;
      private int vertical;
      public  NodeVL(Node node, int vertical){
          this.node = node;
          this.vertical = vertical;
      }
  }
   public static List<Integer> topView(Node root){
       List<Integer> nodeValues = new ArrayList<>();
       if(root == null)
           return  new ArrayList<>();
       TreeMap<Integer,Integer> hashMap = new TreeMap<Integer,Integer>();
       Queue<NodeVL> queue = new LinkedList<>();
       queue.offer(new NodeVL(root,0));
       while (!queue.isEmpty()){
           NodeVL nodeVL = queue.poll();
           if(!hashMap.containsKey(nodeVL.getVertical()))
               hashMap.put(nodeVL.getVertical(), nodeVL.getNode().data);
           if(nodeVL.getNode().left!= null) {
               queue.offer(new NodeVL(nodeVL.getNode().left, nodeVL.getVertical() -1));
           }
           if(nodeVL.getNode().right!= null) {
               queue.offer(new NodeVL(nodeVL.getNode().right, nodeVL.getVertical() +1));
           }
       }

       for (Map.Entry<Integer,Integer> item: hashMap.entrySet()) {
           nodeValues.add(item.getValue());
       }
       return  nodeValues;


   }
}
