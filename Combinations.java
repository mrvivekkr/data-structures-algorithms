import java.util.ArrayList;
import java.util.List;

public class Combinations {

    // Method to generate all combinations of k numbers from range [1, n]
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>(); // Result list to store all valid combinations
        List<Integer> curr = new ArrayList<>();       // Temporary list to store current combination
        combination(n, k, 1, curr, res);              // Start recursive backtracking from 1
        return res;                                   // Return all generated combinations
    }

    // Recursive helper method to build combinations
    // n: upper limit of range
    // k: target size of each combination
    // idx: current number to consider adding in the combination
    // curr: current combination being built
    // res: list collecting all valid combinations
    public void combination(int n, int k, int idx, List<Integer> curr, List<List<Integer>> res) {
        // Base case: if current combination size equals k, add its copy to the result
        if (curr.size() == k) {
            res.add(new ArrayList<>(curr));  // Add a copy to avoid reference issues
            return;                         // Backtrack after adding valid combination
        }
        // Iterate through numbers from idx to n to explore possibilities
        for (int i = idx; i <= n; i++) {
            curr.add(i);                    // Choose current number i
            combination(n, k, i + 1, curr, res); // Explore further combinations including i
            curr.remove(curr.size() - 1);  // Undo choice (backtrack) to try next number
        }
    }

    // Main method to test the code
    public static void main(String[] args) {
        Combinations solution = new Combinations();
        int n = 4;
        int k = 2;
        System.out.println(solution.combine(n, k)); // Outputs all combinations of 2 numbers from [1..4]
    }

}
