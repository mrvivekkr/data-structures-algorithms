/**
 * Solution class for the N-Queens II problem on LeetCode.
 * Counts the total number of distinct solutions to place n queens on an n x n chessboard.
 */
class NQueens2 {

    /**
     * Main method to initiate the search for valid queen placements
     *
     * @param n size of the chess board (n x n)
     * @return total number of distinct valid solutions
     */
    public int totalNQueens(int n) {
        int[][] board = new int[n][n]; // chessboard representation, 1 means queen placed
        int total = 0;
        // Try placing a queen in each column of the first row
        for (int i = 0; i < n; i++)
            total += dfs(board, 0, i);
        return total;
    }

    /**
     * Recursive DFS method to explore queen placements row by row
     *
     * @param board current chessboard state
     * @param x current row to place queen
     * @param y current column to place queen
     * @return number of valid solutions found from placing queens in remaining rows
     */
    public int dfs(int[][] board, int x, int y) {
        // If reached last row, current placement forms a valid solution
        if (x == board.length - 1)
            return 1;

        board[x][y] = 1; // place queen on (x, y)
        int count = 0;

        // Attempt to place queen in next row, in each column
        for (int i = 0; i < board[0].length; i++) {
            if (isSafe(x + 1, i, board)) // check safety of placement
                count += dfs(board, x + 1, i);
        }

        board[x][y] = 0; // backtrack: remove queen from (x, y)
        return count;
    }

    /**
     * Checks if placing a queen at position (x, y) is safe from attacks
     *
     * @param x row index
     * @param y column index
     * @param board current chessboard state
     * @return true if safe, false otherwise
     */
    public boolean isSafe(int x, int y, int[][] board) {
        int n = board.length;

        // Check the row excluding current position
        for (int i = 0; i < n; i++) {
            if (i != y && board[x][i] == 1) {
                return false;
            }
        }

        // Check the column excluding current position
        for (int i = 0; i < n; i++) {
            if (i != x && board[i][y] == 1) {
                return false;
            }
        }

        // Check the two diagonals excluding current position
        for (int i = -n; i <= n; i++) {
            int nx1 = x + i, ny1 = y + i;
            if (nx1 >= 0 && ny1 >= 0 && nx1 < n && ny1 < n && !(nx1 == x && ny1 == y) && board[nx1][ny1] == 1) {
                return false;
            }
            int nx2 = x + i, ny2 = y - i;
            if (nx2 >= 0 && ny2 >= 0 && nx2 < n && ny2 < n && !(nx2 == x && ny2 == y) && board[nx2][ny2] == 1) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args){
        NQueens2 solution = new NQueens2();
        int n =4;
        System.out.println(solution.totalNQueens(n));
    }
}
