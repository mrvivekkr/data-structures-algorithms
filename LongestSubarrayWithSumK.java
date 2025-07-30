import java.util.HashMap;
import java.util.Map;

public class LongestSubarrayWithSumK {
    public int longestSubarray(int[] arr, int k) {
        int maxLen = 0;
        int prefixSum = 0;
        Map<Integer, Integer> sumToIndexMap = new HashMap<>();
        sumToIndexMap.put(0, -1); // To handle prefixSum == k

        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];

            // Store the first occurrence of this prefix sum
            final int index = i;
            sumToIndexMap.computeIfAbsent(prefixSum, key -> index);

            // Check if there exists a prefix sum that satisfies the condition
            if (sumToIndexMap.containsKey(prefixSum - k)) {
                maxLen = Math.max(maxLen, index - sumToIndexMap.get(prefixSum - k));
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        LongestSubarrayWithSumK solution = new LongestSubarrayWithSumK();

        int[] arr = {10, 5, 2, 7, 1, -10};
        int k = 15;
        System.out.println(solution.longestSubarray(arr, k)); // 6

        arr = new int[]{-5, 8, -14, 2, 4, 12};
        k = -5;
        System.out.println(solution.longestSubarray(arr, k)); // 5

        arr = new int[]{10, -10, 20, 30};
        k = 5;
        System.out.println(solution.longestSubarray(arr, k)); // 0
    }
}
