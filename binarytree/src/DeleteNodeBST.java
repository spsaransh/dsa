public class DeleteNodeBST {



    public Node deleteNode(Node root ,int key ){

        if(root == null)
        {
            return null;
        }
        else if (root.data == key )
        {
            if(root.left == null && root.right == null) {
                root = null;
            }

            else if(root.left == null)
            {
                root = root.right;
            }
            else if(root.right == null)
            {
                root = root.left;
            }
            else {
                Node temp = FindMinBST(root.right);
                root.data = temp.data;
                deleteNode(root.left, temp.data);

                //Find max in left
            }
        }
       else if(root.data >key)
        root.left = deleteNode(root.left, key);
        else
        root .right =  deleteNode(root.right,key );

       return  root;

/*Node temp = root;
            temp = null;
           prev.left = root.left;
            if(root.left == null && root.right == null){
                prev = null;
            }
            if(root.data <prev.data)
            {
                 if(root.right == null)
                 {
                    prev.right = root.left;
                 } else if (root.left == null) {
                     prev.right = root.right;
                 }
                 else{
                     root.right.left=
                 }
                //prev.right =
            }
            else{
                prev.left =
            }*/

    }


    private  Node FindMinBST(Node root)
    {
        if(root.left == null )
            return  root ;
        return FindMinBST(root.left);
    }


}
