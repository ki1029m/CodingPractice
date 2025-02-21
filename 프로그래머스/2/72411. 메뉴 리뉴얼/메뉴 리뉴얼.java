import java.io.*;
import java.util.*;

public class Solution {
    
    // 조합을 만들어주는 함수
    public static void combination(char[] arr, int start, int depth, int r, StringBuilder sb, Map<String, Integer> map) {
        if (depth == r) {
            String key = sb.toString();
            map.put(key, map.getOrDefault(key, 0) + 1);
            return;
        }

        for (int i = start; i < arr.length; i++) {
            sb.append(arr[i]);
            combination(arr, i + 1, depth + 1, r, sb, map);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static String[] solution(String[] orders, int[] course) {
        List<String> result = new ArrayList<>();
        
        for (int c : course) {
            Map<String, Integer> map = new HashMap<>();
            int maxCount = 2; // 최소 2번 이상 나온 조합만 포함
            
            for (String order : orders) {
                if (order.length() < c) continue;
                char[] orderArr = order.toCharArray();
                Arrays.sort(orderArr); // 사전순 정렬
                combination(orderArr, 0, 0, c, new StringBuilder(), map);
            }

            // 가장 많이 등장한 개수 찾기
            for (int value : map.values()) {
                maxCount = Math.max(maxCount, value);
            }

            // 가장 많이 등장한 조합 찾기
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                if (entry.getValue() == maxCount) {
                    result.add(entry.getKey());
                }
            }
        }

        Collections.sort(result); // 사전순 정렬
        return result.toArray(new String[0]);
    }
}
