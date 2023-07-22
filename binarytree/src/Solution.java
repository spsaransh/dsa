import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
       /* Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        int[] arr = new int[t];

        int i = 0;
        while(i < t) {
            int data = scan.nextInt();
            arr[i] = data;
            i += 1;
        }
        Node root = insertLevelOrder(arr, 0);

        scan.close();
        List<Integer> list = BoundaryTraversal.doBoundaryTraversal(root);
        for (int j = 0; j < list.size(); j++) {
            System.out.print(list.get(j));
        }*/

        Node root = new Node(4);
        root.left = new Node(9);
        root.right = new Node(0);
        root.left.left = new Node(5);
        root.left.right = new Node(1);
        System.out.println(SumRootLeafNumbers.sumNumbers(root));
        //KDistanceLeafNode.printKDistantfromLeaf(root,1);

      /*Set<Node> set =  KDistanceLeafNode.printKDistantfromLeaf(root,1);
      List<Integer> list = new ArrayList<>();
        for (var set1:
             set) {
            list.add(set1.data);
        }
        for(int i = list.size(); i>= 0; i--)
        {
            System.out.println(list.get(i));
        }*/
        }


    public static Node insertLevelOrder(int[] arr, int i)
    {
        Node root = null;
        // Base case for recursion
        if (i < arr.length && arr[i]>=0) {
            root = new Node(arr[i]);
            // insert left child
            root.left = insertLevelOrder(arr, 2 * i + 1);
            // insert right child
            root.right = insertLevelOrder(arr, 2 * i + 2);
        }
        return root;
    }

}
