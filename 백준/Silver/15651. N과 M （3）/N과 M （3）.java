import java.io.*;
import java.util.StringTokenizer;
 
public class Main {
    static int N, M;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = i + 1;
        }
        
        recursive(0, new int[M]);
        System.out.print(sb);
    }
    
    static void recursive(int depth, int[] result) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(result[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        
        for (int i = 1; i <= N; i++) {
            result[depth] = arr[i - 1];
            recursive(depth + 1, result);
        }
    }
}
