package homework.week5.LapTrinh;

import java.util.Scanner;

public class b6 {
    public static void quickSort(int[] arr, int start, int end){
        if (start >= end){
            return;
        }
        int pivot = partition(arr, start, end);
        quickSort(arr, start, pivot - 1);
        quickSort(arr, pivot + 1, end);
    }

    public static int partition(int[] arr, int start, int end){
        int pivot = arr[end];

        int i = start - 1;
        for (int j = start; j <= end - 1; j++) {
            if (arr[j] < pivot){
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        i++;
        int temp = arr[i];
        arr[i] = pivot;
        arr[end] = temp;
        for(int n: arr){
            System.out.print(n+" ");
        }
        System.out.println();
        return i;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        quickSort(arr, 0 , arr.length - 1);
    }
}
