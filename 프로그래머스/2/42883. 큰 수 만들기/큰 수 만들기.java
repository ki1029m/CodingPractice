import java.util.*;

class Solution {
    
            
    public String solution(String number, int k) {
        
        StringBuilder sb = new StringBuilder(number);
        int count = 0;
        int i=0;
        while(count < k){
            if(i==number.length()-1 || sb.charAt(i)<sb.charAt(i+1)){
                sb.deleteCharAt(i);
                count++;
                //첫번째 삭제하는 경우 예외 발생 가능하므로 조건을 달아야 함
                if(i>0)i--; 
            }else{
                i++;
            }
        }
        return sb.toString();
    }
}

