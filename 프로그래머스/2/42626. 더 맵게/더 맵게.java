import java.util.*;

class Solution {
    
    public int solution(int[] scoville, int K) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2)-> o1-o2);
        
        for(int i=0; i<scoville.length; i++){
            pq.add(scoville[i]);
        }
        
        int result = -1;
        int count = 0;
        while(pq.size()>1){
            if(pq.peek() >= K){
                result = count;
                break;
            }
            ++count;
            
            int food1 = pq.poll();
            int food2 = pq.poll();
            
            pq.add(food1+2*food2);
        }
        
        
        //하나만 남은 경우
        if (pq.size() == 1 && pq.peek() >= K) {
            result = count;
        }
        
        return result;
    }
}