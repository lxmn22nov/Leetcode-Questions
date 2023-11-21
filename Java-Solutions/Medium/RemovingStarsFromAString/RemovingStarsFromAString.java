package Medium.RemovingStarsFromAString;

import java.util.Stack;

public class RemovingStarsFromAString {
    public static String removeStars(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '*') {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String s = "leet**cod*e";
        System.out.println("Removing stars from a string: " + removeStars(s));
    }
}