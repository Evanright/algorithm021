import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstring {
    /**
     * 3. 无重复字符的最长子串
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if(s.length()<2) return s.length();
        Map<Character, Integer> map = new HashMap<>();
//        char[] chars = s.toCharArray();
        int max = 0;
        int start=0;
        for(int i=0;i<s.length();i++){
            if(map.containsKey(s.charAt(i))){
                start = Math.max(start, map.get(s.charAt(i))+1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-start+1);
        }
        return max;
    }

    public static void main(String[] args) {
        LengthOfLongestSubstring obj = new LengthOfLongestSubstring();
        System.out.println(obj.lengthOfLongestSubstring("pwwkew"));
    }
}
