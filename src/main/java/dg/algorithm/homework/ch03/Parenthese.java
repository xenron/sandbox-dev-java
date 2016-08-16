package dg.algorithm.hw.ch03;

import java.util.Stack;

public class Parenthese {

    public static void main(String[] args) {
        System.out.println(checkValid("test()"));
        System.out.println(checkValid("test[]"));
        System.out.println(checkValid("test{}"));
        System.out.println(checkValid("("));
        System.out.println(checkValid(")"));
        System.out.println(checkValid("["));
        System.out.println(checkValid("]"));
        System.out.println(checkValid("{"));
        System.out.println(checkValid("}"));
    }

    public static boolean checkValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (c == ')' || c == ']' || c == '}') {
                if (stack.size() == 0) {
                    return false;
                }
                char cpop = stack.pop();
                if (cpop == '(' && c == ')') {
                    continue;
                } else if (cpop == '[' && c == ']') {
                    continue;
                } else if (cpop == '{' && c == '}') {
                    continue;
                }
                return false;
            }
        }
        return stack.size() == 0;
    }
}
