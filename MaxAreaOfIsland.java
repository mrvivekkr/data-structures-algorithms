public class MaxAreaOfIsland {

    /**
     * Finds the maximum area of an island in a given binary grid.
     * An island is a group of 1's connected 4-directionally.
     * @param grid m x n binary matrix where 1 = land, 0 = water
     * @return maximum island area, 0 if no islands exist
     */
    public int maxAreaOfIsland(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        boolean[][] visited = new boolean[row][col];  // Track visited cells
        int maxNum = 0;

        // Scan entire grid for unvisited land cells
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(!visited[i][j] && grid[i][j] == 1) {
                    int area = dfs(grid, visited, i, j);  // DFS to calculate island area
                    maxNum = Math.max(maxNum, area);
                }
            }
        }
        return maxNum;
    }

    /**
     * DFS traversal to calculate island area starting from (x,y).
     * Marks cell as visited and recursively explores 4-directional neighbors.
     * @param grid input grid
     * @param visited visited matrix
     * @param x current row
     * @param y current column
     * @return total area of connected land cells
     */
    private int dfs(int[][] grid, boolean[][] visited, int x, int y) {
        visited[x][y] = true;  // Mark current cell as visited

        // 4-directional movement: up, down, left, right
        int[] xDir = {-1, 1, 0, 0};
        int[] yDir = {0, 0, -1, 1};

        int area = 1;  // Count current cell

        // Explore all 4 neighbors
        for(int i = 0; i < 4; i++) {
            int newX = x + xDir[i];
            int newY = y + yDir[i];

            // Check if neighbor is valid, unvisited land cell
            if(isValid(newX, newY, grid, visited) && grid[newX][newY] == 1) {
                area += dfs(grid, visited, newX, newY);  // Accumulate subtree areas
            }
        }
        return area;
    }

    /**
     * Checks if coordinates (i,j) are within bounds and unvisited.
     * @param i row index
     * @param j column index
     * @param grid input grid
     * @param visited visited matrix
     * @return true if position is safe to explore
     */
    private boolean isValid(int i, int j, int[][] grid, boolean[][] visited) {
        return i >= 0 && i < grid.length &&
                j >= 0 && j < grid[0].length &&
                !visited[i][j];
    }

    public static void main(String[] args) {
        MaxAreaOfIsland solution = new MaxAreaOfIsland();
        int[][] grid = {
                {0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}
        };
        System.out.println("Max Island Area: " + solution.maxAreaOfIsland(grid));  // Expected: 6
    }
}
