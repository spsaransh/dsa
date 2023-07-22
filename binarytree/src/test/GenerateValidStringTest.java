package test;

import java.util.ArrayList;
import java.util.List;

public class GenerateValidStringTest {

    public static List<String> generateValidStrings(int n) {
        // Write your code here
        List<String> res = new ArrayList<>();
        generateValidStringsUtil(res, n);
        return  res;


    }

    public static void generateValidStringsUtil(List<String> res, int n ){
        if(res.size()/2 == n){
            return;
        }
         res.add("<div>");
        if(isSafe(res)){
            {
                res.add("<div></div>");
                generateValidStringsUtil(res,n);
            }
        }
        else{
            res.add("</div>");
            generateValidStringsUtil(res,n);
        }

        res.clear();


    }

    private  static   boolean isSafe(List<String> res){
        int openDivCount =0;
        int closedDivCount = 0;
        for(int i = 0 ; i< res.size(); i++){
            if(res.get(i).equals("<div>")){
                openDivCount ++;
            }

            if(res.get(i).equals("</div>")){
                closedDivCount ++;
            }
        }

        if(openDivCount == closedDivCount)
            return  true;
        return  false;
    }

    public static void main(String[] args) {
        List<String> list = generateValidStrings(2);
        for(int i =0 ; i< list.size(); i++)
        {
            System.out.print(list.get(i));
        }
    }
}
