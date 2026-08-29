class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();  
        int start = 0;
        int n = s.length();
        int maxLength = 0;

        for(int end = 0; end<n; end++){
            char currChar = s.charAt(end);
            while(set.contains(currChar)){
                set.remove(s.charAt(start));
                start++;
            }
            set.add(currChar);
            maxLength = Math.max(maxLength, end-start+1);  
        }
        return maxLength;
    }
}