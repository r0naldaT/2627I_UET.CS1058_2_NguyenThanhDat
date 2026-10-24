package homework.week7.laptrinh;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class b5 {
    public static List<Double> runningMedian(List<Integer> a) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        List<Double> medianList = new ArrayList<>();
        for(int n: a){
            if(minHeap.isEmpty()){
                minHeap.offer(n);
            }

            else if (n >= minHeap.peek()){
                minHeap.offer(n);
            }
            else{
                maxHeap.offer(n);
            }

            if(minHeap.size() - maxHeap.size() > 1){
                maxHeap.offer(minHeap.poll());
            }
            else if(maxHeap.size() - minHeap.size() > 1){
                minHeap.offer(maxHeap.poll());
            }

            if (maxHeap.size() != minHeap.size()){
                medianList.add((minHeap.size() > maxHeap.size()) ? minHeap.peek() * 1.0 : maxHeap.peek() * 1.0);
            }
            else{
                medianList.add((minHeap.peek() + maxHeap.peek()) / 2.0);
            }
        }
        return medianList;
    }
}
