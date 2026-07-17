class Solution {
    public String minWindow(String s, String t) {

        // Frequency array for characters int
        int[] freq = new int[128];

        // Store frequency of t characters
        for(char ch : t.toCharArray()) {
            freq[ch]++;
        }

        int left = 0;
        int right = 0;

        // Total characters needed
        int count = t.length();

        // Variables for minimum window
        int minLen = Integer.MAX_VALUE;
        int start = 0;

        while(right < s.length()) {

            char rightChar = s.charAt(right);

            // If character is needed
            if(freq[rightChar] > 0) {
                count--;
            }

            // Decrease frequency
            freq[rightChar]--;

            // Window valid
            while(count == 0) {

                // Update minimum window
                if(right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }

                char leftChar = s.charAt(left);

                // Remove left character from window
                freq[leftChar]++;

                // Required character lost
                if(freq[leftChar] > 0) {
                    count++;
                }

                left++;
            }

            right++;
        }

        // No valid window found
        if(minLen == Integer.MAX_VALUE) {
            return "";
        }

        return s.substring(start, start + minLen);
    }
}