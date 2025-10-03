import java.util.Arrays;

public class PalindromePartitioning2 {

    /**
     * Naive recursive solution (no memoization).
     * Tries all possible partitions and returns minimum cuts.
     * This is exponential and inefficient for large strings.
     */
    public int minCut(String s) {
        if (isPalindrome(s)) return 0; // No cuts needed if string is already a palindrome

        int val = s.length();
        for (int i = 1; i < s.length(); i++) {
            String prefix = s.substring(0, i);
            if (isPalindrome(prefix)) {
                // Cut at 'i' and solve recursively for the remainder
                val = Math.min(val, 1 + minCut(s.substring(i)));
            }
        }
        return val;
    }

    /**
     * Recursive solution with memoization.
     * Uses a memo[] array to avoid recalculating subproblems.
     */
    public int minCutMemoHelper(String s, int[] memo, int start) {
        // Base case: if substring from start to end is a palindrome
        if (s.length() <= 1 || isPalindrome(s, start, s.length() - 1)) {
            return 0;
        }

        if (memo[start] != -1) return memo[start]; // Already computed

        int res = s.length();
        for (int i = start; i < s.length(); i++) {
            if (isPalindrome(s, start, i)) {
                res = Math.min(res, 1 + minCutMemoHelper(s, memo, i + 1));
            }
        }

        memo[start] = res;
        return res;
    }

    public int minCutMemo(String s) {
        int[] memo = new int[s.length()];
        Arrays.fill(memo, -1);
        return minCutMemoHelper(s, memo, 0);
    }

    /**
     * Bottom-up Dynamic Programming approach.
     * cuts[i] = minimum cuts needed for substring s[0..i].
     * Time complexity: O(n^2), Space: O(n)
     */
    public int minCutDp(String s) {
        int n = s.length();
        int[] cuts = new int[n];

        // Initialize worst case: max cuts = i (cut between each char)
        for (int i = 0; i < n; i++) {
            cuts[i] = i;
        }

        // Fill DP table
        for (int end = 0; end < n; end++) {
            for (int start = 0; start <= end; start++) {
                if (isPalindrome(s, start, end)) {
                    if (start == 0) {
                        cuts[end] = 0; // Whole substring is palindrome
                    } else {
                        cuts[end] = Math.min(cuts[end], 1 + cuts[start - 1]);
                    }
                }
            }
        }

        return cuts[n - 1];
    }

    /**
     * Helper method: check if entire string is palindrome.
     */
    public boolean isPalindrome(String s) {
        int start = 0, end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    /**
     * Helper method: check if substring s[left..right] is palindrome.
     */
    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromePartitioning2 solution = new PalindromePartitioning2();

        String s = "aab";
        System.out.println(solution.minCutDp(s)); // Output: 1

        s = "a";
        System.out.println(solution.minCutDp(s)); // Output: 0

        s = "ab";
        System.out.println(solution.minCutDp(s)); // Output: 1
    }
}
