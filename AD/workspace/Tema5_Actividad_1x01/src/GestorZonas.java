import java.util.ArrayList;

import org.xmldb.api.base.XMLDBException;

import entrada.Teclado;

public class GestorZonas {

	public static void main(String[] args) {
		try {
			int opcion = -1;
			do {
				imprimirMenu();
				opcion = Teclado.leerEntero("Opcion: ");
				menu(opcion);
			}while(opcion != 0);
			
		}
		catch (ClassNotFoundException cnfe) {
			System.out.println("Error de clase no encontrada: " + cnfe.getMessage());
		} 
		catch (InstantiationException ie) {
			System.out.println("Error de instanciación de base de datos XML: " + ie.getMessage());
		} 
		catch (IllegalAccessException iae) {
			System.out.println("Error de acceso ilegal: " + iae.getMessage());
		} 
		catch (XMLDBException xmldbe) {
			System.out.println("Error de base de datos XML: " + xmldbe.getMessage());
		}
	}
	
	public static void insertar() throws ClassNotFoundException, InstantiationException, IllegalAccessException, XMLDBException{
		
		String nombre = Teclado.leerCadena("¿Nombre? ");
		String director = Teclado.leerCadena("¿director? ");
		AccesoZonas.insertar(nombre, director);
	
		System.out.println("Se ha insertado un producto en la base de datos.");
		
		
	}
	private static void consultar() throws ClassNotFoundException, InstantiationException, IllegalAccessException, XMLDBException {
		ArrayList<Zona> zonas = AccesoZonas.consultar();
		
		if(zonas.size()==0) {
			System.out.println("No se ha encontrado ningún producto en la base de datos.");
		}else {
			for(Zona zona: zonas) {
				System.out.println(zona);
			}
			System.out.println("Se han consultado "+zonas.size()+" productos de la base de datos.");
		}
	}
	private static void consultarCodigo() throws ClassNotFoundException, InstantiationException, IllegalAccessException, XMLDBException {
		int codigo = Teclado.leerEntero("¿Código? ");
		Zona zona = AccesoZonas.consultarCodigo(codigo);
		if (zona!=null) {// si existe
			System.out.println(zona);
		}else {
			System.out.println("No se ha encontrado ningún producto con ese código en la base de datos.");
		}
	}
	private static void actualizar() throws ClassNotFoundException, InstantiationException, IllegalAccessException, XMLDBException {
		int codigo = Teclado.leerEntero("¿Código? ");
		Zona zona = AccesoZonas.consultarCodigo(codigo);
		if (zona!=null) {// si existe
			String nombre = Teclado.leerCadena("¿Nombre? ");
			String director = Teclado.leerCadena("¿director? ");
			Zona zonaNueva = new Zona(codigo,nombre,director);
			AccesoZonas.actualizar(zonaNueva);
			System.out.println("Se ha actualizado un producto de la base de datos.");
		}else {
			System.out.println("No se ha encontrado ningún producto con ese código en la base de datos.");
		}
	}
	private static void eliminar() throws ClassNotFoundException, InstantiationException, IllegalAccessException, XMLDBException {
		int codigo = Teclado.leerEntero("¿Código? ");
		Zona zona = AccesoZonas.consultarCodigo(codigo);
		if (zona!=null) {
			AccesoZonas.eliminar(codigo);
			System.out.println("Se ha eliminado un producto de la base de datos.");
		}else {
			System.out.println("No se ha encontrado ningún producto con ese código en la base de datos.");
		}
	}
	
	/*
	 * Descripción: Describe las opciones del menú
	 */
	public static void imprimirMenu() {
		System.out.println("0) Salir del programa.\n"
				+ "1) Insertar una zona en la base de datos.\n"
				+ "2) Consultar todas las zonas de la base de datos.\n"
				+ "3) Consultar una zona, por código, de la base de datos.\n"
				+ "4) Actualizar una zona, por código, de la base de datos.\n"
				+ "5) Eliminar una zona, por código, de la base de datos.");
	}
	/*
	 * Input: opción a elegir del menú
	 * Descrición: Tras obtener la opción introducidas por parámetro, entra en el switch y ejecuta la opción pertinente
	 */
	public static void menu(int opcion) throws ClassNotFoundException, InstantiationException, IllegalAccessException, XMLDBException {
		switch (opcion) {
		case 0:
			break;
		case 1:
			insertar();
			break;
		case 2: 
			consultar();
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
	}

}
