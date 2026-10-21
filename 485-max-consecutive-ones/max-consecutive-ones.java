class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int finalcount = 0;   

        for(int i = 0; i<nums.length; i++){
            if(nums[i] == 1){
                count++;
            } else {
                finalcount = Math.max(finalcount,count);
                count = 0;
            }
        } 
        return Math.max(finalcount, count);  
    }
}