class Solution
{
    public int solution(int [][]board)
    {
        int n = board.length;
        int m = board[0].length;
        int max = 0;
        
        //i,j까지 이어진 길이
        int[][] square = new int[n+1][m+1];
        
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(board[i-1][j-1] == 1){
                    square[i][j] = Math.min(square[i-1][j-1], Math.min(square[i-1][j], square[i][j-1])) + 1; 
                } else{
                    square[i][j] = Math.min(board[i-1][j-1], Math.min(square[i-1][j], square[i][j-1])); 
                }
                
                max = Math.max(max, square[i][j]);
            }
        }
        
        /*
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                System.out.print(square[i][j]+" ");
                
            }
            System.out.println();
        }*/

        
        return max*max;
    }
}