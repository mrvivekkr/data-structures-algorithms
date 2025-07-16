import java.util.ArrayList;
import java.util.List;

public class NQueens {

    /**
     * Main method to solve N-Queens problem.
     * Returns a list of all valid board configurations.
     */
    public List<List<String>> solveNQueens(int n) {
        int[][] board = new int[n][n]; // 2D board to track queen placements
        List<List<String>> output = new ArrayList<>();
        placeQueens(board, n, 0, output); // Start placing queens from row 0
        return output;
    }

    /**
     * Recursive function to place queens row by row.
     * Uses backtracking to explore all valid configurations.
     */
    public void placeQueens(int[][] board, int n, int row, List<List<String>> output) {
        if (row == n) {
            // All queens placed successfully
            addToOutput(board, n, output);
        }

        // Try placing queen in every column of current row
        for (int j = 0; j < n; j++) {
            if (isSafe(row, j, board, n)) {
                board[row][j] = 1; // Place queen
                placeQueens(board, n, row + 1, output); // Recurse for next row
                board[row][j] = 0; // Backtrack
            }
        }
    }

    /**
     * Converts the board to a list of strings and adds it to the result.
     */
    private void addToOutput(int[][] board, int n, List<List<String>> output) {
        List<String> outputString = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringBuilder rowVal = new StringBuilder();
            for (int j = 0; j < n; j++) {
                rowVal.append(board[i][j] == 1 ? "Q" : ".");
            }
            outputString.add(rowVal.toString());
        }
        output.add(outputString);
    }

    /**
     * Checks if it's safe to place a queen at (i, j).
     * Verifies column, row, and both diagonals.
     */
    private boolean isSafe(int i, int j, int[][] board, int n) {
        // Check for any queen in the same column above
        for (int row = i - 1; row >= 0; row--) {
            if (board[row][j] == 1)
                return false;
        }

        // Check for any queen in the same row (optional in N-Queens)
        for (int col = 0; col < n; col++) {
            if (board[i][col] == 1)
                return false;
        }

        // Check upper-left diagonal
        for (int row = i - 1, col = j - 1; row >= 0 && col >= 0; row--, col--) {
            if (board[row][col] == 1)
                return false;
        }

        // Check upper-right diagonal
        for (int row = i - 1, col = j + 1; row >= 0 && col < n; row--, col++) {
            if (board[row][col] == 1)
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        NQueens solution = new NQueens();
        List<List<String>> out = solution.solveNQueens(4);
        System.out.println(out);

        out = solution.solveNQueens(1);
        System.out.println(out);
    }
}
