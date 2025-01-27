import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			int[][] arr = new int[N][N];
			//흑돌 : 1
			//백돌 : 2
			arr[N/2-1][N/2-1]=2;
			arr[N/2][N/2]=2;
			arr[N/2-1][N/2]=1;
			arr[N/2][N/2-1]=1;
			
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				x--;
				y--;
				arr[x][y] = v;
				
				//12시 방향부터 시계방향
				int[] dx = {-1,-1,0,1,1,1,0,-1};
				int[] dy = {0,1,1,1,0,-1,-1,-1};
				for(int j=0; j<8; j++) {
					int cnt = 1;
					boolean change = false;
					for(int k=1; k<N; k++) {
						int nx = x+dx[j]*k;
						int ny = y+dy[j]*k;
						
						//판 밖으로 나갈 경우
						if(!(0<=nx && nx<N) || !(0<=ny && ny<N)) {
							break;
						}
						//해당 방향으로 없을 경우
						if(arr[nx][ny]==0) {
							break;
						}
						//같은 돌을 발견 했을 경우
						if(arr[nx][ny]==arr[x][y]) {
							change=true;
							break;
						}
						cnt++;
					}
					if(change) {
						//발견한곳까지 돌 변경
						for(int k=1; k<cnt; k++) {
							int nx = x+dx[j]*k;
							int ny = y+dy[j]*k;
							arr[nx][ny]=arr[x][y];
						}
					}
				}
			}
			int black=0;
			int white=0;
			//끝난 후의 결과
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(arr[i][j]==1) {
						black++;
					}
					if(arr[i][j]==2) {
						white++;
					}
				}
			}
			System.out.println("#"+t+" "+black+" "+white);
		}
	}
}
