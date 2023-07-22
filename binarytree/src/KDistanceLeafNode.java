import java.util.*;

public class KDistanceLeafNode {

   public static Set<Node> printKDistantFromLeaf(Node root, int k) {
    List<Node> res = new ArrayList<>();
    Set<Node> set = new HashSet<>();
    printKDistanceFromLeafNodeUtils(root,k,res, set);
    return set;
   }



   private static void printKDistanceFromLeafNodeUtils(Node root , int k , List<Node> result , Set<Node> set){
       if(root == null)
           return ;

     if(isLeafNode(root) && result.size() >= k){
           set.add(result.get(result.size()- k));
           return;
       }
       result.add(root);
       printKDistanceFromLeafNodeUtils(root.left, k , result,set);
       printKDistanceFromLeafNodeUtils(root.right, k , result, set);
       result.remove(root);
   }


   private static boolean isLeafNode(Node node){
       return  (node.left == null ) && (node.right == null);
   }
   private static int findHeight(Node root){
       if(root == null)
           return  0;
       return Integer.max(findHeight(root.left) , findHeight(root.right) ) +1;
   }

   /* private  static void kDistantFromLeafUtil(Node node, int path[],
                              boolean visited[],
                              int pathLen, int k)
    {
        // Base case
        if (node == null)
            return;


        path[pathLen] = node.data;
        visited[pathLen] = false;
        pathLen++;
        //System.out.println(pathLen);
        //System.out.println(Arrays.toString(path));
        //System.out.println(Arrays.toString(visited));


		// it's a leaf, so print the ancestor at distance k
		//only if the ancestor is not already printed
        if (node.left == null && node.right == null
                && pathLen - k - 1 >= 0
                && visited[pathLen - k - 1] == false) {
            System.out.print(path[pathLen - k - 1] + " ");
            visited[pathLen - k - 1] = true;
            return;
        }

        // If not leaf node, recur for left and right
         // subtrees
        kDistantFromLeafUtil(node.left, path, visited,
                pathLen, k);
        kDistantFromLeafUtil(node.right, path, visited,
                pathLen, k);
    }*/

    /* Given a binary tree and a number k, print all nodes
    that are k distant from a leaf*/
   public static void printKDistantfromLeaf(Node node, int k)
    {
        //int path[] = new int[1000];
        //boolean visited[] = new boolean[1000];
        List<Integer> list = new ArrayList<>();
       // kDistantFromLeafUtil(node, path, visited, 0, k);
        printKDistanceFromLeafUtil(node,k,list);
    }

    private static  void printKDistanceFromLeafUtil(Node node ,int k, List<Integer> res){
        if (node == null || k < 0)
            return;
        if (node.left == null && node.right == null && k == 0) {
            System.out.print(node.data + " ");
            return;
        }
        printKDistantfromLeaf(node.left, k - 1);
        printKDistantfromLeaf(node.right, k - 1);
        if (k == 0)
            System.out.print(node.data + " ");
    }


}


