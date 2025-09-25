# Autocomplete Backend System (FindTopKWords)

## Problem Statement

You are designing the backend of an autocomplete feature (like in search boxes).

- You are given:
    1. A list of N words (dictionary).
    2. Each word has a frequency score (indicating how often it has been typed).
- You need to implement:
    - A method `insert(word, frequency)` adds/updates a word with its frequency.
    - A method `getTopK(prefix, k)` returns the top k words that start with the given prefix, ordered by frequency (descending).
        - If frequencies are equal, order lexicographically.

### Constraints
- N can be as large as 10^6.
- Each word length ≤ 50.
- `getTopK` must be efficient; it could be called millions of times per day.
- Memory usage should be reasonable.

---

## Solution Approach

### Data Structures
- **Trie (Prefix Tree):**
    - Used to store and search prefixes efficiently.
    - Each node represents a character and has pointers to child nodes.
    - Supports fast insertion and retrieval of all words with a given prefix.
- **HashMap**:
    - Maintains the frequency of each word separately (`Map<String, Integer>`).
    - Keeps the Trie memory usage low, since frequency is not duplicated in every node.

### Methods

1. **insert(word, frequency)**
    - Traverses/creates the Trie nodes for the word.
    - Marks the end node as a valid word.
    - Updates the word’s frequency in the map. If the word already exists, increments (or updates) the frequency.

2. **getTopK(prefix, k)**
    - Traverses the Trie to reach the end node of the given prefix.
    - Performs a DFS from that node, collecting all words starting with the prefix.
    - Uses the frequency map to fetch frequencies for all candidate words.
    - Sorts the list first by frequency (descending), then lexicographically (ascending for ties).
    - Returns the top k entries.

### Key Points

- **Efficiency**: Prefix search in Trie is O(L), where L is the prefix length. Collecting and sorting candidate words is efficient for small K and reasonable prefix branching.
- **Memory**: Only stores the structure of the Trie plus a single frequency map, minimizing extra space usage.
- **Tie-breaking**: If two words share the same frequency, the comparator sorts them alphabetically.

### Example Usage
```
TrieAutocomplete trie = new TrieAutocomplete();
trie.insert("apple", 5);
trie.insert("app", 3);
trie.insert("application", 2);
List<String> topWords = trie.getTopK("app", 2); // returns ["apple", "app"]
```

### Test Cases
Test cases cover:
- Insertion and updates
- Frequency tie-breaking by lex order
- Empty prefix (top words globally)
- No-matching prefix (empty result)
- Varying k values

---

## How to Run

1. Add the `TrieAutocomplete` and `TrieNode` classes to your Java project.
2. Use the sample usage or test cases in your main/test class to verify correctness.
3. Adjust or extend test cases as needed.

---

**Tags:** Trie, Autocomplete, Top K, Prefix Search, Java, DSA
