public class ReversePairs {
    /**
     * 翻转对
     * @param nums
     * @return
     */
    public int reversePairs(int[] nums) {
        return merger(nums, 0, nums.length-1);
    }

    public int merger(int[] nums, int left, int right){
        if(left>=right) return 0;
        int mid = left+(right-left)/2;
        int count = merger(nums,left,mid) + merger(nums,mid+1,right);
        int[] tmp = new int[right-left+1];
        int i = left, t=left, k=0;
        for(int j = mid+1;j<=right;j++){
            while (i<=mid && nums[i]<=(long) 2*nums[j]) i++; //正着数会丢掉数据，所以选择算差
            while (t<=mid && nums[t]<nums[j]) tmp[k++] = nums[t++];
            tmp[k++] = nums[j];
            count+= mid-i+1;
        }
        while (t<=mid) tmp[k++] = nums[t++];

        System.arraycopy(tmp,0,nums,left,right-left+1);
        return count;
    }




    public static void main(String[] args) {
//        int[] nums = new int[]{1,3,2,3,1};
        int[] nums = new int[]{2,4,3,5,1};
        ReversePairs obj = new ReversePairs();
        System.out.println(obj.reversePairs(nums));
    }




}
