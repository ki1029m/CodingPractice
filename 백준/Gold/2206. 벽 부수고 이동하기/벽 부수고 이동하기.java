import java.io.*;
import java.util.*;


public class Main {
	static int N, M, result;
	static int[][] arr;
	static boolean[][][] visit;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	
	public static class Pos{
		int x;
		int y;
		int dist;
		int state; //벽을 부순적이 있다면 1;
		
		public Pos(int x, int y, int dist, int state) {
			this.x=x;
			this.y=y;
			this.dist=dist;
			this.state=state;
		}
	}
	
	public static void bfs(int x, int y, int d, int s) {
		Queue<Pos> q = new LinkedList<Pos>();
		visit[x][y][s] = true;
		q.offer(new Pos(x,y,d,s));
		
		while(!q.isEmpty()) {
			Pos p= q.poll();
			//종료조건: 끝에 도달했을 때
			if(p.x==N-1 && p.y==M-1) {
				result = p.dist;
				return;
			}
			
			for(int i=0; i<4; i++) {
				int nx = p.x+dx[i];
				int ny = p.y+dy[i];
				//범위체크
				//방문조건
				//(벽이 없을 경우) 1.방문한 적이 없을 때
				//(벽이 있을 경우) 1.현재 벽을 부순적이 없을 때 2.방문한 적이 없을 때
				if((0<=nx&&nx<N) && (0<=ny&&ny<M)) {
					//벽이 없을 경우
					if(arr[nx][ny]==0) {
						//방문한 적이 없을 때
						if(!visit[nx][ny][p.state]) {
							visit[nx][ny][p.state] = true; //방문처리
							q.offer(new Pos(nx,ny, p.dist+1, p.state));
						}
					//벽일 경우
					}else if(arr[nx][ny]==1) {
						//현재 벽을 부순적이 없고, 방문한 적이 없을 때
						 if(p.state==0 && !visit[nx][ny][1]) {
							 visit[nx][ny][1] = true;
							 q.offer(new Pos(nx,ny,p.dist+1,1));
						 }
					}
				}
			}
		}
		//종료조건으로 끝나지 않았을 경우
		result = -1;
		return;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		visit = new boolean[N][M][2]; //부순적이 없다면 0에 저장, 있다면 1에 저장		
		//배열 입력받기
		for(int i=0; i<N; i++) {
			String line = br.readLine();
			for(int j=0; j<M; j++) {
				arr[i][j] = line.charAt(j)-'0';
			}
		}
		/*
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
		*/
		bfs(0,0,1,0);
		System.out.println(result);
		
	}

}
