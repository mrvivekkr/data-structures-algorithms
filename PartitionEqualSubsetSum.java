import java.util.Arrays;

public class PartitionEqualSubsetSum {

    public boolean canPartition(int[] nums) {
        // Step 1: Calculate total sum of array
        int totalSum = Arrays.stream(nums).sum();

        // If sum is odd, it cannot be partitioned into two equal subsets
        if (totalSum % 2 != 0)
            return false;

        // Option 1: Recursive approach (commented for reference)
        // return findSumRec(nums, 0, totalSum / 2);

        // Option 2: DP approach (optimized)
        return findSumDp(nums, totalSum / 2);
    }

    /**
     * Recursive approach (Exponential time complexity, not efficient for large inputs)
     */
    private boolean findSumRec(int[] nums, int index, int target) {
        // Base case: if target becomes 0, subset found
        if (target == 0)
            return true;

        // If index goes out of bounds, no solution
        if (index >= nums.length)
            return false;

        // Either include the current number or skip it
        return findSumRec(nums, index + 1, target) ||
                findSumRec(nums, index + 1, target - nums[index]);
    }

    /**
     * Dynamic Programming approach (Efficient)
     * dp[i][j] → whether we can achieve sum `j` using first `i` elements
     */
    private boolean findSumDp(int[] nums, int target) {
        boolean[][] dp = new boolean[nums.length + 1][target + 1];

        // Base case: sum 0 can always be achieved (empty subset)
        dp[0][0] = true;

        // Fill DP table
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 0; j <= target; j++) {
                if (j - nums[i - 1] >= 0) {
                    // Option 1: Exclude nums[i-1], Option 2: Include nums[i-1]
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                } else {
                    // Cannot include nums[i-1], carry forward previous result
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[nums.length][target];
    }

    public static void main(String[] args) {
        PartitionEqualSubsetSum solution = new PartitionEqualSubsetSum();

        int[] nums1 = {1, 5, 11, 5};
        System.out.println(solution.canPartition(nums1)); // true

        int[] nums2 = {1, 2, 3, 5};
        System.out.println(solution.canPartition(nums2)); // false
    }
}
