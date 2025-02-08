import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K;
    static int[][] arr;
    static int[][] rcs;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        rcs = new int[K][3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            rcs[i][0] = Integer.parseInt(st.nextToken()) - 1;
            rcs[i][1] = Integer.parseInt(st.nextToken()) - 1;
            rcs[i][2] = Integer.parseInt(st.nextToken());
        }

        //모든 경우의 수 탐색
        recursive(new boolean[K], new int[K], 0);

        System.out.println(min);
    }

    //회전 구현
    public static void rotate(int[][] arr, int x, int y, int s) {
        for (int step=1; step<= s; step++) {
            int temp = arr[x-step][y-step]; //제일 왼쪽위부터
            
            //왼쪽
            for(int i=x-step; i<x+step; i++) {
            	arr[i][y-step]=arr[i+1][y-step];
            }
            //아래
            for(int i = y - step; i < y + step; i++) {
            	arr[x+step][i]=arr[x+step][i + 1];
            }
            //오른쪽
            for(int i=x+step; i>x-step; i--) {
            	arr[i][y+step]=arr[i-1][y+step];
            }
            //위
            for(int i=y+step; i>y-step+1; i--) {
            	arr[x-step][i]=arr[x-step][i-1];
            }

            arr[x-step][y-step+1]=temp;
        }
    }

    public static void recursive(boolean[] visited, int[] order, int depth) {
        if (depth == K) {
            int[][] copyArr = new int[N][M];
            for (int i = 0; i < N; i++) {
                copyArr[i] = arr[i].clone();
            }
            
            //가능한 모든 순서로 회전
            for (int i = 0; i < K; i++) {
                int idx = order[i];
                rotate(copyArr, rcs[idx][0], rcs[idx][1], rcs[idx][2]);
            }
            
            for (int i = 0; i < copyArr.length; i++) {
                int sum = 0;
                for (int j = 0; j < copyArr[0].length; j++) {
                    sum += copyArr[i][j];
                }
                min = Math.min(min, sum);
            }
            
            return;
        }

        for (int i = 0; i < K; i++) {
            if (!visited[i]) {
                visited[i] = true;
                order[depth] = i;
                recursive(visited, order, depth + 1);
                visited[i] = false;
            }
        }
    }
}