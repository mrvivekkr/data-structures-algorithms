import java.util.Arrays;

/**
 * 2771. Longest Non-decreasing Subarray From Two Arrays
 *
 * Given two 0-indexed integer arrays nums1 and nums2 of length n,
 * construct nums3 where nums3[i] is either nums1[i] or nums2[i].
 * Maximize the length of the longest non-decreasing subarray in nums3.
 *
 * Time: O(n) | Space: O(n)
 */
public class LongestNonDecreasingSubArraysFromTwoArrays {
    public int maxNonDecreasingLength(int[] nums1, int[] nums2) {
        int maxLen = 1;  // Global maximum length found
        int n = nums1.length;

        // dp1[i]: max non-decreasing subarray length ending at i using nums1[i]
        // dp2[i]: max non-decreasing subarray length ending at i using nums2[i]
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];

        // Base case: single element subarrays have length 1
        Arrays.fill(dp1, 1);
        Arrays.fill(dp2, 1);

        // Fill DP table for i >= 1
        for(int i = 1; i < n; i++){
            // For dp1[i] - choosing nums1[i] at position i
            // 4 possible transitions from position i-1:
            if(nums1[i] >= nums1[i-1]){
                // Continue from nums1[i-1]
                dp1[i] = Math.max(dp1[i], 1 + dp1[i-1]);
            }
            if(nums1[i] >= nums2[i-1]){
                // Switch from nums2[i-1] to nums1[i]
                dp1[i] = Math.max(dp1[i], 1 + dp2[i-1]);
            }

            // For dp2[i] - choosing nums2[i] at position i
            if(nums2[i] >= nums1[i-1]){
                // Switch from nums1[i-1] to nums2[i]
                dp2[i] = Math.max(dp2[i], 1 + dp1[i-1]);
            }
            if(nums2[i] >= nums2[i-1]){
                // Continue from nums2[i-1]
                dp2[i] = Math.max(dp2[i], 1 + dp2[i-1]);
            }

            // Update global maximum
            maxLen = Math.max(maxLen, Math.max(dp1[i], dp2[i]));
        }

        // Check position 0 (handles n=1 case)
        return Math.max(maxLen, 1);
    }

    public static void main(String[] args){
        LongestNonDecreasingSubArraysFromTwoArrays solution = new LongestNonDecreasingSubArraysFromTwoArrays();
        int[] nums1 = {2,3,1};
        int[] nums2 = {1,2,1};

        System.out.println(solution.maxNonDecreasingLength(nums1,nums2));

        nums1 = new int[]{1,3,2,1};
        nums2 = new int[]{2,2,3,4};
        System.out.println(solution.maxNonDecreasingLength(nums1,nums2));

        nums1 = new int[]{5,16,15};
        nums2 = new int[]{12,1,14};
        System.out.println(solution.maxNonDecreasingLength(nums1,nums2));
    }

}
