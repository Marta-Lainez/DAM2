import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entrada.Teclado;
import modelo.Equipo;
import modelo.Fecha;
import modelo.Jugador;
import modelo.Partido;

public class Actividad_1x02 {

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
	/*Método 1: Insertar departamento*/
	public static void insertarEquipo() {
		String nombre = Teclado.leerCadena("Nombre del equipo: ");
		if(GestorEquipos.consultar(nombre) != null) {
			System.out.println("Se ha encontrado un equipo con ese nombre en la base de datos.");
		}
		else {
			String ciudad = Teclado.leerCadena("Ciudad del equipo: ");
			Equipo equipo = new Equipo(nombre, ciudad);
			GestorEquipos.insertarEquipo(equipo);
			System.out.println("Se ha insertado un equipo en la base de datos.");
		}
	}
	/*Método 2: Consultar equipos*/
	public static void consultarEquipos() {
		List <Equipo> equipos = GestorEquipos.consultarEquipos();
		if(equipos.size() == 0)
			System.out.println("No se ha encontrado ningún equipo en la base de datos.");
		for(Equipo equipo: equipos) {
			System.out.println(equipo.toString());
		}
		System.out.println("Se han consultado " + equipos.size() + " equipos de la base de datos.");
	}
	/*Método 3: Buscar equipo*/
	public static void existeEquipo() {
		String nombre = Teclado.leerCadena("Nombre del equipo: ");
		Equipo equipo = GestorEquipos.consultar(nombre);
		if(equipo != null)
			System.out.println(equipo);
		else
			System.out.println("No existe ningún equipo con ese nombre en la base de datos.");
	}
	/*Método 4: Actualizar equipo*/
	public static void actualizarEquipo() {
		String nombre = Teclado.leerCadena("Nombre del equipo: ");
		Equipo equipo = GestorEquipos.consultar(nombre);
		if(equipo == null)
			System.out.println("No existe ningún equipo con ese nombre en la base de datos.");
		else {
			String ciudad = Teclado.leerCadena("Ciudad del equipo: ");
			boolean actualizado = GestorEquipos.actualizarEquipo(nombre, ciudad);
			if(actualizado)
				System.out.println("Se ha actualizado un equipo de la base de datos.");
		}	
	
	}
	/*Método 5: Eliminar equipo*/
	public static void eliminarEquipo() {
		String nombre = Teclado.leerCadena("Nombre del equipo: ");
		Equipo equipo = GestorEquipos.consultar(nombre);
		if(equipo == null) {
			System.out.println("No existe ningún equipo con ese nombre en la base de datos.");
		}
		else {
			List<Jugador> jugadores = GestorEquipos.buscarJugadoresPorEquipo(nombre);
			if(jugadores.size() != 0) {
				System.out.println("Se han encontrado " + jugadores.size() + " jugadores relacionados con ese equipo\r\n"
						+ "en la base de datos:");
				for(Jugador jugador: jugadores) {
					System.out.println(jugador.toString());
				}
				
			}
			List<Partido> partidos = GestorEquipos.buscarPartidosPorEquipo(nombre);
			if(partidos.size() != 0) {
				System.out.println("Se han encontrado " + partidos.size() + " partidos relacionados con ese equipo\r\n"
						+ "en la base de datos.");
				for(Partido partido: partidos) {
					System.out.println(partido.toString());
				}
			}
			if(jugadores.size() == 0 || partidos.size() == 0){
				System.out.println("Se ha eliminado un equipo de la base de datos.");
				GestorEquipos.eliminarEquipo(nombre);
			}
		}
	}
	/*
	 * Descripción: Describe las opciones del menú
	 */
	public static void imprimirMenu() {
		System.out.println("0) Salir del programa.\n"
				+ "1) Insertar un equipo en la base de datos.\n"
				+ "2) Consultar todos los equipos de la base de datos.\n"
				+ "3) Consultar un equipo, por nombre, de la base de datos.\n"
				+ "4) Actualizar un equipo, por nombre, de la base de datos.\n"
				+ "5) Eliminar un equipo, por nombre, de la base de datos.");
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
			insertarEquipo();
			break;
		case 2: 
			consultarEquipos();
			break;
		case 3: 
			existeEquipo();
			break;
		case 4: 
			actualizarEquipo();
			break;
		case 5:
			eliminarEquipo();
			break;
		default:
			System.out.println("La opcion de menu debe estar comprendida entre 0 y 5.");
		}
	}

}
