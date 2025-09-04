// Problem: Container With Most Water
// Approach: Two-pointer technique
// Time Complexity: O(n) | Space Complexity: O(1)

public class ContainerWithMostWater {

    // Function to calculate the maximum area of water that can be stored
    public int maxArea(int[] height) {
        int n = height.length;

        // Initialize two pointers: left at start, right at end
        int l = 0;
        int r = n - 1;

        // Variable to keep track of the maximum area found
        int max = 0;

        // Continue until the two pointers meet
        while (l < r) {
            // Calculate the current area between lines at l and r
            int curr = (r - l) * Math.min(height[r], height[l]);

            // Update maximum area if current is greater
            max = Math.max(curr, max);

            // Move the pointer pointing to the shorter line
            if (height[l] < height[r]) {
                l++; // Move left pointer forward
            } else {
                r--; // Move right pointer backward
            }
        }
        return max;
    }

    // Driver code to test the solution
    public static void main(String[] args) {
        ContainerWithMostWater solution = new ContainerWithMostWater();
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};

        // Expected output: 49
        System.out.println(solution.maxArea(height));
    }
}
