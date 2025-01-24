import java.io.*;
import java.util.*;


public class Solution {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T= Integer.parseInt(br.readLine());
		
		
		for(int t=1; t<=T; t++) {
			int N = Integer.parseInt(br.readLine());
			
			int[] A = new int[N];
			int[] B = new int[N];
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				A[i] = Integer.parseInt(st.nextToken());
				B[i] = Integer.parseInt(st.nextToken());
			}
			int P = Integer.parseInt(br.readLine());
			int[] C = new int[P];
			for(int i=0; i<P; i++ ) {
				C[i] = Integer.parseInt(br.readLine());
			}
			
			int[] result = new int[P];
			for(int i=0; i<P; i++) {
				for(int j=0; j<N; j++) {
					if(A[j]<=C[i] && C[i] <= B[j])
						result[i]++;
				}
			}
			
			
			System.out.print("#"+t);
			for(int i=0; i<P; i++) {
				System.out.print(" "+result[i]);
			}
			System.out.println();
		}
		
	}
}
