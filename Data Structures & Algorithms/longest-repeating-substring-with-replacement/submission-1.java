class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq=new int[26];
        int ws=0,we=0, maxFreq=0,maxLen=0;
        while(we<s.length()) {
           char c=s.charAt(we);
           freq[c-'A']++;
           maxFreq = Math.max(maxFreq,freq[c-'A']);
           while((we-ws+1)-maxFreq>k) {
            char start = s.charAt(ws);
            freq[start-'A']--;
            ws++;
                maxFreq = 0;
                for (int i = 0; i < 26; i++) {
                    maxFreq = Math.max(maxFreq, freq[i]);
                }
           }
           maxLen = Math.max(maxLen , we-ws+1);
           we++;
        }
        return maxLen;
    }
}
