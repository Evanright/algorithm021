import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class LastStone {

    public static int lastStoneWeight(int[] stones) {
        Arrays.sort(stones);
        while(stones.length>=2){
            int len = stones.length;
            if(stones[len-1]==stones[len-2]) {
                stones = Arrays.copyOf(stones, len - 2);
            }else {
                stones[len-2] = stones[len-1] - stones[len-2];
                stones = Arrays.copyOf(stones, len - 1);
            }
            Arrays.sort(stones);
            System.out.println(Arrays.toString(stones));
        }
        if(stones.length==1) return stones[0];
        else return 0;

    }

    public static int lastStoneWeight1(int[] stones) {

//        Comparator<Integer> comparator = new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return (o2 - o1);
//            }
//        };
        PriorityQueue<Integer> pq = new PriorityQueue<>(
                (o1, o2) -> o2-o1
        );
        for(Integer stone: stones){
            pq.add(stone);
        }
        while(pq.size()>1){
            int last1 = pq.poll();
            int last2 = pq.poll();
            if(last1!=last2)pq.add(last1-last2);
        }
        if(pq.size()==1) return pq.poll();
        return 0;
    }





    public static void main(String[] args) {
        int[] stones = new int[]{2,7,4,1,8,1};
        int i = lastStoneWeight1(stones);
        System.out.println(i);
    }
}
