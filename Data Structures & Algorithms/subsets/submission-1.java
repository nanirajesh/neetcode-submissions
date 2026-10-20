class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        util(nums,0,result,new ArrayList<Integer>());
        return result;
    }

    private void util(int[] nums, int index , List<List<Integer>> result, List<Integer> temp){
        result.add(new ArrayList<Integer>(temp));

        for(int i=index;i<nums.length;i++){
            temp.add(nums[i]);
            util(nums,i+1,result,temp);
            temp.remove(temp.size()-1);
        }
    }
}
