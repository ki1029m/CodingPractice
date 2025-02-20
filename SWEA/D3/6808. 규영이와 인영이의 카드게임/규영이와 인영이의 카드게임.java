import java.io.*;
import java.util.*;

public class Solution {
	


	static void recursive(int[] arr, Deque<int[]> cards, int[] card, boolean[] visit, int depth) {
		if(depth == 9) {
			cards.add(card.clone());
			return;
		}
		
		for(int i=0; i<9; i++) {
			if(!visit[i]) {
				visit[i]=true;
				card[depth]=arr[i];
				recursive(arr, cards, card, visit, depth+1);
				visit[i]=false;
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			
			int[] arr1 = new int[9];
			int[] arr2 = new int[9];

			Deque<int[]> cards1 = new ArrayDeque<>();
			
			StringTokenizer st;
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<9; i++) {
				arr1[i] = Integer.parseInt(st.nextToken());
			}
			
			int idx=0;
			for(int i=1; i<=18; i++) {
				boolean isExist = false;
				//순회해서 없으면 추가
				for(int j=0; j<9; j++) {
					if(arr1[j]==i) {
						isExist = true;
					}
				}
				if(!isExist) {
					arr2[idx++]=i;
				}
			}
			
			/*
			System.out.println(Arrays.toString(arr1));
			System.out.println(Arrays.toString(arr2));
			*/
			
			recursive(arr1, cards1, new int[9], new boolean[9],0);
			
			int win=0;
			int lose=0;
			
			while(!(cards1.isEmpty())) {
				int[] c1 = cards1.poll();
				int[] c2 = arr2;
				
				
				int sum1=0;
				int sum2=0;
				for(int i=0; i<9; i++) {
					if(c1[i] > c2[i]) {
						sum1+=c1[i]+c2[i];
					}
					else if(c1[i] < c2[i]) {
						sum2+=c1[i]+c2[i];
					}
				}
				if(sum1 > sum2) {
					win++;
				}else if(sum1 < sum2) {
					lose++;
				}
				
				
			}
			
			System.out.println("#"+t+" "+win+" "+lose);
		}
	}

}
