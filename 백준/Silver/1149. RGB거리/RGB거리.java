import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[][] dp = new int[N][3];
		int[][] arr = new int[N][3];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0]=Integer.parseInt(st.nextToken());
			arr[i][1]=Integer.parseInt(st.nextToken());
			arr[i][2]=Integer.parseInt(st.nextToken());
		}
		
		
		dp[0][0]=arr[0][0];
		dp[0][1]=arr[0][1];
		dp[0][2]=arr[0][2];
		for(int i=1; i<N; i++) {
			dp[i][0]=Math.min(arr[i][0]+dp[i-1][1], arr[i][0]+dp[i-1][2]);
			dp[i][1]=Math.min(arr[i][1]+dp[i-1][0], arr[i][1]+dp[i-1][2]);
			dp[i][2]=Math.min(arr[i][2]+dp[i-1][0], arr[i][2]+dp[i-1][1]);
		}
		
		int result = Math.min(dp[N-1][2], Math.min(dp[N-1][0], dp[N-1][1]));
		System.out.println(result);
	}

}
