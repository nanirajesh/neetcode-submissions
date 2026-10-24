class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num:nums){
            map.merge(num,1,Integer::sum);
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>((a,b) -> Integer.compare(map.get(b),map.get(a)));
        for(int num:map.keySet()){
            heap.offer(num);
        }
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = heap.poll();  // take the top k
        }
        return result;
    }
}
