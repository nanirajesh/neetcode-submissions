public class Solution {
    class Pair {
        int node;
        int cost;
        Pair(int node,int cost){
            this.node=node;
            this.cost=cost;
        }
    }
    class Tuple{
        int stops;
        int node;
        int cost;
        Tuple(int stops,int node,int cost) {
            this.stops=stops;
            this.node=node;
            this.cost=cost;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int s, int dst, int k) {
    
        ArrayList<Pair>[] adjList=new ArrayList[n];
        Queue<Tuple> queue=new LinkedList();
        int[] totalCost = new int[n];
        for(int i=0;i<n;i++){
            totalCost[i]=Integer.MAX_VALUE;
        }
        for(int[] edge:flights){
            int src=edge[0];
            int dest=edge[1];
            int price=edge[2];
            if(adjList[src]==null){
                adjList[src]=new ArrayList<Pair>();
            }
            adjList[src].add(new Pair(dest,price));
        }
        
        
        queue.add(new Tuple(0,s,0));
        
        while(!queue.isEmpty())
        {
            Tuple t = queue.remove();
            int stop=t.stops;
            int src=t.node;
            int cost=t.cost;
            
            //neighbours
            List<Pair> neighbours = adjList[src];
            if(neighbours!=null) {
            for(int i=0;i<neighbours.size();i++) {
             Pair p = neighbours.get(i);
            if(cost + p.cost < totalCost[p.node] && stop<=k) {
                totalCost[p.node]=cost+p.cost;
                queue.add(new Tuple(stop+1,p.node,cost+p.cost));
            }
        }
            }
        }
        return totalCost[dst]==Integer.MAX_VALUE?-1:totalCost[dst];
    }
}