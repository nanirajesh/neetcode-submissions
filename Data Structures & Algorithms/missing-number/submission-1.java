class Solution {
    public int missingNumber(int[] nums) {
        int len= nums.length;
        int result = 0;
        for(int i=1;i<=len;i++){
            result^=i;
        }
        for(int num:nums){
            result^=num;
        }
        return result;
    }
}