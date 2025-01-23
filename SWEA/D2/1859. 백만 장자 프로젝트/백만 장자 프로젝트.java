
import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++)
		{
            int N = Integer.parseInt(br.readLine());
            long[] arr = new long[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
            	arr[i] = Integer.parseInt(st.nextToken());
            }
            
            long result = 0;
            long max = 0;
            for(int i = N-1; i>=0; i--) {
            	if(max < arr[i]) {
            		max = arr[i];
            	}
            	result += max - arr[i];
            }
			System.out.println("#"+t+" "+result);

		}
	}
}