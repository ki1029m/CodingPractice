import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			
			//커맨드 수
			int N = Integer.parseInt(br.readLine());
			
			int velocity = 0;
			int distance = 0;
			
			for(int i=0; i<N; i++) {
				int cmd;
				int value;
				StringTokenizer st = new StringTokenizer(br.readLine());
				
				cmd = Integer.parseInt(st.nextToken());
				
				if(cmd == 0) {
					distance += velocity;
				}else if (cmd == 1) {
					value = Integer.parseInt(st.nextToken());
					velocity += value;
					distance += velocity;
				}else if (cmd == 2) {
					value = Integer.parseInt(st.nextToken());
					velocity -= value;
					if(velocity < 0) velocity = 0;
					distance += velocity;
				}
				
				
			}
			
			System.out.println("#"+t+" "+distance);
		}
	}
}
