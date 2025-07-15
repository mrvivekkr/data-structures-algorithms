import java.util.Arrays;

/**
 * Problem: Given coins of different denominations and a total amount,
 * find the minimum number of coins needed to make up that amount.
 * If it's not possible to make the amount, return -1.
 */
public class CoinChangeMinimumCoins {
    public int coinChange(int[] coins, int amount) {
        // Array to store the minimum number of coins for each amount up to 'amount'
        int[] minCoins = new int[amount + 1];

        // Initialize all values to Integer.MAX_VALUE except base case minCoins[0]
        Arrays.fill(minCoins, Integer.MAX_VALUE);
        minCoins[0] = 0;

        // For each coin, update the minCoins array from that coin to target amount
        for (int coin : coins) {
            for (int j = coin; j <= amount; j++) {
                if (minCoins[j - coin] != Integer.MAX_VALUE) {
                    minCoins[j] = Math.min(minCoins[j], 1 + minCoins[j - coin]);
                }
            }
        }

        // If value at 'amount' index is still MAX, return -1 (not possible)
        return minCoins[amount] != Integer.MAX_VALUE ? minCoins[amount] : -1;
    }

    public static void main(String[] args) {
        CoinChangeMinimumCoins solution = new CoinChangeMinimumCoins();

        int[] coins = {1, 2, 5};
        int amount = 11;
        System.out.println(solution.coinChange(coins, amount)); // Output: 3

        coins = new int[]{2, 5, 10, 1};
        amount = 27;
        System.out.println(solution.coinChange(coins, amount)); // Output: 4

        coins = new int[]{2};
        amount = 3;
        System.out.println(solution.coinChange(coins, amount)); // Output: -1
    }
}
