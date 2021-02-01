import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> rst = new ArrayList<>();
        int len = nums.length;
        if(len<3||nums[0]>0) return rst;

        for(int i=0;i<len;i++){
            if(i>0&&nums[i]==nums[i-1]) continue;
            sumSub(nums[i],i+1,len-1,nums,rst);
        }
        return rst;
    }

    public static void sumSub(int target, int start, int end, int[] nums, List<List<Integer>> rst){
        while(start<end){
            int tmp = nums[start]+nums[end]+target;
            if(tmp==0){
                List<Integer> singleRst = Arrays.asList(target,nums[start],nums[end]);
                rst.add(singleRst);
                while(start<end&&nums[++start]==nums[start-1]); //去重，继续向下循环
                while(start<end&&nums[--end]==nums[end+1]);
            }
            if(tmp<0){
                start++;
            }
            if(tmp>0){
                end--;
            }
        }
    }


    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,1,2,-1,-4};
        System.out.println(threeSum(nums));
    }


}
