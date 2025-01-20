import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int result =0;
		int[] array1 = new int[N];
		int[] array2 = new int[N];
		
		st = new StringTokenizer(br.readLine());
		int idx1 =0;
		int idx2 =0;
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(st.nextToken());
			if(num % 10 ==0) {
				array1[idx1] = num;
				idx1++;
			}else {
				array2[idx2] = num;
				idx2++;
			}
		}
		Arrays.sort(array1);
		Arrays.sort(array2);
		
		idx1 =0;
		while(idx1< array1.length) {
			if(array1[idx1]==10) {
				array1[idx1]-=10;
				result++;
				continue;
			}
			else if(array1[idx1] > 10 && M>0) {
				result++;
				array1[idx1] -= 10;
				M--;
			}
			else {
				idx1++;
			}
		}
		
		idx2=0;
		while(M>0 && idx2<array2.length) {
			if(array2[idx2]==10) {
				array2[idx2]-=10;
				result++;
				continue;
			}
			
			if(array2[idx2] > 10) {
				result++;
				array2[idx2] -= 10;
				M--;
			}
			
			if(array2[idx2]==10) {
				array2[idx2]-=10;
				result++;
				continue;
			}
			
			if(array2[idx2] < 10) {
				idx2++;
			}
		}
		System.out.println(result);
	}

}
