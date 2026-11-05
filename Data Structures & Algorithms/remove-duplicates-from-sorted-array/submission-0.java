class Solution {
    public int removeDuplicates(int[] nums) {
        int start=0,end=0;
        while(end<nums.length){
            if(nums[start]!=nums[end]){
                start++;
                int temp=nums[start];
                nums[start]=nums[end];
                nums[end]=temp;
            }
            end++;
        }
        return start+1;
    }
}