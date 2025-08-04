public class MinimumInsertionsToMakeStringPalindrome {

    // Main method using Bottom-Up DP
    public int minInsertions(String s) {
        return minInsertionDp(s);
    }

    // ✅ Bottom-up DP solution
    public int minInsertionDp(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i][j - 1], dp[i + 1][j]);
                }
            }
        }
        return dp[0][n - 1];
    }

    // 🔁 Recursive approach with String manipulation (not used, for reference only)
    public int minInsertionsRec(String s) {
        if (isPalindrome(s))
            return 0;
        if (s.charAt(0) == s.charAt(s.length() - 1))
            return minInsertionsRec(s.substring(1, s.length() - 1));
        return 1 + Math.min(
                minInsertionsRec(s.charAt(s.length() - 1) + s),
                minInsertionsRec(s + s.charAt(0))
        );
    }

    // 🔁 Top-down memoization approach (not used, for reference only)
    public int minInsertionMemo(String s, int start, int end, int[][] memo) {
        if (start >= end)
            return 0;
        if (memo[start][end] != -1)
            return memo[start][end];
        if (s.charAt(start) == s.charAt(end))
            return minInsertionMemo(s, start + 1, end - 1, memo);
        memo[start][end] = 1 + Math.min(
                minInsertionMemo(s, start, end - 1, memo),
                minInsertionMemo(s, start + 1, end, memo)
        );
        return memo[start][end];
    }

    private boolean isPalindrome(String s) {
        int start = 0, end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        MinimumInsertionsToMakeStringPalindrome solution = new MinimumInsertionsToMakeStringPalindrome();
        System.out.println(solution.minInsertions("zzazz"));    // Output: 0
        System.out.println(solution.minInsertions("mbadm"));    // Output: 2
        System.out.println(solution.minInsertions("leetcode")); // Output: 5
    }
}
