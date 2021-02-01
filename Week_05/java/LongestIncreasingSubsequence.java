import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if(len<2) {
            return len;
        }
        int[] dp = new int[len];
        int rst = 0;
        Arrays.fill(dp,1);
        for(int i=1;i<len;i++){
            for(int j = 0;j<i;j++){
                if(nums[i]>nums[j]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
            rst = Math.max(rst, dp[i]);

        }
        return rst;


    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,6,7,9,4,10,5,6};
        LongestIncreasingSubsequence obj = new LongestIncreasingSubsequence();
        System.out.println(obj.lengthOfLIS(nums));

    }


}
