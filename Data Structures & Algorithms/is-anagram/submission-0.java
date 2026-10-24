class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character,Integer> map = new HashMap<>();
        for(char c : s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        for(char c:t.toCharArray()){
            if(!map.containsKey(c))
            return false;
            int freq = map.get(c);
            freq--;
            if(freq==0){
                map.remove(c);
            }else{
                map.put(c,freq);
            }
        }
        return map.size()==0? true:false;
    }
}
