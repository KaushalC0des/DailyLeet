class Solution {
    public String decodeString(String s) {
        Stack<Integer> numStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();
        String result = "";

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            
            if(Character.isDigit(c)){
                int num = 0;
                while(i < s.length() && Character.isDigit(s.charAt(i))){
                    num = num * 10 + (s.charAt(i) - '0');
                    i++;
                }
                i--;  
                numStack.push(num);
            } 
            else if(c == '['){
                stringStack.push("[");
            } 
            else if(c == ']'){
                String temp = "";
                
                while(!stringStack.isEmpty() && !stringStack.peek().equals("[")){
                    temp = stringStack.pop() + temp;
                }
                
                if(!stringStack.isEmpty()) {
                    stringStack.pop();
                }
                
                int num = numStack.pop();
                
                String repeated = "";
                for(int j = 0; j < num; j++){
                    repeated += temp;
                }
                
                stringStack.push(repeated);
            } 
            else {
                stringStack.push(String.valueOf(c));
            }
        }
        
        while (!stringStack.isEmpty()) {
            result = stringStack.pop() + result;
        }
        
        return result;
    }
}