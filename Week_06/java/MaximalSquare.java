/**
 * 最大正方形 三者取最小+1
 */
public class MaximalSquare {
    public static int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        if(m==0) return 0;
        int n = matrix[0].length;
        int[][] dp = new int[m+1][n+1];
        int maxSquare = Integer.MIN_VALUE;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j] == '1'){
                    dp[i+1][j+1] = Math.min(dp[i][j] ,Math.min(dp[i][j+1],dp[i+1][j]))+1;
                    maxSquare = Math.max(maxSquare, dp[i+1][j+1]);
                }
            }
        }
        return maxSquare*maxSquare;
    }

    public static void main(String[] args) {
        char [][]matrix = new char[][]{{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        System.out.println(maximalSquare(matrix));


    }


}
