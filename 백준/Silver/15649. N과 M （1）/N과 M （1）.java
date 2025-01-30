import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int M;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = i+1;
		}
		
		recursive(arr, new boolean[N], new int[M], 0);
	}
	
	static void recursive(int[] arr, boolean[] v, int[]result, int depth) {
		//basis part
		if(depth == M) {
			for(int i=0; i<M; i++) {
				System.out.print(result[i]);
				if(i != M-1) {
					System.out.print(" ");
				}
			}
			System.out.println();
			return;
		}

		//inductive part
		for(int i=0; i<N; i++) {
			if(v[i]==false) {
				v[i] = true;
				result[depth] = arr[i];
				recursive(arr, v, result, depth+1);
				v[i] = false;
			}
		}
		
	}
}
