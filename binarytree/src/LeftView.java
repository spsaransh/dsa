import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeftView {

    public static  List<Integer> leftView(Node root){
        List<Integer> arrayList = new ArrayList<>();
       leftViewUtils(root,arrayList,0);
       return  arrayList;
    }

    private static void leftViewUtils(Node root , List<Integer> leftList, int level){
        if(root == null)
            return;
        if(leftList.size() == level){
            leftList.add(root.data);
        }
        leftViewUtils(root.left,leftList,level +1);
        leftViewUtils(root.right,leftList,level +1);
    }
}
