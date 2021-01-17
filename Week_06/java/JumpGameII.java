/**
 * 跳跃游戏II
 * 贪心算法
 */
public class JumpGameII {
    public static int jump(int[] nums) {
        int length = nums.length;
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end) { //end 是这一轮能到的最远距离
                end = maxPosition; //更新下一轮能到达的最远距离
                steps++;
            }
        }
        return steps;
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{1,2,3};
        int[] nums = new int[]{2,3,1,1,4};
        System.out.println(jump(nums));
    }
}
