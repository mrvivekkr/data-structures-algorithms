import java.util.Arrays;

public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Ensure nums1 is the smaller array (for efficient binary search).
        // If nums1 is larger, swap nums1 and nums2.
        if (nums1.length > nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }

        // Edge case: if nums1 is empty, median is directly from nums2
        if (nums1.length == 0) {
            if (nums2.length % 2 == 0)
                return (nums2[(nums2.length / 2) - 1] + nums2[nums2.length / 2]) / 2.0;
            else
                return nums2[nums2.length / 2];
        }

        int n1 = nums1.length;
        int n2 = nums2.length;
        int totalCount = n1 + n2;

        int low = 0, high = n1;

        // Binary search on smaller array nums1
        while (low <= high) {
            int mid1 = (low + high) / 2;                  // Partition index for nums1
            int mid2 = (totalCount + 1) / 2 - mid1;       // Partition index for nums2

            // Left and right values around the partition for nums1
            int leftA = mid1 == 0 ? Integer.MIN_VALUE : nums1[mid1 - 1];
            int rightA = mid1 == n1 ? Integer.MAX_VALUE : nums1[mid1];

            // Left and right values around the partition for nums2
            int leftB = mid2 == 0 ? Integer.MIN_VALUE : nums2[mid2 - 1];
            int rightB = mid2 == n2 ? Integer.MAX_VALUE : nums2[mid2];

            // Check if partitions are valid (all left elements <= all right elements)
            if (leftA <= rightB && leftB <= rightA) {
                // If total length is even, median is avg of two middle elements
                if (totalCount % 2 == 0)
                    return (Math.max(leftA, leftB) + Math.min(rightA, rightB)) / 2.0;
                else // If odd, median is the max of left partition
                    return Math.max(leftA, leftB);
            }

            // If partition is invalid, adjust binary search range
            if (leftA > rightB) {
                high = mid1 - 1;  // Move search range left
            } else {
                low = mid1 + 1;   // Move search range right
            }
        }

        return 0; // This line should theoretically never be reached
    }

    public static void main(String[] args) {
        MedianOfTwoSortedArrays solution = new MedianOfTwoSortedArrays();

        int[] nums1 = {-10, -9, -8};
        int[] nums2 = {1, 2};
        System.out.println(solution.findMedianSortedArrays(nums1, nums2)); // Expected: -8

        nums1 = new int[]{1, 3};
        nums2 = new int[]{2};
        System.out.println(solution.findMedianSortedArrays(nums1, nums2)); // Expected: 2.0

        nums1 = new int[]{1, 2};
        nums2 = new int[]{3, 4};
        System.out.println(solution.findMedianSortedArrays(nums1, nums2)); // Expected: 2.5
    }
}
