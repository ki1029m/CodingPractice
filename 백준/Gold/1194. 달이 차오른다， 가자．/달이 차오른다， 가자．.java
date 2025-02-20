import java.io.*;
import java.util.*;

public class Main {

	
	static int N, M;
	static int result;
	static Character[][] arr;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static Character[] doors = {'A', 'B', 'C', 'D', 'E', 'F'};
	static Character[] keys = {'a', 'b', 'c', 'd', 'e', 'f'};
	static Set<Character> doorSet = new HashSet<>(Arrays.asList(doors));
	static Set<Character> keySet = new HashSet<>(Arrays.asList(keys));
	
	static class Pos{
		int x;
		int y;
		int keyState;
		int count;
		Pos(int x, int y, int count, int keyState){
			this.x=x;
			this.y=y;
			this.count=count;
			this.keyState=keyState;
		}
	}
	
	public static void bfs(int x, int y) {
		
		//가지고 있냐 아니냐 열쇠만큼 (=6번)
		boolean[][][] visit = new boolean[N][M][1<<6];
		Deque<Pos> q = new ArrayDeque<>();
		q.offer(new Pos(x,y,0,0));
		visit[x][y][0]=true;
		
		while(!q.isEmpty()) {
			Pos p = q.poll();
			int count = p.count;
			
			if(arr[p.x][p.y]=='1'){
				result = Math.min(result, count);
				break;
			}
			
			for(int d=0; d<4; d++) {
				int nx=p.x+dx[d];
				int ny=p.y+dy[d];
				
				
				if(!(0<=nx&&nx<N&&0<=ny&&ny<M) || arr[nx][ny]=='#') continue;
				
				//다음 칸이 키라면 상태 변경
				if(keySet.contains(arr[nx][ny])) {
					int newKeyState = p.keyState | (1 << (arr[nx][ny] - 'a')); // 키 획득
					if (!visit[nx][ny][newKeyState]) {
				        visit[nx][ny][newKeyState] = true;
				        q.offer(new Pos(nx, ny, count+1, newKeyState));
				    }
				}else if(doorSet.contains(arr[nx][ny])) {
					if ((p.keyState & (1 << (arr[nx][ny] - 'A'))) != 0) { // 문을 열 수 있는지 확인
				        if (!visit[nx][ny][p.keyState]) {
				            visit[nx][ny][p.keyState] = true;
				            q.offer(new Pos(nx, ny, count+1, p.keyState));
				        }
				    }
				}else {
					if (!visit[nx][ny][p.keyState]) {
					    visit[nx][ny][p.keyState] = true;
					    q.offer(new Pos(nx, ny, count+1, p.keyState));
					}
				}
			}
		}
		
		if(result == Integer.MAX_VALUE) {
			System.out.println(-1);
		}else {
			System.out.println(result);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new Character[N][M];
		int x = -1;
		int y = -1;
		
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<M; j++) {
				arr[i][j] = str.charAt(j);
				if(arr[i][j] == '0') {
					x=i;
					y=j;
				}
			}
		}
		
		result = Integer.MAX_VALUE;
		bfs(x,y);
		
		
		
	}

}
