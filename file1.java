//Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

import java.util.ArrayList;
import java.util.List;

class file1 {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, "", 0, 0, n);
        return result;
    }

    private void backtrack(List<String> result, String current, int open, int close, int max){
        if (current.length() == max * 2){
            result.add(current);
            return;
        }

        if(open < max){
            backtrack(result, current + "(", open +1 , close, max);
        }

        if (close < open){
            backtrack(result, current + ")", open, close + 1, max);
        }
    }
    
     public static void main(String[] args) {
        file1 solution = new file1();

        int n = 3; // You can change this value to test with other inputs
        List<String> combinations = solution.generateParenthesis(n);

        System.out.println("Well-formed parentheses combinations for n = " + n + ":");
        for (String s : combinations) {
            System.out.println(s);
}
     }
    }