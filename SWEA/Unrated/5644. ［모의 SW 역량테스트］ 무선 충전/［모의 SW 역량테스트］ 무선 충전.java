import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			//이동수
			int M = Integer.parseInt(st.nextToken());
			//충전기수
			int C = Integer.parseInt(st.nextToken());
			
			int[] moveA = new int[M];
			int[] moveB = new int[M];
			
			st= new StringTokenizer(br.readLine());
			for(int i=0; i<M; i++) {
				moveA[i] = Integer.parseInt(st.nextToken());
			}
			st= new StringTokenizer(br.readLine());
			for(int i=0; i<M; i++) {
				moveB[i] = Integer.parseInt(st.nextToken());
			}
			AP[] aps = new AP[C];
			for(int i=0; i<C; i++) {
				st= new StringTokenizer(br.readLine());
				AP ap = new AP();
				ap.y = Integer.parseInt(st.nextToken());
				ap.x = Integer.parseInt(st.nextToken());
				ap.c = Integer.parseInt(st.nextToken());
				ap.p = Integer.parseInt(st.nextToken());
				aps[i] = ap;
				
			}
			
			
			int result=0;
			int xA = 1;
			int yA = 1;
			int xB = 10;
			int yB = 10;
			
			int[] dx = {0,-1,0,1,0};
			int[] dy = {0,0,1,0,-1};
			
			//시뮬레이션
			for(int m=0; m<=M; m++) {
				//좌표갱신, 처음은 가만히
				if(m !=0) {
					xA = xA + dx[moveA[m-1]];
					yA = yA + dy[moveA[m-1]];
					xB = xB + dx[moveB[m-1]];
					yB = yB + dy[moveB[m-1]];
				}
				
				
				//충전기 별 범위 체크
				//i는 A에 대한 충전기 선택
				//j는 B에 대한 충전기 선택
				int max=0;
				for(int i=0; i<C; i++) {
					for(int j=0; j<C; j++) {
						int charge = 0;
						int cnt = 0;
						if( (Math.abs(xA-aps[i].x) + Math.abs(yA-aps[i].y)) <= aps[i].c ) {
							charge += aps[i].p;
							cnt++;
						}
						if( (Math.abs(xB-aps[j].x) + Math.abs(yB-aps[j].y)) <= aps[j].c ) {
							charge += aps[j].p;
							cnt++;
						}

						//2개가 선택되었을때만 나누기 2를 해야함
						if(i==j && cnt==2) charge = charge/2;
						max = Math.max(max, charge);
					}
				}
				result += max;
			}
			
			
			System.out.println("#"+t+" "+result);
			
		}
	}
	static class AP{
		//좌표
		int x;
		int y;
		
		//충전범위
		int c;
		
		//처리량
		int p;
		
		AP() {
			
		}
		
		AP(int x, int y, int c, int p) {
			this.x=x;
			this.y=y;
			this.c=c;
			this.p=p;
		}

		@Override
		public String toString() {
			return "AP [x=" + x + ", y=" + y + ", c=" + c + ", p=" + p + "]";
		}
		
	}

}
