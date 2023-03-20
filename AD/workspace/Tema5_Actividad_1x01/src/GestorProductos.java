import java.util.ArrayList;

import org.xmldb.api.DatabaseManager;
import org.xmldb.api.base.Collection;
import org.xmldb.api.base.Database;
import org.xmldb.api.base.Resource;
import org.xmldb.api.base.ResourceIterator;
import org.xmldb.api.base.ResourceSet;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.XPathQueryService;

import entrada.Teclado;

import entrada.Teclado;

public class GestorProductos {

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
		int codigo = Teclado.leerEntero("¿Código? ");
		String denominacion = Teclado.leerCadena("¿Denominación? ");
		double precio = Teclado.leerReal("¿Precio? ");
		int stockActual = Teclado.leerEntero("¿Stock Actual? ");
		int stockMinimo = Teclado.leerEntero("¿Stock Mínimo? ");
		int codigoZona = Teclado.leerEntero("¿Código de Zona? ");
		Producto producto = new Producto(codigo,denominacion,precio,stockActual,stockMinimo,codigoZona);
		Boolean insertar = AccesoProductos.insertar(producto);
		if(insertar) {
			System.out.println("Se ha insertado un producto en la base de datos.");
		}else {
			System.out.println("Se ha encontrado un producto con ese código en la base de datos.");
		}
	}


	private static void consultar() throws ClassNotFoundException, InstantiationException, IllegalAccessException, XMLDBException {
		ArrayList<Producto> productos = AccesoProductos.consultar();
		for(Producto producto: productos) {
			System.out.println(producto);
		}
		if(productos.size()==0) {
			System.out.println("No se ha encontrado ningún producto en la base de datos.");
		}else {
			System.out.println("Se han consultado "+productos.size()+" productos de la base de datos.");
		}
	}

	private static void consultarCodigo() throws ClassNotFoundException, InstantiationException, IllegalAccessException, XMLDBException {
		int codigo = Teclado.leerEntero("¿Código? ");
		Producto comProducto = AccesoProductos.consultarCodigo(codigo);
		if (comProducto!=null) {// si existe
			System.out.println(comProducto);
		}else {
			System.out.println("No se ha encontrado ningún producto con ese código en la base de datos.");
		}
	}

	private static void actualizar() throws ClassNotFoundException, InstantiationException, IllegalAccessException, XMLDBException {
		int codigo = Teclado.leerEntero("¿Código? ");
		Producto comProducto = AccesoProductos.consultarCodigo(codigo);
		if (comProducto!=null) {// si existe
			String denominacion = Teclado.leerCadena("¿Denominación? ");
			double precio = Teclado.leerReal("¿Precio? ");
			int stockActual = Teclado.leerEntero("¿Stock Actual? ");
			int stockMinimo = Teclado.leerEntero("¿Stock Mínimo? ");
			int codigoZona = Teclado.leerEntero("¿Código de Zona? ");
			Producto producto = new Producto(codigo,denominacion,precio,stockActual,stockMinimo,codigoZona);
			AccesoProductos.actualizar(producto);
			System.out.println("Se ha actualizado un producto de la base de datos.");
		}else {
			System.out.println("No se ha encontrado ningún producto con ese código en la base de datos.");
		}
	}

	private static void eliminar() throws ClassNotFoundException, InstantiationException, IllegalAccessException, XMLDBException {
		int codigo = Teclado.leerEntero("¿Código? ");
		Producto comProducto = AccesoProductos.consultarCodigo(codigo);
		if (comProducto!=null) {
			AccesoProductos.eliminar(codigo);
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
				+ "1) Insertar un producto en la base de datos\n"
				+ "2) Consultar todos los productos de la base de datos.\n"
				+ "3) Consultar un producto, por código, de la base de datos.\n"
				+ "4) Actualizar un producto, por código, de la base de datos.\n"
				+ "5) Eliminar un producto, por código, de la base de datos.");
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
