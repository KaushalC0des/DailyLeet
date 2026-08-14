class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] used  = new boolean[nums.length];
        backTrack(nums, new ArrayList<>(), used, result);
        return result;        
    }

    private void backTrack(int[] nums, List<Integer> path, boolean[] used, List<List<Integer>> result){
        if(path.size() == nums.length){
            result.add(new ArrayList<>(path));
            return;
        }

        for(int i=0; i<nums.length; i++){
            if(used[i]) continue;

            if(i > 0 && nums[i] == nums[i-1] && !used[i-1]) continue;  // this condition is when both intgers are same but we are we are trying for other index \
            path.add(nums[i]);
            used[i] = true;
            backTrack(nums,path,used,result);
            path.remove(path.size()-1);
            used[i] = false;

        }
    }
}