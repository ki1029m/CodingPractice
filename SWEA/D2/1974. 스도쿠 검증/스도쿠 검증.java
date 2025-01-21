import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			
			int[][] array = new int[9][9];
			for(int i=0; i<9; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<9; j++) {
					array[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			

			boolean hasResult = true;
			for(int i=0; i<9; i++) {
				for(int j=0; j<9; j++) {
					if(hasResult) {
						int sum = 0;
						for(int k=(i/3)*3; k<(i/3)*3+3; k++) {
							for(int l=(j/3)*3; l<(j/3)*3+3; l++) {
								sum+=array[k][l];
							}
						}
						
						if(sum!=45) {
							hasResult = false;
							break;
						}
						
						sum=0;
						for(int k=0; k<9; k++) {
							sum += array[k][j];
						}
						if(sum!=45) {
							hasResult = false;
							break;
						}
						
						sum=0;
						for(int l=0; l<9; l++) {
							sum += array[i][l];
						}
						if(sum!=45) {
							hasResult = false;
							break;
						}
					}
				}
			}
			if(hasResult) System.out.println("#"+t+" "+1);
			else System.out.println("#"+t+" "+0);
		}
	}
}
