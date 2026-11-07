class Pair {
    int row;
    int col;
    Pair(int row,int col)
    {
        this.row=row;
        this.col=col;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        int fresh=0;
        Queue<Pair> queue = new LinkedList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2)
                queue.add(new Pair(i,j));

                if(grid[i][j]==1){
                    fresh++;
                }
            }
        }
        if(fresh ==0) return 0;
        int[] dx = new int[]{-1,1,0,0};
        int[] dy = new int[]{0,0,-1,1};
        int minutes=0;
        while(!queue.isEmpty() ) {
            int size=queue.size();
            while(size-->0) {
           Pair cell = queue.remove();
           for(int i=0;i<4;i++){
            int x=cell.row+dx[i];
            int y=cell.col+dy[i];
                if (x >= 0 && y >= 0 &&
                    x < grid.length && y < grid[0].length &&
                    grid[x][y] == 1) {

                    grid[x][y] = 2;
                    fresh--;

                    queue.add(new Pair(x, y));
           }
           }
        }
         minutes++;
        }
        return fresh==0?minutes-1 : -1;
    }
}
