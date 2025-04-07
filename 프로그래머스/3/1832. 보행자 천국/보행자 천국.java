class Solution {
    int MOD = 20170805;
    public int solution(int m, int n, int[][] cityMap) {
        
        int[][][] cases= new int[m+1][n+1][2]; // 마지막이 0이면 가로 1이면 세로에서 온 경우
        cases[1][1][0] = 1;
        //cases[1][1][1] = 0;
        
        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                if(cityMap[i-1][j-1] == 1) continue;
                
                //가로
                if(j>1){
                    if(cityMap[i-1][j-2] == 2){ //이전 가로칸이 2였다면
                        cases[i][j][0] = cases[i][j-1][0];
                    } else{
                        cases[i][j][0] = (cases[i][j-1][0] + cases[i][j-1][1])% MOD;
                    }
                }
                
                //세로
                if(i>1){
                    if(cityMap[i-2][j-1] == 2) //이전 세로칸이 2였다면
                        cases[i][j][1] = cases[i-1][j][1]; // 직진만 가능
                    else
                        cases[i][j][1] = (cases[i-1][j][1] + cases[i-1][j][0])% MOD;
                }
            }
        }
        return (cases[m][n][0]+cases[m][n][1]) % MOD;
        
    }
}