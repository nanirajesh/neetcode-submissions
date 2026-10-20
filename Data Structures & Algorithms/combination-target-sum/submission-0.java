class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        util(nums,0,result,new ArrayList<Integer>(),target);
        return result;
    }

    private void util(int[] nums , int index, List<List<Integer>> result, List<Integer> temp , int target) {
        if(target <0) return ;
        if(target == 0) {
            result.add(new ArrayList<Integer>(temp));
            return;
        }

        for(int i=index;i<nums.length;i++){
            temp.add(nums[i]);
            util(nums,i,result,temp,target-nums[i]);
            temp.remove(temp.size()-1);
        }
    }
}
