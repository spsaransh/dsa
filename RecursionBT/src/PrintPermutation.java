import java.util.ArrayList;
import java.util.List;

public class PrintPermutation {
    public static List<String> findPermutations(String s) {
        // Write your code here.
        List<String> list = new ArrayList();
        f(list,s.toCharArray(),0);
        return  list ;

    }

    private static  void f(List<String> list, char[] ch , int index){
        if(index == ch.length)
        {
            String s = "";
            for (char ch1: ch) {
                s += ch1;
            }
            list.add(s);
            return  ;
        }

        for(int i = 0 ; i< ch.length ; i++){
            swap(i, index, ch);
            f(list, ch, index+1);
            swap(i, index, ch);
        }
    }

    private static void swap(int i , int j , char[] ch){
        char temp = ch[j];
        ch[j] = ch[i];
        ch[i] = temp;
    }
}
