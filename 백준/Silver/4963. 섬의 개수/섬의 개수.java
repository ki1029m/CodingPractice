import java.io.*;
import java.util.*;

public class Main {
	
	static int W, H;
	static int[][] arr;
	static boolean[][] visit;
	static int[] dx = {-1,0,1,0,-1,-1,1,1};
	static int[] dy = {0,1,0,-1,-1,1,1,-1};
	
	static class Pos{
		int x;
		int y;
		
		public Pos(int x, int y) {
			this.x=x;
			this.y=y;
		}
	}
	
	static void bfs(int x, int y) {
		Queue<Pos> q = new LinkedList<Pos>();
		visit[x][y] = true;
		q.offer(new Pos(x,y));
		
		while(!q.isEmpty()) {
			Pos p= q.poll();
			for(int i=0; i<8; i++) {
				int nx = p.x+dx[i];
				int ny = p.y+dy[i];
				//주변이 범위 안에 있고 방문한 적이 없고 섬인 경우만 탐색 
				if((0<=nx&&nx<H) && (0<=ny&&ny<W) && (!visit[nx][ny]) && (arr[nx][ny]==1)) {
					q.offer(new Pos(nx,ny));
					visit[nx][ny] = true;
				}
			}
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			
			if(W==0 && H==0) {
				break;
			}
			arr = new int[H][W];
			visit = new boolean[H][W];
			
			int result=0;
			//배열 저장
			for(int i=0; i<H; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<W; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			//알고리즘 실행
			for(int i=0; i<H; i++) {
				for(int j=0; j<W; j++) {
					//방문하지 않았고 땅(1)이라면 가능한 길(섬)을 모두 탐색
					if(!visit[i][j] && arr[i][j]==1) {
						bfs(i,j);
						result++;
						
					}
				}
			}
			System.out.println(result);
		}
	}
}
