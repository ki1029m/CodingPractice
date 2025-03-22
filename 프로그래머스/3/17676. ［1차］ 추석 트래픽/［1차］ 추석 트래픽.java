import java.text.SimpleDateFormat;
import java.util.*;

class Solution {
    // 어떻게?
    // 인풋 N개의 끝나는 시간 기준 1초를 탐색
    
    public int solution(String[] lines) throws Exception {
        
        
        int N = lines.length;
        int[][] times = new int[N][2];
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss.SSS");

        for (int i=0; i<N; i++) {
            String[] str = lines[i].split(" ");
            Date endDate = format.parse(str[1]);
            double duration = Double.parseDouble(str[2].replace("s", ""));
            
            //Date끼리 빼려면 ms로 변환 후에 연산
            //시작시간 = 끝시간 - 응답시간
            int end = (int) endDate.getTime(); 
            int start = end - (int)(duration * 1000) + 1; // 시작 시간 (ms), 시작과 끝 포함
            times[i][0] = start;
            times[i][1] = end;
        }

        int max = 0;
        for (int i=0; i<N; i++) {
            int from = times[i][1];
            int to = from + 999;

            int count = 0;
            for (int j=0; j<N; j++) {
                if ( from <= times[j][1]  && times[j][0] <= to) count++;
            }
            max = Math.max(max, count);
        }

        return max;
    }
}