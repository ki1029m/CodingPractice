import java.io.*;
import java.util.*;

class Solution {
    
    
    public boolean solution(String[] phone_book) {
        
        HashSet<String> hSet = new HashSet<>();
        for(String str : phone_book){
            hSet.add(str);
        }
        
        for(String str : phone_book){
            for(int i=1; i<str.length(); i++){
                String prefix = str.substring(0,i);
                
                if(hSet.contains(prefix)) return false;
            }
        }
        
        return true;
    }
}