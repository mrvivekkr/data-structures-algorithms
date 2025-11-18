import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    /**
     * Returns all unique combinations in candidates where the numbers sum to the target.
     * Each number in candidates may be used an unlimited number of times.
     * @param candidates Array of distinct integers to use as candidates for combinations
     * @param target Target sum we want to achieve using combinations of candidates
     * @return A list of lists, where each inner list represents a valid combination
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>(); // List to store all valid combinations
        // Start the recursive backtracking process from index 0 with an empty combination
        getCombinations(candidates, 0, target, new ArrayList<>(), res);
        return res;
    }

    /**
     * Helper function to recursively build valid combinations.
     *
     * @param candidates Array of distinct integers
     * @param idx Current index in candidates array to avoid revisiting previous elements
     * @param target Remaining sum needed to reach the target
     * @param curr List storing the current combination being built
     * @param res List of all valid combinations found so far
     */
    public void getCombinations(int[] candidates, int idx, int target, List<Integer> curr, List<List<Integer>> res){
        // Base case: If target becomes negative, the combination is invalid
        if(target < 0)
            return;
        // Base case: If target becomes zero, we found a valid combination
        if(target == 0)
            res.add(new ArrayList<>(curr)); // Add a copy of the current combination to results
        // Explore further candidates (including the current one, since each can be reused)
        for(int i = idx; i < candidates.length; i++){
            curr.add(candidates[i]); // Choose the candidate at index i
            // Recursive call with updated target and the same index i (allowing reuse)
            getCombinations(candidates, i, target - candidates[i], curr, res);
            curr.remove(curr.size() - 1); // Backtrack: remove last chosen candidate
        }
    }

    public static void main(String[] args){
        CombinationSum solution = new CombinationSum();
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        System.out.println(solution.combinationSum(candidates, target));

        candidates = new int[]{2, 3, 5};
        target = 8;
        System.out.println(solution.combinationSum(candidates, target));

        candidates = new int[]{2};
        target = 1;
        System.out.println(solution.combinationSum(candidates, target));
    }
}
