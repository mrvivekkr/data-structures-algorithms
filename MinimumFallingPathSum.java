public class MinimumFallingPathSum {

    /**
     * Finds the minimum sum of any falling path in the matrix.
     * A falling path starts at any element in first row and moves to next row
     * either directly below or diagonally left/right.
     *
     * Time: O(n²), Space: O(1) - in-place modification
     */
    public int minFallingPathSum(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        // DP: Fill each row using previous row's min path sums
        for (int r = 1; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                // Get min from 3 possible previous positions
                int leftUp = isSafe(r - 1, c - 1, rows, cols) ? matrix[r - 1][c - 1] : Integer.MAX_VALUE;
                int dirUp = isSafe(r - 1, c, rows, cols) ? matrix[r - 1][c] : Integer.MAX_VALUE;
                int rigUp = isSafe(r - 1, c + 1, rows, cols) ? matrix[r - 1][c + 1] : Integer.MAX_VALUE;

                // Update current cell: min(previous) + current weight
                matrix[r][c] = matrix[r][c] + Math.min(leftUp, Math.min(dirUp, rigUp));
            }
        }

        // Answer is minimum value in final row
        int minSum = Integer.MAX_VALUE;
        for (int i = 0; i < cols; i++) {
            minSum = Math.min(minSum, matrix[rows - 1][i]);
        }
        return minSum;
    }

    /**
     * Utility: Prints matrix for debugging/visualization
     */
    private void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * Boundary check for matrix indices
     * @param x row index
     * @param y col index
     * @return true if position is valid
     */
    private boolean isSafe(int x, int y, int rows, int cols) {
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }

    public static void main(String[] args) {
        MinimumFallingPathSum solution = new MinimumFallingPathSum();
        int[][] matrix = {{2, 1, 3}, {6, 5, 4}, {7, 8, 9}};

        // Test: Expected output = 13 (path: 1→5→7)
        System.out.println("Minimum Falling Path Sum: " + solution.minFallingPathSum(matrix));
    }
}
