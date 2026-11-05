class Solution {
    public String mergeAlternately(String word1, String word2) {
        int len = Math.min(word1.length()-1,word2.length()-1);
        StringBuffer sb = new StringBuffer("");
        int i=0;
        while(i<=len){
            sb.append(word1.charAt(i));
            sb.append(word2.charAt(i));
            i++;
        }
        if(word1.length()>word2.length()){
            sb.append(word1.substring(len+1));
        }
       if(word2.length()>word1.length()){
            sb.append(word2.substring(len+1));
        }
        return sb.toString();
    }
}