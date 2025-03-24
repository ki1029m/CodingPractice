import java.util.*;

class Solution {
    static class Q{
        int idx;
        int prior;
        Q(int idx, int prior){
            this.idx=idx;
            this.prior=prior;
        }
    }
    
    public int solution(int[] priorities, int location) {
        Queue<Q> queue = new ArrayDeque<>();
        
        for(int i=0; i<priorities.length; i++){
            queue.add(new Q(i,priorities[i]));
        }
        
        int answer=0;
        while(!queue.isEmpty()){
            Q q = queue.poll();
            
            boolean hasHigh = false;
            for(Q temp : queue){
                if(temp.prior > q.prior){
                    hasHigh = true;
                    break;
                }
            }
            
            if(hasHigh){
                queue.add(q);
            }else{
                answer++;
                
                if(q.idx == location){
                    return answer;
                }
            }
            
            
        }
        
        return answer;
    }
}