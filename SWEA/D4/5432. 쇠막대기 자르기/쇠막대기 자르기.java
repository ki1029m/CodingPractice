import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			String line = br.readLine();
			
			int result = 0;
			int pipe = 0;
			for(int i=0; i<line.length(); i++) {
				if(line.charAt(i) == '(') {
					if(line.charAt(i+1) == ')') {
						result += pipe;
						i++;
						continue;
					}
					pipe++;
				}else if(line.charAt(i) == ')') {
					result++;
					pipe--;
				}
			}
			
			System.out.println("#"+t+" "+result);
		}
	}

}
