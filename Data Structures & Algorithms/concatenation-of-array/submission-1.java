class Solution {
    public int[] getConcatenation(int[] nums) {
        int[] result = new int[2*nums.length];
        int n=nums.length;
        for(int i=0;i<n;i++){
            result[i] = nums[i];
            result[i+n]=nums[i];
        }
        return result;
    }
}