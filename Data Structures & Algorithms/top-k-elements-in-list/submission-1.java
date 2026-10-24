class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num:nums){
            map.put(num , map.getOrDefault(num,0)+1);
        }
        List<Integer>[] buckets = new List[nums.length+1];
        for(int key : map.keySet()){
            int freq = map.get(key);
            if(buckets[freq]== null) {
                buckets[freq] = new ArrayList<Integer>();
            }
            buckets[freq].add(key);
        }

        int[] result = new int[k];
        int index=0;
        for(int i=buckets.length-1;i>0;i--) {
            if(buckets[i]!=null) {
                List<Integer> list = buckets[i];
                for(int j=0;j<list.size();j++){
                    int val = list.get(j);
                    result[index++] = val;
                    if(index == k){
                        return result;
                    }
                }
            }
        }
        return result;
    }
}
