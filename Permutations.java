import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Permutations {

    /**
     * Generates all permutations of the input array nums
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> outputList = new ArrayList<>();
        generatePermutation(nums, 0, outputList);
        return outputList;
    }

    /**
     * Backtracking function to generate permutations
     * @param nums input array
     * @param index current index to fix
     * @param outputList list to collect permutations
     */
    public void generatePermutation(int[] nums, int index, List<List<Integer>> outputList) {
        // Base case: if index reaches end of array, collect the current permutation
        if (index == nums.length) {
            outputList.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
        }

        // Try placing each element at the current index
        for (int i = index; i < nums.length; i++) {
            swap(nums, i, index);  // Fix element at current index
            generatePermutation(nums, index + 1, outputList);  // Recurse for next index
            swap(nums, i, index);  // Backtrack
        }
    }

    /**
     * Helper function to swap two elements in the array
     */
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        Permutations solution = new Permutations();
        int[] nums = {1, 2, 3};
        List<List<Integer>> permutations = solution.permute(nums);
        System.out.println(permutations.toString());
    }
}
