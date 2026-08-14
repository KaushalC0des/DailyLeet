class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<> ();

        backTrack(resultList, new ArrayList<>(), nums);
        return resultList;
        
    }
    private void backTrack(List<List<Integer>> resultList,ArrayList<Integer> tempList, int[] nums){
        if(tempList.size() == nums.length){
            resultList.add(new ArrayList<>(tempList));
            return;
        }
        for(int number : nums){
            // skip we get the same element
            if(tempList.contains(number))
            continue;

            // add the new element
            tempList.add(number);

            // go backto other element
            backTrack(resultList, tempList,  nums);

            // remove the number
            tempList.remove(tempList.size()-1);
        }
    }
}