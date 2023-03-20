

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Suma5 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintStream ps = new PrintStream(System.out);
		String numero = in.readLine();
		if(numero != null) {
			int num = Integer.parseInt(numero) + 5;
			ps.println(num);
			ps.flush();
			
		}
		System.exit(0);
	}

}
