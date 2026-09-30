package homework.week4.laptrinh;

import java.util.ArrayList;
import java.util.List;

public class countingSort {
    public static List<Integer> countingSort(List<Integer> arr) {
        // Write your code here
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < 100; i++){
            res.add(0);
        }
        for(int n: arr){
            res.set(n, res.get(n) + 1);
        }
        return res;
    }
}

