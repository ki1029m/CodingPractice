import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[][] array = new int[N][N];
			
			for(int i=0; i<N; i++) {
				String line = br.readLine();
				for(int j=0; j<N; j++) {
					array[i][j] = Character.getNumericValue(line.charAt(j));
					//array[i][j] = Integer.parseInt(line.substring(j, j+1));
				}
			}
			
			int result =0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if (Math.abs(N / 2 - i) <= j && j < N - Math.abs(N / 2 - i)){
						result += array[i][j];
					}
				}
			}
			System.out.println("#"+t+" "+result);
		}
	}
}
