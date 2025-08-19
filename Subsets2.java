import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets2 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // Resultant list of all unique subsets
        List<List<Integer>> output = new ArrayList<>();

        // Sort the array to bring duplicates together
        Arrays.sort(nums);

        // Call helper function to generate subsets
        findAllSubsetsUtil(nums, 0, new ArrayList<>(), output);

        return output;
    }

    public List<List<Integer>> findAllSubsetsUtil(int[] nums, int index, List<Integer> list, List<List<Integer>> output) {
        // Add current subset only if it's not already in the output
        // (prevents duplicate subsets)
        if (!output.contains(list)) {
            output.add(new ArrayList<>(list));
        }

        // Base condition: if we reached the end of nums
        if (index == nums.length) {
            return output;
        }

        // Explore all possibilities by including nums[i]
        for (int i = index; i < nums.length; i++) {
            // Choose element nums[i]
            list.add(nums[i]);

            // Recurse with next index
            findAllSubsetsUtil(nums, i + 1, list, output);

            // Backtrack (remove last added element)
            list.remove(list.size() - 1);
        }

        return output;
    }

    public static void main(String[] args) {
        Subsets2 solution = new Subsets2();
        int[] nums = {4, 4, 4, 1, 4};

        // Print all unique subsets
        System.out.println(solution.subsetsWithDup(nums));
    }
}
