class Solution {
    public int[] findErrorNums(int[] nums) {
            int dup = -1;
            int missing = -1; 

            for(int i = 0; i < nums.length; i++){
                int val = Math.abs(nums[i]);
                if(nums[val - 1] < 0){
                    dup = val;
                } else {
                    nums[val-1] *= -1;
                }
            }

            for(int i = 0; i < nums.length; i++){
                if(nums[i] > 0){
                    missing = i+1;
                }
            }
            return new int[]{dup, missing};          
    }
}