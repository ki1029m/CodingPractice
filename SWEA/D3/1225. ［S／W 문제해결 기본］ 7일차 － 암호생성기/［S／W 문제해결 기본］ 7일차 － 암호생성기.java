import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int t=1; t<=10; t++) {
			
			int T = Integer.parseInt(br.readLine());
			Deque<Integer> q = new ArrayDeque<>();
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<8; i++) {
				q.add(Integer.parseInt(st.nextToken()));
			}
			
			
			while(true) {
				boolean isZero = false;
				for(int i=1;i<=5;i++) {
					int num = q.poll();
					if(num-i>0) {
						q.add(num-i);
					}else {
						q.add(0);
						isZero = true;
						break;
					}
				}
				if(isZero) break;
			}
			
			System.out.print("#"+t+" ");
			while(!q.isEmpty()) {
				System.out.print(q.poll()+" ");
			}
			System.out.println();
			
		}
	}

}
