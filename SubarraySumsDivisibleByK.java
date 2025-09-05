import java.util.HashMap;
import java.util.Map;

/**
 * Problem: Subarray Sums Divisible by K
 * Given an integer array nums and an integer k, return the number of non-empty subarrays
 * that have a sum divisible by k.
 *
 * Approach:
 * - Use prefix sum + hashmap to track remainders of prefix sums modulo k.
 * - If two prefix sums have the same remainder, their difference is divisible by k,
 *   meaning the subarray between them has a sum divisible by k.
 */
public class SubarraySumsDivisibleByK {

    public int subarraysDivByK(int[] nums, int k) {
        int count = 0; // Total count of valid subarrays
        int n = nums.length;

        // Map to store frequency of remainders
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        // Initialize with remainder 0 having frequency 1
        // This handles cases where the subarray itself is divisible by k
        frequencyMap.put(0, 1);

        int sum = 0; // Running prefix sum

        for (int i = 0; i < n; i++) {
            sum += nums[i];

            // Compute remainder in range [0, k-1]
            int remainder = ((sum % k) + k) % k;

            // If remainder was seen before, all those occurrences form valid subarrays
            int freq = frequencyMap.getOrDefault(remainder, 0);
            count += freq;

            // Update frequency of the current remainder
            frequencyMap.put(remainder, freq + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        SubarraySumsDivisibleByK solution = new SubarraySumsDivisibleByK();

        // Example 1
        int[] arr1 = {4, 5, 0, -2, -3, 1};
        int k1 = 5;
        System.out.println(solution.subarraysDivByK(arr1, k1)); // Output: 7

        // Example 2
        int[] arr2 = {5};
        int k2 = 9;
        System.out.println(solution.subarraysDivByK(arr2, k2)); // Output: 0
    }
}
