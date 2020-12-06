import java.util.Deque;
import java.util.LinkedList;

//接雨水 使用栈
public class TrappingRainWater {
    public static int trap(int[] height) {
        int max = 0;
        Deque<Integer> stack = new LinkedList<Integer>();

        for(int i=0;i<height.length;i++){
            if(stack.isEmpty()&&height[i]>0){
                stack.push(i);
                continue;
            }else if(stack.isEmpty()&&height[i]==0){
                continue;
            }

            while(!stack.isEmpty()&&height[stack.peek()]<height[i]){
                int cur = stack.pop();

                if(stack.isEmpty()) break;
                int left = stack.peek();
                int min = Math.min(height[left],height[i]);
                int high = min - height[cur];
                int len = i - left-1;
                max += high*len;
            }
            stack.push(i);

        }

        return max;

    }

    public static void main(String[] args) {
        int[] ints = {4,2,0,3,2,5};
        int trap = trap(ints);
        System.out.println(trap);
    }

}
