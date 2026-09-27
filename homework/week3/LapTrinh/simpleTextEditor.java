package homework.week3.LapTrinh;
import java.util.Scanner;
import java.util.Stack;

public class simpleTextEditor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<String> stack = new Stack<>();

        int q = sc.nextInt();
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < q; i++) {
            int t = sc.nextInt();
            if (t == 1){
                String s = sc.next();
                stack.push(res.toString());
                res.append(s);
            }
            else if (t == 2){
                int k = sc.nextInt();
                stack.push(res.toString());
                res.delete(res.length() - k,res.length());
            }
            else if (t == 3){
                int k = sc.nextInt();
                System.out.println(res.charAt(k - 1));
            }
            else{
                if (!stack.isEmpty()){
                    res = new StringBuilder(stack.pop());
                }
            }
        }
    }
}
