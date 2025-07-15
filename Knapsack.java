public class Knapsack {

    /**
     * Bottom-up Dynamic Programming approach to solve 0/1 Knapsack problem.
     * dp[j][i] represents the maximum value achievable with capacity 'j' using first 'i' items.
     *
     * @param W   Maximum capacity of the knapsack
     * @param val Array containing values of items
     * @param wt  Array containing weights of items
     * @return Maximum value achievable without exceeding capacity W
     */
    private int knapsack(int W, int[] val, int[] wt) {
        int len = val.length;
        int[][] dp = new int[W + 1][len + 1];

        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= W; j++) {
                if (j >= wt[i - 1]) {
                    // Include the current item or exclude it, take maximum
                    dp[j][i] = Math.max(val[i - 1] + dp[j - wt[i - 1]][i - 1], dp[j][i - 1]);
                } else {
                    // Cannot include item, carry forward previous value
                    dp[j][i] = dp[j][i - 1];
                }
            }
        }

        return dp[W][len];
    }

    /**
     * Recursive solution for 0/1 Knapsack - not used in main, kept for reference
     * Time Complexity: Exponential
     */
    private int knapsackRec(int W, int[] val, int[] wt, int n) {
        if (W == 0 || n == 0)
            return 0;

        if (wt[n - 1] > W)
            return knapsackRec(W, val, wt, n - 1);

        return Math.max(
                val[n - 1] + knapsackRec(W - wt[n - 1], val, wt, n - 1),
                knapsackRec(W, val, wt, n - 1)
        );
    }

    public static void main(String[] args) {
        Knapsack solution = new Knapsack();

        int W = 4;
        int[] val = {1, 2, 3};
        int[] wt = {4, 5, 1};
        System.out.println(solution.knapsack(W, val, wt)); // Output: 3

        W = 3;
        val = new int[]{1, 2, 3};
        wt = new int[]{4, 5, 6};
        System.out.println(solution.knapsack(W, val, wt)); // Output: 0

        W = 5;
        val = new int[]{10, 40, 30, 50};
        wt = new int[]{5, 4, 2, 3};
        System.out.println(solution.knapsack(W, val, wt)); // Output: 80
    }
}
