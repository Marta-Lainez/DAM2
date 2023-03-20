package Actividad1x01_02;

import java.io.IOException;

import java.sql.SQLException;
import java.util.ArrayList;

import entrada.Teclado;

public class Actividad_1x02 {


	/**
	 * Metodo con el menu que queremos imprimir
	 * @return Devuelve una string con el texto a imprimir
	 */
	public static String texto() {
		return 	  "0. Salir del programa. \n"
				+ "1. Insertar un empleado en la base de datos.\n"
				+ "2. Consultar todos los empleados de la base de datos\n"
				+ "3. Consultar un empleado, por código, de la base de datos.\n"
				+ "4. Actualizar un empleado, por código, de la base de datos.\n"
				+ "5. Eliminar un empleado, por código, de la base de datos";
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
					imprimirFichero();
					break;

				case 3:
					consultarCodigo();
					break;

				case 4:
					actualizar();
					break;
				case 5:
					eliminar();
					break;
				default:
					System.out.println("La opcion de menu debe estar comprendida entre 0 y 5.");
				}
			}while(opcion!=0);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RuntimeException e1) {
			System.out.println(e1.getMessage());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

	private static void insertar() throws NumberFormatException, ClassNotFoundException, IOException, SQLException {

		String nombre = Teclado.leerCadena("Dime el nombre del Empleado");
		String fecha_alta = Teclado.leerCadena("Dime la fecha alta del Empleado");
		double salario = Teclado.leerReal("Dime el salario del Empleado");
		int codigo_departamento= Teclado.leerEntero("Dime el codigo departamento");
		Empleado emp = new Empleado(nombre,fecha_alta,salario,codigo_departamento);
		AccesoEmpleado.insertar(emp);
		System.out.println("Se ha insertado un empleado en la base de datos.");
	}

	public static void imprimirFichero() throws IOException, ClassNotFoundException, SQLException{
		ArrayList<Empleado> lista = AccesoEmpleado.consultarTodos();
		if(lista!= null) {
			for (Empleado e: lista) {
				System.out.println(e);
			}
		}else {
			System.out.println("No se ha encontrado ningún Empleado en la base de datos.");
		}
	}

	private static void consultarCodigo() throws SQLException, ClassNotFoundException, IOException {
		int codigo= Teclado.leerEntero("Dime el codigo del Empleado"); 
		Empleado d = AccesoEmpleado.comprobar(codigo);
		if(d!=null) {
			System.out.println(d);
		}else {
			System.out.println("No existe ningún empleado con ese código en la base de datos.");
		}
	}

	private static void actualizar() throws IOException, ClassNotFoundException, SQLException {
		int codigo= Teclado.leerEntero("Dime el codigo del Empleado"); 
		Empleado e = AccesoEmpleado.comprobar(codigo);
		if(e!=null) {
			String nombre = Teclado.leerCadena("Dime el nombre del Empleado");
			String fecha_alta = Teclado.leerCadena("Dime la fecha alta del Empleado");
			double salario = Teclado.leerReal("Dime el salario del Empleado");
			int codigo_departamento= Teclado.leerEntero("Dime el codigo departamento");
			Empleado emp = new Empleado(nombre,fecha_alta,salario,codigo_departamento);
			AccesoEmpleado.actualizar(emp);
			System.out.println("Se ha actualizado");

		}else{
			System.out.println("No existe ningún empleado con ese código en la base de datos.");
		}

	}

	private static void eliminar() throws IOException, ClassNotFoundException, SQLException {
		int codigo= Teclado.leerEntero("Dime el codigo del Empleado"); 
		Empleado empleado = AccesoEmpleado.comprobar(codigo);
		if(empleado!=null) {
			int num = AccesoEmpleado.eliminar(codigo);
			System.out.println(num);
			System.out.println("Se ha eliminado el empleado");
		}else {
			System.out.println("No existe ningún empleado con ese código en la base de datos.");
		}
	}



}
