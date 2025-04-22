class Solution {
    
    static int result = 0;
    
    int solution(int[][] land) {
        
        int n = land.length;
        
        int[][] dp = new int[n][4];
        
        dp[0][0] = land[0][0];
        dp[0][1] = land[0][1];
        dp[0][2] = land[0][2];
        dp[0][3] = land[0][3];
        
        for(int i=1; i<n; i++){
            for(int j=0; j<4; j++){
                
                for(int k=0; k<4; k++){
                    if(j != k){
                        dp[i][j] = Math.max(dp[i][j], land[i][j] + dp[i-1][k] );
                    }
                                       
                }
            }
        }
        
        return Math.max( Math.max(dp[n-1][0],dp[n-1][1] ), Math.max(dp[n-1][2], dp[n-1][3]) );
        
    }
    
}