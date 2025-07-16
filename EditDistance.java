public class EditDistance {

    /**
     * Bottom-up Dynamic Programming approach to compute Edit Distance.
     * dp[i][j] = minimum operations required to convert word1[0...i-1] to word2[0...j-1]
     */
    public int minDistance(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();
        int[][] dp = new int[n1 + 1][n2 + 1];

        // Base cases: converting to empty string
        for (int i = 1; i <= n1; i++)
            dp[i][0] = i;
        for (int j = 1; j <= n2; j++)
            dp[0][j] = j;

        // Fill dp table
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    // No operation needed if characters match
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // Choose min of insert, delete, replace
                    dp[i][j] = 1 + Math.min(
                            dp[i - 1][j - 1], // Replace
                            Math.min(dp[i - 1][j],   // Delete
                                    dp[i][j - 1])   // Insert
                    );
                }
            }
        }

        return dp[n1][n2];
    }

    /**
     * Recursive solution (not used in main) - Exponential time complexity
     */
    private int minDistanceRec(String word1, int i, String word2, int j) {
        if (i < 0)
            return j + 1;
        if (j < 0)
            return i + 1;

        if (word1.charAt(i) == word2.charAt(j))
            return minDistanceRec(word1, i - 1, word2, j - 1);

        int insert = 1 + minDistanceRec(word1, i, word2, j - 1);
        int delete = 1 + minDistanceRec(word1, i - 1, word2, j);
        int replace = 1 + minDistanceRec(word1, i - 1, word2, j - 1);
        return Math.min(replace, Math.min(insert, delete));
    }

    public static void main(String[] args) {
        EditDistance solution = new EditDistance();

        String word1 = "horse", word2 = "ros";
        System.out.println(solution.minDistance(word1, word2));  // Output: 3

        word1 = "intention";
        word2 = "execution";
        System.out.println(solution.minDistance(word1, word2));  // Output: 5
    }
}
