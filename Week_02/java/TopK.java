import java.util.*;

public class TopK {
    // 使用Map和数组处理 效率差
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> numCountMap = new HashMap<>();
        for(int num : nums){
            numCountMap.put(num, numCountMap.getOrDefault(num, 0) + 1);
        }
        int[] rst = new int[k];
        int minIndex=0;
        int i=0;
        for(Integer key: numCountMap.keySet()){
            if(i<k){
                rst[i++]=key; //先填满数组
                continue;
            }
            if(i==k){ //填充完毕
                minIndex = minNumIndex(rst, numCountMap); //第一次寻找出K高中的最小值
                i++; // 使其不再生效
            }
            if(numCountMap.get(key) > numCountMap.get(rst[minIndex])){//如果此元素是否比数组最小值大
                rst[minIndex] = key;
                minIndex = minNumIndex(rst, numCountMap); //重新寻找出K高中的最小值
            }
        }
        return rst;
    }
    public static int minNumIndex(int[] nums, Map<Integer,Integer> map){
        int tmpIndex = 0;
        for(int i=1;i<nums.length;i++){
            if(map.get(nums[i])< map.get(nums[tmpIndex])) tmpIndex = i;
        }
        return tmpIndex;
    }

    //使用堆处理
    public static int[] topKFrequent1(int[] nums, int k) {
        Map<Integer,Integer> numCountMap = new HashMap<>();
        for(int num : nums){
            numCountMap.put(num, numCountMap.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> priQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return numCountMap.get(o1) - numCountMap.get(o2) ;//升序排列，最前面是最小值
            }
        });
        for(Integer key: numCountMap.keySet()){
            if(priQueue.size() < k) priQueue.add(key);

            else if(numCountMap.get(key) >numCountMap.get(priQueue.peek())){
                priQueue.remove();
                priQueue.add(key);
            }
        }
        int rst[] = new int[k];
        for(int i=0;i<k;i++){
            rst[i] = priQueue.remove();
        }
        return rst;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{6,0,1,4,9,7,-3,1,-4,-8,4,-7,-3,3,2,-3,9,5,-4,0};
        int[] result = topKFrequent1(nums, 6);
        for(int i:result){
            System.out.println(i);
        }
    }

}
//-3 0 1 -4 4 9