public class RestoreTheArray {

    /**
     * Pure recursive solution (no memoization).
     *
     * Idea:
     * - At each call, we try to take a valid prefix of the current string s
     *   (s[0..i]) such that:
     *      1) The prefix does not start with '0'.
     *      2) Its integer value is in [1, k].
     * - For every such valid prefix, we recursively count the ways to split
     *   the remaining suffix s[i..end].
     *
     * This is exponential in the worst case and will TLE on large inputs,
     * but it is helpful to understand the core recurrence before adding DP.
     */
    public int numberOfArrays(String s, int k) {
        // If we consumed the whole string, that's one valid way to split.
        if (s.isEmpty()) {
            return 1;
        }

        // Numbers cannot start with '0', so no valid splits from here.
        if (s.startsWith("0")) {
            return 0;
        }

        int count = 0;

        // Try all prefixes s[0..i], i from 0 to s.length()-1.
        for (int i = 1; i <= s.length(); i++) {
            String sub = s.substring(0, i);
            long val = Long.parseLong(sub);

            // If the number exceeds k, any longer prefix will also exceed k.
            if (val > k) {
                break;
            }

            // Count all ways to split the remaining suffix.
            count += numberOfArrays(s.substring(i), k);
        }

        return count;
    }

    /**
     * Bottom-up dynamic programming solution.
     *
     * dp[i] = number of ways to split the suffix s[i..n-1] into valid integers.
     *
     * Transition:
     *  - If s[i] == '0', then dp[i] = 0 (no number can start with '0').
     *  - Otherwise, for each j >= i, we form the number represented by s[i..j].
     *      * stop when s[i..j] > k
     *      * for every valid s[i..j], we add dp[j + 1] to dp[i]
     *
     * Base case:
     *  - dp[n] = 1   (empty suffix has exactly one way to be "split")
     *
     * Time complexity:
     *  - O(n * L), where L is the number of digits in k,
     *    because we never need to consider segments longer than L.
     */
    public int numberOfArraysDp(String s, int k) {
        final int MOD = 1_000_000_007;
        int n = s.length();
        int[] dp = new int[n + 1];

        // Empty suffix: one valid way.
        dp[n] = 1;

        // Precompute max length of any valid number based on k's digits.
        int maxLen = String.valueOf(k).length();

        // Fill dp from right to left.
        for (int i = n - 1; i >= 0; i--) {
            // Cannot start a number with '0'.
            if (s.charAt(i) == '0') {
                dp[i] = 0;
                continue;
            }

            long ways = 0;
            long val = 0;

            // Build the number s[i..j] incrementally and stop early when:
            //  - j reaches i + maxLen, or
            //  - val exceeds k.
            for (int j = i; j < n && j < i + maxLen; j++) {
                val = val * 10 + (s.charAt(j) - '0');

                if (val > k) {
                    break;
                }

                ways += dp[j + 1];
                if (ways >= MOD) {
                    ways -= MOD;
                }
            }

            dp[i] = (int) ways;
        }

        return dp[0];
    }

    public static void main(String[] args) {
        RestoreTheArray sol = new RestoreTheArray();

        String s = "1317";
        int k = 2000;
        System.out.println(sol.numberOfArraysDp(s, k)); // expected: 8

        s = "1000";
        k = 10000;
        System.out.println(sol.numberOfArraysDp(s, k)); // expected: 1

        s = "2020";
        k = 30;
        System.out.println(sol.numberOfArraysDp(s, k)); // expected: 1

        s = "1000";
        k = 10;
        System.out.println(sol.numberOfArraysDp(s, k)); // expected: 0

        s = "407780786171321121429620765476840275495357129574174233567552131453038760763182952432348422252546559691171161181440370120987634895458140447952079749439961325982629462531738374032416182281868731817661954890417245087359968833257550123324827240537957646002494771036413572415";
        k = 823924906;
        System.out.println(sol.numberOfArraysDp(s, k));
    }
}
