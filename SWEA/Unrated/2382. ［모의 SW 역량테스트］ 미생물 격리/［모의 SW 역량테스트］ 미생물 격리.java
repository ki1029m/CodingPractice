import java.io.*;
import java.util.*;

public class Solution {
	
	static int[] dx = {0,-1,1,0,0};
	static int[] dy = {0,0,0,-1,1};
	
	
	static class Bio implements Cloneable{
		int x;
		int y;
		int size;
		int dir;
		
		Bio(int x, int y, int size, int dir){
			this.x=x;
			this.y=y;
			this.size=size;
			this.dir=dir;
		}
		
		protected Bio clone() {
			return new Bio(this.x, this.y, this.size, this.dir);
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			

			LinkedList<Bio> bioList = new LinkedList<>();
			for(int i=0; i<K; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int size = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken());

				Bio b = new Bio(x,y,size,dir);
				bioList.add(b);
			}

			
			
			//시뮬레이션
			int time=1;
			while(time <= M) {
				
				//이동
				for(int i=0; i<bioList.size(); i++) {
					
					Bio bio = bioList.get(i);
					int nx = bio.x + dx[bio.dir];
					int ny = bio.y + dy[bio.dir];
					
					
					bio.x = nx;
					bio.y = ny;
					
					//빨간 약에 닿이면 나누기 2
					if(nx==0 || ny==0 || nx==N-1 || ny==N-1) {
						//방향바꾸기
						if(bio.dir==1) bio.dir=2;
						else if(bio.dir==2) bio.dir=1;
						else if(bio.dir==3) bio.dir=4;
						else if(bio.dir==4) bio.dir=3;
						
						bio.size = bio.size / 2;
					}
				}
				
				//같은 위치의 군집군 모으기 (키 : x+y)
                Map<String, List<Bio>> map = new HashMap<>();
                for (Bio bio : bioList) {
                	if(bio.size == 0) continue;
                    String key = bio.x + "+" + bio.y;

                    if (!map.containsKey(key)) {
                    	map.put(key, new ArrayList<>());
                    }
                    map.get(key).add(bio); 
                }

                //군집 합치기
                LinkedList<Bio> newList = new LinkedList<>();

                for (List<Bio> group : map.values()) {
                    if (group.size() == 1) {
                        newList.add(group.get(0)); // 1개만 있으면 그대로 추가
                    } else {
                        // 내림차순 정렬
                        group.sort((a, b) -> b.size - a.size);

                        // 가장 큰 군집 선택
                        Bio largest = group.get(0); 
                        int totalSize = 0;
                        for (Bio bio : group) {
                            totalSize += bio.size;
                        }

                        // 최종 군집 추가 (가장 큰 미생물 군집의 방향 유지)
                        newList.add(new Bio(largest.x, largest.y, totalSize, largest.dir));
                    }
                }

                // 새로운 리스트로 변경
                bioList = newList;
				time++;
			}
			
			//결과 계산
			int result =0;
			while(!bioList.isEmpty()) {
				Bio bio = bioList.poll();
				result += bio.size;
			}
			
			System.out.println("#"+t+" "+result);
		}
		
	}

}
