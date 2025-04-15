import java.io.*;
import java.util.*;

public class Solution {

    static class Cell implements Comparable<Cell> {
        int x;
        int y;
        int life; //생명력
        int time; //만든시간
        boolean active;

        public Cell(int x, int y, int life, int time, boolean active) {
            this.x = x;
            this.y = y;
            this.life = life;
            this.time = time;
            this.active = active;
        }

        @Override
        public int compareTo(Cell o) {
            //내림차순
            return o.life - this.life;
        }
    }

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int SIZE = 700;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t=1; t<=T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int[][] map = new int[SIZE][SIZE];
            boolean[][] visited = new boolean[SIZE][SIZE];
            PriorityQueue<Cell> pq = new PriorityQueue<>();
            Queue<Cell> inactive = new LinkedList<>();
            Queue<Cell> active = new LinkedList<>();

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    int value = Integer.parseInt(st.nextToken());
                    if (value > 0) {
                        int nx = i + SIZE/2;
                        int ny = j + SIZE/2;
                        map[nx][ny] = value;
                        visited[nx][ny] = true;
                        inactive.offer(new Cell(nx, ny, value, 0, false));
                    }
                }
            }

            for (int time = 1; time <= K; time++) {
            	//활성화
                int size = inactive.size();
                for (int i = 0; i < size; i++) {
                    Cell c = inactive.poll();
                    if (time - c.time == c.life) {
                        active.offer(new Cell(c.x, c.y, c.life, time, true));
                    } else {
                        inactive.offer(c);
                    }
                }

                //번식
                PriorityQueue<Cell> newCells = new PriorityQueue<>();
                size = active.size();
                for (int i = 0; i < size; i++) {
                    Cell cell = active.poll();
                    if (time - cell.time == 1) {
                        for (int d = 0; d < 4; d++) {
                            int nx = cell.x + dx[d];
                            int ny = cell.y + dy[d];
                            if (!visited[nx][ny]) {
                                newCells.offer(new Cell(nx, ny, cell.life, time, false));
                            }
                        }
                    }
                    if (time - cell.time < cell.life) {
                        active.offer(cell);
                    }
                }

                // 우선순위 큐에서 높은것부터 채우기
                while (!newCells.isEmpty()) {
                    Cell c = newCells.poll();
                    if (!visited[c.x][c.y]) {
                        visited[c.x][c.y] = true;
                        inactive.offer(c);
                    }
                }
            }

            System.out.println("#" + t + " " + (inactive.size() + active.size()));
        }
    }
}
