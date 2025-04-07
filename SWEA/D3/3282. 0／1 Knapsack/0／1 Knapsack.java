import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			int[] V = new int[N];
			int[] C = new int[N];
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				V[i] = Integer.parseInt(st.nextToken());
				C[i] = Integer.parseInt(st.nextToken());
			}
			
			int[] dp = new int[K+1];
			for(int i=0; i<N; i++) {
				for(int v=K; v>0; v--) {
					if(V[i] <= v) {
						dp[v] = Math.max(dp[v], dp[v-V[i]] + C[i]);
					}
				}
			}
			
			System.out.println("#"+t+" "+dp[K]);
		}
	}

}
