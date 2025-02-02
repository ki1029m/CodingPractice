import java.io.*;
import java.util.*;

public class Solution {
	static int N,result;
	static int[][] arr;
	static boolean[][] visit;
    static int[] dy = {-1,0,1,0};
    static int[] dx = {0,1,0,-1};
	
	static class Pos{
		int x;
		int y;
		public Pos(int x, int y) {
			this.x=x;
			this.y=y;
		}
	}
	
	static void bfs(int x, int y){
		Queue<Pos> q = new LinkedList<Pos>();
		visit[x][y] = true;
		q.offer(new Pos(x, y));
		while(!q.isEmpty()) {
			Pos p = q.poll();
			for(int i=0; i<4; i++) {
				int nx=p.x+dx[i];
				int ny=p.y+dy[i];
				
				if(0<=nx&&nx<N && 0<=ny&&ny<N && !visit[nx][ny] && arr[nx][ny]!=0) {
					visit[nx][ny]=true;
					q.offer(new Pos(nx,ny));
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			visit = new boolean[N][N];
			
			StringTokenizer st;
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			result = 0;
			for (int day=0; day<=100; day++) {
				visit = new boolean[N][N]; // 반복 시 마다 초기화
				int cheese=0;
				for (int i=0; i<N; i++) {
					for (int j=0; j<N; j++) {
						if (arr[i][j] == day) {
							arr[i][j] = 0;
						}
					}
				}

				for (int i=0; i<N; i++) {
					for (int j=0; j<N; j++) {
						if (arr[i][j] != 0 && !visit[i][j]) {
							bfs(i, j);
							cheese++;
						}
					}
				}
				result = Math.max(result, cheese);
			}
			System.out.println("#"+t+" "+result);
		}
	}
}
