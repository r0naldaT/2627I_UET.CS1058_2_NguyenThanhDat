package homework.week3.LapTrinh;

import java.util.Stack;

public class balancedBrackets {
    public static String isBalanced(String s) {
         if (s.length() % 2 == 1){
             return "NO";
         }
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            }
            else {
                if (stack.isEmpty() || c != stack.pop()) {
                    return "NO";
                }
            }
        }
        if (!stack.isEmpty()){
            return "NO";
        }
        return "YES";
    }
}