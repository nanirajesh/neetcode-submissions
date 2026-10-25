class Solution {
    public int countComponents(int n, int[][] edges) {
       List<Integer>[] adj = new ArrayList[n];
       for(int i=0;i<n;i++){
        adj[i]=new ArrayList<Integer>();
       }
       for(int[] edge:edges){
        int u=edge[0];
        int v=edge[1];
        adj[u].add(v);
        adj[v].add(u);
       }
       int count=0;
       boolean[] visited= new boolean[n];
       for(int i=0;i<n;i++){
           if(!visited[i]){
            dfs(adj,visited,i);
            count++;
           }
       }
       return count;
    }


    private void dfs(List<Integer>[] adj,boolean[] visited,int v){
        visited[v]=true;
        List<Integer> children = adj[v];
        for(int child:children){
            if(!visited[child]){
                dfs(adj,visited,child);
            }
        }
    }
}
