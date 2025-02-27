import java.io.*;
import java.util.*;


public class Solution {

	static int N, resultX, resultY, maxCount;
	static int[][] arr;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			resultX = -1;
			resultY = -1;
			maxCount = 1;
			
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					int count = recursive(i,j);
					if ( (resultX==-1&&resultY==-1) || (count > maxCount) || (count == maxCount && arr[i][j] < arr[resultX][resultY]) ) {
                        maxCount = count;
                        resultX = i;
                        resultY = j;
                    }
				}
			}
			System.out.println("#"+t+" "+arr[resultX][resultY]+" "+maxCount);
			
		}
	}
	
	static int recursive(int x, int y) {
		//시작값
		int maxMove=1;
		
		boolean isFound = false;
		for(int d=0; d<4; d++) {
			int nx=x+dx[d];
			int ny=y+dy[d];
			if(!(0<=nx&&nx<N&&0<=ny&&ny<N)) continue;
			
			if(arr[nx][ny]==arr[x][y]+1 && !isFound) {
				isFound = true;
				//최대 횟수 비교
				maxMove = Math.max(maxMove, recursive(nx, ny)+1); 
			}
		}
		// 최대 이동거리 반환
		return maxMove; 
	}
}
