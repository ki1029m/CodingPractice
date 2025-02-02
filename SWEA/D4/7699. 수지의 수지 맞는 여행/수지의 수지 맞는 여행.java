import java.util.*;
import java.io.*;

public class Solution {
	static int R,C,result;
	static char[][] arr;
	static boolean[] visit;
	
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	
	public static void dfs(int x, int y, int cnt) {
		for(int i=0; i<4; i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			if(0<=nx&&nx<R && 0<=ny&&ny<C && !visit[arr[nx][ny]-'A']) {
				visit[arr[nx][ny]-'A']=true;
				dfs(nx,ny,cnt+1);
				visit[arr[nx][ny]-'A']=false;
			}
		}
		result = Math.max(result,cnt);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			result=0;
			arr = new char[R][C];
			visit = new boolean[26];
			
			for(int i=0; i<R; i++) {
				String line = br.readLine();
				for(int j=0; j<C; j++) {
					arr[i][j] = line.charAt(j);
				}
			}
			
			visit[arr[0][0]-'A']=true;
			dfs(0,0,1);
			
			System.out.println("#"+t+" "+result);
		}
	}

}
