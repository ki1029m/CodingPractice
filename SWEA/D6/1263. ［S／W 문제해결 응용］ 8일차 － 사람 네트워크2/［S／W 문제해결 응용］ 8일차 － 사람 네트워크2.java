import java.io.*;
import java.util.*;

public class Solution {

	static final int INF = 10000;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			
			int[][] arr = new int[N][N];
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int[][] dist = new int[N][N];
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(arr[i][j] == 0) dist[i][j] = INF;
					else dist[i][j] = arr[i][j];
				}
			}
			
			for(int k=0; k<N; k++) {
				for(int i=0; i<N; i++) {
					for(int j=0; j<N; j++) {
						dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
					}
				}
			}
			
			int result = INF;
			for (int i = 0; i < N; i++) {
			    int sum = 0;
			    for (int j = 0; j < N; j++) {
			        if (i == j) continue;
			        sum += dist[i][j];
			    }
			    result = Math.min(result, sum);
			}
			
			
			System.out.println("#"+t+" "+result);
			
		}
		
		
	}

}
