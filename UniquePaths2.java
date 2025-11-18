import java.util.Arrays;

public class UniquePaths2 {

    /**
     * Main method to calculate number of unique paths considering obstacles.
     * Uses dynamic programming solution by default.
     *
     * @param obstacleGrid 2D grid representing obstacles (1) and free spaces (0).
     * @return number of unique paths from top-left to bottom-right corner.
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // Call the DP-based path calculation method
        return totalPathsDp(obstacleGrid);
    }

    /**
     * Recursive method with memoization to count paths from (x,y) to bottom-right.
     * Top-down approach with pruning if out of bounds or obstacle encountered.
     *
     * @param obstacleGrid grid with obstacles
     * @param x current row index
     * @param y current column index
     * @param memo memoization table to cache computed path counts (-1 means uncomputed)
     * @return number of paths from (x, y) to bottom-right corner
     */
    public int totalPaths(int[][] obstacleGrid, int x, int y, int[][] memo) {
        // Base cases: out of bounds or obstacle cell
        if (x >= obstacleGrid.length || y >= obstacleGrid[0].length || obstacleGrid[x][y] == 1)
            return 0;
        // Return memoized result if already computed
        if (memo[x][y] != -1)
            return memo[x][y];
        // Reached bottom-right corner
        if (x == obstacleGrid.length - 1 && y == obstacleGrid[0].length - 1)
            return 1;

        // Recursive calls for down and right moves
        memo[x][y] = totalPaths(obstacleGrid, x + 1, y, memo) + totalPaths(obstacleGrid, x, y + 1, memo);
        return memo[x][y];
    }

    /**
     * Bottom-up dynamic programming approach to count unique paths.
     * Uses an (m+1) x (n+1) dp array with padding to simplify boundary conditions.
     * dp[i][j] stores number of unique paths to cell (i-1, j-1) in obstacleGrid.
     *
     * @param obstacleGrid grid with obstacles (1) and free spaces (0)
     * @return total number of unique paths from start to end considering obstacles
     */
    public int totalPathsDp(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] dp = new int[m + 1][n + 1];

        // Initialize start position to 1 if it is not an obstacle
        dp[1][1] = (obstacleGrid[0][0] == 0) ? 1 : 0;

        // Build up dp table from top-left to bottom-right
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == 1 && j == 1) continue; // Skip start cell, already set

                if (obstacleGrid[i - 1][j - 1] == 1)
                    dp[i][j] = 0; // No path through obstacles
                else
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1]; // Sum of paths from top and left cells
            }
        }

        // Return total paths to bottom-right corner cell
        return dp[m][n];
    }

    public static void main(String[] args){
        // Sample obstacle grid: 0 is free, 1 is obstacle
        int[][] obstacleGrid = {{0,0,0},{0,1,0},{0,0,0}};

        UniquePaths2 solution = new UniquePaths2();
        int result = solution.uniquePathsWithObstacles(obstacleGrid);

        // Print number of unique paths from top-left to bottom-right considering obstacles
        System.out.println(result); // Expected output: 2
    }
}
