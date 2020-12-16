import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Intersection {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> rstList = new ArrayList<>();
        Map<Integer,Integer> numMap = new HashMap<>();
        for(int i : nums1){
            if(numMap.containsKey(i)){
                numMap.put(i,numMap.get(i)+1);
            }else{
                numMap.put(i,1);
            }
        }
        for(int j:nums2){
            if(numMap.get(j)!=null && numMap.get(j)!=0){
                rstList.add(j);
                numMap.put(j,numMap.get(j)-1);
            }
        }
        int[] rstNums= new int[rstList.size()];
        for(int k=0;k<rstList.size();k++){
            rstNums[k]=rstList.get(k);
        }
        return rstNums;
    }
}
