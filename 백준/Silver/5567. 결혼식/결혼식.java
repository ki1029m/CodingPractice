import java.io.*;
import java.util.*;

public class Main {

	static int N,M;
	static int result;
	static int[][] graph;
	public static void main(String[] args) throws IOException{
		//--------------솔루션 코드를 작성하세요.--------------------------------
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		graph = new int[N+1][N+1];
		
		for(int i=0; i<M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			graph[s][e] = 1;
			graph[e][s] = 1;
		}
		
		bfs();
		
		//System.out.println();
		//자기 자신 빼고 출력
		System.out.println(result-1);
	}

	static void bfs() {
		
		Deque<Integer> q = new ArrayDeque<>();
		boolean[] visit = new boolean[N+1];
		
		q.add(1);
		visit[1] = true;
		

		int depth = 0;
		while(depth <= 2 && !q.isEmpty()) {
			int size = q.size();
			int count = 0;
			//System.out.println("사이즈"+size);
			while(count < size) {
				Integer n = q.poll();
				//System.out.println(n);
				result++;
				
				for(int i=1; i<=N; i++) {
					if(visit[i]) continue;
					if(graph[n][i] == 0) continue;
					visit[i] = true;
					q.add(i);
				}
				count++;
			}
			depth++;
		}
		
		
	}
}
