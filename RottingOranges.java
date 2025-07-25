import java.util.LinkedList;
import java.util.Queue;

// Main class to solve the Rotting Oranges problem using BFS
public class RottingOranges {
    public int orangesRotting(int[][] grid) {
        Queue<Position> q = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;

        // Add all initially rotten oranges to the queue
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new Position(i, j));
                }
            }
        }

        int level = 0;  // Represents minutes passed
        int[] x = {-1, 1, 0, 0};  // Direction vectors for row
        int[] y = {0, 0, 1, -1};  // Direction vectors for column

        // Perform BFS level by level
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Position p = q.poll();
                // Try all 4 directions
                for (int k = 0; k < 4; k++) {
                    int newX = p.x + x[k];
                    int newY = p.y + y[k];
                    // If adjacent cell is fresh and valid, rot it and add to queue
                    if (isSafe(newX, newY, m, n) && grid[newX][newY] == 1) {
                        q.offer(new Position(newX, newY));
                        grid[newX][newY] = 2;
                    }
                }
            }
            level++;
        }

        // Check if any fresh orange remains
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1)
                    return -1;
            }
        }

        // Subtract 1 because we increment level even on last empty round
        return Math.max(0, level - 1);
    }

    // Helper method to ensure the coordinates are within the grid
    private boolean isSafe(int x, int y, int m, int n) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }

    // Sample test cases
    public static void main(String[] args) {
        RottingOranges solution = new RottingOranges();
        int[][] grid = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        System.out.println(solution.orangesRotting(grid)); // Output: 4

        grid = new int[][]{{2, 1, 1}, {0, 1, 1}, {1, 0, 1}};
        System.out.println(solution.orangesRotting(grid)); // Output: -1

        grid = new int[][]{{0, 2}};
        System.out.println(solution.orangesRotting(grid)); // Output: 0
    }
}

// Simple class to store 2D grid coordinates
class Position {
    int x, y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
