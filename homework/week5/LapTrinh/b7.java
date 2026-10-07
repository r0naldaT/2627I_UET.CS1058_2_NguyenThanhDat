package homework.week5.LapTrinh;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class b7 {
    // Quick Select
    public static int findMedian(List<Integer> arr) {
        int n = arr.size();
        int m = n / 2;

        int start = 0;
        int end = n - 1;

        while (start <= end){
            int pivot = partition(arr, start, end);
            if (pivot == m){
                return arr.get(pivot);
            }
            else if (pivot > m){
                end = pivot - 1;
            }
            else{
                start = pivot + 1;
            }
        }
        return 0;
    }
    private static int partition(List<Integer> arr, int start, int end){
        int pivot = arr.get(end);

        int i = start - 1;

        for(int j = start; j < end ; j++){
            if (arr.get(j) < pivot){
                i++;
                int temp = arr.get(i);
                arr.set(i, arr.get(j));
                arr.set(j, temp);
            }
        }
        i++;
        int temp = arr.get(i);
        arr.set(i, pivot);
        arr.set(end, temp);
        return i;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }
        System.out.println(findMedian(arr));
    }
}
