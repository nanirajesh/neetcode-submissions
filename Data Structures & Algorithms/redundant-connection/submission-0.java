class UnionFind{
    int[] parent;
    UnionFind(int num){
        parent=new int[num];
        for(int i=0;i<num;i++){
            parent[i]=i;
        }
    }
    int find(int node1){
        if(parent[node1]==node1)
        return node1;

        parent[node1]=find(parent[node1]);
        return parent[node1];
    }

    boolean union(int node1,int node2){
        int root1=find(node1);
        int root2=find(node2);


        if(root1==root2)
        return false;

        parent[root1]=root2;
        return true;
    }
}
class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        UnionFind uf=new UnionFind(edges.length+1);
        int[] result = new int[2];
        for(int[] edge:edges){
            if(!uf.union(edge[0],edge[1]))
            {
                result=edge;
            }
        }
        return result;
    }
}
