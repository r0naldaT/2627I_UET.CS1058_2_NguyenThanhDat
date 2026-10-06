package homework.week5.LapTrinh;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class b1 {
    public static int introTutorial(int V, List<Integer> arr) {
        // Write your code here
        int l = 0;
        int r = arr.size() - 1;

        while (l <= r){
            int m = l + (r - l) / 2;
            if (arr.get(m) == V){
                return m;
            }
            else if (arr.get(m) > V){
                r = m - 1;
            }
            else{
                l = m + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int n = sc.nextInt();
        List<Integer> arr = new ArrayList<>();

        for(int i = 0; i < n; i++){
            arr.add(sc.nextInt());
        }
        System.out.println(introTutorial(V, arr));
    }
}
