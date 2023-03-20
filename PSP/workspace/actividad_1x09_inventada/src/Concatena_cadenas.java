import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Concatena_cadenas {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintStream ps = new PrintStream(System.out);
		String cadena1 = in.readLine();
		String cadena2 = in.readLine();
		if(!cadena1.equals(null) && !cadena2.equals(null)) {
			String cadena = cadena1 + " " + cadena2;
			ps.println(cadena);
			ps.flush();
			cadena1 = in.readLine();
			cadena2 = in.readLine();
	
		}
		System.exit(0);

	}

}
