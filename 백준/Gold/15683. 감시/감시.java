import java.io.*;
import java.util.*;

public class Main {
	
	static class Camera{
		int x;
		int y;
		int dir;
		int type;
		
		Camera(int x, int y, int dir, int type){
			this.x=x;
			this.y=y;
			this.dir=dir;
			this.type=type;
		}
	}
	
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static int N,M;
	
	//앞은 카메라 별로 가지고 있는 dx, dy의 인덱스
	//d의 값들을 +1씩 돌려가며 순회하면 됨
	static int[][] d = {{0}, {0,2}, {0,1}, {0,1,2}, {0,1,2,3}};
	
	static LinkedList<Integer[]> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[N][M];
		LinkedList<Camera> camList = new LinkedList<>();
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] != 6 && arr[i][j] != 0) {
					camList.add(new Camera(i, j, 0, arr[i][j]-1));
				}
			}
		}
		
		//순열 저장할 리스트
		list = new LinkedList<Integer[]>();
		//0~3까지 중복 순열을 생성
		recursive(new int[]{0,1,2,3}, 0, camList.size(), new Integer[camList.size()]);
		
		/*
		for(Integer[] i : list) {
			for(Integer c : i) {
				System.out.print(c+" ");
			}
			System.out.println();
		}
		System.out.println();
		*/
		
		//순열 경우의 수
		int result=Integer.MAX_VALUE;
		for(Integer[] nums: list) {
			//카메라별 방향 설정
			for(int i=0; i<nums.length; i++) {
				Camera c = camList.get(i);
				c.dir = nums[i];
				
				
				//타입에 따라 바라보는 인덱스 들고 오기
				int[] idxs = d[c.type].clone();
				
				//순열에 따라 바라보는 인덱스 바꾸기
				for(int j=0; j<idxs.length; j++) {
					idxs[j] = (idxs[j]+nums[i])%4;
				}
				
				
				//방향별 감시 영역 그리기
				for(int j=0; j<idxs.length; j++) {
					draw(arr, c.x, c.y, idxs[j]);
				}
			}
			
			//맵에서 0개수 구하기
			int zero=0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(arr[i][j] == 0) zero++;
				}
			}
			
			/*
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					System.out.print(arr[i][j]+" ");
				}
				System.out.println();
			}
			System.out.println();
			*/
			
			//원복
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(arr[i][j] == -1) arr[i][j] = 0;
				}
			}
			
			result = Math.min(result, zero);
			
			
			
		}
		
		
		System.out.println(result);
	}
	
	//중복 조합 생성
	static void recursive(int[] arr, int depth, int camsize, Integer[] result) {
		if(depth == camsize) {
			list.add(result.clone());
			return;
		}
		
		for(int i=0; i<arr.length; i++) {
			result[depth] = arr[i];
			recursive(arr, depth+1, camsize, result);
		}
	}
	
	//한줄씩 긋는 함수
	static void draw(int[][] arr, int x, int y, int dir) {
		int[] dx = {-1,0,1,0};
		int[] dy = {0,1,0,-1};
		
		while(true) {
			int nx = x+dx[dir];
			int ny = y+dy[dir];
			
			if(!(0<=nx&&nx<N&&0<=ny&&ny<M)) break;
			if(arr[nx][ny] == 6) break;
			
			if(arr[nx][ny] == 0) arr[nx][ny]=-1;
			
			
			x=nx;
			y=ny;
		}
		
	}
	

}
