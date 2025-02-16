import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Main {
	static int N;
	static long result;
	static StringBuilder sb;

	public static void recursive(int n, int from, int temp, int to) {
		if(n==0) {
			return;
		}
		
		recursive(n-1, from, to, temp);
		sb.append(from+" "+to+"\n");
		recursive(n-1,temp,from, to);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		if(N<=20) {
			recursive(N,1,2,3);
		}
		
		//쓰레기 문제...
		//2^N-1 연산
        BigInteger result = (new BigInteger("2")).pow(N).subtract(new BigInteger("1"));
		System.out.println(result);
		System.out.println(sb);
	}

}
