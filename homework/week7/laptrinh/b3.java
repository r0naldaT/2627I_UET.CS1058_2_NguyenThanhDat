package homework.week7.laptrinh;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class b3 {
    public static int cookies(int k, List<Integer> A) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int n: A){
            pq.offer(n);
        }
        int res = 0;
        while(pq.peek() < k && pq.size() >= 2){
            int c1 = pq.poll();
            int c2 = pq.poll();
            pq.offer(c1 + 2 * c2);
            res++;
        }
        if (pq.peek() < k) {
            return -1;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        List<Integer> a = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            a.add(sc.nextInt());
        }

        System.out.println(cookies(k, a));

    }
}
