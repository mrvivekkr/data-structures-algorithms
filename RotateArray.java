/**
 * Rotate Array
 *
 * Problem:
 * Given an array, rotate it to the right by k steps.
 * The rotation should be in-place (no extra array used).
 *
 * Example:
 * Input: [1,2,3,4,5,6,7], k = 3 → Output: [5,6,7,1,2,3,4]
 */
public class RotateArray {

    /**
     * Rotates the array to the right by k steps using reversal algorithm.
     * @param nums input array
     * @param k number of steps to rotate
     */
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n; // In case k > n
        reverseArr(nums, 0, n - 1);     // Step 1: Reverse the whole array
        reverseArr(nums, 0, k - 1);     // Step 2: Reverse first k elements
        reverseArr(nums, k, n - 1);     // Step 3: Reverse the rest
    }

    /**
     * Reverses elements in the array between indices start and end.
     */
    private void reverseArr(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    /**
     * Utility to print the array.
     */
    public void printArray(int[] nums) {
        System.out.println();
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    public static void main(String[] args) {
        RotateArray solution = new RotateArray();

        int[] nums1 = {1, 2, 3, 4, 5, 6, 7};
        int k1 = 3;
        solution.rotate(nums1, k1);
        solution.printArray(nums1); // Output: 5 6 7 1 2 3 4

        int[] nums2 = {-1, -100, 3, 99};
        int k2 = 2;
        solution.rotate(nums2, k2);
        solution.printArray(nums2); // Output: 3 99 -1 -100
    }
}
