import java.util.Arrays;

public class LongestIncreasingSubsequence {

    /**
     * This method returns the length of the longest strictly increasing subsequence.
     * It uses dynamic programming to build up the solution.
     */
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;

        // lis[i] will store the length of the longest increasing subsequence ending at index i
        int[] lis = new int[len];

        // Initialize all LIS values to 1 (each element is an LIS of length 1 by itself)
        Arrays.fill(lis, 1);

        int max = 1; // Store the max LIS found

        // Build the lis array
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                // Check if nums[i] can be appended to the increasing subsequence ending at nums[j]
                if (nums[i] > nums[j]) {
                    lis[i] = Math.max(lis[i], 1 + lis[j]);
                    max = Math.max(max, lis[i]); // Update the overall max
                }
            }
        }

        return max;
    }

    public static void main(String[] args) {
        LongestIncreasingSubsequence solution = new LongestIncreasingSubsequence();

        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(solution.lengthOfLIS(nums)); // Output: 4

        nums = new int[]{0, 1, 0, 3, 2, 3};
        System.out.println(solution.lengthOfLIS(nums)); // Output: 4

        nums = new int[]{7, 7, 7, 7, 7, 7, 7};
        System.out.println(solution.lengthOfLIS(nums)); // Output: 1
    }
}
