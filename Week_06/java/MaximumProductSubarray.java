/**
 * 152. 乘积最大子数组
 * 使用动态规划
 * 维护两极元素
 */
public class MaximumProductSubarray {
    public static int maxProduct(int[] nums) {
        int max = nums[0];
        int maxNum = nums[0];
        int minNum = nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]<0){
                int tmp = minNum;
                minNum = maxNum;
                maxNum = tmp;
            }
            maxNum = Math.max(maxNum*nums[i],nums[i]);
            minNum = Math.min(minNum*nums[i],nums[i]);

            max = Math.max(maxNum, max);
        }
        return Math.max(max, minNum);

    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,3,-2,4};
        System.out.println(maxProduct(nums));
    }

}
