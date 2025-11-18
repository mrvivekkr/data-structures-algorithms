import java.util.ArrayList;
import java.util.List;

/**
 * GenerateParentheses class provides a method to generate all combinations
 * of well-formed parentheses for a given number n.
 */
public class GenerateParentheses {

    /**
     * Generates all combinations of well-formed parentheses using backtracking.
     *
     * @param n The number of pairs of parentheses.
     * @return A list of strings, each string representing a valid parentheses combination.
     */
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        allParenthesis(0, 0, n, "", res);
        return res;
    }

    /**
     * Helper method to recursively build valid parentheses combinations.
     *
     * @param open  The count of '(' used so far.
     * @param close The count of ')' used so far.
     * @param n     The total number of pairs to be used.
     * @param curr  The current string being formed.
     * @param res   The list to collect all valid combinations.
     */
    public void allParenthesis(int open, int close, int n, String curr, List<String> res) {
        // If the current string length equals twice n, it is complete and valid
        if (curr.length() == 2 * n) {
            res.add(curr);
            return; // Backtrack for other possibilities
        }

        // If we can add an opening parenthesis, recurse after adding '('
        if (open < n) {
            allParenthesis(open + 1, close, n, curr + "(", res);
        }

        // If we can add a closing parenthesis without exceeding the number of '('
        if (close < open) {
            allParenthesis(open, close + 1, n, curr + ")", res);
        }
    }

    /**
     * Main method to run example usage.
     *
     * @param args Command line arguments (unused).
     */
    public static void main(String[] args) {
        GenerateParentheses solution = new GenerateParentheses();
        int n = 3;
        System.out.println(solution.generateParenthesis(n).toString());
    }
}
