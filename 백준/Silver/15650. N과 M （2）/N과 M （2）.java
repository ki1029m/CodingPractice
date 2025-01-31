import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] arr, result;

    public static void recursive(int depth, int start) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(result[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = start; i < N; i++) {
            result[depth] = arr[i]; // arr 배열에서 숫자를 선택
            recursive(depth + 1, i + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        result = new int[M];

        // 1부터 N까지 숫자를 arr 배열에 저장
        for (int i = 0; i < N; i++) {
            arr[i] = i + 1;
        }

        recursive(0, 0);
    }
}