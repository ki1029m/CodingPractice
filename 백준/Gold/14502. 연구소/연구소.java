import java.io.*;
import java.util.*;

public class Main {

	static int N, M, result;
	static int[][] arr;
	static ArrayList<Integer> list;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		list = new ArrayList<Integer>();
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
				if(arr[i][j] == 0) list.add(i*M+j);
			}
		}
		
		//3개의 기둥 설치를 위한 조합 뽑기
		recursive(0,0, new int[3]);
		
		System.out.println(result);
		
	}
	
	static void recursive(int depth, int idx, int[] comb) {
		if(depth == 3) {
			//조합을 뽑은 후에는 bfs로 시뮬레이션
			
			int[][] nArr = new int[N][M];
			for(int i=0; i<N; i++) {
				nArr[i] = arr[i].clone();
			}
			
			
			for(int i=0; i<3; i++) {
				int x = comb[i]/M;
				int y = comb[i]%M;
				
				
				nArr[x][y] = 1;
			}
			
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(nArr[i][j] == 2) bfs(i,j, nArr);
				}
			}
			
			//안전지대 크기 계산
			int sum = 0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(nArr[i][j] == 0) sum++;
				}
			}
			result = Math.max(result, sum);
			
			return;
			
		}
		
		for(int i=idx; i<list.size(); i++) {
			comb[depth] = list.get(i);
			recursive(depth+1, i+1, comb);
		}
		
	}
	
	static class Pos{
		int x;
		int y;
		Pos(){}
		Pos(int x, int y){
			this.x=x;
			this.y=y;
		}
	}
	
	static void bfs(int x, int y, int[][] nArr) {
		
		Queue<Pos> q = new ArrayDeque<>();
		boolean[][] visit = new boolean[N][M];
		visit[x][y] = true;
		q.add(new Pos(x,y));
		
		while(!q.isEmpty()) {
			Pos p = q.poll();
			
			for(int i=0; i<4; i++) {
				int nx= p.x + dx[i];
				int ny= p.y + dy[i];
				
				if(!(0<=nx&&nx<N && 0<=ny&&ny<M)) continue;
				if(visit[nx][ny]) continue;
				if(nArr[nx][ny] != 0) continue;
				
				visit[nx][ny] = true;
				nArr[nx][ny] = 2;
				q.add(new Pos(nx,ny));
			}
			
		}
		
		
	}
}
