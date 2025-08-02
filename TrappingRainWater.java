public class TrappingRainWater {

    // Main function to calculate total trapped rainwater
    public int trap(int[] height) {
        int n = height.length;
        // Arrays to store max height to the left and right of each bar
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        // Fill leftMax: maximum height seen so far from the left
        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(height[i], leftMax[i - 1]);
        }

        // Fill rightMax: maximum height seen so far from the right
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        // Calculate trapped water at each index
        int trappedWater = 0;
        for (int i = 0; i < n; i++) {
            trappedWater += Math.min(leftMax[i], rightMax[i]) - height[i];
        }

        return trappedWater;
    }

    public static void main(String[] args) {
        TrappingRainWater solution = new TrappingRainWater();

        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(solution.trap(height)); // Output: 6

        height = new int[]{4, 2, 0, 3, 2, 5};
        System.out.println(solution.trap(height)); // Output: 9
    }
}
