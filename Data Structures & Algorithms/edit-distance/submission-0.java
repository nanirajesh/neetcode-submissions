class Solution {
    public int minDistance(String word1, String word2) {
        int rows= word1.length();
        int cols = word2.length();
        int[][] dp = new int[rows+1][cols+1];
        for(int i=0;i<=rows;i++){
            for(int j=0;j<=cols;j++){
                if(i==0){
                    dp[0][j]=j;
                }
                else if(j==0){
                   dp[i][0]=i;
                }else{
                    if(word1.charAt(i-1) == word2.charAt(j-1)){
                        dp[i][j]=dp[i-1][j-1];
                    }else{
                        dp[i][j] = 1+ Math.min(dp[i-1][j-1] , Math.min(dp[i-1][j], dp[i][j-1]));
                    }
                }
            }
        }
        return dp[rows][cols];
    }
}
