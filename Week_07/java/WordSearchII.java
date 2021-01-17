import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Trie {
    public boolean isEnd;
    public Trie[] next;
    public String val;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        isEnd = false;
        next = new Trie[26];
    }

    /**
     * Inserts a word into the trie.
     * @return
     */
    public void insert(String word) {
        if (word == null || word.length() == 0) return ;
        Trie curr = this;
        char[] words = word.toCharArray();
        for (int i = 0; i < words.length; i++) {
            int n = words[i] - 'a';
            if (curr.next[n] == null) curr.next[n] = new Trie();
            curr = curr.next[n];
        }
        curr.isEnd = true;
        curr.val = word;
    }

    public boolean search(String word) {
        Trie node = searchPrefix(word);
        return node != null && node.isEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Trie node = searchPrefix(prefix);
        return node != null;
    }

    private Trie searchPrefix(String word) {
        Trie node = this;
        char[] words = word.toCharArray();
        for (int i = 0;i < words.length;i++) {
            node = node.next[words[i] - 'a'];
            if (node == null) return null;
        }
        return node;
    }
}

public class WordSearchII {
    Set<String> ans = new HashSet<>();

    /**
     * 成功实现，速度很慢
     * @param board
     * @param words
     * @return
     */
    public List<String> findWords(char[][] board, String[] words) {

        Trie trie = new Trie();
        for(String word: words){
            trie.insert(word);
        }

        int m = board.length;
        int n = board[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                findDfs(i, j, board, "",trie);
            }
        }
        return new ArrayList<>(ans);
    }

    public void findDfs(int i, int j, char[][] board, String singleRst, Trie trie){
        int [][] site = {{1,0},{0,1},{-1,0},{0,-1}};

        if(i<0||i>=board.length||j<0||j>=board[0].length) return;

        char ch = board[i][j];
        if(ch=='@'||trie.next[ch-'a']==null)
            return;
        board[i][j] ='@';
        trie = trie.next[ch-'a'];
//        singleRst = singleRst+ch;
        if(trie.isEnd){
            ans.add(trie.val);
//            return; //不能返回同组其他元素还需要遍历
        }
        for(int[] index:site) {
            findDfs(i+index[0],j+index[1], board, singleRst,trie);
        }
//        findDfs(i+1,j, board, singleRst+ch,trie);
//        findDfs(i-1,j, board, singleRst+ch,trie);
//        findDfs(i,j+1, board, singleRst+ch,trie);
//        findDfs(i,j-1, board, singleRst+ch,trie);
        board[i][j] = ch;
    }


    /**
     * 可以实现 太慢了
     * @param board
     * @param words
     * @return
     */
    public List<String> findWords2(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board, "", i, j, trie);
            }
        }
        return new ArrayList<>(ans);
    }

    public void dfs(char[][] board, String str, int x, int y, Trie trie) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) return;

        str += board[x][y];
        if (board[x][y]=='@'||!trie.startsWith(str)) return;

        if (trie.search(str)) {
            ans.add(str);
        }
        char ch = board[x][y];

        board[x][y] ='@';
        dfs(board, str, x - 1, y, trie);
        dfs(board, str, x + 1, y, trie);
        dfs(board, str, x, y - 1, trie);
        dfs(board, str, x, y + 1, trie);
        board[x][y] = ch;
    }


    public static void main(String[] args) {
        char[][] board = {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
        String[] words = {"oath","pea","eat","rain","hklf", "hf"};


//        char[][] board = {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
//        String[] words = {"oath","pea","eat","rain"};
//        char[][] board ={{'a'}};
//        String[] words ={"a"};
        WordSearchII wordSearchII = new WordSearchII();
        System.out.println(wordSearchII.findWords(board, words));


    }
}
