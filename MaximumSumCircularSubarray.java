public class MaximumSumCircularSubarray {

    public int maxSubarraySumCircular(int[] nums) {
        int maxSum = Integer.MIN_VALUE; // To track maximum subarray sum (non-circular)
        int minSum = Integer.MAX_VALUE; // To track minimum subarray sum
        int totalSum = 0;               // Total sum of the array
        int currMax = 0;                // Current max for Kadane’s algo
        int currMin = 0;                // Current min for inverted Kadane’s algo

        for (int num : nums) {
            // Kadane's algorithm to find max subarray sum
            currMax = Math.max(currMax + num, num);
            maxSum = Math.max(maxSum, currMax);

            // Kadane's variation to find min subarray sum
            currMin = Math.min(currMin + num, num);
            minSum = Math.min(minSum, currMin);

            totalSum += num;
        }

        // If all numbers are negative, totalSum == minSum
        if (totalSum == minSum)
            return maxSum;

        // Return the max of standard subarray or circular subarray
        return Math.max(maxSum, totalSum - minSum);
    }

    public static void main(String[] args) {
        MaximumSumCircularSubarray solution = new MaximumSumCircularSubarray();
        int[] nums = {1, -2, 3, -2};
        System.out.println(solution.maxSubarraySumCircular(nums)); // 3

        nums = new int[]{5, -3, 5};
        System.out.println(solution.maxSubarraySumCircular(nums)); // 10

        nums = new int[]{-3, -2, -3};
        System.out.println(solution.maxSubarraySumCircular(nums)); // -2

        nums = new int[]{9, -4, -7, 9};
        System.out.println(solution.maxSubarraySumCircular(nums)); // 18
    }
}
