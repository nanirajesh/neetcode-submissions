class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] lis=new int[nums.length];
        int max=0;
        for(int i=0;i<nums.length;i++){
            int tempMax=0;
            for(int j=i-1;j>=0;j--){
                if(nums[i]>nums[j]){
                    tempMax = Math.max(tempMax,lis[j]);
                }
            }
            lis[i]=1+tempMax;
            max=Math.max(max,lis[i]);
        }
        return max;
    }
}
