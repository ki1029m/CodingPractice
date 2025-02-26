import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			Integer[] H = new Integer[N];
			st = new StringTokenizer(br.readLine());
			int S=0;
			for(int i=0; i<N; i++) {
				H[i] = Integer.parseInt(st.nextToken());
				S+=H[i];
			}
			
			Arrays.sort(H);
			
			//해당 높이를 만들 수 있냐 없냐를 체크
			boolean[] dp = new boolean[S+1];
			dp[0] = true;
			
			for(int i=0; i<N; i++) {
				int height = H[i];
				
				for(int j=S; j>=height; j--) {
					if(dp[j-height]) {
						dp[j]=true;
					}
				}
			}
			
			int result=0;
			for(int i=B; i<=S; i++) {
				if(dp[i]) {
					result=i-B;
					break;
				}
			}
			
			
			System.out.println("#"+t+" "+result);
			
		}
		
	}

}
