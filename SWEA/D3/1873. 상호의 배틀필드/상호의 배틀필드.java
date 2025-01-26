import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			
			int x=-1, y=-1;
			Character[][] arr = new Character[H][W];
			for(int i=0; i<H; i++) {
				String line = br.readLine();
				for(int j=0; j<W; j++) {
					arr[i][j] = line.charAt(j);
					if(arr[i][j] == '^' ||
						arr[i][j] == 'v' ||
						arr[i][j] == '<' ||
						arr[i][j] == '>' ) {
						x = i;
						y = j;
					}
				}
			}
			
			int N = Integer.parseInt(br.readLine());
			String line = br.readLine();
			for(int i=0; i<N; i++) {
				char input = line.charAt(i);
				switch(input) {
				case 'U':
					arr[x][y] = '.';
					if(0<=(x-1) &&!(arr[x-1][y]=='*'||
									arr[x-1][y]=='#'||
									arr[x-1][y]=='-')) {
						x--;
					}
					arr[x][y] = '^';
					break;
				case 'D':
					arr[x][y] = '.';
					if((x+1)<H &&!(arr[x+1][y]=='*'||
									arr[x+1][y]=='#'||
									arr[x+1][y]=='-')) {
						x++;
					}
					arr[x][y] = 'v';
					break;
				case 'L':
					arr[x][y] = '.';
					if(0<=(y-1) &&!(arr[x][y-1]=='*'||
									arr[x][y-1]=='#'||
									arr[x][y-1]=='-')) {
						y--;
					}
					arr[x][y] = '<';
					break;
				case 'R':
					arr[x][y] = '.';
					if((y+1)<W &&!(arr[x][y+1]=='*'||
									arr[x][y+1]=='#'||
									arr[x][y+1]=='-')) {
						y++;
					}
					arr[x][y] = '>';
					break;
				case 'S':
					int dx=0;
					int dy=0;
					if(arr[x][y]=='^') {
						dx=-1;
						dy=0;
					}
					if(arr[x][y]=='v') {
						dx=1;
						dy=0;
					}
					if(arr[x][y]=='<') {
						dx=0;
						dy=-1;
					}
					if(arr[x][y]=='>') {
						dx=0;
						dy=1;
					}
					boolean check = true;
					int cnt = 1;
					while(check) {
						int nx = x+dx*cnt;
						int ny = y+dy*cnt;
						if(!(0<=nx && nx<H) || !(0<=ny && ny<W)) {
							check = false;
							break;
						}
						if(arr[nx][ny] == '*') {
							arr[nx][ny] = '.';
							check = false;
							break;
						}
						if(arr[nx][ny] == '#') {
							check = false;
							break;
						}
						
						cnt ++;
					}
					break;
				default:
					break;
				}
			}
			System.out.print("#"+t+" ");
			for(int i=0; i<H; i++) {
				for(int j=0; j<W; j++) {
					System.out.print(arr[i][j]);
				}
				System.out.println();
			}
		}
	}
}
