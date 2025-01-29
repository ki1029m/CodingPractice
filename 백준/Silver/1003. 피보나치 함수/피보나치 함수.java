import java.util.*;
import java.io.*;

public class Main {
	static int num0 = 0;
	static int num1 = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			num0=0;
			num1=0;
			int N = Integer.parseInt(br.readLine());
			
			//[][0]: 0의 개수
			//[][1]: 1의 개수
			int[][] arr = new int[41][2];
			arr[0][0]=1;
			arr[0][1]=0;
			arr[1][0]=0;
			arr[1][1]=1;
			for(int i=2;i<41;i++) {
				arr[i][0]=arr[i-2][0]+arr[i-1][0];
				arr[i][1]=arr[i-2][1]+arr[i-1][1];
			}
			System.out.println(arr[N][0]+" "+arr[N][1]);
		}
	}
	

}
