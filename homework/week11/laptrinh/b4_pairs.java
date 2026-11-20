package homework.week11.laptrinh;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class b4_pairs {
    public static int pairs(int k, List<Integer> arr) {
        HashSet<Integer> set = new HashSet<>();
        for(int n: arr){
            set.add(n);
        }
        int cnt = 0;
        for(int n : arr){
            if (set.contains(n + k)){
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập số lượng phần tử n: ");
        int n = scanner.nextInt();

        System.out.print("Nhập giá trị k: ");
        int k = scanner.nextInt();

        List<Integer> arr = new ArrayList<>();
        System.out.println("Nhập " + n + " phần tử của mảng (cách nhau bởi dấu cách hoặc xuống dòng):");
        for (int i = 0; i < n; i++) {
            arr.add(scanner.nextInt());
        }

        int result = pairs(k, arr);
        System.out.println("Số lượng cặp thỏa mãn: " + result);

        scanner.close();
    }
}
