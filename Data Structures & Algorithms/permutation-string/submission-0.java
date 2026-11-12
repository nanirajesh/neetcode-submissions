class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s1.length();i++){
            map.put(s1.charAt(i),map.getOrDefault(s1.charAt(i),0)+1);
        }
        int matched=0;
        for(int i=0;i<s2.length();i++){
            char rightChar=s2.charAt(i);
            if(map.containsKey(rightChar)){
                map.put(rightChar,map.get(rightChar)-1);
                if(map.get(rightChar)==0)
                    matched++;
            }
            int k=s1.length();
            if(i>=k-1){
                if(matched==map.size())
                    return true;
                char leftChar=s2.charAt(i-k+1);
                if(map.containsKey(leftChar)){
                    if(map.get(leftChar)==0){
                        matched--;
                    }
                    map.put(leftChar,map.get(leftChar)+1);
                }
            }
        }
        return false;
    }
}