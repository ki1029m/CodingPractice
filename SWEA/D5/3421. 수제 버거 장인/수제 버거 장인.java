import java.io.*;
import java.util.*;

public class Solution {
	
	static class Ingredient{
		int num1;
		int num2;
		Ingredient(int num1, int num2){
			this.num1=num1;
			this.num2=num2;
		}
	}

	static void powerSet(int depth, int state) {
		
		
		
		if(depth==N) {
			for(Ingredient i : q) {
				if( (state & (1<<(i.num1-1)))!=0 && (state & (1<<(i.num2-1)))!=0 ) {
					return;
				}
			}
			result++;
			return;
		}
		
		powerSet(depth+1, (state | (1<<depth)));
		powerSet(depth+1, state);
		
	}
	
	static int N,M,result;
	static Deque<Ingredient> q;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			result = 0;
			q = new ArrayDeque<>();
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				int i1 = Integer.parseInt(st.nextToken());
				int i2 = Integer.parseInt(st.nextToken());
				q.add(new Ingredient(i1,i2));
			}
			
			powerSet(0,0);
			System.out.println("#"+t+" "+result);
		}
		
	}

}
