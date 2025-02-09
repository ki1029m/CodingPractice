import java.io.*;
import java.util.*;

public class Main {
	
	static String str;
	static int N;
	static int max=Integer.MIN_VALUE;

	//op1 op2 연산을 먼저할지 op2 op3연산을 먼저할지 결정
	public static void recursive(int idxOp1, int op1) {
		
		if(idxOp1 >= N-1) {
			max = Math.max(max, op1);
			return;
		}
		
		
		
		char operator1 = str.charAt(idxOp1+1);
		int op2 = Character.getNumericValue(str.charAt(idxOp1+2));
		
		//op1 op2 연산
		int op = 0;
		if(operator1 == '+') {
			op=op1+op2;
		}else if(operator1 == '-') {
			op=op1-op2;
		}else if(operator1 == '*') {
			op=op1*op2;
		}
		recursive(idxOp1+2, op);
		

		if(idxOp1 >= N-4) {
			return;
		}
		
		char operator2 = str.charAt(idxOp1+3);
		int op3 = Character.getNumericValue(str.charAt(idxOp1+4));
		//op2 op3 연산 후 op1
		if(operator2 == '+') {
			op=op2+op3;
		}else if(operator2 == '-') {
			op=op2-op3;
		}else if(operator2 == '*') {
			op=op2*op3;
		}
		
		if(operator1 == '+') {
			op=op1+op;
		}else if(operator1 == '-') {
			op=op1-op;
		}else if(operator1 == '*') {
			op=op1*op;
		}
		
		recursive(idxOp1+4, op);
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		str = br.readLine();
		
		recursive(0,Character.getNumericValue(str.charAt(0)));
		System.out.println(max);
	}

}
