import java.util.HashMap;
import java.util.Map;

/**
 * Isomorphic Strings
 *
 * Two strings are isomorphic if characters in the first string can be replaced to get the second string.
 * Each character must map to exactly one character (one-to-one mapping), preserving order.
 */
public class IsomorphicStrings {

    /**
     * Checks if two strings are isomorphic by maintaining two-way character mappings.
     *
     * @param s first string
     * @param t second string
     * @return true if strings are isomorphic, false otherwise
     */
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length())
            return false;

        // Map from s -> t and t -> s to ensure one-to-one mapping
        Map<Character, Character> mapST = new HashMap<>();
        Map<Character, Character> mapTS = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char cs = s.charAt(i);
            char ct = t.charAt(i);

            // Check s -> t mapping
            if (mapST.containsKey(cs)) {
                if (mapST.get(cs) != ct)
                    return false;
            } else {
                mapST.put(cs, ct);
            }

            // Check t -> s mapping
            if (mapTS.containsKey(ct)) {
                if (mapTS.get(ct) != cs)
                    return false;
            } else {
                mapTS.put(ct, cs);
            }
        }

        return true;
    }

    public static void main(String[] args) {
        IsomorphicStrings solution = new IsomorphicStrings();

        String s = "egg", t = "add";
        System.out.println(solution.isIsomorphic(s, t)); // true

        s = "badc"; t = "baba";
        System.out.println(solution.isIsomorphic(s, t)); // false
    }
}
