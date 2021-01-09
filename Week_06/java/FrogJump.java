/**
 * 青蛙过河
 * dp[i][k] 表示能否由前面的某一个石头 j 通过跳 k 步到达当前这个石头 i ，这个 j 的范围是 [1, i - 1]
 *          当然，这个 k 步是 i 石头 和 j 石头之间的距离
 *          那么对于 j 石头来说，跳到 j 石头的上一个石头的步数就必须是这个 k - 1 || k || k + 1
 *          由此可得状态转移方程：dp[i][k] = dp[j][k - 1] || dp[j][k] || dp[j][k + 1]
 */
public class FrogJump {

    public boolean canCross(int[] stones) {
        int len = stones.length;
        if(stones[1] != 1){
            return false;
        }
        boolean[][] dp = new boolean[len][len+1];
        dp[0][0]= true;

        for(int i=1;i<len;i++){
            for(int j=0; j<i; j++){
                int k = stones[i]-stones[j];
                if(k <= j + 1){
                    dp[i][k] = dp[j][k - 1] || dp[j][k] || dp[j][k + 1];
                    //提前结束循环直接返回结果
                    if(i == len - 1 && dp[i][k]){
                        return true;
                    }
                }
            }

        }
        return false;
    }
}
