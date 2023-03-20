import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Random;

public class ValorRetorno {

	public static void main(String[] args) throws IOException {
		Random random = new Random();
		int numero = random.nextInt(-1,1);
		System.exit(numero);

	}

}
