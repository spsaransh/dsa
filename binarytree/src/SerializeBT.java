import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SerializeBT {

    public List<Integer> serialize(Node root){
        List<Integer> list = new ArrayList<>();
        if(root == null)
            return list;

        list.add(root.data);
        serialize(root.left);
        serialize(root.right);

        /*Queue<Node> queue = new LinkedList<>();

        queue.offer(root);
        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            if (temp == null){
                list.add(null);
                continue;
            }
            list.add(temp.data);
            if(temp.left != null)
                queue.offer(temp.left);
            if(temBinaryTree p.right != null)
                queue.offer(temp.right);

        }*/
        return  list;
    }

    public static Node deserialize(String data){
        if(data == "")
            return null;
        String[] nodeData= data.split(" ");

        Queue<Node> queue = new LinkedList<>();
        Node root = new Node(Integer.parseInt(nodeData[0]));
        queue.add(root);

        for(int i = 1; i< nodeData.length; i++)
        {
            Node parent = queue.poll();
            //left
            if(nodeData[i]!= "#"){
               Node left   = new Node(Integer.parseInt(nodeData[i]));
               parent.left = left;
               queue.add(left);

            }

            if(nodeData[++i]!= "#"){
                Node right   = new Node(Integer.parseInt(nodeData[i]));
                parent.right = right;
                queue.add(right);
            }
        }
        return  root;
    }

}
