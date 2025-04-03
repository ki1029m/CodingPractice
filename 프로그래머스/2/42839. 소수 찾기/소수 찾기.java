import java.util.*;

class Solution {
    static HashSet<Integer> set = new HashSet<>();
    public int solution(String numbers) {
        recursive(numbers, new StringBuilder(), new boolean[numbers.length()]);
        return set.size();
    }
    
    static void recursive(String numbers, StringBuilder sb, boolean[] visit){
        if(sb.length() > 0){
            int num = Integer.parseInt(sb.toString());
            if(isPrime(num)) {
                set.add(num);
            }
        }
        
        for (int i = 0; i < numbers.length(); i++) {
            if (!visit[i]) {
                visit[i] = true;
                sb.append(numbers.charAt(i));
                recursive(numbers, sb, visit);
                sb.deleteCharAt(sb.length() - 1);
                visit[i] = false;
            }
        }
        
    }
    
    static boolean isPrime(int num){
        if(num <= 1) return false;
        for(int i=2; i<=Math.sqrt(num); i++){
            if(num%i == 0) return false;
        }
        return true;
    }
}