import java.util.*;
import java.io.*;


public class Solution {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int t=1; t<=10; t++) {
			
			int d = Integer.parseInt(br.readLine());
			int result = 0;
			int[] array = new int[100];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<100; i++) {
				array[i] = Integer.parseInt(st.nextToken());
			}
			


			Arrays.sort(array);
			
			for(int i=0; i<d; i++) {
				if(array[99] - array[0] <= 1) break;
				array[99]--;
				array[0]++;
				Arrays.sort(array);
			}
			
			System.out.println("#"+t+" "+ (array[99]-array[0]));
		}
		

	}

}
