import java.io.*;
import java.util.*;



public class Main {
	static int N,M;
	static int[] arr;
	
	static void recursive(int depth, int[] result, boolean[] visit) {
		//basis part
		if(depth == M) {
			for(int i=0; i<M; i++) {
				System.out.print(result[i]+" ");
			}
			System.out.println();
			return;
		}
		
		//inductive part
		for(int i=0; i<N; i++) {
			if(!visit[i]) {
				result[depth] = arr[i];
				visit[i] = true;
				recursive(depth+1, result, visit);
				visit[i] = false;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		int[] result = new int[M];
		boolean[] visit = new boolean[N];
		
		for(int i=0; i<N; i++) {
			arr[i]=i+1;
		}
		
		
		recursive(0, result, visit);
	}

}
