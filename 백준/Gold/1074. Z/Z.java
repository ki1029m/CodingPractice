import java.io.*;
import java.util.*;

public class Main {

	static int N, R, C, result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =  new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		result =recursive(N,R,C);
		System.out.println(result);
		
	}
	
	static int recursive(int n, int r, int c) {
		if(n==0) {
			return 0;
		}
		
		
		//단위(N)를 기준으로 어디에 있는지 파악
		//위치해있는 곳에 따라 단위만큼 더하기
		//(2*r/size+c/size)를 하면 위치해있는 곳이 어디인지 알 수 있음
		// 0 1
		// 2 3 이 나옴
		int size = 1 << (n-1);
		return recursive(n-1, r%size,c%size) + (2*(r/size)+(c/size)) * (size*size);
		/*
		 // 현재 그리드 크기 계산 (2^n)
	    int size = (int) Math.pow(2, n - 1);
	    
	    // 현재 (r, c)가 어느 사분면에 속하는지 확인
	    if (r < size && c < size) {
	        return recursive(n - 1, r, c); // 첫 번째 사분면 (왼쪽 위)
	    } else if (r < size && c >= size) {
	        return (int) Math.pow(4, n - 1) + recursive(n - 1, r, c - size); // 두 번째 사분면 (오른쪽 위)
	    } else if (r >= size && c < size) {
	        return (int) Math.pow(4, n - 1) * 2 + recursive(n - 1, r - size, c); // 세 번째 사분면 (왼쪽 아래)
	    } else {
	        return (int) Math.pow(4, n - 1) * 3 + recursive(n - 1, r - size, c - size); // 네 번째 사분면 (오른쪽 아래)
	    }
	    */
	}

}
