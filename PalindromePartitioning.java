import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

    // Entry method that initializes required data structures
    public List<List<String>> partition(String s) {
        List<String> path = new ArrayList<>();              // current path of palindromic substrings
        List<List<String>> result = new ArrayList<>();      // stores final list of all valid partitions
        partitionUtil(s, 0, path, result);                  // begin DFS from index 0
        return result;
    }

    // Recursive DFS method to explore all partitions
    public void partitionUtil(String s, int start, List<String> path, List<List<String>> result) {
        // If we've reached the end of the string, add current path as a valid result
        if (start == s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }

        // Explore all substrings starting from 'start' to end of string
        for (int i = start; i < s.length(); i++) {
            String subStr = s.substring(start, i + 1);
            if (isPalindrome(subStr)) {
                path.add(subStr);                           // choose
                partitionUtil(s, i + 1, path, result);      // explore
                path.remove(path.size() - 1);               // un-choose (backtrack)
            }
        }
    }

    // Utility to check if a string is a palindrome
    private boolean isPalindrome(String s) {
        int n = s.length();
        for (int i = 0; i < n / 2; i++) {
            if (s.charAt(i) != s.charAt(n - i - 1))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromePartitioning solution = new PalindromePartitioning();

        String s = "aab";
        System.out.println(solution.partition(s)); // Output: [["a","a","b"],["aa","b"]]

        s = "a";
        System.out.println(solution.partition(s)); // Output: [["a"]]
    }
}
