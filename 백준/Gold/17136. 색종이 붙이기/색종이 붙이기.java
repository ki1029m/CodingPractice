import java.io.*;
import java.util.*;


public class Main {

	static int result = Integer.MAX_VALUE;
	
	
	public static void main(String[] args) throws IOException{

		int[][] arr = new int[10][10];
		int[] pappers = {5,5,5,5,5};
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i=0; i<10; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<10; j++) {
				arr[i][j]= Integer.parseInt(st.nextToken());
			}
		}
		
		getResult(arr,pappers,0,0,0);
		
		
		if(result != Integer.MAX_VALUE)
			System.out.println(result);
		else {
			System.out.println(-1);
		}
	}



	public static void getResult(int[][] arr, int[] pappers, int x, int y, int depth) {
		int[][] nArr = arr.clone();
		
		//종료조건
		if (isAllZero(arr)) {
		    result = Math.min(result, depth);
		    return;
		}
		
		// 탐색 범위를 초과한 경우 종료
        if (x >= 10 || y >= 10) return;

        // 현재 위치가 이미 0이면 다음 칸으로 이동
        if (arr[x][y] == 0) {
            getResult(arr, pappers, x + (y + 1) / 10, (y + 1) % 10, depth);
            return;
        }
        
        
		
		//종이 사이즈
		for(int k=1; k<=5; k++) {
			 if (pappers[k-1] > 0 && isAble(arr, x, y, k)) { 
				if(nArr[x][y]==0 || pappers[k-1]-1 <0) continue;
				changeMap(nArr,x,y,k,0);
				pappers[k-1]--;
				
				//다음칸 계산
				getResult(nArr, pappers, x + (y + 1) / 10, (y + 1) % 10, depth+1);
				
				changeMap(nArr,x,y,k,1);
				pappers[k-1]++;
			}
		}
		
		

	}
	
	public static boolean isAble(int[][] arr, int x, int y, int size) {

		
		if (x + size > 10 || y + size > 10) return false;

            
		for(int i=x; i< x+ size; i++) {
			for(int j=y; j< y+size; j++) {
				if(arr[i][j]==0) {
					return false;
				}
			}
		}
		return true;
	}
	
	public static void changeMap(int[][] arr, int x, int y, int size, int n) {
		
		for(int i=x; i< x+size; i++) {
			for(int j=y; j<y+size; j++) {
				arr[i][j] = n;
			}
		}
	}
	
	public static boolean isAllZero(int[][] arr) {
	    for (int i = 0; i < 10; i++) {
	        for (int j = 0; j < 10; j++) {
	            if (arr[i][j] == 1) return false;
	        }
	    }
	    return true;
	}
}


	