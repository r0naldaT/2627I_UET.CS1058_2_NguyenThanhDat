package homework.week4.laptrinh;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class insertionSort1 {
    private static void printArray(List<Integer> arr) {
        for(int n : arr){
            System.out.print(n + " ");
        }
        System.out.print("\n");
    }
    public static void insertionSort1(int n, List<Integer> arr) {
        int j = n - 2;
        int key = arr.get(n - 1);

        while (j >= 0 && arr.get(j) > key){
            arr.set(j + 1, arr.get(j));
            printArray(arr);
            j--;
        }
        arr.set(j + 1, key);
        printArray(arr);
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        List<Integer> arr = new ArrayList<>();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }

        insertionSort1(n, arr);
    }
}
