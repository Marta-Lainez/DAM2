import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Referencia {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintStream ps = new PrintStream(System.out);
		String codigo = in.readLine();
		while(!(codigo.equals("0000"))) {
			String cadena1 = codigo.substring(0, 1);
			int cadena2 = Integer.parseInt(codigo.substring(1, 3));
			if(cadena2 < 10) {
				if(cadena1.equals("A")) {
					ps.println("REF01");
					ps.flush();
				}
				else {
					ps.println("REF02");
					ps.flush();
				}	
			}
			else if(cadena1.equals("A")) {
				ps.println("REF03");
				ps.flush();
			}	
			else {
				ps.println("REF09");
				ps.flush();
			}	
			codigo = in.readLine();
		}
		System.exit(0);

	}

}
