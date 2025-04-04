import java.io.*;
import java.util.*;

public class Solution {
	
	static int[][] arr;
	static int N,M, result;
	static boolean isAble;
	
	public static boolean bfs(int num){

		boolean[] visit1 = new boolean[N+1];
		Deque<Integer> q = new ArrayDeque<Integer>();
		q.offer(num);
		visit1[num]=true;
		
		//나가는 방향
		while(!q.isEmpty()) {
			int now = q.poll();
			for(int i=1; i<=N; i++) {
				if(!visit1[i] && arr[now][i]==1) {
					visit1[i]=true;
					q.offer(i);
				}
			}
		}
		
		//들어오는 방향
		boolean[] visit2 = new boolean[N+1];
		q = new ArrayDeque<Integer>();
		q.offer(num);
		visit2[num]=true;
		
		while(!q.isEmpty()) {
			int now = q.poll();
			for(int i=1; i<=N; i++) {
				if(!visit2[i] && arr[i][now]==1) {
					visit2[i]=true;
					q.offer(i);
				}
			}
		}
		
		for(int i=1; i<=N; i++) {
			if(!(visit1[i]||visit2[i])) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());
			
			arr = new int[N+1][N+1];
			for(int i=0; i<M; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				
				arr[from][to]=1;
			}

			result=0;
			for(int i=1; i<=N; i++) {
				if(bfs(i)) {
					result++;
				}
			}
			System.out.println("#"+t+" "+result);
		}

	}
}
