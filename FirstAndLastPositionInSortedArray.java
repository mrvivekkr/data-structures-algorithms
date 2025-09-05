public class FirstAndLastPositionInSortedArray {

    // Main method to return the first and last positions of the target in the array
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        // Find first occurrence using binary search
        result[0] = findFirst(nums, target);
        // Find last occurrence using binary search
        result[1] = findLast(nums, target);
        return result;
    }

    // Helper method to find the first occurrence (left boundary) of the target
    public int findFirst(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int index = -1;  // Default when target not found
        while (left <= right) {
            int mid = (left + right) / 2; // Middle index
            if (nums[mid] == target) {
                index = mid;   // Record index
                right = mid - 1; // Keep searching left side for earlier occurrence
            } else if (nums[mid] > target) {
                right = mid - 1; // Discard right half
            } else {
                left = mid + 1; // Discard left half
            }
        }
        return index;
    }

    // Helper method to find the last occurrence (right boundary) of the target
    public int findLast(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int index = -1;  // Default when target not found
        while (left <= right) {
            int mid = (left + right) / 2; // Middle index
            if (nums[mid] == target) {
                index = mid;   // Record index
                left = mid + 1; // Keep searching right side for later occurrence
            } else if (nums[mid] > target) {
                right = mid - 1; // Discard right half
            } else {
                left = mid + 1; // Discard left half
            }
        }
        return index;
    }

    // Driver code to test functionality
    public static void main(String[] args) {
        FirstAndLastPositionInSortedArray solution = new FirstAndLastPositionInSortedArray();
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
        System.out.println(solution.searchRange(nums, target)[0] + " " + solution.searchRange(nums, target)[1]); // Expected: 3 4

        target = 6;
        System.out.println(solution.searchRange(nums, target)[0] + " " + solution.searchRange(nums, target)[1]); // Expected: -1 -1

        nums = new int[]{1};
        target = 1;
        System.out.println(solution.searchRange(nums, target)[0] + " " + solution.searchRange(nums, target)[1]); // Expected: 0 0
    }
}
