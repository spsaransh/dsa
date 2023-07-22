public class Diameter {

    public int diameterOfBinaryTree(Node root){
        if(root == null)
            return  0;
       int[] array = new int[1];
        heightBinaryTreeUtil(root,array);
        return array[0];

    }

    private  int heightBinaryTreeUtil(Node root ,int arr[]){
        if(root == null)
            return 0;
        int left = heightBinaryTreeUtil(root.left, arr);
        int right = heightBinaryTreeUtil(root.right, arr);

        arr [0] = Integer.max(left + right, arr[0]);
        return Math.max(left,right) +1;
    }




}
