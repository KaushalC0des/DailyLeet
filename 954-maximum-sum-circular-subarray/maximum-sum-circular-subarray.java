class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int total_sum = nums[0];
        int max_ending_here = nums[0];
        int max_so_far = nums[0];
        int min_ending_here = nums[0];
        int min_so_far = nums[0];

        for(int i = 1; i<nums.length; i++){
            total_sum += nums[i];

            max_ending_here = Math.max(nums[i], max_ending_here+nums[i]);
            max_so_far = Math.max(max_so_far,max_ending_here);

            min_ending_here = Math.min(nums[i], nums[i]+min_ending_here);
            min_so_far = Math.min(min_so_far, min_ending_here);
        }

        if(max_so_far < 0){
            return max_so_far;
        }

        return Math.max(max_so_far, total_sum-min_so_far);
    }
}