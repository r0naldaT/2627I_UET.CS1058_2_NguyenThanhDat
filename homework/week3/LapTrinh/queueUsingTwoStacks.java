package homework.week3.LapTrinh;
import java.util.Scanner;
import java.util.Stack;


public class queueUsingTwoStacks {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int q = sc.nextInt();
        Stack<Integer> stackIn = new Stack<>();
        Stack<Integer> stackOut = new Stack<>();


        for (int i = 0; i < q; i++) {
            int n = sc.nextInt();
            if (n == 1){
                int v = sc.nextInt();
                stackIn.push(v);
            }
            else if (n == 2){
                if (!stackOut.isEmpty()){
                    stackOut.pop();
                }
                else{
                    while(!stackIn.isEmpty()){
                        stackOut.push(stackIn.pop());
                    }
                    stackOut.pop();
                }
            }
            else{
                if (!stackOut.isEmpty()){
                    System.out.println(stackOut.peek());
                }
                else{
                    while(!stackIn.isEmpty()){
                        stackOut.push(stackIn.pop());
                    }
                    System.out.println(stackOut.peek());
                }
            }
        }
    }
}
