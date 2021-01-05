import java.util.Arrays;
import java.util.List;

/**
 * 322. 零钱兑换
 *  使用动态规划
 */
public class CoinChange {
    public static int coinChange(int[] coins, int amount) {
        int[] store = new int[amount+1];
        store[0]=0;
        for(int i=1;i<=amount;i++){
            int min = Integer.MAX_VALUE;
            for(int coin : coins){
                if(i>=coin && store[i-coin]<min){
                    min = store[i-coin]+1;
                }
            }
            store[i] = min;
        }
        return store[amount]==Integer.MAX_VALUE ? -1: store[amount];
    }

    /**
     * 第二种方式 使用贪心+DFS
     * 先使用最大面值的币去换 -> 然后回溯减少较大面值的币
     *
     */
    public static int min=Integer.MAX_VALUE;
    public static int coinChange1(int[] coins, int amount) {
        if(amount == 0) return 0;
        Arrays.sort(coins);
        coinChangeSun(coins, amount, coins.length-1,0);
        return min==Integer.MAX_VALUE ? -1 : min;
    }
    public static void coinChangeSun(int[] coins, int amount, int coinIndex, int coinNum){
        if(amount==0)
            min = Math.min(min, coinNum);
        if(coinIndex<0)
            return;

        for(int i=amount/coins[coinIndex]; i>=0 && i+coinNum<min; i--){
            coinChangeSun(coins, amount-coins[coinIndex]*i, coinIndex-1,i+coinNum);
        }

    }


    public static void main(String[] args) {
        int[] coins = new int[]{1, 2, 5};
        System.out.println(coinChange(coins, 11));
    }
}
