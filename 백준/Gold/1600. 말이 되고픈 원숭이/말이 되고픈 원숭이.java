import java.io.*;
import java.util.*;


public class Main {

	static int K, W, H;
	static int[][] arr;
	static int result;
	
	static class Pos{
		int x;
		int y;
		int monkeyMove;
		int horseMove;
		Pos(int x, int y, int monkeyMove, int horseMove){
			this.x=x;
			this.y=y;
			this.monkeyMove=monkeyMove;
			this.horseMove=horseMove;
		}
	}
	
	static void bfs() {
		
		boolean[][][] visit = new boolean[H][W][K+1]; 
		Deque<Pos> q = new ArrayDeque<>();
		//0,0에서 시작!
		q.add(new Pos(0,0,0,0));
		visit[0][0][0] = true;
		
		while(!q.isEmpty()) {
			Pos p =q.poll();
			
			if(p.x==H-1 && p.y==W-1) {
				result = Math.min(p.monkeyMove,result);
				return;
			}
			
			
			int[] dxM= {-1,0,1,0};
			int[] dyM= {0,1,0,-1};
			
			for(int d=0; d<4; d++) {
				int nx = p.x+dxM[d];
				int ny = p.y+dyM[d];
				
				if(!(0<=nx&&nx<H&&0<=ny&&ny<W)) continue;
				
				if(!visit[nx][ny][p.horseMove] && arr[nx][ny] == 0) {
					visit[nx][ny][p.horseMove]=true;
					q.add(new Pos(nx,ny,p.monkeyMove+1, p.horseMove));
				}
			}
			int[] dxH= {-2,-2,-1,1,2,2,1,-1};
			int[] dyH= {-1,1,2,2,1,-1,-2,-2};
			
			for(int d=0; d<8; d++) {
				int nx = p.x+dxH[d];
				int ny = p.y+dyH[d];
				
				if(!(0<=nx&&nx<H&&0<=ny&&ny<W)) continue;
				
				if(p.horseMove<K && !visit[nx][ny][p.horseMove+1] && arr[nx][ny] == 0) {
					visit[nx][ny][p.horseMove+1]=true;
					q.add(new Pos(nx,ny,p.monkeyMove+1, p.horseMove+1));
				}
			}
			
		}
		
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		arr = new int[H][W];
		for(int i=0; i<H; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<W; j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		result = Integer.MAX_VALUE;
		bfs();
		if(result != Integer.MAX_VALUE) {
			System.out.println(result);
		}else {
			System.out.println(-1);
		}
		
	}

}
