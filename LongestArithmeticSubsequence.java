import java.util.HashMap;
import java.util.Map;

public class LongestArithmeticSubsequence {

    /**
     * Finds the length of the longest arithmetic subsequence in the given array.
     *
     * @param nums the input array of integers
     * @return the length of the longest arithmetic subsequence
     */
    public int longestArithSeqLength(int[] nums) {
        int n = nums.length;
        if (n <= 2)
            return n; // If array length is 2 or less, longest arithmetic subsequence
        // is the whole array itself

        int max = 0; // To track the maximum length found

        // Array of HashMaps to store difference -> length of arithmetic subsequence
        // ending at index i with that difference
        Map<Integer, Integer>[] dp = new HashMap[n];
        for (int i = 0; i < n; i++) {
            dp[i] = new HashMap<>();
        }

        // Iterate over all pairs (j, i) with j < i
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int diff = nums[i] - nums[j]; // Calculate the difference between elements

                // Get the length of subsequence ending at j with this difference,
                // default is 1 because nums[j] alone counts as a single element subsequence
                int prev = dp[j].getOrDefault(diff, 1);

                // Update dp for index i with the new length (extend by 1)
                dp[i].put(diff, prev + 1);

                // Update global maximum length if this subsequence is longer
                max = Math.max(max, dp[i].get(diff));
            }
        }
        return max;
    }

    public static void main(String[] args) {
        LongestArithmeticSubsequence solution = new LongestArithmeticSubsequence();

        int[] nums = {3, 6, 9, 12};
        System.out.println(solution.longestArithSeqLength(nums)); // Output: 4

        nums = new int[]{9, 4, 7, 2, 10};
        System.out.println(solution.longestArithSeqLength(nums)); // Output: 3

        nums = new int[]{20, 1, 15, 3, 10, 5, 8};
        System.out.println(solution.longestArithSeqLength(nums)); // Output: 4
    }
}
