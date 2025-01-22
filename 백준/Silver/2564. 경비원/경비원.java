import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		/*
		 * 1:북쪽
		 * 2:남쪽
		 * 3:서쪽
		 * 4:동쪽
		 */
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		//가로
		int C = Integer.parseInt(st.nextToken());
		//세로
		int R = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		
		ArrayList<int[]> al = new ArrayList<>();
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int type = Integer.parseInt(st.nextToken());
			int position = Integer.parseInt(st.nextToken());
			if(type == 1) {
				al.add(new int[] {0,position});
			}
			if(type == 2) {
				al.add(new int[] {R,position});
			}
			if(type == 3) {
				al.add(new int[] {position,0});
			}
			if(type == 4) {
				al.add(new int[] {position,C});
			}
		}
		
		int[] dong = {,};
		st = new StringTokenizer(br.readLine());
		int type = Integer.parseInt(st.nextToken());
		int position = Integer.parseInt(st.nextToken());
		if(type == 1) {
			dong = new int[] {0,position};
		}
		if(type == 2) {
			dong = new int[] {R,position};
		}
		if(type == 3) {
			dong = new int[] {position,0};
		}
		if(type == 4) {
			dong = new int[] {position,C};
		}
		
		int result =0;
		for(int[] a : al) {
			if(Math.abs(a[0]-dong[0]) == R) {
				result += Math.min(R+a[1]+dong[1],R+(C-a[1])+(C-dong[1]));
			} else if (Math.abs(a[1]-dong[1]) == C) {
				result += Math.min(C+a[0]+dong[0],C+(R-a[0])+(R-dong[0]));
			} else {
				result += Math.abs(a[0]-dong[0]) + Math.abs(a[1]-dong[1]);
			}
		}
		System.out.println(result);

	}

}
