public class CoinChangeCountWays {

    /**
     * Bottom-up Dynamic Programming approach
     * dp[i][j] represents number of ways to make amount 'i' using first 'j' coins
     */
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[amount + 1][n + 1];

        // There is 1 way to make amount 0 (select no coins)
        for (int i = 0; i <= n; i++)
            dp[0][i] = 1;

        for (int j = 1; j <= n; j++) {
            for (int i = 1; i <= amount; i++) {
                // Exclude current coin
                dp[i][j] += dp[i][j - 1];

                // Include current coin if it does not exceed amount
                if (coins[j - 1] <= i)
                    dp[i][j] += dp[i - coins[j - 1]][j];
            }
        }

        return dp[amount][n];
    }

    /**
     * Recursive solution - Not used in main, but kept for reference
     * Time Complexity: Exponential
     */
    public int coinChangeRec(int amount, int[] coins, int n) {
        if (amount == 0)
            return 1;
        if (n == 0 || amount < 0)
            return 0;

        // Include current coin + exclude current coin
        return coinChangeRec(amount - coins[n - 1], coins, n) +
                coinChangeRec(amount, coins, n - 1);
    }

    /**
     * Top-down DP approach with memoization - Also not used in main, but functional
     */
    public int coinChangeDp(int amount, int[] coins, int n, int[][] dp) {
        if (n <= 0 || amount < 0)
            return 0;
        if (amount == 0)
            return 1;
        if (dp[amount][n] != -1)
            return dp[amount][n];

        dp[amount][n] = coinChangeDp(amount - coins[n - 1], coins, n, dp) +
                coinChangeDp(amount, coins, n - 1, dp);
        return dp[amount][n];
    }

    public static void main(String[] args) {
        CoinChangeCountWays solution = new CoinChangeCountWays();

        int amount = 5;
        int[] coins = {1, 2, 5};
        System.out.println(solution.change(amount, coins));  // Output: 4

        amount = 3;
        coins = new int[]{2};
        System.out.println(solution.change(amount, coins));  // Output: 0
    }
}
