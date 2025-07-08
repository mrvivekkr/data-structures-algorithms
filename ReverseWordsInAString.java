/**
 * Reverse Words in a String
 *
 * Given an input string s, reverse the order of the words.
 * A word is defined as a sequence of non-space characters.
 * Leading/trailing/multiple spaces must be trimmed to a single space.
 */
public class ReverseWordsInAString {

    /**
     * Reverses the order of words in the given string.
     *
     * @param s Input string with words separated by spaces
     * @return Reversed word order with single spaces and no leading/trailing space
     */
    public String reverseWords(String s) {
        // Trim leading/trailing spaces and split by one or more spaces
        String[] words = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();

        // Iterate from the end to reverse the word order
        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i]); // Append each word
            if (i != 0) {
                sb.append(" "); // Add space between words
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        ReverseWordsInAString solution = new ReverseWordsInAString();

        String s1 = "the sky is blue";
        System.out.println(solution.reverseWords(s1)); // Output: "blue is sky the"

        String s2 = "  hello world  ";
        System.out.println(solution.reverseWords(s2)); // Output: "world hello"

        String s3 = "a good   example";
        System.out.println(solution.reverseWords(s3)); // Output: "example good a"
    }
}
