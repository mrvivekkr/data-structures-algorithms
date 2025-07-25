public class RegularExpressionMatching {

    // Main method that starts matching from index 0 of both strings
    public boolean isMatch(String s, String p) {
        return isMatchUtil(s, p, 0, 0);
    }

    /**
     * Recursive helper method to check if s[i:] matches p[j:].
     * @param s The input string
     * @param p The pattern string (may contain '.' or '*')
     * @param i Index in string s
     * @param j Index in pattern p
     * @return true if s[i:] matches p[j:], false otherwise
     */
    public boolean isMatchUtil(String s, String p, int i, int j) {
        // If we've reached the end of the pattern, match only if string is also exhausted
        if (j == p.length())
            return i == s.length();

        // Check if current characters match or pattern has '.'
        boolean firstMatch = (i < s.length()) && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');

        // If next character in pattern is '*', handle zero or more of preceding character
        if (j < p.length() - 1 && p.charAt(j + 1) == '*') {
            // Two choices:
            // 1. Skip 'x*' in pattern (zero occurrence)
            // 2. If firstMatch is true, consume one character from s and keep j at current position
            return isMatchUtil(s, p, i, j + 2) || (firstMatch && isMatchUtil(s, p, i + 1, j));
        } else {
            // If no '*', just move ahead if current characters match
            return firstMatch && isMatchUtil(s, p, i + 1, j + 1);
        }
    }

    public static void main(String[] args) {
        RegularExpressionMatching solution = new RegularExpressionMatching();
        String s = "aa";
        String p = "a";
        System.out.println(solution.isMatch(s, p));  // false

        s = "aa"; p = "a*";
        System.out.println(solution.isMatch(s, p));  // true

        s = "ab"; p = ".*";
        System.out.println(solution.isMatch(s, p));  // true
    }
}
