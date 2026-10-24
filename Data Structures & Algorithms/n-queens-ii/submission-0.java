class Solution {
    public int totalNQueens(int n) {
      char[][] matrix = new char[n][n];
       for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            matrix[i][j]='.';
        }
       }
       int[] result = new int[]{0};
       backtrack(0,n,matrix,result);    
       return result[0];
    }
    private void backtrack(int row , int n , char[][] matrix, int[] result) {
        if(row>=n){
            result[0] = result[0]+1;
            return ;
        }
        for(int col=0;col<n;col++){
            if(isValid(matrix , row, col ,n)) {
            matrix[row][col]='Q';
            backtrack(row+1,n , matrix,result);
            matrix[row][col]='.';
            }
        }
    }

   private boolean isValid(char[][] matrix , int row , int col , int n) {
       for(int i=0;i<row;i++) {
        if(matrix[i][col] == 'Q') return false;
       }

       for(int i=row-1,j=col-1;i>=0 && j>=0 ; i-- ,j--) {
         if(matrix[i][j] == 'Q') return false;
       }
       
       for(int i=row-1 , j = col+1 ; i>=0 && j<n;i--,j++){
        if(matrix[i][j] == 'Q') return false;
       }

      return true;
   }
 

}