class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int result=0;

        for(int i:nums){
            set.add(i);
        }
        for(int num:set){
           if(!set.contains(num-1)) {
            int temp = 1;
             while(set.contains(num+1)){
                temp++;
                num = num+1;
             }
            result= Math.max(temp,result);
           }
        }
        return result;
    }
}
