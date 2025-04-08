import java.io.*;
import java.util.*;


public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		Integer[] arr = new Integer[N];
		Integer[] dp = new Integer[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		
		int size = 0;
		Integer[] DP = new Integer[N]; //역순 정렬 위해서는 원시타입 X
		for(int i=0; i<N; i++) {
			int pos = Arrays.binarySearch(DP,0,size,arr[i], Comparator.reverseOrder());
			if(pos >= 0) continue;
			int insert = Math.abs(pos)- 1;
			DP[insert] = arr[i];
			if(insert == size) size++;
		}
		System.out.println(size);
		
		
		
		/*
		//기본 - 성공
		int max = 0;
		int[] LIS = new int[N]; //인덱스를 끝으로 하는 최대 길이
		for(int i=0; i<N; i++) {
			LIS[i] = 1;
			for(int j=0; j<i; j++) {
				//새로운 원소가 더 작을 떄 갱신
				if(arr[j] > arr[i] && LIS[i] < LIS[j]+1) {
					LIS[i] = LIS[j] + 1;
				}
			}
			max = Math.max(max, LIS[i]);
		}
		System.out.println(max);
		*/
	}

}
