class Solution {
    public int heightChecker(int[] heights) {
        int min = Integer.MAX_VALUE;
        int max = 0;
        for(int i = 0; i<heights.length; i++){
            max = Math.max(max,heights[i]);
            min = Math.min(min,heights[i]);
        }

        int[] count = new int[max+1];
        for(int i = 0; i<heights.length; i++){
            count[heights[i]]++;
        }
        int[] expected = heights.clone();
        int val = 0;
        for(int i = min; i<max+1; i++){
            while(count[i] > 0){
                expected[val] = i;
                val++;
                count[i]--;
            }
        }

        int ans = 0;
        for(int i = 0; i<heights.length; i++){
            if(expected[i] != heights[i]){
                ans++;
            }
        }
        return ans;

    }
}