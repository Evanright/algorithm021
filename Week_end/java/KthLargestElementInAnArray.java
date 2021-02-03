import java.util.PriorityQueue;

/**
 * 第K大的数
 */
public class KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(len, (a, b) -> b - a);

        for(int i=0;i<len;i++){
            maxHeap.add(nums[i]);
        }
        for(int j=0;j<k-1; j++){
            maxHeap.poll();
        }
        return maxHeap.peek();
    }

    public int findKthLargest2(int[] nums, int k) {
        int len = nums.length;
        int left = 0;
        int right = len-1;

        int target = len - k;
        while (left<=right){
            int index = parttion(nums, left,right);
            if(index==target){
                return nums[target];
            }else if(index<target){
                left= index+1;
            }else {
                right = index-1;
            }
        }
        return -1;
    }
    public int parttion(int[]nums, int begin, int end){
        int pivot = end, counter = begin;
        for (int i = begin; i < end; i++) {
            if (nums[i] < nums[pivot]) {
                int temp = nums[counter]; nums[counter] = nums[i]; nums[i] = temp;
                counter++;
            }
        }
        int temp = nums[pivot]; nums[pivot] = nums[counter]; nums[counter] = temp;
        return counter;
    }
}
