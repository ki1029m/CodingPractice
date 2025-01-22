import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int M = Integer.parseInt(br.readLine());
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());

			// 1: 남자, 2: 여자
			int gender = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			if(gender == 1) {
				for(int j=0; j<N; j++) {
					if( (j+1) %num == 0) {
						if(arr[j]==1) {
							arr[j]=0;
						}
						else if(arr[j]==0) {
							arr[j]=1;
						}
					}
				}
				
				
			} else if(gender == 2) {
				int move = 0; 
				boolean isSame = true;
				while(isSame) {
					if((num-1)-move >=0 && (num-1)+move<N && arr[(num-1)-move] == arr[(num-1)+move]) {
						if(move ==0) {
							arr[(num-1)-move] = (arr[(num-1)-move]==0)? 1: 0;
						}else {
							arr[(num-1)-move] = (arr[(num-1)-move]==0)? 1: 0;
							arr[(num-1)+move] = (arr[(num-1)+move]==0)? 1: 0;
						}
						move++;
					}else {
						isSame=false;
					}
				}
			}
			
		}
		
		for(int i=0; i<N; i++) {
			System.out.print(arr[i]);
			if(i== N-1 || (i+1)%20==0) System.out.println();
			else System.out.print(" ");
		}
	}

}
