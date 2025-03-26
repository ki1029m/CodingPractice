class Solution {
    public int solution(String s) {
        
        int len = s.length();
        int result = len;
        for(int size=1; size<=len; size++){
            StringBuilder sb = new StringBuilder();
            int idx = 0 ;
            while(idx < len){
                //끝 부분 추가후 반복문 탈출
                if(idx + size >= len){
                    sb.append(s.substring(idx,len));
                    break;
                }
                //같은 문자 찾기
                String word = s.substring(idx, idx+size);
                int count = 1;
                int nidx = idx+size;
                while (nidx+size <= len) {
                   //System.out.println( s.substring(nidx, nidx+size));
                    if(!word.equals(s.substring(nidx, nidx+size))) break;
                    count++;
                    idx+=size;
                    nidx+=size;
                }

                if(count>1){
                    sb.append(count).append(word);
                    idx+=size;
                }else{
                    sb.append(word);
                    idx+=size;
                }
            }
            //System.out.println(sb.toString());
            result = Math.min(result, sb.toString().length());
        }
        
        
        return result;
    }
}