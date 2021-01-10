import java.util.Arrays;
import java.util.Comparator;

/**
 * 435. 无重叠区间
 * 贪心算法
 * 排序 + 比较尾部
 */
public class NonOverlappingIntervals {
    public static int eraseOverlapIntervals(int[][] intervals) {

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });

        if(intervals.length==0) return 0;
        int count = 1;
        int x_end = intervals[0][1];
        for(int i =1;i<intervals.length;i++){
            System.out.println(intervals[i][0]);
            if(intervals[i][0]>=x_end){
                count++;
                x_end = intervals[i][1];
            }
        }
        return intervals.length-count;
    }

    public static void main(String[] args) {

        int[][] secArray = new int[][]{{1,2}, {2,3}};
//        int[][] secArray = new int[][]{{1,100},{11,22},{1,11},{2,12}};
        int i = eraseOverlapIntervals(secArray);
        System.out.println(i);
    }


}
