import java.util.Arrays;

public class HouseRobber1 {
    public static int rob(int[] nums) {
        int len = nums.length;
        if(len==0) return 0;

        int[] house = new int[len+1];

        house[0] = 0; //偷第一家
        house[1] = nums[0];

        for(int i=2;i<=len;i++){
            house[i] = Math.max(house[i-2]+nums[i-1], house[i-1]);
        }

        return house[len];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,7,9,3,1};
        System.out.println(rob(nums));
    }

}
