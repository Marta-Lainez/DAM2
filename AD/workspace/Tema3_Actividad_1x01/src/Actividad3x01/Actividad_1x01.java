package Actividad3x01;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import entrada.Teclado;

public class Actividad_1x01 {


	/**
	 * Metodo con el menu que queremos imprimir
	 * @return Devuelve una string con el texto a imprimir
	 */
	public static String texto() {
		return 	  "0. Salir del programa. \n"
				+ "1. Insertar un departamento en la base de datos.\n"
				+ "2. Insertar todos los empleados de un fichero de texto en la base de datos\n"
				+ "3. Actualizar los salarios de los empleados, por departamento, de la base de datos.\n"
				+ "4. Eliminar un departamento, por código, de la base de datos.";
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
					System.out.println("Se han insertado "+AccesoDepartamentos.insertarDepartamentos()+" empleados en la base de datos.");
					break;

				case 2:
					String fecha=Teclado.leerCadena("Dime la fecha de alta");
					System.out.println("Se han insertado "+AccesoDepartamentos.insertarEmpleados(fecha)+" empleados en la base de datos.");
					break;

				case 3:
					System.out.println("Se han actualizado "+AccesoDepartamentos.actualizar()+" empleados en la base de datos.");
					break;

				case 4:
					int codigo=Teclado.leerEntero("Dime el codigo de departamento a eliminar");
					int[] lista =AccesoDepartamentos.eliminar(codigo);
					System.out.println("Se han eliminado "+lista[0]+" empleados en la base de datos.");
					System.out.println("Se ha eliminado "+lista[1]+" departamentos de la base de datos.");
					
					break;
				
				default:
					System.out.println("La opcion de menu debe estar comprendida entre 0 y 4.");
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


}
