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
		
		int[] cmd = new int[R];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<R; i++) {
			cmd[i] = Integer.parseInt(st.nextToken());
		}
		
		int[][] temp = {};
		for(int r=0; r<R; r++) {
			
			
			switch(cmd[r]) {
			case 1:
				temp = new int[N][M];
				for(int i=0; i<N; i++) {
					for(int j=0; j<M; j++) {
						temp[(N-1)-i][j] = arr[i][j];
					}
				}
				break;
			case 2:
				temp = new int[N][M];
				for(int i=0; i<N; i++) {
					for(int j=0; j<M; j++) {
						temp[i][(M-1)-j] = arr[i][j];
					}
				}
				break;
			case 3:
				temp = new int[M][N];
				for(int i=0; i<N; i++) {
					for(int j=0; j<M; j++) {
						temp[j][(N-1)-i] = arr[i][j];
					}
				}
				int t1 = N;
				N = M;
				M = t1;
				break;
			case 4:
				temp = new int[M][N];
				for(int i=0; i<N; i++) {
					for(int j=0; j<M; j++) {
						temp[(M-1)-j][i] = arr[i][j];
					}
				}
				int t2 = N;
				N = M;
				M = t2;
				break;
			case 5:
				temp = new int[N][M];
				//왼쪽 위 -> 오른쪽 위
				for(int i=0; i<N/2; i++) {
					for(int j=0; j<M/2; j++) {
						temp[i][j+M/2] = arr[i][j];
					}
				}
				//오른쪽 위 -> 오른쪽 아래
				for(int i=0; i<N/2; i++) {
					for(int j=M/2; j<M; j++) {
						temp[i+N/2][j] = arr[i][j];
					}
				}
				//오른쪽 아래 -> 왼쪽 아래
				for(int i=N/2; i<N; i++) {
					for(int j=M/2; j<M; j++) {
						temp[i][j-M/2] = arr[i][j];
					}
				}
				//왼쪽 아래 -> 왼쪽 위
				for(int i=N/2; i<N; i++) {
					for(int j=0; j<M/2; j++) {
						temp[i-N/2][j] = arr[i][j];
					}
				}
				
				break;
			case 6:
				temp = new int[N][M];
				//왼쪽 위 -> 왼쪽 아래
				for(int i=0; i<N/2; i++) {
					for(int j=0; j<M/2; j++) {
						temp[i+N/2][j] = arr[i][j];
					}
				}
				//왼쪽 아래 -> 오른쪽 아래
				for(int i=N/2; i<N; i++) {
					for(int j=0; j<M/2; j++) {
						temp[i][j+M/2] = arr[i][j];
					}
				}
				//오른쪽 아래 -> 오른쪽 위
				for(int i=N/2; i<N; i++) {
					for(int j=M/2; j<M; j++) {
						temp[i-N/2][j] = arr[i][j];
					}
				}
				//오른쪽 위 -> 왼쪽 아래
				for(int i=0; i<N/2; i++) {
					for(int j=M/2; j<M; j++) {
						temp[i][j-M/2] = arr[i][j];
					}
				}
				break;
			}
			
			arr=temp;
		}
		
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[0].length; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		
	}

}
