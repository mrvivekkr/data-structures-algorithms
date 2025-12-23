import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 2958: Length of Longest Subarray With at Most K Frequency
 * Solved using Sliding Window technique with frequency tracking.
 *
 * Problem: Find the longest contiguous subarray where no element appears more than k times.
 *
 * Approach:
 * - Use two pointers (start, end) to maintain sliding window [start, end]
 * - Expand window by moving end pointer, tracking frequency with HashMap
 * - When any element's frequency > k, shrink from left by moving start pointer
 * - Track maximum valid window length: end - start + 1
 *
 * Time: O(n) - Each element added/removed at most once
 * Space: O(n) - HashMap stores unique elements in worst case
 */
public class LongestSubArrayWithAtMostKFrequency {

    /**
     * Returns length of longest subarray where each element frequency <= k
     *
     * @param nums input array of integers
     * @param k maximum allowed frequency for any element
     * @return length of longest valid subarray
     */
    public int maxSubarrayLength(int[] nums, int k) {
        int maxLen = 0;                    // Track maximum valid window length
        Map<Integer, Integer> freq = new HashMap<>();  // Frequency map: num -> count
        int start = 0;                     // Left pointer of sliding window
        int end = 0;                       // Right pointer of sliding window

        // Expand window until end reaches array boundary
        while (end < nums.length) {
            int num = nums[end];           // Current element being added

            // Expand: Add current element to window
            freq.put(num, freq.getOrDefault(num, 0) + 1);

            // Shrink: Contract from left while current element violates constraint
            while (freq.get(num) > k) {
                int curr = nums[start];    // Element to remove from left
                freq.put(curr, freq.getOrDefault(curr, 0) - 1);
                start++;                   // Move left pointer right
            }

            // Update maximum length of valid window
            maxLen = Math.max(maxLen, end - start + 1);
            end++;                         // Always expand right pointer
        }
        return maxLen;
    }

    /**
     * Test cases demonstrating solution correctness
     */
    public static void main(String[] args) {
        LongestSubArrayWithAtMostKFrequency solution = new LongestSubArrayWithAtMostKFrequency();

        // Test 1: [1,2,3,1,2,3,1,2], k=2 → Expected: 6 ([1,2,3,1,2,3])
        int[] nums1 = {1, 2, 3, 1, 2, 3, 1, 2};
        int k1 = 2;
        System.out.println(solution.maxSubarrayLength(nums1, k1));  // Output: 6

        // Test 2: [1,2,1,2,1,2,1,2], k=1 → Expected: 1 (no element can repeat)
        nums1 = new int[]{1, 2, 1, 2, 1, 2, 1, 2};
        int k2 = 1;
        System.out.println(solution.maxSubarrayLength(nums1, k2));  // Output: 1

        // Test 3: [5,5,5,5,5,5,5], k=4 → Expected: 4 (max 4 consecutive 5s)
        int[] nums2 = new int[]{5, 5, 5, 5, 5, 5, 5};
        int k3 = 4;
        System.out.println(solution.maxSubarrayLength(nums2, k3));  // Output: 4
    }
}
