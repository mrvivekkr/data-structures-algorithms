package DS;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Sliding Window Maximum
 *
 * Problem:
 * You are given an array of integers nums, and a window size k.
 * You need to return an array of the maximum value in each sliding window of size k.
 *
 * Example:
 * Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
 * Output: [3,3,5,5,6,7]
 */

public class SlidingWindowMaximum {

    /**
     * Finds the maximum for each sliding window of size k.
     * @param nums Input array
     * @param k Size of the sliding window
     * @return Array of maximum values in each window
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n - k + 1];  // Output array
        int start = 0;                      // Pointer for result index
        Deque<Integer> dq = new ArrayDeque<>(); // Will store indexes, not values

        for (int i = 0; i < n; i++) {
            // Remove indices out of the current window from the front
            while (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.pollFirst();
            }

            // Remove smaller elements from the back since they're not useful
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                dq.pollLast();
            }

            // Add current index to the deque
            dq.addLast(i);

            // If window has reached size k, record the maximum (front of deque)
            if (i >= k - 1) {
                result[start++] = nums[dq.peekFirst()];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        SlidingWindowMaximum solution = new SlidingWindowMaximum();
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] output = solution.maxSlidingWindow(nums, k);

        System.out.print("Sliding Window Maximum: ");
        for (int val : output) {
            System.out.print(val + " ");
        }
    }
}
