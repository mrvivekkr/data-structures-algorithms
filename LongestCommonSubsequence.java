public class LongestCommonSubsequence {

    // Main function to compute LCS length
    public int longestCommonSubsequence(String text1, String text2) {
        // Recursive solution (inefficient for large inputs)
        // return longestCommonSubsequenceUtil(text1, text2, 0, 0);

        // Optimized DP solution
        return longestCommonSubsequenceDp(text1, text2);
    }

    // Recursive approach (exponential time complexity)
    public int longestCommonSubsequenceUtil(String text1, String text2, int i, int j) {
        // Base case: reached end of one string
        if (i == text1.length() || j == text2.length())
            return 0;

        // If characters match, move both pointers
        if (text1.charAt(i) == text2.charAt(j))
            return 1 + longestCommonSubsequenceUtil(text1, text2, i + 1, j + 1);

        // Else, skip one character from either string
        return Math.max(
                longestCommonSubsequenceUtil(text1, text2, i, j + 1),
                longestCommonSubsequenceUtil(text1, text2, i + 1, j)
        );
    }

    // Dynamic Programming approach (efficient)
    public int longestCommonSubsequenceDp(String text1, String text2) {
        int n1 = text1.length();
        int n2 = text2.length();

        // dp[i][j] = LCS length for text1[0..i-1], text2[0..j-1]
        int[][] dp = new int[n1 + 1][n2 + 1];

        // Build dp table bottom-up
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1]; // characters match
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]); // take best option
            }
        }
        return dp[n1][n2];
    }

    public static void main(String[] args) {
        LongestCommonSubsequence solution = new LongestCommonSubsequence();

        String text1 = "abcde";
        String text2 = "ace";
        System.out.println(solution.longestCommonSubsequence(text1, text2)); // Output: 3

        text1 = "abc";
        text2 = "abc";
        System.out.println(solution.longestCommonSubsequence(text1, text2)); // Output: 3

        text1 = "abc";
        text2 = "def";
        System.out.println(solution.longestCommonSubsequence(text1, text2)); // Output: 0
    }
}
