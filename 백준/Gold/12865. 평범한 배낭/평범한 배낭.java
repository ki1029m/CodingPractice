import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] W = new int[N];
		int[] V = new int[N];
		
		
		//무게 ?일때 최대 가치 (%주의% 최대 K까지)
		int[] dp = new int[K+1];

		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			W[i] = Integer.parseInt(st.nextToken());
			V[i] = Integer.parseInt(st.nextToken());
		}
		
		
		// 아이템을 하나씩 고려하면서 DP 테이블 업데이트
        for (int i = 0; i < N; i++) {
            // 반대로 순회(중복방지)하며 업데이트
            for (int j = K; j >= W[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - W[i]] + V[i]);
            }
        }
        
        int max=0;
        for(int i=0; i<=K; i++) {
        	max = Math.max(max, dp[i]);
        }

        System.out.println(max);
		
		
	}
	
	

}
