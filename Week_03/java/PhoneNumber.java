import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneNumber {
    public static List<String> letterCombinations(String digits) {
        Map<String, String> numMap = new HashMap<>();
        numMap.put("2","abc");
        numMap.put("3","def");
        numMap.put("4","ghi");
        numMap.put("5","jkl");
        numMap.put("6","mno");
        numMap.put("7","pqrs");
        numMap.put("8","tuv");
        numMap.put("9","wxyz");
        List<String> rstList = new ArrayList<>();
        if(digits.equals("")) return rstList;
        letterCombinSub(digits, 0, "", rstList, numMap);
        return rstList;
    }
    public static void letterCombinSub(String digits, int numLevel, String curLetter, List<String> rstList, Map<String, String> numMap){
        if(numLevel == digits.length()){
            rstList.add(curLetter);
            return;
        }
        char c = digits.charAt(numLevel);
        String letters = numMap.get(String.valueOf(c));
        for(int i =0; i<letters.length();i++){
            letterCombinSub(digits, numLevel+1, curLetter+ letters.charAt(i),rstList, numMap);
        }

    }

    public static void main(String[] args) {
        List<String> strings = letterCombinations("23");
        System.out.println(strings.toString());

    }


}
