class Solution {
    public boolean isAnagram(String s, String t) {
       if(s.length() != t.length()){
        return false;
       }   
       int[] Counts = new int  [26];
       for(int i = 0; i<s.length(); i++){
            Counts[s.charAt(i) - 'a']++;
            Counts[t.charAt(i) - 'a']--;
       }
       for(int count : Counts) {
            if(count != 0){
                return false;
            }
       } 
       return true;      
    }
}