public class NumberOfIslands {

    public int numIslands(char[][] grid) {
        int islandCount = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        // Keep track of visited cells to avoid re-processing
        boolean[][] visited = new boolean[rows][cols];

        // Traverse the entire grid
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                // If we find an unvisited land cell ('1'), it's a new island
                if(grid[i][j] == '1' && !visited[i][j]) {
                    islandCount++;
                    // Explore the whole island using DFS
                    traverse(grid, visited, i, j);
                }
            }
        }
        return islandCount;
    }

    // DFS to mark all connected land cells of the current island
    private void traverse(char[][] grid, boolean[][] visited, int i, int j) {
        // Boundary check
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length)
            return;

        // Process only land cells that are not yet visited
        if(grid[i][j] == '1' && !visited[i][j]) {
            visited[i][j] = true; // mark current cell as visited

            // Recursively explore neighbors (up, down, left, right)
            traverse(grid, visited, i + 1, j); // down
            traverse(grid, visited, i - 1, j); // up
            traverse(grid, visited, i, j + 1); // right
            traverse(grid, visited, i, j - 1); // left
        }
    }

    public static void main(String[] args){
        NumberOfIslands solution = new NumberOfIslands();

        // Example 1
        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        System.out.println(solution.numIslands(grid)); // Output: 1

        // Example 2
        grid = new char[][]{
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        System.out.println(solution.numIslands(grid)); // Output: 3
    }
}
