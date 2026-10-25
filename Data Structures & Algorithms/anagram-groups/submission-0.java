class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result= new ArrayList<>();
        Map<String,List<String>> map = new HashMap<>();
        for(int i=0;i<strs.length;i++ ){
            char[] carr= strs[i].toCharArray();
            Arrays.sort(carr);
            String s= new String(carr);
            if(!map.containsKey(s)){
              map.put(s,new ArrayList<String>());
            }
            map.get(s).add(strs[i]);
        }
        for(Map.Entry<String,List<String>> entry:map.entrySet()){
            result.add(entry.getValue());
        }
        return result;
    }
}
