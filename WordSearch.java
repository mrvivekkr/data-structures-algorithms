public class WordSearch {

    /**
     * Main function to check if the word exists in the board.
     * It scans every cell to find the starting character and triggers backtracking search.
     */
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                // If the first character matches, start DFS search
                if (board[i][j] == word.charAt(0)) {
                    boolean[][] visited = new boolean[board.length][board[0].length];
                    if (checkIfExists(board, i, j, word, visited))
                        return true;
                }
            }
        }
        return false;
    }

    /**
     * Recursive backtracking function to check if the word exists starting from (i,j)
     */
    public boolean checkIfExists(char[][] board, int i, int j, String word, boolean[][] visited) {
        // Boundary checks
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length)
            return false;

        // Already visited or character mismatch
        if (visited[i][j] || board[i][j] != word.charAt(0))
            return false;

        // Base case: All characters matched
        if (word.length() == 1)
            return true;

        // Mark current cell as visited
        visited[i][j] = true;

        // Explore all 4 directions
        boolean found = checkIfExists(board, i - 1, j, word.substring(1), visited) ||
                checkIfExists(board, i + 1, j, word.substring(1), visited) ||
                checkIfExists(board, i, j + 1, word.substring(1), visited) ||
                checkIfExists(board, i, j - 1, word.substring(1), visited);

        // Backtrack
        visited[i][j] = false;

        return found;
    }

    public static void main(String[] args) {
        WordSearch solution = new WordSearch();
        char[][] board = {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };

        String word = "ABCCED";
        System.out.println(solution.exist(board, word)); // true

        word = "ABCB";
        System.out.println(solution.exist(board, word)); // false

        board = new char[][] {
                {'A','B','C','E'},
                {'S','F','E','S'},
                {'A','D','E','E'}
        };
        word = "ABCESEEEFS";
        System.out.println(solution.exist(board, word)); // true
    }
}
