import java.util.HashMap;
import java.util.Map;

public class PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        int match = 0;
        Map<Character, Integer> map = new HashMap<>();
        int ws = 0;

        char[] chPattern = s1.toCharArray();
        for (int i = 0; i < s1.length(); i++) {
            map.put(chPattern[i],map.getOrDefault(chPattern[i], 0) +1);
        }

        for(int we = 0 ; we < s2.length(); we++)
        {
            //check if element is present in map
            //if present reduce the count and if equal to 0 increase match by 1
            // if(match == patter.len) we found the value and return true
            // else 2 are found and we did not find 3rd we decrease match and increase count of element in map
            char rightChar = s2.charAt(we);
            if(map.containsKey(rightChar)){
                map.put(rightChar,map.get(rightChar) -1);
                if(map.get(rightChar) == 0){
                    match ++;
                }
            }
            if(match == map.size()){
                return  true;
            }
            if(we >= s1.length()-1 ) {
                char leftChar = s2.charAt(ws);
                if(map.containsKey(leftChar))
                {
                        if(map.get(leftChar) == 0){
                            match --;
                        }
                    map.put(leftChar,map.get(leftChar) +1);

                }
                ws++;
            }
        }
        return  false;

    }




}