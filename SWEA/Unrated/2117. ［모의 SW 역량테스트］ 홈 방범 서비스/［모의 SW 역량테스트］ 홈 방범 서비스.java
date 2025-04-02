import java.io.*;
import java.util.*;


public class Solution {
	
	static class Pos{
		int x;
		int y;
		Pos(int x, int y){
			this.x=x;
			this.y=y;
		}
	}
	//운영비용 K * K + (K - 1) * (K - 1)
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			int[][] arr = new int[N][N];
			List<Pos> list = new ArrayList<>()
;			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					if(arr[i][j] == 1) {
						list.add(new Pos(i,j));
					}
				}
			}
			
			int result = 0;
			for(int k=1; k<=2*N; k++) {
				int cost = k*k + (k-1)*(k-1);
				if(cost > list.size()*M) break;
				for(int i=0; i<N; i++) {
					for(int j=0; j<N; j++) {
						int count = 0;
						for(Pos h : list) {
							int dist = Math.abs(i-h.x)+Math.abs(j-h.y);
							if(dist < k) {
								count++;
							}
						}
						
						if(count*M - cost >= 0) {
							result = Math.max(result, count);
						}
					}
					
				}
			}
			System.out.println("#"+t+" "+result);
			
		}
		
	}

}
