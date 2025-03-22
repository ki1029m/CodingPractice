import java.util.*;

class Solution {
    //어떻게 짜지...
    //1.완료되는 날짜 작성
    //2.앞날짜가 뒤보다 큰 경우의 수를 사이클 마다 계산
    public int[] solution(int[] progresses, int[] speeds) {
        //완료 날짜
        int[] days = new int[progresses.length];
        for (int i=0; i<progresses.length; i++) {
            //일수 = 남은일수/속도 올림
            
            //형변환 꼭 필요
            int day = (int)Math.ceil((double)(100-progresses[i]) / speeds[i]);
            days[i]= day;
        }
        
        List<Integer> result = new ArrayList<>();
        int cur = days[0];
        int count = 1;

        for (int i = 1; i < days.length; i++) {
            if (days[i] <= cur) {
                count++;
            } else {
                result.add(count);
                cur = days[i];
                count = 1;
            }
        }
        result.add(count); //  << 꼭 추가해야함 주의
        
        int[] answer = new int[result.size()];
        for (int i=0; i<result.size(); i++) {
            answer[i] = result.get(i);
        }
        
        return answer;
    }
}