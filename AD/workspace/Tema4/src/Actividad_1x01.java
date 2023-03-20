import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entrada.Teclado;
import modelo.Fecha;
import modelo.Jugador;

public class Actividad_1x01 {

	public static void main(String[] args) {
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
		}catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (SQLException sqle) {
			System.out.println(sqle.getMessage());
		}
	}
	/*Validar Fecha*/
	public static Fecha fechaValida() {
		int dia = Teclado.leerEntero("Día de nacimiento: ");
		int mes = Teclado.leerEntero("Mes de nacimiento: ");
		int agno = Teclado.leerEntero("Año de nacimiento: ");
		// Validar fecha con esValido()
		boolean fechaValida = Fecha.esValida(dia, mes, agno);
		if(!fechaValida) {
			while(!fechaValida) {
				System.out.println("Fecha de nacimiento incorrecta.");
				dia = Teclado.leerEntero("Día de nacimiento: ");
				mes = Teclado.leerEntero("Mes de nacimiento: ");
				agno = Teclado.leerEntero("Año de nacimiento: ");
				fechaValida = Fecha.esValida(dia, mes, agno);
			}
		}
		Fecha fechaNacimiento = new Fecha(dia, mes, agno);
		return fechaNacimiento;
	}
	/*Metodo 1: Insertar jugador*/
	public static void insertarJugador() {
		String nombre = Teclado.leerCadena("Nombre del jugador: ");
		Fecha fechaNacimiento = fechaValida();
		Jugador jugador = new Jugador(nombre, fechaNacimiento);
		GestorJugadores.insertarJugador(jugador);
		System.out.println("Se ha insertado un jugador en la base de datos.");
	}
	/*Método 2: Consultar jugadores*/
	public static void consultarJugadores() {
		List <Jugador> jugadores = GestorJugadores.consultarJugadores();
		if(jugadores.size() == 0)
			System.out.println("No se ha encontrado ningún jugador en la base de datos.");
		for(Jugador jugador: jugadores) {
			System.out.println(jugador.toString());
		}
		System.out.println("Se han consultado " + jugadores.size() + " jugadores de la base de datos.");
	}
	/*Método 3: Buscar jugador*/
	public static void existeJugador() {
		int codigo = Teclado.leerEntero("Código del jugador: ");
		Jugador jugador = GestorJugadores.existeJugador(codigo);
		if(jugador != null)
			System.out.println(jugador.toString());
		else
			System.out.println("No existe ningún jugador con ese código en la base de datos.");
	}
	/*Método 4: Actualizar jugador*/
	public static void actualizarJugador() {
		int codigo = Teclado.leerEntero("Código del jugador: ");
		Jugador jugador = GestorJugadores.existeJugador(codigo);
		if(jugador == null)
			System.out.println("No existe ningún jugador con ese código en la base de datos.");
		else {
			String nombre = Teclado.leerCadena("Nombre del jugador:" );
			Fecha fechaNacimiento = fechaValida();
			boolean actualizado = GestorJugadores.actualizarJugador(codigo, nombre, fechaNacimiento);
			if(actualizado)
				System.out.println("Se ha actualizado un jugador de la base de datos.");
		}
	
	}
	/*Método 5: Eliminar un jugador*/
	public static void eliminarJugador() {
		int codigo = Teclado.leerEntero("Código del jugador: ");
		Jugador jugador = GestorJugadores.existeJugador(codigo);
		if(jugador == null)
			System.out.println("No existe ningún jugador con ese código en la base de datos.");
		else {
			if(GestorJugadores.buscarEquipoConJugador(codigo) == null) {
				GestorJugadores.eliminarJugador(codigo);
				System.out.println("Se ha eliminado un jugador de la base de datos.");
			}
			else {
				System.out.println("Se ha encontrado un equipo relacionado con ese jugador en la base de datos.");
				System.out.println(GestorJugadores.buscarEquipoConJugador(codigo).toString());
			}
		}
	}
		
	/*
	 * Descripción: Describe las opciones del menú
	 */
	public static void imprimirMenu() {
		System.out.println("0) Salir del programa.\n"
				+ "1) Insertar un jugador en la base de datos.\n"
				+ "2) Consultar todos los jugadores de la base de datos.\n"
				+ "3) Consultar un jugador, por código, de la base de datos.\n"
				+ "4) Actualizar un jugador, por código, de la base de datos.\n"
				+ "5) Eliminar un jugador, por código, de la base de datos.");
	}
	/*
	 * Input: opción a elegir del menú
	 * Descrición: Tras obtener la opción introducidas por parámetro, entra en el switch y ejecuta la opción pertinente
	 */
	public static void menu(int opcion) throws IOException, ClassNotFoundException, SQLException {
		switch (opcion) {
		case 0:
			break;
		case 1:
			insertarJugador();
			break;
		case 2: 
			consultarJugadores();
			break;
		case 3: 
			existeJugador();
			break;
		case 4: 
			actualizarJugador();
			break;
		case 5:
			eliminarJugador();
			break;
		default:
			System.out.println("La opcion de menu debe estar comprendida entre 0 y 5.");
		}
	}
}

