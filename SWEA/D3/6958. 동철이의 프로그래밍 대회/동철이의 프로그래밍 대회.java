import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			int[][] arr = new int[N][M+1];
			int max = 0;
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				int count=0;
				for(int j=0; j<M; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					if(arr[i][j]== 1) {
						count++;
					}
				}
				if(count > max) max = count;
				arr[i][M] = count;
			}
			
			int result = 0;
			for(int i=0; i<N; i++) {
				if(arr[i][M] == max) result++;
			}
			
			System.out.println("#"+t+" "+result+" "+max);
		}
	}
}
