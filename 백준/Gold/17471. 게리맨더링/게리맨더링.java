import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] people;
    static int[][] g;
    static boolean[] powerSet;
    static int minDiff = Integer.MAX_VALUE;
    static int count;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        people = new int[N + 1];
        g = new int[N + 1][N + 1];
        powerSet = new boolean[N + 1];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            people[i] = Integer.parseInt(st.nextToken());
        }
        
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            for (int j = 0; j < cnt; j++) {
                int vertex = Integer.parseInt(st.nextToken());
                g[i][vertex] = 1;
                g[vertex][i] = 1;
            }
        }
        
        powerset(1);
        
        System.out.println(minDiff == Integer.MAX_VALUE ? -1 : minDiff);
    }
    
    static void powerset(int idx) {
        if (idx > N) {
            List<Integer> listA = new ArrayList<>();
            List<Integer> listB = new ArrayList<>();
            
            for (int i = 1; i <= N; i++) {
                if (powerSet[i]) {
                    listA.add(i);
                } else {
                    listB.add(i);
                }
            }
            
            if (!listA.isEmpty() && !listB.isEmpty()) {
                if (isAble(listA, listB)) {
                    int sumA = 0;
                    int sumB = 0;
                    
                    for (int i = 1; i <= N; i++) {
                        if (powerSet[i]) {
                            sumA += people[i];
                        } else {
                            sumB += people[i];
                        }
                    }
                    
                    minDiff = Math.min(minDiff, Math.abs(sumA - sumB));
                }
            }
            return;
        }
        
        powerSet[idx] = true;
        powerset(idx + 1);
        
        powerSet[idx] = false;
        powerset(idx + 1);
    }
    
    static boolean isAble(List<Integer> listA, List<Integer> listB) {
        count = 0;
        dfs(listA.get(0), new boolean[N + 1], listA);
        if (count != listA.size()) {
            return false;
        }
        
        count = 0;
        dfs(listB.get(0), new boolean[N + 1], listB);
        if (count != listB.size()) {
            return false;
        }
        
        return true;
    }
    
    static void dfs(int start, boolean[] visit, List<Integer> list) {
        if (visit[start]) {
            return;
        }
        visit[start] = true;
        count++;
        
        //start에서 갈 수 있는 곳 모두 체크
        //갈 수 있다면 dfs로 해당 vertex에서 다른 곳으로 갈 수 있는지 체크
        for (int i : list) {
            if (g[start][i] != 0 && !visit[i]) {
                dfs(i, visit, list);
            }
        }
    }
}
