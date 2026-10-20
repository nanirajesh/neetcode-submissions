/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
       if(intervals.size()==0) return 0;
       Collections.sort(intervals,(a,b)->a.start-b.start);
       int minRooms = 1;
       PriorityQueue<Interval> minHeap = new PriorityQueue<>((a,b)->a.end-b.end);
       minHeap.add(intervals.get(0));
       for(int i=1;i<intervals.size();i++){
        if( minHeap.peek().end <= intervals.get(i).start){
            minHeap.poll();
        }
            minHeap.offer(intervals.get(i));
            minRooms = Math.max(minRooms , minHeap.size());
        
       }
       return minRooms;
    }
}
