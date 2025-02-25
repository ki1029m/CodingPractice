import java.io.*;
import java.util.*;

public class Main {

    static int[][] arr;
    static int R, C, T;
    static int upperX, upperY, lowerX, lowerY;

    static class Pos {
        int x, y, dust;
        Pos(int x, int y, int dust) {
            this.x = x;
            this.y = y;
            this.dust = dust;
        }
    }

    // 먼지 확산
    static void spreadDust() {
        int[][] spreadArr = new int[R][C];

        // 먼지 확산
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (arr[i][j] > 0) {
                    int spread = arr[i][j] / 5;
                    int spreadCnt = 0;
                    int[] dx = {-1, 0, 1, 0};
                    int[] dy = {0, 1, 0, -1};
                    for (int d = 0; d < 4; d++) {
                        int nx = i + dx[d];
                        int ny = j + dy[d];
                        if (0 <= nx && nx < R && 0 <= ny && ny < C && arr[nx][ny] != -1) {
                            spreadArr[nx][ny] += spread;
                            spreadCnt++;
                        }
                    }
                    arr[i][j] -= spread * spreadCnt;
                }
            }
        }

        // 확산된 먼지 반영
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                arr[i][j] += spreadArr[i][j];
            }
        }
    }

    // 공기청정기 작동
    static void cleanAir() {
        // 상단 공기청정기 (반시계방향)
        for (int i = upperX - 1; i > 0; i--) {
            arr[i][0] = arr[i - 1][0];
        }
        for (int i = 0; i < C - 1; i++) {
            arr[0][i] = arr[0][i + 1];
        }
        for (int i = 0; i < upperX; i++) {
            arr[i][C - 1] = arr[i + 1][C - 1];
        }
        for (int i = C - 1; i > 1; i--) {
            arr[upperX][i] = arr[upperX][i - 1];
        }
        arr[upperX][1] = 0;  // 공기청정기 위치 0으로 설정

        // 하단 공기청정기 (시계방향)
        for (int i = lowerX + 1; i < R - 1; i++) {
            arr[i][0] = arr[i + 1][0];
        }
        for (int i = 0; i < C - 1; i++) {
            arr[R - 1][i] = arr[R - 1][i + 1];
        }
        for (int i = R - 1; i > lowerX; i--) {
            arr[i][C - 1] = arr[i - 1][C - 1];
        }
        for (int i = C - 1; i > 1; i--) {
            arr[lowerX][i] = arr[lowerX][i - 1];
        }
        arr[lowerX][1] = 0;  // 공기청정기 위치 0으로 설정
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        arr = new int[R][C];
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == -1) {
                    if (upperX == 0) {
                        upperX = i; // 첫 번째 공기청정기
                    } else {
                        lowerX = i; // 두 번째 공기청정기
                    }
                }
            }
        }

        // 시뮬레이션 T번 동안 진행
        for (int t = 0; t < T; t++) {
            spreadDust();  // 먼지 확산
            cleanAir();    // 공기청정기 작동
        }

        // 결과 출력 (남은 먼지의 합)
        int result = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (arr[i][j] > 0) {
                    result += arr[i][j];
                }
            }
        }
        System.out.println(result);
    }
}
