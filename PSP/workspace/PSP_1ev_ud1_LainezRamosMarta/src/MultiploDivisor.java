import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Random;

public class MultiploDivisor {

	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintStream ps = new PrintStream(System.out);
		String cadena1 = in.readLine();
		String cadena2 = in.readLine();
		if(cadena1 != null && cadena2 != null) {
			int numero1 = Integer.parseInt(cadena1);
			int numero2 = Integer.parseInt(cadena2);
			if(numero1 % numero2 == 0) {
				ps.println("Resultado: Múltiplo");
				ps.flush();
			}
			if(numero2 % numero1 == 0) {
				ps.println("Resultado: Primero divisor de segundo");
				ps.flush();
			}
			else {
				ps.println("No hay relación entre ellos");
				ps.flush();
			}
			
		}
		System.exit(0);
	}
	

}
