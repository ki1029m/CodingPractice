import java.io.*;
import java.util.*;

class Solution {
    static int[][] arr;
    static int result = Integer.MAX_VALUE;
    
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    
    static class Pos{
        int x;
        int y;
        int cnt;
        
        Pos(int x, int y, int cnt){
            this.x=x;
            this.y=y;
            this.cnt=cnt;
        }
        
    }
    
    public int solution(int[][] maps) {
        arr = maps;
        
        bfs(0,0);
        
        return result;
    }
    
    
    static void bfs(int x, int y){
        int n = arr.length;
        int m = arr[0].length;
        
        Queue<Pos> q = new ArrayDeque<>();
        boolean[][] visit = new boolean[n][m];
        
        visit[x][y] = true;
        q.add(new Pos(x,y,1));
        
        while(!q.isEmpty()){
            Pos p = q.poll();
            if(p.x==n-1 && p.y==m-1){
                result = Math.min(result, p.cnt);
                return;
            }
            
            for(int d=0; d<4; d++){
                int nx = p.x+dx[d];
                int ny = p.y+dy[d];
                if(!(0<=nx&&nx<n && 0<=ny&&ny<m)) continue;
                if(visit[nx][ny]) continue;
                if(arr[nx][ny] == 0) continue;
                if(p.cnt > m*n ) continue;

                visit[nx][ny] = true;
                q.add(new Pos(nx,ny,p.cnt+1));
            
            }
            
        }
        
        result = -1;
        
        
    }
}