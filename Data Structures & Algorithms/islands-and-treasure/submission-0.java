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
    public void islandsAndTreasure(int[][] grid) {
        final int inf=2147483647;
        Queue<Pair> queue = new LinkedList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==0)
                queue.add(new Pair(i,j));
            }
        }
        int[] dx = new int[]{-1,1,0,0};
        int[] dy = new int[]{0,0,-1,1};
        while(!queue.isEmpty()) {
           Pair cell = queue.remove();
           for(int i=0;i<4;i++){
            int x=cell.row+dx[i];
            int y=cell.col+dy[i];
                if (x >= 0 && y >= 0 &&
                    x < grid.length && y < grid[0].length &&
                    grid[x][y] == Integer.MAX_VALUE) {

                    grid[x][y] = grid[cell.row][cell.col] + 1;

                    queue.add(new Pair(x, y));
           }
           }
        }
    }
}
