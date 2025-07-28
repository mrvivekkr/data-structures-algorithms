import java.util.*;

class MedianFinder {

    // Max heap for the left half (lower values)
    PriorityQueue<Integer> leftMaxHeap = new PriorityQueue<>(Collections.reverseOrder());

    // Min heap for the right half (higher values)
    PriorityQueue<Integer> rightMinHeap = new PriorityQueue<>();

    public MedianFinder() {
        // Constructor initializes two heaps
    }

    public void addNum(int num) {
        // Step 1: Add to max heap
        leftMaxHeap.add(num);

        // Step 2: Balance — move max from left to right to maintain order
        rightMinHeap.offer(leftMaxHeap.poll());

        // Step 3: Maintain size property — leftMaxHeap can be larger by at most 1
        if (rightMinHeap.size() > leftMaxHeap.size()) {
            leftMaxHeap.offer(rightMinHeap.poll());
        }
    }

    public double findMedian() {
        // If even total elements, return average of two middle values
        if (rightMinHeap.size() == leftMaxHeap.size()) {
            return (leftMaxHeap.peek() + rightMinHeap.peek()) / 2.0;
        }

        // If odd, the left heap has the extra element (middle)
        return leftMaxHeap.peek();
    }

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian()); // Output: 1.5
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian()); // Output: 2
    }
}
