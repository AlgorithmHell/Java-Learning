import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by Helga on 11/21/2017.
 */
public class LengthOfLongestSubstring {


    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> map = new HashMap<>();
        if(s == "" || s == null) return 0;
        int maxLength = 0;
        int length = 0;
        for ( int i = 0; i< s.length(); i++) {
            if(map.containsKey((Character)s.charAt(i))){
                if(length > maxLength){
                    maxLength = length;
                }
                length = 0;
                i=map.get(s.charAt(i));
                i++;
                map.clear();
            }
            map.put(s.charAt(i),i);
            length++;
        }
        if(maxLength < length){
            maxLength = length;
        }

        return maxLength;
    }

}
