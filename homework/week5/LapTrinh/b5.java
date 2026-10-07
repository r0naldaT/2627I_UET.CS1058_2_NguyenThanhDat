package homework.week5.LapTrinh;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class b5 {
    public static List<Integer> quickSort(List<Integer> arr) {
        // Write your code here
        int pivot = arr.get(0);

        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> equal = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();

        for(int num: arr){
            if (num < pivot){
                left.add(num);
            }
            else if (num == pivot){
                equal.add(num);
            }
            else{
                right.add(num);
            }
        }
        int i = 0;
        for(int n: left){
            arr.set(i, n);
            i++;
        }
        for(int n: equal){
            arr.set(i, n);
            i++;
        }
        for(int n: right){
            arr.set(i, n);
            i++;
        }
        return arr;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }
        quickSort(arr);
        for(int num: arr){
            System.out.print(num + " ");
        }

    }
}
