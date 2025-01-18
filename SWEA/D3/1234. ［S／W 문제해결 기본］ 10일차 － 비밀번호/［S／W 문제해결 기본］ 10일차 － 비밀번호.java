import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//int T = Integer.parseInt(br.readLine());
		int T = 10;
		
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine()); 
			int N = Integer.parseInt(st.nextToken());
			String str = st.nextToken();
			StringBuilder sb = new StringBuilder(str);
			int i= 0;
			while (i < sb.length() - 1) {
                if (sb.charAt(i) == sb.charAt(i + 1)) { // 현재 문자와 다음 문자가 같으면
                    sb.delete(i, i + 2); // i와 i+1 위치의 문자 제거
                    // i를 감소시켜 이전 상태도 다시 확인
                    if (i > 0) i--;
                } else {
                	i++;
                }
            }
			System.out.println("#"+t+" "+sb.toString());
		}
	}

}
