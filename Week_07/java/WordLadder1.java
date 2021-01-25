import java.util.*;

/**
 * 单词接龙
 */
public class WordLadder1 {
    /**
     * BFS
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordList.contains(endWord)) return 0;

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        Set<String> visitedSet = new HashSet<>();
        visitedSet.add(beginWord);
        int count=1;
        while(!queue.isEmpty()){
            int len = queue.size();
            for(int i=0;i<len;i++){
                String curStr = queue.poll();
                if(ladderLengthSub(curStr, endWord, wordSet, queue, visitedSet)){
                    return count +1;
                }
            }
            count++;
        }
        return 0;

    }

    public boolean ladderLengthSub(String curStr, String endWord, Set<String> wordSet, Queue<String> queue, Set<String> visitedSet) {
        char[] curChars = curStr.toCharArray();
        for(int i = 0;i<curChars.length;i++){
            char tmp = curChars[i];
            for(char ch = 'a';ch<='z';ch++){
                curChars[i]=ch;
                String nextStr = String.valueOf(curChars);
                if(wordSet.contains(nextStr)){
                    if(endWord.equals(nextStr))
                        return true;
                    if(!visitedSet.contains(nextStr)){
                        queue.offer(nextStr);
                        visitedSet.add(nextStr);
                    }
                }
            }
            curChars[i] = tmp;
        }
        return false;
    }

    /**
     * 双向BFS
     */
    public static int ladderLength2(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if(!wordSet.contains(endWord))
            return 0;
        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        Set<String> visitedSet = new HashSet<>();
        int count = 1;
        beginSet.add(beginWord);
        endSet.add(endWord);
        while(!beginSet.isEmpty()||!endSet.isEmpty()){
            if(beginSet.size()>endSet.size()||beginSet.isEmpty()){
                Set<String> tmpset = beginSet;
                beginSet = endSet;
                endSet = tmpset;
            }

            Set<String> nextBeginSet = new HashSet<>();
            if(ladderLengthSub2(wordSet, beginSet,endSet,visitedSet, nextBeginSet))
                return count+1;
            beginSet = nextBeginSet;
            count++;
        }
        return 0;
    }

    public static boolean ladderLengthSub2(Set<String> wordSet, Set<String> beginSet, Set<String> endSet, Set<String> visitedSet, Set<String> nextBeginSet) {
        for(String curStr:beginSet) {
            char[] curChars = curStr.toCharArray();
            for(int i = 0;i<curChars.length;i++){
                char tmp = curChars[i];
                for(char ch = 'a';ch<='z';ch++){
                    curChars[i]=ch;
                    String nextStr = String.valueOf(curChars);
                    if(endSet.contains(nextStr))
                        return true;
                    if(!visitedSet.contains(nextStr)&&wordSet.contains(nextStr)){
                        nextBeginSet.add(nextStr);
                        visitedSet.add(nextStr);
                    }
                }
                curChars[i] = tmp;
            }
        }
        return false;
    }

    public static void main(String[] args) {
//        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log");
        List<String> wordList = Arrays.asList("hot", "dog");
        System.out.println(ladderLength2("hot", "dog", wordList));
    }
}
