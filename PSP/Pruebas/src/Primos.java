
public class Primos {

	public static void main(String[] args) {
		System.out.println(esPrimo(14));
		System.out.println(resolverPrimos(14));

	}
	public static boolean esPrimo(int numero) {
		for(int i = 2; i < numero; i++) {
			if(numero % i == 0) {
				return false;
			}
		}
		return true;
	}
	public static String resolverPrimos(int numero) {
		if(esPrimo(numero))
			return "El numero " + numero + " es primo.";
		else {
			String output = "Los numeros primos menores que " + numero + " son:\n";
			for (int j = 1; j < numero; j++) {
				if(esPrimo(j))
					output += j + "\n";
			}
			return output;
		}
	}
}
