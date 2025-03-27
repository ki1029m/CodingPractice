import java.io.*;
import java.util.*;

public class Solution {

	static class Person {
        int x;
        int y;
        public Person(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Stair {
        int x;
        int y;
        int len;
        public Stair(int x, int y, int len) {
            this.x = x;
            this.y = y;
            this.len = len;
        }
    }

    static int N, result;
    static List<Person> people;
    static Stair[] stairs;
    static boolean[] selected;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            people = new ArrayList<>();
            stairs = new Stair[2];
            int idx = 0;
            //입력
            for (int i=0; i<N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j=0; j<N; j++) {
                    int value = Integer.parseInt(st.nextToken());
                    if (value == 1) {
                    	people.add(new Person(i, j));
                    }
                    else if(value >= 2) {
                    	stairs[idx++] = new Stair(i, j, value);
                    }
                }
            }

            selected = new boolean[people.size()];
            result = Integer.MAX_VALUE;

            powerSet(0);
            System.out.println("#" + t + " " + result);
        }
    }

    static void powerSet(int depth) {
    	
        if (depth == people.size()) { //어디로 갈지 정해짐
            List<Integer> sList1 = new ArrayList<>();
            List<Integer> sList2 = new ArrayList<>();

            for (int i = 0; i < people.size(); i++) {
                Person p = people.get(i);
                		
                if(selected[i]) {
                	sList1.add(Math.abs(p.x-stairs[0].x) + Math.abs(p.y-stairs[0].y));
                }else {
                	sList2.add(Math.abs(p.x-stairs[1].x) + Math.abs(p.y-stairs[1].y));
                }
            }

            int stairMax = 0;
            for (int i = 0; i < 2; i++) {
                List<Integer> arr = null;
                //계단까지 걸리는 시간들
                if(i == 0) arr = sList1;
                else arr = sList2;
                
                Collections.sort(arr);
                PriorityQueue<Integer> pq = new PriorityQueue<>();
                
                for (int dist : arr) {
                	int startTime = dist+1;
                	if (pq.size() >= 3) {
                		startTime = Math.max(startTime, pq.peek());
                		pq.poll(); // 기다리는 사람을 대기 큐에서 제거
                    }
                	
                	pq.offer(startTime + stairs[i].len);
                	stairMax = Math.max(stairMax, startTime + stairs[i].len);
                }
            }
            result = Math.min(result, stairMax);
            return;
        }
        selected[depth] = false;
        powerSet(depth + 1);
        selected[depth] = true;
        powerSet(depth + 1);
    }

}

