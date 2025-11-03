import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * TrieNode class representing each node of the Trie data structure.
 */
class TrieNode {
    TrieNode[] children = new TrieNode[26];
    String word = "";  // Store word at leaf node, empty if none
}

/**
 * WordSearch2 class provides solution for LeetCode 212. Word Search II.
 *
 * Problem: Given an m x n board of characters and a list of words, find all words on the board.
 * Words are formed from adjacent horizontal or vertical cells without reusing any cell.
 */
public class WordSearch2 {

    /**
     * Finds all words from the provided list that appear in the board.
     * Uses a Trie for prefix pruning and backtracking to search the board.
     *
     * @param board 2D char grid of letters
     * @param words List of words to find
     * @return List of words found on the board (no duplicates)
     */
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();

        // Build Trie from words
        for (String word : words) {
            buildTrie(word, root);
        }

        Set<String> matchedWords = new HashSet<>();

        // Start DFS from each cell if the prefix matches
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                boolean[][] visited = new boolean[board.length][board[0].length];
                // Only start DFS if character exists in root children to optimize
                if (root.children[board[r][c] - 'a'] != null) {
                    dfs(board, visited, r, c, root.children[board[r][c] - 'a'], matchedWords);
                }
            }
        }

        // Return result as list
        return new ArrayList<>(matchedWords);
    }

    /**
     * DFS helper method to recursively find words matching Trie prefixes.
     * Marks visited cells to prevent reuse in same word path.
     * Adds words to matchedWords set when end of word is found.
     *
     * Backtracks by unmarking visited cells after exploring paths.
     *
     * @param board 2D board characters
     * @param visited boolean visited matrix
     * @param r      current row position
     * @param c      current col position
     * @param root   current TrieNode in search
     * @param matchedWords set to collect found words
     */
    private void dfs(char[][] board, boolean[][] visited, int r, int c, TrieNode root, Set<String> matchedWords) {
        if (root == null)
            return;

        if (!root.word.isEmpty())
            matchedWords.add(root.word);

        // Mark current cell visited
        visited[r][c] = true;

        // Directions: down, up, left, right
        int[] xDir = {1, -1, 0, 0};
        int[] yDir = {0, 0, -1, 1};

        for (int i = 0; i < 4; i++) {
            int x1 = r + xDir[i];
            int y1 = c + yDir[i];

            if (isSafe(board, visited, x1, y1)) {
                char ch = board[x1][y1];
                if (root.children[ch - 'a'] != null) {
                    dfs(board, visited, x1, y1, root.children[ch - 'a'], matchedWords);
                }
            }
        }

        // Backtrack - unmark visited cell
        visited[r][c] = false;
    }

    /**
     * Check boundary and visited constraints for DFS
     *
     * @param board 2D char board
     * @param visited boolean visited matrix
     * @param x current row idx
     * @param y current col idx
     * @return true if position is safe to explore
     */
    private boolean isSafe(char[][] board, boolean[][] visited, int x, int y) {
        return x >= 0 && x < board.length && y >= 0 && y < board[0].length && !visited[x][y];
    }

    /**
     * Builds Trie from a given word by inserting characters as nodes.
     * Marks the last node with the word string.
     *
     * @param word   word to add
     * @param root   Trie root node
     */
    private void buildTrie(String word, TrieNode root) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            if (curr.children[c - 'a'] == null) {
                curr.children[c - 'a'] = new TrieNode();
            }
            curr = curr.children[c - 'a'];
        }
        curr.word = word;
    }

    /**
     * Main method to test WordSearch2 with example input.
     */
    public static void main(String[] args) {
        char[][] board = {
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}
        };

        String[] words = {"oath", "pea", "eat", "rain"};

        WordSearch2 solution = new WordSearch2();

        List<String> foundWords = solution.findWords(board, words);

        System.out.println("Words found on the board:");
        for (String word : foundWords) {
            System.out.println(word);
        }
    }
}
