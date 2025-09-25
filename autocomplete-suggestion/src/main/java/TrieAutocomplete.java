import java.util.*;

public class TrieAutocomplete {
    TrieNode root;
    Map<String, Integer> wordFrequency ;
    public TrieAutocomplete(){
        root = new TrieNode();
        wordFrequency = new HashMap<>();
    }

    public void insert(String word){
        TrieNode curr = root;
        for(Character ch : word.toCharArray()){
            if(!curr.children.containsKey(ch)){
                curr.children.put(ch, new TrieNode());
            }
            curr = curr.children.get(ch);
        }
        curr.isEndOfWord = true;
        wordFrequency.put(word, wordFrequency.getOrDefault(word,0)+1);
    }
    public void insert(String word, int frequency){
        TrieNode curr = root;
        for(Character ch : word.toCharArray()){
            if(!curr.children.containsKey(ch)){
                curr.children.put(ch, new TrieNode());
            }
            curr = curr.children.get(ch);
        }
        curr.isEndOfWord = true;
        wordFrequency.put(word, wordFrequency.getOrDefault(word,0)+frequency);
    }

    public List<String> getTopK(String prefix, int K){
        List<String> words = getWordsWithPrefix(prefix);
        int n = words.size();
        return words.subList(0, n>K?K:n);
    }

    private List<String> getWordsWithPrefix(String prefix) {
        List<String> words = new ArrayList<>();
        TrieNode curr = root;
        for(Character ch : prefix.toCharArray()){
            if(!curr.children.containsKey(ch)){
                return words;
            }
            curr = curr.children.get(ch);
        }
        gatherWords(curr, new StringBuilder(prefix), words);
        Collections.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int freqCompare =  wordFrequency.getOrDefault(o2,0)- wordFrequency.getOrDefault(o1,0);
                if(freqCompare!=0){
                    return freqCompare;
                }else{
                    return o1.compareTo(o2);
                }
            }
        });
        return words;
    }

    private void gatherWords(TrieNode curr, StringBuilder sb, List<String> words) {
        if(curr.isEndOfWord){
            words.add(sb.toString());
        }
        for(Map.Entry entry: curr.children.entrySet()){
            sb = sb.append(entry.getKey());
            gatherWords((TrieNode) entry.getValue(),sb,words );
            sb.deleteCharAt(sb.length()-1);
        }
    }

}
