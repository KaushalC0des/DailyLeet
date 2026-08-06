class Solution {
    public String simplifyPath(String path) {
        Deque<String> stack = new ArrayDeque<>();

        String[] components = path.split("/");

        for(String dir : components){
            if(dir.equals("") || dir.equals(".")){
                continue;
            }

            if(dir.equals("..")){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            } else {
                stack.push(dir);
            }
        }   

        StringBuilder result = new StringBuilder();

        while (!stack.isEmpty()) {
            result.append("/").append(stack.pollLast());
        }  

        return result.length() == 0 ? "/" : result.toString();          
    }
}