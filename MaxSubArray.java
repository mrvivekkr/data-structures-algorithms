/**
 * Maximum Subarray Sum (Kadane's Algorithm)
 *
 * Problem:
 * Given an integer array nums, find the contiguous subarray (containing at least one number)
 * which has the largest sum and return its sum.
 *
 * Example: [-2,1,-3,4,-1,2,1,-5,4] → Max sum is 6 from subarray [4,-1,2,1]
 */
public class MaxSubArray {

    /**
     * Implements Kadane's algorithm to find maximum subarray sum.
     * @param nums the input integer array
     * @return maximum subarray sum
     */
    public int maxSubArray(int[] nums) {
        int maxSoFar = Integer.MIN_VALUE; // Stores the max sum encountered
        int runningSum = 0;               // Current subarray sum

        for (int num : nums) {
            runningSum += num;

            // If current number alone is better than the running sum, reset
            if (num > runningSum) {
                runningSum = num;
            }

            // Update max if needed
            if (runningSum > maxSoFar) {
                maxSoFar = runningSum;
            }
        }

        return maxSoFar;
    }

    public static void main(String[] args) {
        MaxSubArray solution = new MaxSubArray();

        int[] nums1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(solution.maxSubArray(nums1)); // Output: 6

        int[] nums2 = {1};
        System.out.println(solution.maxSubArray(nums2)); // Output: 1

        int[] nums3 = {5, 4, -1, 7, 8};
        System.out.println(solution.maxSubArray(nums3)); // Output: 23
    }
}
