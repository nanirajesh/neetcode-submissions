class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> permute(int[] nums) {
        result = new ArrayList<>();
        util(nums,0);
        return result;
    }

    private void util(int[] nums , int index) {
        if(index == nums.length){
            List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
            result.add(list);
            return;
        }

        for(int i=index;i<nums.length;i++){
            swap(nums , i , index );
            util(nums,index+1);
            swap(nums, index, i);
        }
    }
    private void swap(int[] nums , int i , int j){
        int temp = nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
