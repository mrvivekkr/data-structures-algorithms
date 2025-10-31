import java.util.ArrayList;
import java.util.List;

// Subsets.java
public class Subsets {

    /**
     * Returns all possible subsets (the power set) of the given array of unique integers.
     * Uses backtracking to generate subsets recursively.
     *
     * @param nums Input array of unique integers
     * @return List of all subsets
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        generateAllSets(nums, 0, curr, res);
        return res;
    }

    /**
     * Helper method to generate subsets using backtracking.
     * At each step, it tries adding each number starting from index `start` to current subset,
     * recursively generates further subsets, and then backtracks.
     *
     * @param nums Input array
     * @param start Current index in nums to consider
     * @param curr Currently formed subset
     * @param res Result list containing all subsets
     */
    private void generateAllSets(int[] nums, int start, List<Integer> curr, List<List<Integer>> res) {
        // Add the current subset to result at every recursion step
        res.add(new ArrayList<>(curr));

        for (int i = start; i < nums.length; i++) {
            // Choose the element nums[i]
            curr.add(nums[i]);
            // Explore further with next index i+1
            generateAllSets(nums, i + 1, curr, res);
            // Undo the choice (backtrack) to explore subsets without nums[i]
            curr.remove(curr.size() - 1);
        }
    }

    public static void main(String[] args) {
        Subsets subsetsSolver = new Subsets();

        // Example 1
        int[] nums1 = {1, 2, 3};
        List<List<Integer>> result1 = subsetsSolver.subsets(nums1);
        System.out.println("Subsets of [1, 2, 3]:");
        System.out.println(result1);

        // Example 2
        int[] nums2 = {0};
        List<List<Integer>> result2 = subsetsSolver.subsets(nums2);
        System.out.println("Subsets of [0]:");
        System.out.println(result2);
    }
}


