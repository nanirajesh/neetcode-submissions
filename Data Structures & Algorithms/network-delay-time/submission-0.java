class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<int[]>[] graph = new ArrayList[n+1];

        for (int i = 1; i <=n; i++) {
            graph[i] = new ArrayList<>();
        }
        for(int[] time:times){
            int u=time[0];
            int v=time[1];
            int w=time[2];

            graph[u].add(new int[]{v,w});
        }
       int[] dist = new int[n+1];
       Arrays.fill(dist,Integer.MAX_VALUE);
       dist[k]=0;
       //sort by distance
       PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b)->a[0]-b[0]);
       minHeap.add(new int[]{0,k});


while (!minHeap.isEmpty()) {

    int[] minNode = minHeap.poll();

    int distance = minNode[0];
    int node = minNode[1];

    // Ignore outdated entries
    if (distance > dist[node]) {
        continue;
    }

    for (int[] neighbour : graph[node]) {

        int nextNode = neighbour[0];
        int weight = neighbour[1];

        int newDistance = distance + weight;

        if (newDistance < dist[nextNode]) {

            dist[nextNode] = newDistance;

            minHeap.offer(
                new int[]{newDistance, nextNode}
            );
        }
    }
}

int result = 0;

for (int i = 1; i <= n; i++) {

    if(dist[i]==Integer.MAX_VALUE) return -1;

    result = Math.max(result,dist[i]);
}

return result;
       
    }
}