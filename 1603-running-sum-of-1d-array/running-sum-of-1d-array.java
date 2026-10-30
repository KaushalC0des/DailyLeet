class Solution {
    public int[] runningSum(int[] nums) {
        int n = nums.length;
        int x = nums[0];
        for(int i = 1; i<n; i++){
            nums[i] = nums[i]+x;
            x = nums[i];
        }
        return nums;
    }
}