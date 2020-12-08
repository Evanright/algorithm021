
public class SlidingWindow {
    public static int[] maxSlidingWindow(int[] nums, int k) {

        int len = nums.length;
        if(len==0){
            return new int[]{};
        }
        if(len<k){
            int maxIndex = max(nums, 0,len-1);
            return new int[]{nums[maxIndex]};
        }

        int[] rst = new int[len-k+1];
        int maxIndex;
        maxIndex = max(nums,0,k-1);
        rst[0] = nums[maxIndex];
        for(int i=k;i<nums.length;i++){
            if(maxIndex+k==i){
                maxIndex = max(nums,maxIndex+1,i);
            }
            if(nums[maxIndex]<nums[i]) maxIndex = i;

            rst[i-k+1] = nums[maxIndex];


        }
        return rst;
    }

    public static int max(int[] nums, int start, int end){
        int maxIndex = start;
        for(int i = start+1;i<=end;i++){
            if(nums[i]> nums[maxIndex]) maxIndex= i;
        }
        return maxIndex;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,-1,-3,5,3,6,7};
        int[] rsts = maxSlidingWindow(nums, 3);
        for(int i =0;i<rsts.length;i++){
            System.out.println(rsts[i]);
        }
    }

}
