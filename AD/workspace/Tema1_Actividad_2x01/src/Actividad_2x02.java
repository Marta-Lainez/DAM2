import java.io.IOException;
import java.util.List;

import entrada.Teclado;

public class Actividad_2x02 {

	public static void main(String[] args) {
		try {
			int opción = -1;
			do {
				imprimirMenú();
				opción = Teclado.leerEntero("Opción: ");
				menú(opción);
			}while(opción != 0);
		}/*
		catch (InputMismatchException ime) {
			System.out.println("Error en el input:");
			System.out.println(ime.getMessage());
			ime.printStackTrace();
		}*/
		catch (IOException ioe) {
			System.out.println("Error al leer del fichero:");
			System.out.println(ioe.getMessage());
			ioe.printStackTrace();
		}
	}
	public static String imprimirFichero() throws IOException{
		List <Empleado> lista = AccesoEmpleado.getDeFicheroALista();
		int contador = 0;
		for(Empleado e: lista) {
			contador++;
			System.out.println(e.toString());
		}
		return "Se han consultado " + contador + " departamentos del fichero de texto.";
	}
	
	public static void insertarEmpleado(int código, int códigoDepartamento, double salario, String nombre, String fechaAlta) throws IOException {
		if(AccesoEmpleado.existeEmpleado(código))
			System.out.println("Ya existe otro empleado con ese código en el fichero de texto.");
		else if (!AccesoDepartamento.existeDepartamento(códigoDepartamento)) 
			System.out.println("No existe ningún departamento con ese código en el fichero de texto.");
		else {
			AccesoEmpleado.insertarEmpleado(código, códigoDepartamento, salario, nombre, fechaAlta);
			System.out.println("Se ha insertado un empleado en el fichero de texto");
		}
	}
	public static void actualizarEmpleado(int código, int códigoDepartamento, double salario, String nombre, String fechaAlta) throws IOException{
		Empleado empleado = new Empleado(código,códigoDepartamento,salario,nombre,fechaAlta);
		if(AccesoEmpleado.existeEmpleado(código)) {
			List lista = AccesoEmpleado.eliminarEmpleado(código);
			AccesoEmpleado.getDeListaAFichero(lista);
			AccesoEmpleado.insertarEmpleado(código,códigoDepartamento,salario,nombre,fechaAlta);
			System.out.println("Se ha actualizado un empleado del fichero de texto.");
		}
		else
			System.out.println("No existe ningún empleado con ese código en el fichero de texto.");
	}
	public static void eliminarEmpleado(int código) throws IOException {
		if(!AccesoEmpleado.existeEmpleado(código))
			System.out.println("No existe ningún empleado con ese código en el fichero de texto.");
		else {
			List lista = AccesoEmpleado.eliminarEmpleado(código);
			AccesoEmpleado.getDeListaAFichero(lista);
			System.out.println("Se ha eliminado un empleado del fichero de texto.");
		}
	}
	public static void imprimirMenú() {
		System.out.println("0) Salir del programa.\n1) Insertar un empleado en el fichero de texto.\n"
				+ "2) Consultar todos los empleados del fichero de texto.\n"
				+ "3) Consultar un empleado, por código, del fichero de texto.\n"
				+ "4) Actualizar un empleado, por código, del fichero de texto.\n"
				+ "5) Eliminar un empleado, por código, del fichero de texto.");
	}
	public static void menú(int opción) throws IOException {
		int código;
		int códigoDepartamento;
		double salario;
		String nombre;
		String fechaAlta;
		switch (opción) {
		case 0:
			break;
		case 1: // FUNCIONA
			imprimirFichero();
			código = Teclado.leerEntero("Código empleado:");
			códigoDepartamento = Teclado.leerEntero("Código departamento:");
			salario = Teclado.leerReal("Salario: ");
			nombre = Teclado.leerCadena("Nombre: ");
			fechaAlta = Teclado.leerCadena("Fecha de alta: ");
			insertarEmpleado(código, códigoDepartamento, salario, nombre, fechaAlta);
			break;
		case 2: // FUNCIONA
			System.out.println(imprimirFichero());
			break;
		case 3: // FUNCIONA
			código = Teclado.leerEntero("Código: ");
			if (AccesoEmpleado.estáVacio())
				System.out.println("No existe ningún empleado con ese código en el fichero de texto. ");
			else
				System.out.println(AccesoEmpleado.devuelveEmpleado(código).toString());
			break;
		case 4: // FUNCIONA
			Actividad_2x01.imprimirFichero();
			código = Teclado.leerEntero("Código empleado:");
			códigoDepartamento = Teclado.leerEntero("Nuevo código departamento:");
			salario = Teclado.leerReal("Nuevo salario: ");
			nombre = Teclado.leerCadena("Nuevo nombre: ");
			fechaAlta = Teclado.leerCadena("Nueva fecha de alta: ");
			if (!AccesoEmpleado.existeEmpleado(código))
				System.out.println("No existe ningún empleado con ese código en el fichero de texto.");
			else
				actualizarEmpleado(código,códigoDepartamento,salario,nombre,fechaAlta);
			break;
			
		case 5: // FUNCIONA 
			código = Teclado.leerEntero("Código empleado:");
			eliminarEmpleado(código);
			break;
		default:
			System.out.println("La opción de menú debe estar comprendida entre 0 y 5.");
		}
	}
}
