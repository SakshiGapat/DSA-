//Given a string containing just the characters '(' and ')', return the length of the longest valid (well-formed) parentheses substring.

import java.util.Stack;

public class file8 {

    public int longestValidParentheses(String s) {
        int maxLen = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1); // Initialize base index

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i); // Reset the base index
                } else {
                    maxLen = Math.max(maxLen, i - stack.peek());
                }
            }
        }

        return maxLen;
    }

    // Main method to test the solution
    public static void main(String[] args) {
        file8 solution = new file8();

        String s1 = "(()";
        String s2 = ")()())";
        String s3 = "";
        String s4 = "((()))";
        String s5 = "()(()";

        System.out.println("Input: \"" + s1 + "\" Output: " + solution.longestValidParentheses(s1)); // 2
        System.out.println("Input: \"" + s2 + "\" Output: " + solution.longestValidParentheses(s2)); // 4
        System.out.println("Input: \"" + s3 + "\" Output: " + solution.longestValidParentheses(s3)); // 0
        System.out.println("Input: \"" + s4 + "\" Output: " + solution.longestValidParentheses(s4)); // 6
        System.out.println("Input: \"" + s5 + "\" Output: " + solution.longestValidParentheses(s5)); // 2
    }
}
