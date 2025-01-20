import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		int result=0;
		int[] array = new int[N];
		for(int i=0; i<N; i++) {
			array[i] = 0;
		}
		
		int i=0;
		while(true) {
			array[i]++;
			if(array[i] == M) {
				break;
			}
			if(array[i]%2==0) {
				i = (i+N-L)%N;
			}else {
				i = (i+N+L)%N;
			}
			result++;
		}
		System.out.println(result);
	}
}
