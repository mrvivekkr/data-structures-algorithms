import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordBreak {

    // Main function that invokes DP-based word break
    public boolean wordBreak(String s, List<String> wordDict) {
        return wordBreakDp(s, s.length(), wordDict);
    }

    // Recursive (backtracking) method – not used in main flow
    // Included for understanding purpose
    public boolean wordBreakUtil(String s, int i, int n, List<String> wordDict) {
        if (wordDict.contains(s))
            return true;
        if (i == n)
            return false;

        if (!wordDict.contains(s.substring(0, i))) {
            return wordBreakUtil(s, i + 1, n, wordDict);
        }

        return wordBreakUtil(s.substring(i), 0, s.substring(i).length(), wordDict)
                || wordBreakUtil(s, i + 1, n, wordDict);
    }

    // Bottom-up DP solution
    public boolean wordBreakDp(String s, int n, List<String> wordDict) {
        boolean[] dp = new boolean[n + 1];
        dp[0] = true; // Base case: empty string

        // Check all substrings ending at i
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                // If s[0..j-1] can be segmented and s[j..i-1] is in the dictionary
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        WordBreak solution = new WordBreak();

        String s = "leetcode";
        List<String> wordDict = new ArrayList<>(Arrays.asList("leet", "code"));
        System.out.println(solution.wordBreak(s, wordDict)); // true

        s = "applepenapple";
        wordDict = new ArrayList<>(Arrays.asList("apple", "pen"));
        System.out.println(solution.wordBreak(s, wordDict)); // true

        s = "catsandog";
        wordDict = new ArrayList<>(Arrays.asList("cats", "dog", "sand", "and", "cat"));
        System.out.println(solution.wordBreak(s, wordDict)); // false
    }
}