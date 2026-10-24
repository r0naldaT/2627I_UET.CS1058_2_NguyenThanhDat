package homework.week7.laptrinh;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class b2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String s = sc.next();

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < s.length(); i++) {
            minHeap.offer(i);
            maxHeap.offer(i);
        }
        String res = "Yes";
        while (!minHeap.isEmpty()) {
            if (s.charAt(minHeap.poll()) != s.charAt(maxHeap.poll())){
                res = "No";
                break;
            }
        }
        System.out.println(res);
    }
}
