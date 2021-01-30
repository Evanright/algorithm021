import java.util.*;

public class RelativeSortArray {
    /**
     * 使用Map、List实现
     * @param arr1
     * @param arr2
     * @return
     */
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> arr1Map = new HashMap<>();
        for(int num: arr1){
            arr1Map.put(num,arr1Map.getOrDefault(num,0)+1);
        }
        List<Integer> rst = new ArrayList<>();
        for(int num2: arr2){
            if(arr1Map.containsKey(num2)){
                for(int i=0;i<arr1Map.get(num2);i++){
                    rst.add(num2);
                }
                arr1Map.remove(num2);
            }
        }
        List<Integer> rst2 = new ArrayList<>();
        for (Integer key : arr1Map.keySet()) {
            for (int j = 0; j < arr1Map.get(key); j++) {
                rst2.add(key);
            }
        }
        rst2.sort(Integer::compareTo);
        rst.addAll(rst2);
        return rst.stream().mapToInt(i->i).toArray();
    }



    public static void main(String[] args) {
        int[] arr1 = new int[]{2,3,1,3,2,4,6,7,9,2,19};
        int[] arr2 = new int[]{2,1,4,3,9,6};
        RelativeSortArray relativeSortArray = new RelativeSortArray();
        int[] ints = relativeSortArray.relativeSortArray(arr1, arr2);
        for(int i :ints){
            System.out.println(i);
        }

    }
}
