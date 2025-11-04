import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WordBreak2 {

    /*
     * Problem: Given a string s and a list of valid words (wordDict),
     * find all possible sentences where s can be segmented into a
     * sequence of one or more dictionary words.
     *
     * This class implements a backtracking solution to explore all
     * valid segmentations.
     */

    // Main function that initiates the backtracking process
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<List<String>> res = new ArrayList<>(); // Store lists of words forming valid sentences
        // Start backtracking from index 0 with empty current sentence and results list
        wordBreakUtil(s, 0, wordDict, new ArrayList<>(), res);
        // Convert List<List<String>> to List<String> by joining words with space
        return res.stream()
                .map(innerList -> String.join(" ", innerList))
                .collect(Collectors.toList());
    }

    /**
     * Utility backtracking function to explore all valid sentences.
     *
     * @param s               The input string to segment.
     * @param idx             The current starting index in s.
     * @param wordDict        The dictionary of valid words.
     * @param currentSentence The current list of chosen words forming a partial sentence.
     * @param res             The result list collecting all valid sentences as lists of words.
     */
    public void wordBreakUtil(String s, int idx, List<String> wordDict, List<String> currentSentence, List<List<String>> res) {
        // If we've reached the end of the string, add a copy of the current sentence to results
        if (idx == s.length()) {
            res.add(new ArrayList<>(currentSentence));
            return;
        }

        // Explore all substrings starting from idx
        for (int i = idx; i < s.length(); i++) {
            // Extract substring from idx to i (inclusive)
            String sub = s.substring(idx, i + 1);
            // If substring is in dictionary, try extending current sentence with this word
            if (wordDict.contains(sub)) {
                currentSentence.add(sub); // Choose this word
                wordBreakUtil(s, i + 1, wordDict, currentSentence, res); // Explore further
                currentSentence.remove(currentSentence.size() - 1); // Backtrack: remove last word and try other options
            }
        }
    }

    // Driver method to test the solution with sample input
    public static void main(String[] args) {
        WordBreak2 solution = new WordBreak2();
        String s = "catsanddog";
        List<String> wordDict = Arrays.asList("cat", "cats", "and", "sand", "dog");
        List<String> res = solution.wordBreak(s, wordDict);
        System.out.println(res.toString()); // Expected output: ["cat sand dog", "cats and dog"]
    }
}
