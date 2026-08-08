class Solution {
    public String removeOccurrences(String s, String part) {
        StringBuilder sb = new StringBuilder();
        
        int n = part.length();
        
        for (char c : s.toCharArray()) {
            sb.append(c);
            
            if (sb.length() >= n) {
                if (sb.substring(sb.length() - n).equals(part)) {
                    sb.delete(sb.length() - n, sb.length()); //delete(start, end)
                }
            }
        }
        
        return sb.toString();
    }
}