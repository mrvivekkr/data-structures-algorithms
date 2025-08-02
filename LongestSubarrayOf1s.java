import java.util.ArrayList;
import java.util.List;

public class LongestSubarrayOf1s {
    // Function to find the longest subarray of 1s after deleting one element
    public int longestSubarray(int[] nums) {
        List<Integer> positions = new ArrayList<>();

        // Collect all indices where 0 occurs
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                positions.add(i);
        }

        // Edge case: only one or no zero — remove one element and return length - 1
        if (positions.size() == 1 || positions.isEmpty())
            return nums.length - 1;

        int maxLen = 0;

        // Loop through each zero's position and calculate max length if that 0 is deleted
        for (int i = 0; i < positions.size(); i++) {
            if (i == 0) {
                // For the first 0, take distance to next 0 (excluding deleted 0)
                maxLen = Math.max(maxLen, positions.get(i + 1) - 1);
            } else if (i == positions.size() - 1) {
                // For the last 0, take distance from previous 0 to end
                maxLen = Math.max(maxLen, nums.length - positions.get(i - 1) - 2);
            } else {
                // For in-between zeros, distance between surrounding 0s minus 1
                maxLen = Math.max(maxLen, positions.get(i + 1) - positions.get(i - 1) - 2);
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        LongestSubarrayOf1s solution = new LongestSubarrayOf1s();

        int[] nums = {1, 1, 0, 1};
        System.out.println(solution.longestSubarray(nums)); // 3

        nums = new int[]{0, 1, 1, 1, 0, 1, 1, 0, 1};
        System.out.println(solution.longestSubarray(nums)); // 5

        nums = new int[]{1, 1, 1};
        System.out.println(solution.longestSubarray(nums)); // 2

        nums = new int[]{1, 1, 0, 0, 1, 1, 1, 0, 1};
        System.out.println(solution.longestSubarray(nums)); // 4
    }
}
