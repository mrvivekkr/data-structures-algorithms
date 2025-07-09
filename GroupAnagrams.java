import java.util.*;

/**
 * Group Anagrams
 *
 * Given an array of strings, group the anagrams together.
 * Anagrams are strings that have the same character counts.
 */
public class GroupAnagrams {

    /**
     * Groups anagrams by using character frequency hash as key.
     *
     * @param strs input array of strings
     * @return list of grouped anagram lists
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            // Generate a hash key representing the character frequency
            String hash = computeHash(str);

            // Group strings by their hash
            map.computeIfAbsent(hash, k -> new ArrayList<>()).add(str);
        }

        // Collect grouped lists
        return new ArrayList<>(map.values());
    }

    /**
     * Creates a unique hash string based on character frequencies.
     * This ensures all anagrams map to the same key.
     *
     * @param str the input string
     * @return frequency-based hash string
     */
    private String computeHash(String str) {
        int[] frequency = new int[26];
        for (char c : str.toCharArray()) {
            frequency[c - 'a']++;
        }

        // Format: "1#0#0#2#..." — ensures uniqueness
        StringBuilder hash = new StringBuilder();
        for (int freq : frequency) {
            hash.append(freq).append("#");
        }
        return hash.toString();
    }

    public static void main(String[] args) {
        GroupAnagrams solution = new GroupAnagrams();

        String[] strs1 = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(solution.groupAnagrams(strs1)); // [["bat"],["nat","tan"],["eat","tea","ate"]]

        String[] strs2 = {""};
        System.out.println(solution.groupAnagrams(strs2)); // [[""]]

        String[] strs3 = {"a"};
        System.out.println(solution.groupAnagrams(strs3)); // [["a"]]
    }
}
