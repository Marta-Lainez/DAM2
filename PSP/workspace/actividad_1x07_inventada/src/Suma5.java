

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Suma5 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintStream ps = new PrintStream(System.out);
		int numero = Integer.parseInt(in.readLine());
		while(numero != 0) {
			int num = numero + 5;
			ps.println(num);
			ps.flush();
			numero = Integer.parseInt(in.readLine());
			//numero = Integer.parseInt(in.readLine());
		}
		System.exit(0);
	}

}
