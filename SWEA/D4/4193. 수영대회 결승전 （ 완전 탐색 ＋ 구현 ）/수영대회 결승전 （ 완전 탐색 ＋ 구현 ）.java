import java.io.*;
import java.util.*;

public class Solution {
	static int N,A,B,C,D,result;
	static int[][] arr;
	static boolean[][] visit;
    static int[] dy = {-1,0,1,0};
    static int[] dx = {0,1,0,-1};
	
	static class Pos{
		int x;
		int y;
		int time;
		public Pos(int x, int y, int time) {
			this.x=x;
			this.y=y;
			this.time=time;
		}
	}
	
	static void bfs(int x, int y){
		Queue<Pos> q = new LinkedList<Pos>();
		visit[x][y] = true;
		q.offer(new Pos(x, y, 0));
		while(!q.isEmpty()) {
			Pos p = q.poll();
			if(p.x==C && p.y==D) {
				result = Math.min(result, p.time);
				return;
			}
			
			for(int i=0; i<4; i++) {
				int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                int nextTime = p.time + 1;

                if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue; 
                if (arr[nx][ny] == 1) continue;
                if (visit[nx][ny]) continue;

                // 소용돌이가 존재하는 경우 기다리기
                if (arr[nx][ny] == 2) {
                	if(p.time%3 == 2) {
						visit[nx][ny] = true;
						q.offer(new Pos(nx,ny,p.time+1));
					}else {
						visit[p.x][p.y] = true;
						q.offer(new Pos(p.x,p.y,p.time+1));
					}
                }else {
                    visit[nx][ny] = true;
                    q.offer(new Pos(nx, ny, p.time+1));
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
			
			st = new StringTokenizer(br.readLine());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			C = Integer.parseInt(st.nextToken());
			D = Integer.parseInt(st.nextToken());
			
			result=Integer.MAX_VALUE;
			bfs(A,B);
			
			if(result != Integer.MAX_VALUE)
				System.out.println("#"+t+" "+result);
			else
				System.out.println("#"+t+" "+"-1");
		}
	}

}
