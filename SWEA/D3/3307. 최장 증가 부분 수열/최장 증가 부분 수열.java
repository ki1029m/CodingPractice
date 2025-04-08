import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			int size = 0; //LIS 크기
			int[] DP = new int[N]; //길이별 올 수 있는 최소 원소
			for(int i=0; i<N; i++) {
				int pos = Arrays.binarySearch(DP,0,size,arr[i]);
				int insert = Math.abs(pos)- 1;
				DP[insert] = arr[i];
				if(insert == size) size++;
			}
			System.out.println("#"+t+" "+size);
			
			/*
			//기본 풀이법
			int max = 0;
			int[] LIS = new int[N]; //인덱스를 끝으로 하는 최대 길이
			for(int i=0; i<N; i++) {
				LIS[i] = 1;
				for(int j=0; j<i; j++) {
					if(arr[j] < arr[i] && LIS[i] < LIS[j]+1) {
						LIS[i] = LIS[j] + 1;
					}
				}
				max = Math.max(max, LIS[i]);
			}
			System.out.println("#"+t+" "+max);
			*/
			
		}
		
	}

}
