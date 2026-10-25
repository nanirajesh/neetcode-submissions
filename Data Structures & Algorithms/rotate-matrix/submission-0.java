class Solution {
    public void rotate(int[][] matrix) {
        int start=0,end=matrix.length-1;
        while(start<end){
            int[] temp = matrix[start];
            matrix[start]=matrix[end];
            matrix[end]=temp;
            start++;
            end--;
        }
        int n = matrix.length;
        for(int i=0;i<n;i++){
          for(int j=i;j<n;j++){
            int temp = matrix[i][j];
            matrix[i][j]=matrix[j][i];
            matrix[j][i]=temp;
          }
        }
    }
}
