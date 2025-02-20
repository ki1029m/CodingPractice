import java.io.*;
import java.util.*;


public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			StringTokenizer st =new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			int[][] arr = new int[N+1][N+1];
			int[][] prefix = new int[N+1][N+1];
			for(int i=1; i<=N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=1; j<=N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken()); 
					prefix[i][j] = arr[i][j]
									+ prefix[i-1][j]
									+ prefix[i][j-1]
									- prefix[i-1][j-1];
				}
			}
			
			
			int result = Integer.MIN_VALUE;
			for(int i=M; i<=N; i++) {
				for(int j=M; j<=N; j++) {
					int sum = prefix[i][j]-prefix[i-M][j]-prefix[i][j-M]+prefix[i-M][j-M];
					result = Math.max(result, sum);
				}
			}
			
			System.out.println("#"+t+" "+result);
		}
	}
}
