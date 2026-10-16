import java.util.Stack;

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
           
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                
                int right = stack.pop();
                int left = stack.pop();
                int result = 0;

                switch (token) {
                    case "+":
                        result = left + right;
                        break;
                    case "-":
                        result = left - right;
                        break;
                    case "*":
                        result = left * right;
                        break;
                    case "/":
                        result = left / right; 
                        break;
                }
               
                stack.push(result);
            } else {
               
                stack.push(Integer.parseInt(token));
            }
        }

      
        return stack.pop();
    }
}