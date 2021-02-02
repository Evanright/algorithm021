import java.util.List;

public class Triangle {
    /**
     * 120. 三角形最小路径和
     * @param triangle
     * @return
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int size = triangle.size();
        int[][]dp = new int[size+1][size+1];
        for(int i=size-1;i>=0;i--){
            for(int j=0;j<=i;j++){
                dp[i][j] = Math.min(dp[i+1][j],dp[i+1][j+1])+triangle.get(i).get(j);
            }
        }
        return dp[0][0];
    }

    public int minimumTotal2(List<List<Integer>> triangle) {
        int size = triangle.size();
        int[]dp = new int[size+1];
        for(int i=size-1;i>=0;i--){
            for(int j=0;j<=i;j++){
                dp[j] = Math.min(dp[j],dp[j+1])+triangle.get(i).get(j);
            }
        }
        return dp[0];
    }
}
