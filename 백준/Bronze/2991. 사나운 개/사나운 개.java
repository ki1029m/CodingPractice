import java.io.*;
import java.util.*;


public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int P = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		int result;
		result= 0;
		if(P%(A+B)<=A && P%(A+B)!=0)
			result++;
		if(P%(C+D)<=C && P%(C+D)!=0)
			result++;
		System.out.println(result);
		result = 0;
		if(M%(A+B)<=A && M%(A+B)!=0)
			result++;
		if(M%(C+D)<=C && M%(C+D)!=0)
			result++;
		System.out.println(result);
		result = 0;
		if(N%(A+B)<=A && N%(A+B)!=0)
			result++;
		if(N%(C+D)<=C && N%(C+D)!=0)
			result++;
		System.out.println(result);
		
		
		
	}

}
