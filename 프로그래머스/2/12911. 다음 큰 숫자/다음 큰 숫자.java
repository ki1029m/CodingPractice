class Solution {
    //Integer.bitCount() 쓰면 더욱 수월
    
    static int result = Integer.MAX_VALUE;
    
    public int solution(int n) {
        String str = Integer.toBinaryString(n);
        
        int one = 0;
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) == '1') one++;
        }
        
        for(int num=n+1; num<= 1_000_000; num++){
            String numStr = Integer.toBinaryString(num);
            int cnt = 0;
            for(int i=0; i<numStr.length(); i++){
                if(numStr.charAt(i) == '1') cnt++;
            }
            
            if(one == cnt){
                return num;
            }
        }
        
        return -1;
    }
    
}