import java.io.*;
import java.util.*;


public class Solution {
	
	static class Node{
		int idx;
		int depth;
		Node(int idx, int depth){
			this.idx=idx;
			this.depth=depth;
		}
	}
	
	static HashMap<Integer, LinkedList<Integer>> adj;
	static int result;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int t=1; t<=10; t++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int START = Integer.parseInt(st.nextToken());
			
			adj = new HashMap<Integer, LinkedList<Integer>>();

			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N/2; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				
				if(!adj.containsKey(from)) {
					adj.put(from, new LinkedList<Integer>());
				}
				if(!adj.containsKey(to)) {
					adj.put(to, new LinkedList<Integer>());
				}
				adj.get(from).add(to);
			}

			result = START;
			bfs(START);
			
			System.out.println("#"+t+" "+result);
		}
		
		
	}
	
	static void bfs(int start) {
		
		Queue<Node> q = new ArrayDeque<Node>();
		HashSet<Integer> visit = new HashSet<>();

		int depth = 0;
		q.add(new Node(start,0));
		visit.add(start);
		
		while(!q.isEmpty()) {
			int s = q.size();
			for(int i=0; i<s; i++) {
				Node n = q.poll();
				//System.out.println(n.idx);
				
				if(n.depth > depth) {
					result = n.idx;
					depth = n.depth;
				}else if(n.depth == depth && n.idx > result){
					result = n.idx;
				}
				if(adj.containsKey(n.idx)) {
					for(Integer next : adj.get(n.idx)) {
						if(!visit.contains(next)) {
							visit.add(next);
							q.add(new Node(next, n.depth+1));
						}
						
					}
				}
			}
			
		}
			
	}

}
