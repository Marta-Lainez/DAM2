import java.io.IOException;
import java.util.List;

import entrada.Teclado;

public class GestorVideojuegos {

	public static void main(String[] args) throws ClassNotFoundException {
		try {
			int opcion = -1;
			do {
				imprimirMenu();
				opcion = Teclado.leerEntero("Opcion: ");
				menu(opcion);
			}while(opcion != 0);
			
		}
		catch (IOException ioe) {
			System.out.println("Error al leer del fichero:");
			System.out.println(ioe.getMessage());
			ioe.printStackTrace();
		}
	}
	public static void imprimirMenu() {
		System.out.println("0) Salir del programa.\n1) Crear un fichero de texto a partir del fichero binario.\n"
				+ "2) Consultar todos los videojuegos del fichero de texto.\n"
				+ "3) Eliminar un videojuego, por codigo, del fichero binario.\n"
				+ "4) Actualizar un videojuego, por codigo, del fichero de texto.");
	}
	// FUNCION 1
	public static void crearFichero() throws ClassNotFoundException, IOException {
		List<Videojuego> listaVideojuegos = AccesoVideojuegoBinario.leerVideojuegos();
		AccesoVideojuegoTexto.escribirVideojuegos(listaVideojuegos);
		System.out.println("Se han copiado " + listaVideojuegos.size() + " videojuegos desde el fichero binario"
				+ " al fichero de texto.");
	}
	// FUNCION 2
	public static void consultarVideojuegos() throws IOException {
		List<Videojuego> listaVideojuegos = AccesoVideojuegoTexto.leerVideojuegos();
		if(listaVideojuegos.size() == 0)
			System.out.println("El fichero no tiene ningun videojuego.");
		else {
			for(Videojuego videojuego: listaVideojuegos) {
				System.out.println(videojuego.toString());
			}
			System.out.println("Se han consultado " + listaVideojuegos.size() + " videojuegos desde el fichero binario"
					+ " al fichero de texto.");
		}
	}
	//FUNCION 3
	public static void eliminarVideojuego() throws ClassNotFoundException, IOException {
		int codigo = Teclado.leerEntero("Codigo: ");
		if(AccesoVideojuegoBinario.existeVideojuego(codigo) == null) 
			System.out.println("No existe ningun videojuego con ese codigo en el fichero binario.");
		else {
			List<Videojuego> listaVideojuegos = AccesoVideojuegoBinario.eliminarVideojuego(codigo);
			AccesoVideojuegoBinario.escribirVideojuegos(listaVideojuegos);
			System.out.println("Se ha eliminado un videojuego del fichero binario.");
		}
	}
	// FUNCION 4
	public static void actualizarVideojuego() throws IOException, ClassNotFoundException {
		int codigo = Teclado.leerEntero("Codigo: ");
		if(AccesoVideojuegoBinario.existeVideojuego(codigo) == null) 
			System.out.println("No existe ningun videojuego con ese codigo en el fichero de texto.");
		else {
			String titulo = Teclado.leerCadena("Titulo: ");
			String plataforma = Teclado.leerCadena("Plataforma: ");
			double precio = Teclado.leerReal("Precio: ");
			List<Videojuego> listaVideojuego = AccesoVideojuegoTexto.actualizarVideojuego(codigo, titulo, plataforma, precio);
			AccesoVideojuegoTexto.escribirVideojuegos(listaVideojuego);
			System.out.println("Se ha actualizado un videojuego del fichero de texto");
		}
	}
	public static void menu(int opción) throws IOException, ClassNotFoundException {
		switch (opción) {
		case 0:
			break;
		case 1: 
			crearFichero();
			break;
		case 2: 
			consultarVideojuegos();
			break;
		case 3: 
			eliminarVideojuego();
			break;
		case 4: 
			actualizarVideojuego();
			break;
		default:
			System.out.println("La opcion de menu debe estar comprendida entre 0 y 4.");
		}
	}
}
