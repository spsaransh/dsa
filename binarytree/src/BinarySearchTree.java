import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class BinarySearchTreeNode {
    public int data;
    public BinarySearchTreeNode left;
    public BinarySearchTreeNode right;

    BinarySearchTreeNode (int nodeData) {
        this.data = nodeData;
        this.left = null;
        this.right = null;
    }
}

class BinarySearchTree {
    public BinarySearchTreeNode root;

    public BinarySearchTree() {
        this.root = null;
    }

    public void insertNode(int nodeData) {
        this.root = this.insertNode(this.root, nodeData);
    }

    private BinarySearchTreeNode insertNode(BinarySearchTreeNode root, int nodeData) {
        if (root == null) {
            root = new BinarySearchTreeNode(nodeData);
        } else {
            if (nodeData <= root.data) {
                root.left = this.insertNode(root.left, nodeData);
            } else {
                root.right = this.insertNode(root.right, nodeData);
            }
        }

        return root;
    }
}

class BinarySearchTreePrintHelper {
    public static void printInorder(BinarySearchTreeNode root, String sep, BufferedWriter bufferedWriter) throws IOException {
        if (root == null) {
            return;
        }

        BinarySearchTreePrintHelper.printInorder(root.left, sep, bufferedWriter);

        if (root.left != null) {
            bufferedWriter.write(sep);
        }

        bufferedWriter.write(String.valueOf(root.data));

        if (root.right != null) {
            bufferedWriter.write(sep);
        }

        BinarySearchTreePrintHelper.printInorder(root.right, sep, bufferedWriter);
    }
}

class Result {

    /*
     * Complete the 'KLargestElement' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_BINARY_SEARCH_TREE b_tree
     *  2. INTEGER k
     */

    /*
     * For your reference:
     *
     * BinarySearchTreeNode {
     *     int data;
     *     BinarySearchTreeNode left;
     *     BinarySearchTreeNode right;
     * }
     *
     */

    public static int KSmallestElement(BinarySearchTreeNode b_tree, int k) {
        // Write your code here
       List<Integer> list =KLargestUtil(b_tree,k,new ArrayList<>());
       return list.get(list.size()-k+1);
    }

    public static  List<Integer> KLargestUtil(BinarySearchTreeNode b_tree , int k , List<Integer> list){
        if(b_tree == null)
            return  null;
        KLargestUtil(b_tree,k,list);
        list.add(b_tree.data);
        KLargestUtil(b_tree,k, list);

        return  list;

    }

}



