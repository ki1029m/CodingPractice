import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		//패딩을 둬서 입력 받기
		int size = 100;
		int[][] arr = new int[size+2][size+2];
		int result=0;
		for(int n=0; n<N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			
			//기준점을 좌표에 맞게 변환
			x = size-(x+10)+1;
			y = y+1;
			for(int i=0; i<10; i++) {
				for(int j=0; j<10; j++) {
					if( (0<(x+i)&&(x+i)<102) && (0<(y+j)&&(y+j)<102)) {
						arr[x+i][y+j]=1;
					}
				}
			}
		}
		
		/*
		for(int i=0; i<size+2; i++) {
			for(int j=0; j<size+2; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
		*/
		
		for(int i=0; i<size+2; i++) {
			for(int j=0; j<size+2; j++) {
				if(arr[i][j] == 0) {
					continue;
				}
				
				int[] dx = {-1,0,1,0};
				int[] dy = {0,1,0,-1};
				
				for(int m=0; m<4; m++) {
					int nx = i+dx[m];
					int ny = j+dy[m];
					if(arr[nx][ny]==0) {
						result++;
					}
				}
			}
		}
		System.out.println(result);
	}

}
