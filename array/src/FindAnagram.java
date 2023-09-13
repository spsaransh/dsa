import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAnagram {
    public List<Integer> findAnagrams(String s, String p) {
        //p is pattern
        int match = 0;
        Map<Character, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        int ws = 0;

        char[] chPattern = p.toCharArray();
        for (int i = 0; i < p.length(); i++) {
            map.put(chPattern[i],map.getOrDefault(chPattern[i], 0) +1);
        }

        for(int we = 0 ; we < s.length(); we++)
        {
            //check if element is present in map
            //if present reduce the count and if equal to 0 increase match by 1
            // if(match == patter.len) we found the value and return true
            // else 2 are found and we did not find 3rd we decrease match and increase count of element in map
            char rightChar = s.charAt(we);
            if(map.containsKey(rightChar)){
                map.put(rightChar,map.get(rightChar) -1);
                if(map.get(rightChar) == 0){
                    match ++;
                }
            }
            if(match == map.size()){
                list.add(ws);
            }
            if(we >= p.length()-1 ) {
                char leftChar = s.charAt(ws);
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
        return  list;
    }
}
