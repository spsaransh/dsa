import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharacterReplacement {
    public static int characterReplacement(String s, int k) {

        int ws = 0 ;
        int count = 0 ;
        int maxLength = 0;
        Map<Character, Integer > freqMap = new HashMap<>();

        for(int we = 0 ; we< s.length(); we++)
        {
            char ch = s.charAt(we);
            freqMap.put(ch, freqMap.getOrDefault(ch,0) +1);
            count = Integer.max(count, freqMap.get(ch));

            if(we-ws+1  -count >k)
            {
                char lch = s.charAt(ws);
                freqMap.put(lch, freqMap.get(lch)-1);
                ws++;
            }
            maxLength = Integer.max(maxLength, we-ws+1);
        }
        return maxLength;

    }
}
