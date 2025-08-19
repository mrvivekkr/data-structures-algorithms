import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LeetCode Problem: Combination Sum II
 * Difficulty: Medium
 *
 * Given a collection of candidate numbers (candidates) and a target number (target),
 * find all unique combinations in candidates where the candidate numbers sum to target.
 *
 * Each number in candidates may only be used once in the combination.
 * The solution set must not contain duplicate combinations.
 */
public class CombinationSum2 {

    /**
     * Main function to find all unique combinations that sum up to target.
     *
     * @param candidates array of candidate numbers
     * @param target target sum
     * @return list of unique combinations
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> output = new ArrayList<>();

        // Sort array to handle duplicates easily
        Arrays.sort(candidates);

        // Backtracking helper function
        combinationSumUtil(candidates, 0, target, new ArrayList<>(), output);
        return output;
    }

    /**
     * Recursive helper method for backtracking.
     *
     * @param candidates sorted array of candidates
     * @param index current index in the array
     * @param target remaining target sum
     * @param list current combination being formed
     * @param output final list of unique combinations
     */
    private void combinationSumUtil(int[] candidates, int index, int target,
                                    List<Integer> list, List<List<Integer>> output) {
        // Base case: found a valid combination
        if (target == 0) {
            output.add(new ArrayList<>(list));
            return;
        }

        // Stop recursion if out of bounds or target becomes negative
        if (index >= candidates.length || target < 0) {
            return;
        }

        // Iterate through candidates
        for (int i = index; i < candidates.length; i++) {
            // Skip duplicates
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }

            // Choose current number
            list.add(candidates[i]);

            // Recurse with next index and reduced target
            combinationSumUtil(candidates, i + 1, target - candidates[i], list, output);

            // Backtrack: remove last chosen number
            list.remove(list.size() - 1);
        }
    }

    // Driver code for testing
    public static void main(String[] args) {
        CombinationSum2 solution = new CombinationSum2();
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;

        // Expected output: [[1,1,6],[1,2,5],[1,7],[2,6]]
        System.out.println(solution.combinationSum2(candidates, target));
    }
}
