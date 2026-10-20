class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        util(nums,0,new ArrayList<Integer>());
        return result;
    }

    private void util(int[] nums, int index ,List<Integer> temp) {
       result.add(new ArrayList<>(temp));
       for(int i=index;i<nums.length;i++){
        temp.add(nums[i]);
        util(nums,i+1,temp);
        temp.remove(temp.size()-1);
       }
    }
}
