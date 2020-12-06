//旋转数组
public class RotateArray {
    public static void rotate(int[] nums, int k) {

        int len = nums.length;
        k = k % len;
        rever(nums,0,len-1);
        rever(nums,0,k-1);
        rever(nums,k,len-1);
    }

    public static void rever(int[]nums, int start, int end){
        int len = end-start+1;
        for(int i=0;i<len/2;i++){
            int tmp = nums[start+i];
            nums[start+i] = nums[end-i];
            nums[end-i] = tmp;
        }
    }

    public static void main(String[] args) {
        int nums[] = new int[]{1,2,3,4,5,6,7};
        rotate(nums, 3);
        for(int i :nums){
            System.out.println(i);
        }
    }

}
