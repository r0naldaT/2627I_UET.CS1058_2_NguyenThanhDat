package homework.week11.laptrinh;

import java.util.*;


public class b5_missing_numbers {
    public static List<Integer> missingNumbers1(List<Integer> arr, List<Integer> brr) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int n: brr){
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        for(int n: arr){
            map.put(n, map.get(n) - 1);
        }
        List<Integer> res = new ArrayList<>();
        for (int n : brr) {
            if (map.get(n) > 0) {
                res.add(n);
                map.put(n, 0);
            }
        }
        Collections.sort(res);
        return res;
    }

    public static List<Integer> missingNumbers2(List<Integer> arr, List<Integer> brr) {
        Collections.sort(arr);
        Collections.sort(brr);
        List<Integer> res = new ArrayList<>();
        int i = 0; int j = 0;
        while (i < arr.size() && j < brr.size()){
            if (arr.get(i).equals(brr.get(j))){
                i++;
                j++;
            }
            else{
                if (!res.isEmpty() && brr.get(j).equals(res.get(res.size() - 1))){
                    j++;
                }
                else{
                    res.add(brr.get(j));
                    j++;
                }
            }
        }
        while (j < brr.size()){
            if (!res.isEmpty() && brr.get(j).equals(res.get(res.size() - 1))){
                j++;
            }
            else{
                res.add(brr.get(j));
                j++;
            }
        }
        return res;
    }

    public static List<Integer> missingNumbers3(List<Integer> arr, List<Integer> brr) {
        int min = Collections.min(brr);

        int[] count = new int[101];

        for (int n : brr) {
            count[n - min]++;
        }

        for (int n : arr) {
            count[n - min]--;
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0) {
                res.add(i + min);
            }
        }

        return res;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập số lượng phần tử của arr: ");
        int n = scanner.nextInt();
        List<Integer> arr = new ArrayList<>();
        System.out.println("Nhập " + n + " phần tử của arr:");
        for (int i = 0; i < n; i++) {
            arr.add(scanner.nextInt());
        }

        System.out.print("Nhập số lượng phần tử của brr: ");
        int m = scanner.nextInt();
        List<Integer> brr = new ArrayList<>();
        System.out.println("Nhập " + m + " phần tử của brr:");
        for (int i = 0; i < m; i++) {
            brr.add(scanner.nextInt());
        }

        List<Integer> result = missingNumbers1(arr, brr);
        System.out.println("Các số bị thiếu là: " + result);

        scanner.close();
    }
}
