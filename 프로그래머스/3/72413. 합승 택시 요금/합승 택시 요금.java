import java.util.*;

class Solution {
    static final int INF = 100_000_000;
    public int solution(int n, int s, int a, int b, int[][] fares) {
        // n : 숫자 개수
        // s : 시작 지점
        // a : a 목적지
        // b : b 목적지
        
        int[][] dist = new int[n+1][n+1];
        
        for(int i=0; i<fares.length; i++){
            int start = fares[i][0];
            int end = fares[i][1];
            int weight = fares[i][2];
            
            dist[start][end] = weight;
            dist[end][start] = weight;
        }
        
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(i==j) continue;
                if(dist[i][j] == 0) dist[i][j] = INF;
            }
        }
        
        for(int k=1; k<=n; k++){
            for(int i=1; i<=n; i++){
                for(int j=1; j<=n; j++){
                    dist[i][j] = Math.min(dist[i][k] + dist[k][j], dist[i][j]);
                }
            }
        }
        
        int result = dist[s][a] + dist[s][b];
        for(int k=1; k<=n; k++){
            if(dist[s][k] >= INF) continue;
            result = Math.min(dist[s][k]+dist[k][a]+dist[k][b], result);
        }
        
        
        return result;
    }
}