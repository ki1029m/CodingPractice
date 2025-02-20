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
			
			int[][] arr = new int[N][N];
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken()); 
				}
			}
			
			
			int result = Integer.MIN_VALUE;
			for(int i=0; i<N-M+1; i++) {
				for(int j=0; j<N-M+1; j++) {
					int sum=0;
					for(int k=i; k<i+M; k++) {
						for(int l=j; l<j+M; l++) {
							sum+=arr[k][l];
						}
					}
					result = Math.max(result, sum);
				}
			}
			
			System.out.println("#"+t+" "+result);
		}
		
		
	}

}
