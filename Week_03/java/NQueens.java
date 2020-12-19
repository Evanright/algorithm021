import java.util.*;

public class NQueens {
    static List<List<String>> rst = new ArrayList<>();

    public static List<List<String>> solveNQueens(int n) {
        if(n<=0) return null;
        List<Integer> row = new ArrayList<>();
        List<Integer> pie = new ArrayList<>();
        List<Integer> na  = new ArrayList<>();
        solveNQueensSub(n,0, new ArrayList<>(), row, pie, na);
        return rst;
    }

    public static void solveNQueensSub(int totalN, int curLevel, List<Integer> singleLine, List<Integer> row, List<Integer> pie, List<Integer> na){
        if(curLevel == totalN ){
            char[] chars = new char[totalN];
            List<String> rstFir = new ArrayList<>();
            for(Integer i:singleLine){
                Arrays.fill(chars, '.');
                chars[i] = 'Q';
                rstFir.add(new String(chars));
            }
            rst.add(rstFir);
            return;
        }
        for(int queenRow=0;queenRow<totalN;queenRow++) {
            if (row.contains(queenRow) || pie.contains(curLevel - queenRow) || na.contains(curLevel + queenRow)) continue;
            singleLine.add(queenRow);
            row.add(queenRow);
            pie.add(curLevel - queenRow);
            na.add(curLevel+queenRow);
            solveNQueensSub(totalN, curLevel+1, singleLine, row, pie, na);
            singleLine.remove((Object) queenRow);
            row.remove((Object)queenRow);
            pie.remove((Object)(curLevel - queenRow));
            na.remove((Object)(curLevel+queenRow));
        }
    }

    public static void main(String[] args) {
        List<List<String>> lists = solveNQueens(4);
        System.out.println(lists.toString());
    }

}
