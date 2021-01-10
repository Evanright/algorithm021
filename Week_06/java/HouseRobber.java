import java.util.Arrays;

/**
 * 213. 打家劫舍 II
 * 使用动太规划
 */
public class HouseRobber {
    /**
     * 使用二维数组， 二维使用0,1表示偷或不偷
     * @param nums
     * @return
     */
    public static int rob(int[] nums) {
        int len = nums.length;
        if (len==1){
            return nums[0];
        }
        int[][] house1 = new int[nums.length][2];
        int[][] house2 = new int[nums.length][2];
        house1[0][0] = 0;
        house1[0][1] = nums[0];
        house2[1][0] = 0;
        house2[1][1] = nums[1];
        for(int i=1;i<len-1;i++){
            house1[i][0] = Math.max(house1[i-1][0],house1[i-1][1]);
            house1[i][1] = house1[i-1][0]+nums[i];
        }
        int first = Math.max(house1[len-2][0], house1[len-2][1]);
        for(int i=2;i<len;i++){
            house2[i][0] = Math.max(house2[i-1][0],house2[i-1][1]);
            house2[i][1] = house2[i-1][0]+nums[i];
        }
        int second = Math.max(house2[len-1][0],house2[len-1][1]);
        return Math.max(first, second);
    }

    /**
     * 使用一维数组
     * @param nums
     * @return
     */
    public static int rob1(int[] nums) {
        int len = nums.length;
        if (len<=2){
            Arrays.sort(nums);
            return nums[len-1];
        }

        int[] house1 = new int[nums.length];
        int[] house2 = new int[nums.length];
        house1[0] = nums[0];
        house1[1] = Math.max(nums[0],nums[1]);

        house2[1] = nums[1];
        house2[2] = Math.max(nums[1],nums[2]);

        for(int i=2;i<len-1;i++){
            house1[i] = Math.max(house1[i-1],house1[i-2]+nums[i]);
        }
        for(int i=3;i<len;i++){
            house2[i] = Math.max(house2[i-1],house2[i-2]+nums[i]);
        }
        return Math.max(house1[len-2],house2[len-1]);
    }

    /**
     * 使用数字 （只存前面两家能偷的钱）
     * @param nums
     * @return
     */
    public static int rob2(int[] nums) {
        int len = nums.length;
        if (len<=2){
            Arrays.sort(nums);
            return nums[len-1];
        }
        int housePre1 = nums[0];
        int houseNow1 = Math.max(nums[0],nums[1]);


        int housePre2 = nums[1];
        int houseNow2 = Math.max(nums[1],nums[2]);

        for(int i=2;i<len-1;i++){
            int tmp = houseNow1;
            houseNow1 = Math.max(housePre1+nums[i], houseNow1);
            housePre1 = tmp;
        }
        int house1 = Math.max(housePre1, houseNow1);
        for(int i=3;i<len;i++){
            int tmp = houseNow2;
            houseNow2 = Math.max(housePre2+nums[i], houseNow2);
            housePre2 = tmp;
        }
        int house2 = Math.max(housePre2, houseNow2);
        return Math.max(house1,house2);
    }



    public static void main(String[] args) {
        int[] nums = new int[]{2,3,2,0};
        System.out.println(rob(nums));
        System.out.println(rob1(nums));
        System.out.println(rob2(nums));
    }
}
