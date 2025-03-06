import java.io.*;
import java.util.*;


public class Solution {

	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static int result;
	
	static void dfs(int N, int K, int[][] arr, boolean[][][] visit, int x, int y, int length, int cut) {
		
		for(int d=0; d<4; d++) {
			int nx = x+dx[d];
			int ny = y+dy[d];
			
			if(!(0<=nx&&nx<N&&0<=ny&&ny<N)) continue;
			
			
			//안바꾸고 그대로
			if( (arr[nx][ny] < arr[x][y]) && !visit[nx][ny][cut]) {
				visit[nx][ny][cut]= true;
				dfs(N, K, arr, visit, nx, ny, length+1, cut);
				visit[nx][ny][cut]= false;
			}
			
			
			//기회가 남아 있을때 산 깎기
			//왔던 곳은 깎으면 안됨
			if(cut == 1 && !visit[nx][ny][cut]) {
				for(int k=1; k<=K; k++) {
					if(arr[nx][ny]-k < 0) continue;
					
					arr[nx][ny] = arr[nx][ny]-k;
					if( (arr[nx][ny] < arr[x][y]) && !visit[nx][ny][0]) {
						visit[nx][ny][0]= true;
						dfs(N, K, arr, visit, nx, ny, length+1, 0);
						visit[nx][ny][0]= false;
					}
					//원복
					arr[nx][ny] = arr[nx][ny]+k;
				}
			}
		}
		
		result = Math.max(result, length);
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			StringTokenizer st= new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			int[][] arr = new int[N][N];
			
			int max = 0;
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					max = Math.max(max, arr[i][j]);
				}
			}
			
			result=0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(arr[i][j] == max) {
						boolean[][][] visit = new boolean[N][N][2];
						visit[i][j][0]=true;
						dfs(N, K, arr, visit, i, j, 1, 1);
					}
				}
			}
			
			
			System.out.println("#"+t+" "+result);
		}
		
	}

}
