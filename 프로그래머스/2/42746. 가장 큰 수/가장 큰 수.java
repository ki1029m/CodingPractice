import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        ArrayList<String> list = new ArrayList<>();
        
        for(int a : numbers){
            list.add(Integer.toString(a));
        }
        
        list.sort((o1,o2)->
                  Integer.compare(Integer.parseInt(o2+o1), Integer.parseInt(o1+o2))
                 );
        
        StringBuilder sb = new StringBuilder();
        for(String str : list){
            sb.append(str);
        }
        
        String result;
        if(sb.charAt(0) == '0') return "0";
        else return sb.toString();
    }
}