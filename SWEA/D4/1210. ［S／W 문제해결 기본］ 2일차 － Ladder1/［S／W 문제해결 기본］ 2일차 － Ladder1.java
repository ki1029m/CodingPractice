import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int t=1; t<=10; t++) {

			int T = Integer.parseInt(br.readLine());
			
			int[][] arr = new int[100][100];
			boolean[][] visit = new boolean[100][100];
			int x=-1;
			int y=-1;
			for(int i=0; i<100; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<100; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					if(arr[i][j]==2) {
						x=i;
						y=j;
					}
				}
			}
			
			/*
			for(int i=0; i<100; i++) {
				System.out.println(Arrays.toString(arr[i]));
			}*/

			int[] dx = {0,0,-1};
			int[] dy = {-1,1,0};
			while(true) {
				boolean isMove = false;
				for(int i=0; i<3; i++) {
					int nx = x+dx[i];
					int ny = y+dy[i];
					
					if(!(0<=nx&&nx<100&&0<=ny&&ny<100)) continue;
					
					if(arr[nx][ny]==1 && !visit[nx][ny]) {
						x=nx;
						y=ny;
						isMove=true;
						visit[x][y]=true;
						break;
					}
				}
				if(!isMove) break;
			}
			
			System.out.println("#"+t+" "+y);
			
		}
		
	}

}
