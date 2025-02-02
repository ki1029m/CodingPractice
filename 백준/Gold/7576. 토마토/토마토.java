import java.io.*;
import java.util.*;

public class Main {
	
	static int M, N;
	static int[][] arr;
	static boolean[][] visit;
	static int result = 0;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	
	public static class Pos{
		int x;
		int y;
		public Pos(int x, int y) {
			this.x=x;
			this.y=y;
		}
	}
	
	public static void bfs() {
		Queue<Pos> phaseQ = new LinkedList<Pos>();
		Queue<Pos> playQ = new LinkedList<Pos>();
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(arr[i][j]==1) {
					visit[i][j] = true;
					phaseQ.offer(new Pos(i,j));
				}
			}
		}
		while(!phaseQ.isEmpty()) {
			while(!phaseQ.isEmpty()) {
				playQ.offer(phaseQ.poll());
			}
			while(!playQ.isEmpty()) {
				Pos p = playQ.poll();
				for(int i=0; i<4; i++) {
					int nx = p.x+dx[i];
					int ny = p.y+dy[i];
					if(0<=nx&&nx<N && 0<=ny&&ny<M && !visit[nx][ny] && arr[p.x][p.y]==1 && arr[nx][ny]==0) {
						visit[nx][ny]=true;
						arr[nx][ny]=1;
						phaseQ.offer(new Pos(nx,ny));
					}
				}
			}
			
			if(!phaseQ.isEmpty()) {
				result++;
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		visit = new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				arr[i][j]= Integer.parseInt(st.nextToken());
			}
		}
		
		bfs();
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(arr[i][j]==0 && visit[i][j]==false) {
					System.out.println(-1);
					return;
				}
			}
		}
		System.out.println(result);
	}
}
