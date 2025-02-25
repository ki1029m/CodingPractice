import java.io.*;
import java.util.*;


public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		
		for(int r=0; r<R; r++) {
			int step = Math.min(N, M)/2;
			//겉 부분부터 돌리기
			for(int s=0; s<step; s++) {
				int temp = arr[s][s];
				
				//거꾸로 바꿔줘야함
				for(int j=s; j<M-s-1; j++) {
					arr[s][j] = arr[s][j+1];
				}
				for(int i=s; i<N-s-1; i++) {
					arr[i][M-1-s] = arr[i+1][M-1-s];
				}
				for(int j=M-s-1; j>s; j--) {
					arr[N-1-s][j] = arr[N-1-s][j-1];
				}
				for(int i=N-s-1; i>s; i--) {
					arr[i][s] = arr[i-1][s];
				}
				
				arr[s+1][s] = temp;
				
				
				
			}
		}
		
		
		//결과 출력
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		
	}

}
