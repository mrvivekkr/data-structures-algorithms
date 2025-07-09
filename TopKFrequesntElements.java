import java.util.*;

/**
 * Top K Frequent Elements
 *
 * Given an array of integers and a number k, return the k most frequent elements.
 */
public class TopKFrequesntElements {

    /**
     * Finds the k most frequent elements in the array.
     *
     * @param nums input integer array
     * @param k number of most frequent elements to return
     * @return array of k most frequent elements
     */
    public int[] topKFrequent(int[] nums, int k) {
        // Count frequency of each number
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Max heap based on frequency
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> b.freq - a.freq);
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            pq.add(new Pair(entry.getKey(), entry.getValue()));
        }

        // Extract top k elements
        int[] out = new int[k];
        for (int i = 0; i < k; i++) {
            out[i] = pq.poll().num;
        }

        return out;
    }

    public static void main(String[] args) {
        TopKFrequesntElements solution = new TopKFrequesntElements();

        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        int[] res = solution.topKFrequent(nums, k);
        System.out.println(Arrays.toString(res)); // Output: [1, 2]

        nums = new int[]{1};
        k = 1;
        res = solution.topKFrequent(nums, k);
        System.out.println(Arrays.toString(res)); // Output: [1]
    }
}

// Helper class to represent number-frequency pair
class Pair {
    int num;   // the number
    int freq;  // its frequency

    public Pair(int num, int freq) {
        this.num = num;
        this.freq = freq;
    }
}
