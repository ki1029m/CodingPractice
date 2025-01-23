import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++)
		{
			int up = 0;
			int down = 0;
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[N];
            for(int i=0; i<N; i++) {
            	arr[i]=Integer.parseInt(st.nextToken());
            }
            
            for(int i=0; i<N-1; i++) {
            	if(arr[i] < arr[i+1]) {
            		if(up < arr[i+1]-arr[i]) up = arr[i+1]-arr[i];
            	}
            	
            	if(arr[i] > arr[i+1]) {
            		if(down < arr[i]-arr[i+1]) down = arr[i]-arr[i+1];
            	}
            }
			System.out.println("#"+t+" "+up+" "+down);

		}
	}
}
