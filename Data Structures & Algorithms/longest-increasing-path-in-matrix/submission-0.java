class Solution {
    int max=0;
    public int longestIncreasingPath(int[][] matrix) {
        Integer[][] dp = new Integer[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                max=Math.max(max,util(matrix,i,j,Integer.MIN_VALUE,dp));
            }
        }
        return max;
    }

    private int util(int[][] matrix,int row,int col,int prev,Integer[][] dp){
        if(row<0 || row==matrix.length || col<0 || col == matrix[0].length || prev>=matrix[row][col]){
            return 0;
        }
        if(dp[row][col]!=null) return dp[row][col];
        int val = matrix[row][col];
        matrix[row][col]=Integer.MIN_VALUE;
        dp[row][col] = 1+ Math.max(
            Math.max(util(matrix,row+1,col,val , dp) , util(matrix,row-1,col,val,dp)),
            Math.max(util(matrix,row,col+1,val,dp), util(matrix,row,col-1,val,dp))
            );
        matrix[row][col]=val;
        return dp[row][col]; 
    }
}
