import java.util.ArrayList;
import java.util.List;

//全排列
public class Permute {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int[] used = new int[nums.length];
        permuteSub(nums, 0, used, new ArrayList<>(), res);
        return res;

    }

    private void permuteSub( int[] nums, int level, int[] used, ArrayList<Integer> rstSingle, List<List<Integer>> result) {
        if (level == nums.length) {
            result.add(new ArrayList<>(rstSingle));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i] == 1) continue;
            used[i] = 1;
            rstSingle.add(nums[i]);
            permuteSub(nums, level+1, used, rstSingle, result);
            used[i] = 0;
            rstSingle.remove(level);
        }
    }
}
