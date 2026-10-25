class Solution {
    public int lengthOfLongestSubstring(String s) {
        int start=0,end=0;
        Set<Character> set= new HashSet<>();
        int maxLen = 0;
        while(end<s.length()){
          char right=s.charAt(end);
          while(set.contains(right)){
            char left = s.charAt(start);
            set.remove(left);
            start++;
          }
          set.add(right);
          maxLen = Math.max(maxLen,end-start+1);
          end++;
        }
        return maxLen;
    }
}
