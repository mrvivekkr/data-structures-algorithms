import java.util.HashMap;
import java.util.Map;

/**
 * Longest Substring Without Repeating Characters
 *
 * Problem:
 * Given a string `s`, find the length of the longest substring without repeating characters.
 *
 * Example:
 * Input: s = "abcabcbb"
 * Output: 3  // "abc"
 */

public class LongestSubstringWithoutRepeatingChars {

    /**
     * Uses sliding window and HashMap to track last seen positions of characters.
     * @param s input string
     * @return length of longest substring without repeating characters
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0)
            return 0;

        int maxLen = 0;
        int start = 0;
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // If character is already seen and in the current window
            if (map.containsKey(c) && map.get(c) >= start) {
                // Move the start of the window just after the last occurrence
                start = map.get(c) + 1;
            }

            // Update the last seen index of the character
            map.put(c, i);

            // Update maxLen if current window is larger
            int len = i - start + 1;
            if (len > maxLen)
                maxLen = len;
        }

        return maxLen;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingChars solution = new LongestSubstringWithoutRepeatingChars();

        String s1 = "abcabcbb";
        System.out.println(solution.lengthOfLongestSubstring(s1)); // Output: 3

        String s2 = "bbbbb";
        System.out.println(solution.lengthOfLongestSubstring(s2)); // Output: 1

        String s3 = "pwwkew";
        System.out.println(solution.lengthOfLongestSubstring(s3)); // Output: 3
    }
}
