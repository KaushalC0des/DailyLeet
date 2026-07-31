class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");

        if(pattern.length() != words.length) {
            return false;
        }

        Map<Character, String> charWord = new HashMap<>();
        Map<String, Character> wordChar = new HashMap<>();

        for(int i=0; i<pattern.length(); i++){
            char C = pattern.charAt(i);
            String word = words[i];
            if(charWord.containsKey(C)) {
                if(!charWord.get(C).equals(word)){
                    return false;
                }
            } else {
                charWord.put(C,word);
            }

            if (wordChar.containsKey(word)) {
                if (wordChar.get(word) != C) {
                    return false;
                }
            } else {
                wordChar.put(word, C);
            }
        }
        return true;
    }
}