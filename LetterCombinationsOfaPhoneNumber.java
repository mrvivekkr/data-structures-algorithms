import java.util.*;

public class LetterCombinationsOfaPhoneNumber {

    // Method to return all possible letter combinations for given digits
    public List<String> letterCombinations(String digits) {
        // Mapping of digits to corresponding letters on a phone keypad
        Map<Integer, List<Character>> mp = new HashMap<>();
        mp.put(2, Arrays.asList('a','b','c'));
        mp.put(3, Arrays.asList('d','e','f'));
        mp.put(4, Arrays.asList('g','h','i'));
        mp.put(5, Arrays.asList('j','k','l'));
        mp.put(6, Arrays.asList('m','n','o'));
        mp.put(7, Arrays.asList('p','q','r','s'));
        mp.put(8, Arrays.asList('t','u','v'));
        mp.put(9, Arrays.asList('w','x','y','z'));

        List<String> res = new ArrayList<>();

        // Start the recursive backtracking to generate combinations
        allCombinations(digits, 0, mp, "", res);
        return res;
    }

    /**
     * Recursive helper method to build all possible letter combinations
     * @param digits The input digit string
     * @param idx Current index in the digit string being processed
     * @param mp Map from digit to list of corresponding characters
     * @param curr Current string combination being built
     * @param res List to store all valid combinations
     */
    public void allCombinations(String digits, int idx, Map<Integer, List<Character>> mp, String curr, List<String> res) {
        // Base case: when index reaches the length of digits, add the current combination to results
        if (idx == digits.length()) {
            if(!curr.isEmpty()) { // Avoid adding empty string when input is empty
                res.add(curr);
            }
            return;
        }
        // Convert character digit to integer to get corresponding letters
        int currDigit = digits.charAt(idx) - '0';
        List<Character> charsForDigit = mp.get(currDigit);

        // Iterate through all letters for the current digit and recurse
        for (int i = 0; i < charsForDigit.size(); i++) {
            // Append the current letter and recurse for next digit
            allCombinations(digits, idx + 1, mp, curr + charsForDigit.get(i), res);
        }
    }

    public static void main(String[] args) {
        LetterCombinationsOfaPhoneNumber solution = new LetterCombinationsOfaPhoneNumber();
        String digits = "23";
        // Output all possible letter combinations for input digits
        System.out.println(solution.letterCombinations(digits).toString());
    }
}
