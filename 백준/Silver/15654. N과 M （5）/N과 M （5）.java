import java.util.*;
import java.io.*;

public class Main {

	static int[] arr;
	static int N;
	static int M;
	static StringBuilder sb = new StringBuilder();
	
	public static void recursive(int[] result, boolean[] visit, int idx) {
		if(idx == M) {
			for (int i = 0; i < M; i++) {
                sb.append(result[i]).append(" ");
            }
            sb.append("\n");
			return;
		}
		for(int i=0; i<N; i++) {
			if(!visit[i]) {
				visit[i] = true;
				result[idx] = arr[i];
				recursive(result, visit, idx+1);
				visit[i] = false;
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		recursive(new int[M], new boolean[N], 0);
		System.out.print(sb);
	}

}
