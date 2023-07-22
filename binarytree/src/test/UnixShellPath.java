package test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class UnixShellPath {


    public static String unixShellPath(String path) {
        // Write your code here
        List<String> str = new ArrayList<>();
        Stack<String> stack = new Stack<>();
        String[] paths = path.split("/");
        String str1= "";
        if(path.isEmpty())
            return path;
        for(int i = 0 ; i<paths.length; i++) {
            if ((paths[i] != ".") && paths[i] != "..") {
                stack.push(paths[i]);
            }

            if (paths[i] == "..") {
                stack.pop();
            }
        }

            while (!stack.isEmpty()) {
                if (stack.peek() != "") {
                    str.add(stack.peek());
                }

            }
            for (int i = 0 ; i< str.size(); i++){
                str1 += str.get(str.size()-i-1) + "/";
            }

            return  str1;

    }

}
