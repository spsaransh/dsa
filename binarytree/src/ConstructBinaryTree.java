public class ConstructBinaryTree {
    public Node buildTree(int[] preorder, int[] inorder) {

        for(int i = 0; i< preorder.length; i++)
        {
            Node node  = new Node(preorder[i]);
            //search for this element in inorder

            for(int j = 0 ; j< inorder.length; j++){

                if(preorder[i] == inorder[j])
                {

                }
            }


        }


        return null;
    }
}
