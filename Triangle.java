import java.util.ArrayList;
import java.util.List;

public class Triangle {

    /**
     * Finds the minimum path sum from top to bottom of a triangle.
     * Uses a bottom-up dynamic programming approach with space optimization.
     *
     * @param triangle A list of lists representing the triangle, where triangle.get(i).get(j)
     *                 is the value at row i and column j.
     * @return The minimum path sum from top to bottom.
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();

        // dp array stores the minimum path sums for the current row being processed
        // Initialized to values of the bottom row of the triangle
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = triangle.get(n - 1).get(i);
        }

        // Process the triangle from the second-last row upward to the top
        for (int row = n - 2; row >= 0; row--) {
            // For each element in the current row
            for (int col = 0; col <= row; col++) {
                // Update dp[col] to be the minimum path sum from this position:
                // current element + min of the two adjacent children in row below
                dp[col] = triangle.get(row).get(col) + Math.min(dp[col], dp[col + 1]);
            }
        }

        // dp[0] holds the minimum path sum from the top to the bottom of the triangle
        return dp[0];
    }

    public static void main(String[] args){
        Triangle solution = new Triangle();
        int[][] input = new int[][] {{7},{-5,9},{6,5,2},{-8,-2,-7,3},{-2,6,-6,-1,4}};
        List<List<Integer>> triangle = new ArrayList<>();
        for (int[] arr : input) {
            List<Integer> innerList = new ArrayList<>();
            for (int num : arr) {
                innerList.add(num);
            }
            triangle.add(innerList);
        }
        System.out.println(solution.minimumTotal(triangle));
    }
}
