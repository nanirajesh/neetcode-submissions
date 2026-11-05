class Solution {
    public int maxSubArray(int[] nums) {
        int max=nums[0];
        int prevSum=max;
        for(int i=1;i<nums.length;i++){
           if(nums[i] > nums[i]+prevSum){
             prevSum=nums[i];
           }else{
            prevSum = nums[i]+prevSum;
           }
           max=Math.max(max,prevSum);
        }
        return max;
    }
}
