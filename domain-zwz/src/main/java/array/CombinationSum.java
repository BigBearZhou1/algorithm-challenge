package array;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < candidates.length; i++) {
            List<Integer> res = new ArrayList<>();
            res.add(candidates[i]);
            process(candidates[i], candidates, res, target, result,i);
        }
        return result;
    }

    private void process(int sum, int[] candidates, List<Integer> res,
                         int target, List<List<Integer>> result,int curIndex) {
        if (sum == target) {
            result.add(new ArrayList<>(res));
            return;
        }
        if(sum>target){
            return;
        }
        for (int i = curIndex; i < candidates.length; i++) {
            res.add(candidates[i]);
            process(sum+candidates[i], candidates, res, target, result,i);
            res.remove(res.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] candidates = {2};
        CombinationSum solution = new CombinationSum();
        List<List<Integer>> results = solution.combinationSum(candidates, 1 );
        System.out.println(results);
    }
}
