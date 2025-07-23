import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {

    /**
     * Returns the total number of continuous subarrays whose sum equals k.
     *
     * @param nums the input array of integers
     * @param k    the target sum
     * @return the count of subarrays with sum equal to k
     */
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int runningSum = 0;

        // Map to store prefix sums and their frequencies
        Map<Integer, Integer> prefixSum = new HashMap<>();
        prefixSum.put(0, 1); // Base case: sum 0 occurs once

        for (int num : nums) {
            runningSum += num; // Compute current prefix sum

            // If (runningSum - k) exists in map, it means there's a subarray summing to k
            count += prefixSum.getOrDefault(runningSum - k, 0);

            // Update prefix sum frequency in the map
            prefixSum.put(runningSum, prefixSum.getOrDefault(runningSum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        SubarraySumEqualsK solution = new SubarraySumEqualsK();

        int[] nums = {1, 1, 1};
        int k = 2;
        System.out.println(solution.subarraySum(nums, k)); // Output: 2

        nums = new int[]{1, 2, 3};
        k = 3;
        System.out.println(solution.subarraySum(nums, k)); // Output: 2

        nums = new int[]{-1, -1, 1};
        k = 0;
        System.out.println(solution.subarraySum(nums, k)); // Output: 1

        nums = new int[]{1};
        k = 0;
        System.out.println(solution.subarraySum(nums, k)); // Output: 0
    }
}
