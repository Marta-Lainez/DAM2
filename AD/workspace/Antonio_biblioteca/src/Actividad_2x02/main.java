package Actividad_2x02;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import org.sqlite.SQLiteException;

import entrada.Teclado;

public class main {

	/**
	 * Metodo con el menu que queremos imprimir
	 * @return Devuelve una string con el texto a imprimir
	 */
	public static String texto() {
		return 	  "0. Salir del programa. \n"
				+ "1. Insertar un socio en la base de datos.\n"
				+ "2. Eliminar un socio, por código, de la base de datos\n"
				+ "3. Consultar todos los socios de la base de datos.\n"
				+ "4. Consultar varios socios, por localidad, de la base de datos, ordenados por nombre ascendente\n"
				+ "5. Consultar los socios sin préstamos de la base de datos\n"
				+ "6. Consultar los socios con préstamos en una fecha de la base de datos.";
	}

	/**
	 * Desde este main se ejecutara el switch con las distintas opciones que contempla el menu
	 */
	public static void main(String[] args) {
		try {
			int opcion;
			do {
				System.out.println(texto());
				opcion=Teclado.leerEntero("Dime una opcion \n");
				switch (opcion) {
				case 0:
					System.out.println("Fin del programa");
					break;
				case 1: 
					insertar();
					break;

				case 2:
					eliminar();
					break;

				case 3:
					consultarTodos();
					break;
				case 4:
					consultarLocalidad();
					break;
				case 5:
					consultarNoPrestamos();
					break;
				case 6:
					consultarConPrestamos();
					break;
				default:
					System.out.println("La opcion de menu debe estar comprendida entre 0 y 5.");
				}
			}while(opcion!=0);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void insertar() throws ClassNotFoundException, SQLException {
		String dni=Teclado.leerCadena("Dime el DNI");
		String nombre=Teclado.leerCadena("Dime el nombre");
		String domicilio=Teclado.leerCadena("Dime el domicilio");
		String telefono=Teclado.leerCadena("Dime el telefono");
		String correo=Teclado.leerCadena("Dime el correo");
		Socio socio = new Socio(dni,nombre,domicilio,telefono,correo);
		AccesoSocio.insertar(socio);
		System.out.println("Se ha insertado un socio en la base de datos.");
	}

	public static void eliminar() throws ClassNotFoundException, IOException, SQLException{
		try{
			int codigo = Teclado.leerEntero("Dime el codigo del socio");
			if(AccesoSocio.eliminar(codigo)!=0) {
				System.out.println("Se ha eliminado un socio de la base de datos.");
			}else {
				System.out.println("No existe ningún socio con ese código en la base de datos.");
			}
		}catch (SQLiteException SQLE){
			System.err.println("El socio está referenciado en un préstamo de la base de datos.");
		}
	}

	public static void consultarTodos() throws ClassNotFoundException, SQLException {
		ArrayList<Socio> socios = AccesoSocio.consultarTodos();
		if(socios.size()==0) {
			System.out.println("No se ha encontrado ningún socio en la base de datos.");
		}else {
			for(Socio socio: socios) {
				System.out.println(socio);
			}
			System.out.println("Se han consultado "+socios.size()+" socios de la base de datos");
		}

	}
	public static void consultarLocalidad() throws ClassNotFoundException, SQLException {
		String localidad = Teclado.leerCadena("Dime la direccion de los socios");
		ArrayList<Socio> socios = AccesoSocio.consultarLocalidad(localidad);
		if(socios.size()==0) {
			System.out.println("No existe ningún socio con esa localidad en la base de datos.");
		}else {
			for(Socio socio: socios) {
				System.out.println(socio);
			}
			System.out.println("Se han consultado "+socios.size()+" socios de la base de datos");
		}

	}

	public static void consultarNoPrestamos() throws ClassNotFoundException, SQLException {
		ArrayList<Socio> socios = AccesoSocio.consultarNoPrestamos();
		if(socios.size()==0) {
			System.out.println("No existe ningún socio sin préstamos en la base de datos.");
		}else {
			for(Socio socio: socios) {
				System.out.println(socio);
			}
			System.out.println("Se han consultado "+socios.size()+" socios de la base de datos");
		}

	}
	
	public static void consultarConPrestamos() throws ClassNotFoundException, SQLException {
		int fecha_inicio = Teclado.leerEntero("Dime la fecha de inicio de los prestamos");
		ArrayList<Socio> socios = AccesoSocio.consultarConPrestamos(fecha_inicio);
		if(socios.size()==0) {
			System.out.println("No existe ningún socio con préstamos en esa fecha en la base de datos.");
		}else {
			for(Socio socio: socios) {
				System.out.println(socio);
			}
			System.out.println("Se han consultado "+socios.size()+" socios de la base de datos");
		}

	}
	
}
