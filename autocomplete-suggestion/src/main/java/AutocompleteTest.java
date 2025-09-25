public class AutocompleteTest {

    public static void main(String[] args){
        TrieAutocomplete acs = new TrieAutocomplete();
        // Test 1: Basic Inserts and top k retrieval
        acs.insert("apple", 5);
        acs.insert("app", 3);
        acs.insert("application", 2);
        acs.insert("ape", 4);
        acs.insert("banana", 1);

        // Expect top 2 words with prefix "app" => ["apple", "app"]
        System.out.println(acs.getTopK("app", 2)); // Apple frequency=5, app=3

        // Test 2: Frequency update on existing words
        acs.insert("app", 5); // Update app to frequency 8
        System.out.println(acs.getTopK("app", 3)); // app(8), apple(5), application(2)

        // Test 3: Prefix not present
        System.out.println(acs.getTopK("xyz", 2)); // []

        // Test 4: Prefix is empty string (should return top k from all words)
        System.out.println(acs.getTopK("", 3)); // app(8), apple(5), ape(4)

        // Test 5: Tie on frequency, expect lexicographical order
        acs.insert("bat", 2);
        acs.insert("ball", 2);
        System.out.println(acs.getTopK("ba", 3)); // ball, bat, banana

        // Test 6: k larger than number of available words
        System.out.println(acs.getTopK("app", 10)); // app, apple, application

        // Test 7: Words with frequency 0 or negative? (should handle gracefully)
        acs.insert("zero", 0);
        acs.insert("negative", -1);
        System.out.println(acs.getTopK("z", 1)); // zero

        // Test 8: Case sensitivity (assuming lowercase only)
        System.out.println(acs.getTopK("A", 2)); // []

        // Test 9: Single character prefix
        System.out.println(acs.getTopK("a", 5)); // app, apple, ape, application

        // Test 10: Insert and getTopK on single word
        acs.insert("zebra", 6);
        System.out.println(acs.getTopK("z", 2)); // zebra, zero
    }
}
