import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] array = new int[19][19];
		
		for(int i=0; i<19; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<19; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//1시부터 시계방향 6시 방향까지만 (반대쪽도 체크하기 때문에 중복 x)
		int[] dr = {-1,0,1,1};
		int[] dc = {1,1,1,0};
		
		//결과저장변수
		int result=0;
		int r=-1;
		int c=-1;
		
		
		for(int i=0; i<19; i++) {
			for(int j=0; j<19; j++) {
				if(array[i][j] == 0)
					continue;
				
				
				for(int k=0; k<4; k++) {
					int sum1 = 0;
					int sum2 = 0;
					boolean isContinue1 = true;
					boolean isContinue2 = true;
					for(int s=1; s<=19; s++) {
						//연속적일때만 계속체크
						if(isContinue1) {
							//방향체크
							int nr = i+dr[k]*s;
							int nc = j+dc[k]*s;
							
							if( 0<=nr && nr<19 && 0<=nc && nc<19 && array[nr][nc] != 0 && array[nr][nc]==array[i][j]) {
								sum1++;
							}
							else {
								isContinue1 = false;
							}
						}
						
						if(isContinue2) {
							//반대방향체크
							int nr = i-dr[k]*s;
							int nc = j-dc[k]*s;
							if( 0<=nr && nr<19 && 0<=nc && nc<19 && array[nr][nc] != 0 && array[nr][nc]==array[i][j]) {
								sum2++;
							}
							else {
								isContinue2 = false;
							}
						}
						
						if(!isContinue1 && !isContinue2) {
							break;
						}
						
					}
					//자신을 제외하고 4일 경우에만 승리
					if(sum1+sum2==4 && sum1==4) {
						//결과저장
						result = array[i][j];
						
						
						r=i+1;
						c=j+1;
						
						//2중 for문을 탈출하기 위한 식
						i=100;
						j=100;
						k=100;
						break;
					}
				}
			}
		}
		System.out.println(result);
		if(result != 0)
			System.out.println(r+" "+c);
		
	}

}
