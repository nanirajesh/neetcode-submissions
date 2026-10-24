class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        util(nums,0,result,new ArrayList<Integer>());
        return result;
    }

    private void util(int[] nums, int index , List<List<Integer>> result, List<Integer> temp){
        result.add(new ArrayList<Integer>(temp));
       for(int i=index; i<nums.length; i++){
            if(i>index && nums[i]==nums[i-1]){
                continue;
            }
            temp.add(nums[i]);
            util(nums,i+1,result,temp);
            temp.remove(temp.size()-1);
        }
    }
}
