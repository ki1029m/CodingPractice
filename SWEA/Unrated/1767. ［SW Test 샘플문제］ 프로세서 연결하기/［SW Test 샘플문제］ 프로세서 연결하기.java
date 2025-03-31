import java.io.*;
import java.util.*;

public class Solution {
	
    static class Pos {
        int x;
        int y;
        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N;
    static int maxCore;
    static int minLen;
    static List<Pos> cores;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            int[][] arr = new int[N][N];
            cores = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    if (arr[i][j] == 1) {
                    	
                    	if (i==0 || i==N-1 || j==0 || j==N-1) continue;
                        cores.add(new Pos(i, j));
                    }
                }
            }

            maxCore = 0;
            minLen = Integer.MAX_VALUE;

            recursive(0, 0, 0, arr);

            System.out.println("#"+t+" "+minLen);
        }
    }
    
    static void recursive(int idx, int count, int length, int[][] arr) {
    	
    	//코어 다 돌면 갱신
        if (idx == cores.size()) {
        	if (count == maxCore) {
                minLen = Math.min(minLen, length);
            }else if (count > maxCore) {
                maxCore = count;
                minLen = length;
            }
            
            return;
        }

        Pos core = cores.get(idx);
        int x = core.x;
        int y = core.y;
        
        //선택안함
        recursive(idx + 1, count, length, arr);
        
        //4방탐색
        for (int d=0; d<4; d++) {
            int wireLen = 0;
            boolean isConnect = true;
            
            //일직선 확인
            while (true) {
                int nx= x+dx[d]*(wireLen+1);
                int ny= y+dy[d]*(wireLen+1);

                if (nx<0 || nx>= N || ny<0 || ny>=N) break;
                if (arr[nx][ny]==1 || arr[nx][ny]==2) {
                	isConnect = false;
                    break;
                }
                wireLen++;
            }

            if (isConnect) {
            	int[][] nArr = new int[N][N];
                for (int i = 0; i < N; i++) {
                    nArr[i] = arr[i].clone();
                }
            	
                for (int i = 0; i < wireLen; i++) {
                    int nx = x+dx[d]*(i+1);
                    int ny = y+dy[d]*(i+1);
                    nArr[nx][ny] = 2;
                }

                recursive(idx+1, count+1, length+wireLen, nArr);
            }
        }
    }
}