import java.io.*;
import java.util.*;

public class Main {
	static int N,M;
	static int[] arr, result;
	
	static void recursive(int idx, int depth, int[] result) {
		//basis part
		
		if(depth == M) {
			for(int i=0; i<M; i++) {
				System.out.print(result[i]+" ");
			}
			System.out.println();
			return;
		}
		
		if(idx == N) {
			return;
		}

		//inductive part
        result[depth] = arr[idx]; 
        recursive(idx+1, depth+1, result);
        recursive(idx+1, depth, result);
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i]=i+1;
		}
		
		result = new int[M];
		recursive(0,0, result);
	}

}
