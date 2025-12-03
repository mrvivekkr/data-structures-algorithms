/**
 * Problem: Wildcard Matching (LeetCode 44)
 * Given string s and pattern p, implement wildcard matching where '?' matches any single char
 * and '*' matches any sequence of chars (including empty). Must match entire string.
 *
 * Approach: Bottom-Up Dynamic Programming
 * dp[i][j] = true if s[0..i-1] matches p[0..j-1]
 *
 * Time: O(m*n), Space: O(m*n)
 */
public class WildcardMatching {

    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        // Early return: all '*' pattern matches empty string
        boolean onlyStarPattern = true;
        for (char ch : p.toCharArray()) {
            if (ch != '*') {
                onlyStarPattern = false;
                break;
            }
        }
        if ((m == 0 && n == 0) || (m == 0 && onlyStarPattern))
            return true;
        if (n == 0 && m != 0)
            return false;

        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;

        // Initialize: leading '*'s match empty string
        for (int j = 1; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 1];
            }
        }

        // Fill DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) == '*') {
                    // * matches empty OR one+ chars
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                } else if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
                    // Direct match or '?'
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        WildcardMatching solution = new WildcardMatching();
        System.out.println(solution.isMatch("aa", "a"));      // false
        System.out.println(solution.isMatch("aa", "*"));      // true
        System.out.println(solution.isMatch("cb", "?a"));     // false
        System.out.println(solution.isMatch("adceb", "*a*b")); // true
        System.out.println(solution.isMatch("acdcb", "a*c?b")); // false
        System.out.println(solution.isMatch("", "******"));   // true
    }
}
