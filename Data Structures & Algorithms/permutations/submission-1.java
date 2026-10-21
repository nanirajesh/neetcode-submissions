class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        util(nums,result,0);
        return result;
    }
    private void util(int[] nums, List<List<Integer>> result , int index) {
        if(index == nums.length){
            List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
            result.add(list);
            return;
        }
        for(int i=index;i<nums.length;i++){
            swap(nums,i,index);
            util(nums,result,index+1);
            swap(nums,i,index);
        }
    }
    private void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
