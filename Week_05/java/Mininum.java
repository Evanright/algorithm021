import java.util.*;

public class Mininum {
    /**
     * 433. 最小基因变化 //广度优先遍历
     */
    public int minMutation(String start, String end, String[] bank) {
        Set<String> bankSet = new HashSet<String>(Arrays.asList(bank));
        if(!bankSet.contains(end)) return -1;
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        Set<String> visited = new HashSet<>();
        visited.add(start);
        int count = 1;
        while(!queue.isEmpty()){
            int len = queue.size();
            for(int i=0;i<len;i++){
                String curStr = queue.poll();
                if(minSub(curStr, end, bankSet, queue, visited))
                    return count;
            }
            count++;
        }
        return -1;
    }
    public boolean minSub(String curStr, String end, Set<String> bankSet, Queue<String> queue, Set<String> visited){
        char[] chars = curStr.toCharArray();
        char[] charBank = new char[]{'A','C','G','T'};
        for(int i=0;i<chars.length;i++){
            char tmp = chars[i];
            for(char ch : charBank){
                chars[i] = ch;
                String nextStr = String.copyValueOf(chars);
                if(bankSet.contains(nextStr)){
                    if(end.equals(nextStr))
                        return true;
                    if(!visited.contains(nextStr)){
                        queue.add(nextStr);
                        visited.add(nextStr);
                    }
                }
            }
            chars[i] = tmp;
        }
        return false;
    }
}
