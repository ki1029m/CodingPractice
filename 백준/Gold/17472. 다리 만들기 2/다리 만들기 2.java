import java.io.*;
import java.util.*;


public class Main {
	
	static int N, M;
	static int[][] arr;
	static boolean[][] visit;
	
	static int[][] dist;
	
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	
	static int totalWeight;
	
	static class Pos{
		int x;
		int y;
		
		Pos(int x, int y){
			this.x=x;
			this.y=y;
		}
	}
	
	public static void bfs(int x, int y, int num ) {
		
		Deque<Pos> q = new ArrayDeque<>();
		q.add(new Pos(x,y));
		arr[x][y] = num;
		visit[x][y] = true;
		
		while(!q.isEmpty()) {
			Pos p = q.poll();
			
			for(int i=0; i<4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				
				if(0<=nx&&nx<N&&0<=ny&&ny<M && arr[nx][ny]!=0 && !visit[nx][ny]) {
					arr[nx][ny] = num;
					visit[nx][ny] = true;
					q.offer(new Pos(nx,ny));
				}
			}
		}
	}
	
	public static void connect(int x, int y, int d) {
		

		int distance=0;
		while(true) {
			int nx = x+dx[d]*(distance+1);
			int ny = y+dy[d]*(distance+1);
			
			if(!(0<=nx&&nx<N&&0<=ny&&ny<M)) return;
			
			if(arr[nx][ny]!=0 && arr[x][y]!=arr[nx][ny] && distance >= 2) {
				dist[arr[x][y]][arr[nx][ny]] = Math.min(dist[arr[x][y]][arr[nx][ny]], distance);
				dist[arr[nx][ny]][arr[x][y]] = Math.min(dist[arr[nx][ny]][arr[x][y]], distance);
				return;
			}
			
			if(arr[nx][ny]==0) {
				distance++;
			}else{
				return;
			}
		}
	}
	
	
	public static void prim(int num) {
        boolean[] visit = new boolean[num];
        int[] cost = new int[num];
        Arrays.fill(cost, Integer.MAX_VALUE);
        
        // 시작 정점 1에서 시작
        cost[1] = 0;
        
        totalWeight = 0;
        for (int i = 1; i < num; i++) {
            int u = -1;
            int min = Integer.MAX_VALUE;
            
            // 최소 가중치를 가진 정점 찾기
            for (int v = 1; v < num; v++) {
                if (!visit[v] && cost[v] < min) {
                    min = cost[v];
                    u = v;
                }
            }
            
            if(u==-1) break;
            
            // MST에 포함
            visit[u] = true;
            totalWeight += min;
            
            // 갱신
            for (int v = 1; v < num; v++) {
                if (!visit[v] && dist[u][v] != Integer.MAX_VALUE) {
                	cost[v] = Math.min(cost[v], dist[u][v]);
                }
            }
        }
        
        // 모든 섬 방문 여부 확인
        for (int i = 1; i < num; i++) {
            if (!visit[i]) {
                totalWeight = 0;  // 연결되지 않은 섬이 있음
                return;
            }
        }
	}
	
	public static void main(String[] args) throws IOException {
		//섬번호(bfs)
		//연결하기(갱신하면서), (bfs)
		//MST 계산
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		visit = new boolean[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		//섬에 번호 붙이기
		int num=1;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(!visit[i][j] && arr[i][j] != 0) {
					bfs(i,j,num);
					num++;
				}
			}
		}
		
		//다리 초기화
		//방문 배열 재사용을 위한 초기화
		dist = new int[num][num];
		for(int i=0; i<num; i++) {
			for(int j=0; j<num; j++) {
				dist[i][j]=Integer.MAX_VALUE;
			}
		}
		
		
		//다리 잇기
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				for(int d=0; d<4; d++) {
					if(arr[i][j] != 0) {
						connect(i,j,d);
					}
				}
			}
		}
		
		//프림
		prim(num);
		
		if(totalWeight != 0) {
			System.out.println(totalWeight);
		}else {
			System.out.println(-1);
		}
	}

}
