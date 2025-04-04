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
                if(i>0)i--;
            }else{
                i++;
            }
        }
        return sb.toString();
    }
}

