import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int R=Integer.MIN_VALUE;
		int C=Integer.MIN_VALUE;;
		int len = str.length();
		for(int i=1; i<=(int)Math.sqrt(len); i++) {
			if(len % i == 0) {
				C = len/i;
				R = i;
			}
		}
		
		Character[][] array = new Character[R][C];
		int idx = 0;
		for(int j=0; j<C; j++) {
			for(int i=0; i<R; i++) {
				array[i][j] = str.charAt(idx++);
			}
		}
		
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				System.out.print(array[i][j]);
			}
		}

	}

}
