import entrada.Teclado;

public class MainPolialfabetico {

	public static void main(String[] args) {
		try {
			int opcion = -1;
			do {
				imprimirMenu();
				opcion = Teclado.leerEntero("Opcion: ");
				menu(opcion);
			}while(opcion != 0);
			
		}catch (Exception e) {
			e.printStackTrace();
		}

	}
	public static void cifrar() {
		String cadena = Teclado.leerCadena("Cadena a cifrar: ");
		String cifrado = CifrarPolialfabetico.cifrar(cadena);
		System.out.println(cifrado);
	}
	public static void descifrar() {
		String cadena = Teclado.leerCadena("Cadena a descifrar: ");
		String descifrado = CifrarPolialfabetico.descifrar(cadena);
		System.out.println(descifrado);
	}
	/*
	 * Descripción: Describe las opciones del menú
	 */
	public static void imprimirMenu() {
		System.out.println("0) Salir del programa.\n"
				+ "1) Cifrar.\n"
				+ "2) Descifrar.");
	}
	/*
	 * Input: opción a elegir del menú
	 * Descrición: Tras obtener la opción introducidas por parámetro, entra en el switch y ejecuta la opción pertinente
	 */
	public static void menu(int opcion)  {
		switch (opcion) {
		case 0:
			break;
		case 1:
			cifrar();
			break;
		case 2: 
			descifrar();
			break;
		
		default:
			System.out.println("La opcion de menu debe estar comprendida entre 0 y 2.");
		}
	}

}
