import java.util.HashMap;
import java.util.Map;

public class FirstUniqueChar {

    public int firstUniqChar(String s) {
        Map<Character, Integer> wordMap = new HashMap<>();
        char[] chars = s.toCharArray();
        for(char ch: chars){
            wordMap.put(ch,wordMap.getOrDefault(ch,0)+1);
        }

        for (int i = 0; i < chars.length; i++) {
            if (wordMap.get(chars[i])==1) return i;
        }
        return -1;

    }

}
