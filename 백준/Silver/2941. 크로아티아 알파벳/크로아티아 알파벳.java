import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] diction = {"c=","c-","dz=","d-","lj","nj","s=","z="};
		String line = br.readLine();
		
		int i=0;
		int result =0;
		while(i < diction.length) {
			while(line.contains(diction[i])) {
				line = line.replaceFirst(diction[i], " ");
			}
			if(!line.contains(diction[i]))
				i++;
		}
		System.out.println(line.length());

	}
	
}
