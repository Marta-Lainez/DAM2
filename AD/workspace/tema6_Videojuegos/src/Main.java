

import java.io.IOException;
import java.util.ArrayList;

import entrada.Teclado;

public class Main {

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
	public static void insertar() {
		int codigo = Teclado.leerEntero("Código: ");
		Videojuego juego = AccesoJuegos.consultarJuegoPorCodigo(codigo);
		if(juego == null) {
			String titulo = Teclado.leerCadena("Título: ");
			int agno = Teclado.leerEntero("Año: ");
			String desarrollador = Teclado.leerCadena("Desarrollador: ");
			Double precio = Teclado.leerReal("Precio: ");
			juego = new Videojuego(codigo, titulo, agno, desarrollador, precio);
			AccesoJuegos.insertarJuego(juego);
			System.out.println("Se ha insertado un juego en la base de datos.");
		}
		else {
			System.out.println("Ese juego ya existe en la base de datos");
			System.out.println(juego.toString());
		}
	}
	public static void consultarTodos() {
		ArrayList<Videojuego> listaJuegos = AccesoJuegos.consultarTodos();
		if(listaJuegos.size() > 0) {
			for(Videojuego juego: listaJuegos) {
				System.out.println(juego.toString());
			}
			System.out.println("Se han encontrado " + listaJuegos.size() + " juegos en la base de datos.");
		}
		else {
			System.out.println("No se ha encontrado ningún juego en la base de datos.");
		}
	}
	public static void consultaJuego() {
		int codigo = Teclado.leerEntero("Código: ");
		Videojuego videojuego = AccesoJuegos.consultarJuegoPorCodigo(codigo);
		if(videojuego == null) {
			System.out.println("No existe ningún juego con ese código en la base de datos.");
		}
		else {
			System.out.println(videojuego.toString());
		}
	}
	public static void actualizarJuego() {
		int codigo = Teclado.leerEntero("Código: ");
		Videojuego juego = AccesoJuegos.consultarJuegoPorCodigo(codigo);
		if(juego == null) {
			System.out.println("No existe ningún juego con ese código en la base de datos.");
		}
		else {
			String titulo = Teclado.leerCadena("Título: ");
			int agno = Teclado.leerEntero("Año: ");
			String desarrollador = Teclado.leerCadena("Desarrollador: ");
			Double precio = Teclado.leerReal("Precio: ");
			juego = new Videojuego(codigo, titulo, agno, desarrollador, precio);
			long actualizaciones = AccesoJuegos.actualizarJuego(juego);
			System.out.println("Ha habido " + actualizaciones + " actualizaciones.");
			System.out.println(juego.toString());
		}
	}
	public static void eliminarJuego() {
		int codigo = Teclado.leerEntero("Código: ");
		Videojuego juego = AccesoJuegos.consultarJuegoPorCodigo(codigo);
		if(juego == null) {
			System.out.println("No existe ningún juego con ese código en la base de datos.");
		}
		else {
			long juegosEliminados = AccesoJuegos.eliminarJuego(codigo);
			System.out.println("Se ha eliminado el juego de la base de datos.");
		}
	}
	
	/*
	 * Descripción: Describe las opciones del menú
	 */
	public static void imprimirMenu() {
		System.out.println("0) Salir del programa.\n"
				+ "1) Insertar un juego en la base de datos.\n"
				+ "2) Consultar todos los juegos de la base de datos.\n"
				+ "3) Consultar un juego, por código, de la base de datos.\n"
				+ "4) Actualizar un juego, por código, de la base de datos.\n"
				+ "5) Eliminar un juego, por código, de la base de datos.");
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
			insertar();
			break;
		case 2: 
			consultarTodos();
			break;
		case 3: 
			consultaJuego();
			break;
		case 4: 
			actualizarJuego();
			break;
		case 5: 
			eliminarJuego();
			break;
		default:
			System.out.println("La opcion de menu debe estar comprendida entre 0 y 5.");
		}
	}

}
