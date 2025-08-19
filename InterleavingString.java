public class InterleavingString {

    public boolean isInterleave(String s1, String s2, String s3) {
        // If combined length doesn't match s3, interleaving is impossible
        if (s1.length() + s2.length() != s3.length())
            return false;

        // Recursive approach (can be exponential time, commented here)
        // return isInterleaveRec(s1, s2, 0, 0, s3);

        // Efficient DP approach
        return isInterleaveDp(s1, s2, s3);
    }

    /**
     * Recursive solution (Brute force)
     * Tries to match characters from s1 and s2 one by one with s3
     */
    public boolean isInterleaveRec(String s1, String s2, int i1, int i2, String s3) {
        int i3 = i1 + i2;

        // Base case: if all characters from s1, s2, and s3 are used
        if (i1 == s1.length() && i2 == s2.length() && i3 == s3.length())
            return true;

        // Option 1: take character from s1
        boolean p1 = (i1 < s1.length()) &&
                (s1.charAt(i1) == s3.charAt(i3)) &&
                isInterleaveRec(s1, s2, i1 + 1, i2, s3);

        // Option 2: take character from s2
        boolean p2 = (i2 < s2.length()) &&
                (s2.charAt(i2) == s3.charAt(i3)) &&
                isInterleaveRec(s1, s2, i1, i2 + 1, s3);

        return p1 || p2;
    }

    /**
     * Dynamic Programming solution
     * dp[i][j] = true if first i chars of s1 and first j chars of s2
     * can form first (i+j) chars of s3
     */
    public boolean isInterleaveDp(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();
        boolean[][] dp = new boolean[m + 1][n + 1];

        dp[0][0] = true; // Empty s1 and s2 can form empty s3

        // Fill DP table
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 && j == 0) continue;

                // If current char of s1 matches char of s3, check dp[i-1][j]
                boolean p1 = (i > 0) &&
                        (s1.charAt(i - 1) == s3.charAt(i + j - 1)) &&
                        dp[i - 1][j];

                // If current char of s2 matches char of s3, check dp[i][j-1]
                boolean p2 = (j > 0) &&
                        (s2.charAt(j - 1) == s3.charAt(i + j - 1)) &&
                        dp[i][j - 1];

                dp[i][j] = p1 || p2;
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbbaccc";

        InterleavingString solution = new InterleavingString();
        System.out.println(solution.isInterleave(s1, s2, s3)); // false

        s1 = "aabcc"; s2 = "dbbca"; s3 = "aadbbcbcac";
        System.out.println(solution.isInterleave(s1, s2, s3)); // true
    }
}
