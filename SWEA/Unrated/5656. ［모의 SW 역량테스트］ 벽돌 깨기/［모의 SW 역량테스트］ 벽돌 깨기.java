import java.io.*;
import java.util.*;

public class Solution {
	
	static int N, W, H;
	static LinkedList<Integer[]> list;
	static int[][] arr;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	
	static class Block{
		int x;
		int y;
		int power;
		
		Block(int x, int y, int power){
			this.x=x;
			this.y=y;
			this.power=power;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			
			arr = new int[H][W];
			
			for(int i=0; i<H; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<W; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			list = new LinkedList<>();
			//N번에 해당하는 중복 순열 만들기
			recursive(new Integer[N], 0);
			
			//가능한 경우 순회
			int result = Integer.MAX_VALUE;
			for(Integer[] order : list) {
				
				//원본 배열 복사
				int[][] nArr = new int[H][W];
				for(int i=0; i<H; i++) {
					nArr[i] = arr[i].clone();
				}
				
				//order 순회
				for(int n=0; n<N; n++) {
					int line = order[n];
					
					Block b = null;
					b = findBlock(nArr, line);
					if(b == null) continue;
					
					deleteBlocks(new boolean[H][W],nArr, b);
					
					updateBlocks(nArr);
				}
				
				/*
				for(int i=0; i<H; i++) {
					for(int j=0; j<W; j++) {
						System.out.print(nArr[i][j]+" ");
					}
					System.out.println();
				}
				System.out.println();
				*/
				
				int count = 0;
				for(int i=0; i<H; i++) {
					for(int j=0; j<W; j++) {
						if(nArr[i][j] != 0) count++;
					}
				}
				result = Math.min(count, result);
			}
			
			System.out.println("#"+t+" "+result);
			
		}
	}
	
	static void updateBlocks(int[][] nArr) {
		for (int j = 0; j < W; j++) {
	        Queue<Integer> q = new ArrayDeque<>();
	        for (int i = H-1; i>=0; i--) {
	            if (nArr[i][j] != 0) {
	                q.add(nArr[i][j]);
	                nArr[i][j] = 0;
	            }
	        }
	        int i = H-1;
	        while (!q.isEmpty()) {
	        	nArr[i][j] = q.poll();
	            i--;
	        }
	    }
	}
	
	static void deleteBlocks(boolean[][] visited, int[][] nArr, Block start) {
		
	    Queue<Block> q = new ArrayDeque<>();
	    q.offer(start);
	    visited[start.x][start.y] = true;

	    while (!q.isEmpty()) {
	        Block b = q.poll();
	        int power = b.power;
	        nArr[b.x][b.y] = 0;

	        for (int d = 0; d < 4; d++) {
	            for (int p = 0; p < power; p++) {
	                int nx = b.x + dx[d] * p;
	                int ny = b.y + dy[d] * p;

	                if (nx < 0 || ny < 0 || nx >= H || ny >= W) continue;
	                if (visited[nx][ny]) continue;
	                
	                visited[nx][ny] = true;
                    q.offer(new Block(nx, ny, nArr[nx][ny]));
	            }
	        }
	    }
	}
	
	//해당 라인 윗쪽 블럭찾기
	static Block findBlock(int[][] nArr, int line) {
		for(int i=0; i<H; i++) {
			if(nArr[i][line] != 0) return new Block(i,line, nArr[i][line]);
		}
		return null;
	}
	
	static void recursive(Integer[] result, int idx){
		if(idx == N) {
			list.add(result.clone());
			return;
		}
		
		for(int i=0; i<W; i++) {
			result[idx] = i;
			recursive(result, idx+1);
		}
		
	}

}
