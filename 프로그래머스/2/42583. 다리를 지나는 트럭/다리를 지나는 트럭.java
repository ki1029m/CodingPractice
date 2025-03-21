import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> q = new ArrayDeque<>();
        int time = 0;
        int wSum = 0;
        int idx = 0;

        for (int i = 0; i < bridge_length; i++) {
            q.offer(0);
        }

        while (idx < truck_weights.length) {
            time++;

            wSum -= q.poll();

            int t = truck_weights[idx];
            if (wSum + t <= weight) {
                q.offer(t);
                wSum += t;
                idx++;
            } else {
                q.offer(0);
            }
        }

        return time + bridge_length;
    }
}
