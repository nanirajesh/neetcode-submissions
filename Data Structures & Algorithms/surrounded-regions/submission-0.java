class Solution {
    public void solve(char[][] board) {
        int rows=board.length;
        int cols = board[0].length;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(i==0 || j==0 || i==rows-1 || j==cols-1){
                    dfs(board,i,j,rows,cols);
                }
            }
        }


        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++){
                if(board[i][j]=='#')
                {
                board[i][j]='O';
                }else if(board[i][j]=='O'){
                    board[i][j]='X';
                }

            }
        }

    }

    private void dfs(char[][] board , int i ,int j , int rows, int cols) {
        if(i<0 || i == rows || j<0 || j==cols || board[i][j]!='O')
        return;

        board[i][j]='#';
        dfs(board,i+1,j,rows,cols);
        dfs(board,i-1,j,rows,cols);
        dfs(board,i,j+1,rows,cols);
        dfs(board,i,j-1,rows,cols);
    }
}
