class Solution {
    public String minWindow(String s, String t) {
        if(s.length()<t.length()) return "";
        Map<Character,Integer> map=new HashMap<>();
        for(char c:t.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        int matched=0,mws=-1,mwe=-1,min=Integer.MAX_VALUE,ws=0,we=0;
        while(we<s.length()) {
            char right = s.charAt(we);
            if(map.containsKey(right)){
                map.put(right,map.get(right)-1);
                if(map.get(right)==0){
                    matched++;
                }
            }
            while(matched == map.size()) //shrink
            {
                if(min>we-ws+1){
                    min = we-ws+1;
                    mws=ws;
                    mwe=we;
                }
                char left = s.charAt(ws);
                if(map.containsKey(left)) {
                    if(map.get(left) ==0){
                        matched--;
                    }
                    map.put(left,map.get(left)+1);
                }
                ws++;
            }
            we++;
        }
        if(mwe==-1){
            return "";
        }
        return s.substring(mws,mwe+1);
    }
}