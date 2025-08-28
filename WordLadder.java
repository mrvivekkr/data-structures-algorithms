import java.util.*;

// The WordLadder class provides a method to solve the Word Ladder problem.
// The goal is to find the shortest transformation sequence from beginWord to endWord,
// where each step transforms only one character and must result in a word from the wordList.
public class WordLadder {
    // Computes the shortest transformation sequence length (number of words) from beginWord to endWord.
    // Returns 0 if no such sequence exists.
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // If the word list does not contain endWord, transformation is impossible.
        if (!wordList.contains(endWord))
            return 0;

        // Convert wordList to a set for efficient lookup.
        Set<String> wordSet = new HashSet<>(wordList);

        // Tracks visited words to avoid cycles and redundant paths.
        HashMap<String, Boolean> visited = new HashMap<>();

        // Queue for BFS traversal.
        Queue<String> q = new LinkedList<>();

        int pathLength = 1; // Initialize transformation length.

        // Begin BFS from beginWord.
        q.add(beginWord);
        visited.put(beginWord, true);

        while (!q.isEmpty()) {
            int size = q.size();

            // Process all words at the current path length.
            for (int i = 0; i < size; i++) {
                String currWord = q.poll();

                // If current word is endWord, return its level as result.
                if (endWord.equals(currWord))
                    return pathLength;

                // Find valid neighbors (words differing by one letter and in wordSet).
                for (String neighbour : getNeighbours(currWord, wordSet)) {

                    // Enqueue unvisited neighbors and mark them visited.
                    if (!visited.getOrDefault(neighbour, false)) {
                        q.add(neighbour);
                        visited.put(neighbour, true);
                    }
                }
            }
            pathLength++; // Increment path length for next level.
        }
        // No valid transformation sequence found.
        return 0;
    }

    // Helper function that returns all valid neighbors of currWord.
    // Neighbor words differ by exactly one letter and exist in the wordSet.
    private List<String> getNeighbours(String currWord, Set<String> wordSet) {
        List<String> neighbours = new ArrayList<>();
        char[] cArr = currWord.toCharArray();

        // Try changing each character of currWord to every letter from 'a' to 'z'.
        for (int i = 0; i < cArr.length; i++) {
            char orig = cArr[i];
            for (char c = 'a'; c <= 'z'; c++) {
                if (c == orig)
                    continue;

                cArr[i] = c;
                String str = String.valueOf(cArr);

                // If the new word is in wordSet, it's a valid neighbor.
                if (wordSet.contains(str))
                    neighbours.add(str);
            }
            // Restore original character before moving to next position.
            cArr[i] = orig;
        }
        return neighbours;
    }

    // Test cases for the Word Ladder solution.
    public static void main(String[] args) {
        WordLadder solution = new WordLadder();
        String beginWord = "hit";
        String endWord = "cog";
        String[] wordList = { "hot", "dot", "dog", "lot", "log", "cog" };
        System.out.println(solution.ladderLength(beginWord, endWord, List.of(wordList))); // Output: 5

        solution = new WordLadder();
        beginWord = "hot";
        endWord = "dog";
        List<String> words = new ArrayList<>(List.of("hot", "dog"));
        System.out.println(solution.ladderLength(beginWord, endWord, words)); // Output: 0
    }
}
