public class ValidPerfectSquare {
    /**
     * 367. 有效的完全平方数
     */
    public static boolean isPerfectSquare(int num) {
        //正整数 num 的平方根一定落在 [1, num/2 + 1] 区间
        //防止 mid * mid 太大而发生溢出（超出整型的范围），取 mid 跟 num / mid 进行比较；
        int left = 1;
        int right = num/2+1;
        while(left<=right){
            int mid = left+((right-left)>>1);
            int target = num/mid;
            if(target==mid) {
                if (num % mid == 0) //如果取余为0说明相等
                    return true;
                right = mid - 1;   //缩小上边界
            } else if(target>mid){
                left = mid+1;
            } else{
                right = mid-1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isPerfectSquare(16));
    }
}
