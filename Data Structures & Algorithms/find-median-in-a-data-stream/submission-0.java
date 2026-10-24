class MedianFinder {

  PriorityQueue<Integer> minHeap;
  PriorityQueue<Integer> maxHeap;
    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((a,b)->Integer.compare(b,a));
    }
    
    public void addNum(int num) {
      if(maxHeap.isEmpty() || num  <= maxHeap.peek()) {
        maxHeap.add(num);
       }else{
         minHeap.offer(num);
       } 
        if (maxHeap.size() > minHeap.size() + 1) {
        minHeap.offer(maxHeap.poll());
        } else if (minHeap.size() > maxHeap.size()) {
        maxHeap.offer(minHeap.poll());
       }
    }
    
    public double findMedian() {
       if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        }

        return ((double) maxHeap.peek() + minHeap.peek()) / 2;
    }
}
