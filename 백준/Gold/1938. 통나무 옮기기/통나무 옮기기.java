import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static int x, y;
	static int ex, ey;
	static int type, etype;
	static char[][] arr;
	static int result = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException{
		//--------------솔루션 코드를 작성하세요.--------------------------------
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		arr = new char[N][N];
		
		type = 0; //가로는 0, 세로는 1
		etype = 0; //가로는 0, 세로는 1
		
		int tempX=0;
		int tempY=0;
		x=0;
		y=0;
		
		int etempX=0;
		int etempY=0;
		ex=0;
		ey=0;
		
		int cnt=0;
		int ecnt=0;
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<N; j++) {
				arr[i][j] = str.charAt(j);
				
				if(arr[i][j] == 'B') {
					cnt++;
					if(cnt == 1) {
						tempX = i;
						tempY = j;
					}
					else if(cnt == 2) {
						x = i;
						y = j;
					}
				}
				
				if(arr[i][j] == 'E') {
					ecnt++;
					if(ecnt == 1) {
						etempX = i;
						etempY = j;
					}
					else if(ecnt == 2) {
						ex = i;
						ey = j;
					}
				}
			}
		}
		
		if(tempX == x) type = 0;
		else if(tempY == y) type = 1;
		
		if(etempX == ex) etype = 0;
		else if(etempY == ey) etype = 1;
		
		bfs();
		
		if(result == Integer.MAX_VALUE) System.out.println(0);
		else System.out.println(result);
		
	}
	
	static class Pos{
		int x;
		int y;
		int type;
		int cnt;
		
		Pos(int x, int y, int type, int cnt){
			this.x=x;
			this.y=y;
			this.type=type;
			this.cnt=cnt;
		}
	}
	
	
	static void bfs() {
		
		Deque<Pos> q = new ArrayDeque<>();
		boolean[][][] visit = new boolean[N][N][2];
		
		q.add(new Pos(x,y,type,0));
		visit[x][y][type] = true;
		
		while(!q.isEmpty()) {
			Pos p = q.poll();
			
			if(p.x == ex && p.y == ey && p.type == etype) {
				result = Math.min(result, p.cnt);
				return;
			}
			
			//가로
			if(p.type == 0) {
				//상
				if((p.x > 0) &&
						!visit[p.x-1][p.y][p.type] &&
						!(arr[p.x-1][p.y-1]=='1' || arr[p.x-1][p.y]=='1' || arr[p.x-1][p.y+1]=='1') ) {
					visit[p.x-1][p.y][p.type]=true;
					q.add(new Pos(p.x-1,p.y,p.type, p.cnt+1));
				}
				//하
				if((p.x < N-1) &&
						!visit[p.x+1][p.y][p.type] &&
						!(arr[p.x+1][p.y-1]=='1' || arr[p.x+1][p.y]=='1' || arr[p.x+1][p.y+1]=='1') ) {
					visit[p.x+1][p.y][p.type]=true;
					q.add(new Pos(p.x+1,p.y,p.type, p.cnt+1));
				}
				//좌
				if((p.y > 1) &&
						!visit[p.x][p.y-1][p.type] &&
						!(arr[p.x][p.y-2]=='1') ) {
					visit[p.x][p.y-1][p.type]=true;
					q.add(new Pos(p.x,p.y-1,p.type, p.cnt+1));
				}
				//우
				if((p.y < N-2) &&
						!visit[p.x][p.y+1][p.type] &&
						!(arr[p.x][p.y+2]=='1') ) {
					visit[p.x][p.y+1][p.type]=true;
					q.add(new Pos(p.x,p.y+1,p.type, p.cnt+1));
				}
				//회전
				if(( 1<=p.y && p.y <= N-2 && 1 <= p.x && p.x <= N-2) &&
						!visit[p.x][p.y][(p.type+1)%2] &&
						!(arr[p.x-1][p.y-1]=='1' || arr[p.x-1][p.y]=='1' || arr[p.x-1][p.y+1]=='1' ||
						arr[p.x+1][p.y-1]=='1' || arr[p.x+1][p.y]=='1' || arr[p.x+1][p.y+1]=='1') ) {
					visit[p.x][p.y][(p.type+1)%2]=true;
					q.add(new Pos(p.x,p.y,(p.type+1)%2, p.cnt+1));
				}
				
			}
			//세로
			else {
				//상
				if((p.x > 1) &&
						!visit[p.x-1][p.y][p.type] &&
						!(arr[p.x-2][p.y]=='1') ){
					visit[p.x-1][p.y][p.type]=true;
					q.add(new Pos(p.x-1,p.y,p.type, p.cnt+1));
				}
				//하
				if((p.x < N-2) &&
						!visit[p.x+1][p.y][p.type] &&
						!(arr[p.x+2][p.y]=='1') ) {
					visit[p.x+1][p.y][p.type]=true;
					q.add(new Pos(p.x+1,p.y,p.type, p.cnt+1));
				}
				//좌
				if((p.y > 0) &&
						!visit[p.x][p.y-1][p.type] &&
						!(arr[p.x-1][p.y-1]=='1' || arr[p.x][p.y-1]=='1' || arr[p.x+1][p.y-1]=='1') ) {
					visit[p.x][p.y-1][p.type]=true;
					q.add(new Pos(p.x,p.y-1,p.type, p.cnt+1));
				}
				//우
				if((p.y < N-1) &&
						!visit[p.x][p.y+1][p.type] &&
						!(arr[p.x-1][p.y+1]=='1' || arr[p.x][p.y+1]=='1' || arr[p.x+1][p.y+1]=='1') ) {
					visit[p.x][p.y+1][p.type]=true;
					q.add(new Pos(p.x,p.y+1,p.type, p.cnt+1));
				}
				
				//회전
				if(( 1 <= p.y && p.y <= N-2 && 1 <= p.x && p.x <= N-2) &&
						!visit[p.x][p.y][(p.type+1)%2] &&
						!(arr[p.x-1][p.y-1]=='1' || arr[p.x][p.y-1]=='1' || arr[p.x+1][p.y-1]=='1' ||
						arr[p.x-1][p.y+1]=='1' || arr[p.x][p.y+1]=='1' || arr[p.x+1][p.y+1]=='1') ) {
					visit[p.x][p.y][(p.type+1)%2]=true;
					q.add(new Pos(p.x,p.y,(p.type+1)%2, p.cnt+1));
				}
			}
			
			
		}
		
	}

}
