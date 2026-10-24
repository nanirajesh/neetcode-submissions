class Solution {
    public List<List<String>> solveNQueens(int n) {
       char[][] matrix = new char[n][n];
       for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            matrix[i][j]='.';
        }
       }
       List<List<String>> result = new ArrayList<>();
       backtrack(0,n,matrix,result);    
       return result;
    }
    private void backtrack(int row , int n , char[][] matrix, List<List<String>> result) {
        if(row>=n){
            buildSolution(result , matrix,n);
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
  
   private void buildSolution(List<List<String>> result , char[][] matrix , int n) {
    
    List<String> list = new ArrayList<>();
    for(char[] row : matrix) {
        StringBuilder sb = new StringBuilder();
           for(char c:row){
            sb.append(c);
           }
           list.add(sb.toString());
       }
    result.add(list);
   }


}
