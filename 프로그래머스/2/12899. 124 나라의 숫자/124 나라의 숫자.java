import java.util.*;

class Solution {
    public String solution(int n) throws Exception {
        String[] nums = {"1","2","4"};
        Deque<Integer> s = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        
        int num = n;
        while(num > 0){
            int idx = num%3;
            num /= 3;
            //0은 표현 안됨
            if(idx == 0) {
                num -= 1;
                s.push(2);
            }else{
                s.push(idx-1);
            }
            
        }
        
        while(!s.isEmpty()){
            sb.append(nums[s.pop()]);
        }
        return sb.toString();
    }
}