import java.io.*;
import java.util.*;

public class Main {
    static int N,max=0;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        arr=new int[N][9];

        for(int i=0;i<N;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            for(int j=0;j<9;j++) arr[i][j]=Integer.parseInt(st.nextToken());
        }

        recursive(new boolean[9],new int[9],0);
        System.out.println(max);
    }
    
    //모든 순열 계산
    static void recursive(boolean[] visit,int[] order,int depth){
    	//모두 완성
        if(depth==9){
            int score=0;
    		int idx=0;

            for(int i=0;i<N;i++){
                int out=0;
                boolean[] base=new boolean[4]; //1~3루
                
                //3아웃되면 끝
                while(out<3){
                    int player=order[idx];
                    int hit=arr[i][player];
                    
                    
                    if(hit==0) {
                    	out++;
                    }
                    else{
                    	//각 선수 진루
                    	//뒤에서 해야함에 주의%%%
                        for(int j=3;j>=1;j--){
                            if(base[j]){
                                if(j+hit>=4) {
                                	score++;
                                } else {
                                	base[j+hit]=true;
                                }
                                base[j]=false;
                            }
                        }
                        //타자 출루
                        if(hit==4) {
                        	score++;
                        }
                        else{
                        	base[hit]=true;
                        }
                    }
                    //다음 선수
                    idx=(idx+1)%9;
                }
            }
            max=Math.max(max,score);
            return;
        }
        
        //4번타자는 이미 정해짐
        if(depth==3){
            visit[0]=true;
            order[depth]=0;
            recursive(visit,order,depth+1);
            visit[0]=true;
        }else{
            for(int i=1;i<9;i++){
                if(!visit[i]){
                    visit[i]=true;
                    order[depth]=i;
                    recursive(visit,order,depth+1);
                    visit[i]=false;
                }
            }
        }
    }
}
