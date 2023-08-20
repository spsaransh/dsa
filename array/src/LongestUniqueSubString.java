import java.util.HashMap;
import java.util.Map;

public class LongestUniqueSubString {
    public int lengthOfLongestSubstring(String s) {
       //A,B,C,A,E,B
        int maxLength = Integer.MIN_VALUE;
        int ws = 0 ;
        char[] ch = s.toCharArray();
        int length = ch.length;

        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for(int we = 0 ; we < length ;we++){
            //check if character exists in the map
            if(map.containsKey(ch[we])){
                int charValue = map.get(ch[we]);
                // check if this value exists in between the window
                if(charValue >= ws) {
                    //windowstart should move to the  previous value of ch in map
                    ws = charValue + 1;
                }
                //update indices
            }
            map.put(ch[we], we);
            maxLength = Math.max(maxLength, we - ws +1 );
        }
        return  maxLength;
    }
}
