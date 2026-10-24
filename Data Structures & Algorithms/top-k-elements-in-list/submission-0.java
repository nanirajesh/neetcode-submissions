class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num:nums){
            map.put(num , map.getOrDefault(num,0)+1);
        }
        int[] result = new int[k];
        int index =0;
        PriorityQueue<Map.Entry<Integer,Integer>> minHeap = new PriorityQueue<>((a,b) -> a.getValue()-b.getValue());
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            minHeap.add(entry);
            if(minHeap.size()>k){
                minHeap.poll();
            }
        } 

        while(minHeap.size()>0) {
           Map.Entry<Integer,Integer> entry = minHeap.poll();
           result[index++] = entry.getKey();
        }
        return result;

    }
}
