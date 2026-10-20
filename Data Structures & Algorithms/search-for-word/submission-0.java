class Solution {
    public boolean exist(char[][] board, String word) {
        int rows=board.length,cols=board[0].length;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(board[i][j]==word.charAt(0)){
                    if(search(board , i , j ,rows ,cols ,0,word))
                     return true;
                }
            }
        }
        return false;
    }

    private boolean search(char[][] board,int row, int col , int rows, int cols , int index,String word) {
        if(index == word.length()) return true;
        if(row<0 || col<0 || row == rows || col == cols || board[row][col]!=word.charAt(index)){
            return false;
        }
      char temp = board[row][col];
      board[row][col]='*';
      boolean exist =  search(board,row+1,col,rows,cols,index+1,word)
            ||
            search(board,row-1,col,rows,cols,index+1,word)
            ||
            search(board,row,col+1,rows,cols,index+1,word)
            ||
            search(board,row,col-1,rows,cols,index+1,word);
       board[row][col]=temp;
       return exist;    
    }
}
