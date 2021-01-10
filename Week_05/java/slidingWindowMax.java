import java.util.*;

/**
 * 滑动窗口
 * 使用双端对列，头放最大的数
 */
public class slidingWindowMax {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new LinkedList<>();
        int len = nums.length;
        int[] rst = new int[len-k+1];
        int index = 0;
        for(int i=0; i<len; i++){
            if(!deque.isEmpty()&&deque.peekFirst()+k<=i) { //判断头部数据的是否还满足滑动窗口的要求
                deque.pollFirst();
            }

            while(!deque.isEmpty() && nums[deque.peekLast()]<nums[i]){ //从后向前判断，将小的数据全部删除
                deque.pollLast();
            }
            deque.addLast(i);
            if(index+k-1==i) {
                rst[index++] = nums[deque.peekFirst()]; //头部是最大值
            }
        }

        return rst;

    }


    public static void main(String[] args) {
//        int[] nums = new int[]{9,11,15,2,18};
        int[] nums = new int[]{1,3,1,2,0,5};
        int[] rst = maxSlidingWindow(nums, 3);
        for(int i:rst){
            System.out.println(i);
        }
    }
}
