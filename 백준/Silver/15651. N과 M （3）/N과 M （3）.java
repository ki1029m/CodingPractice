import java.io.*;
import java.util.*;

public class Main {

	static int[] arr;
	static int N;
	static int M;
	static StringBuilder sb = new StringBuilder();
	
	public static void recursive(int[] result, int idx) {
		if(idx == M) {
			for (int i = 0; i < M; i++) {
                sb.append(result[i]).append(" ");
            }
            sb.append("\n");
			return;
		}
		for(int i=0; i<N; i++) {
			result[idx] = arr[i];
			recursive(result, idx+1);
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i]=i+1;
		}
		
		recursive(new int[M], 0);
		System.out.print(sb);
	}

}
