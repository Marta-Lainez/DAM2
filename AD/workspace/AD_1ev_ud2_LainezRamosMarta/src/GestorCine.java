import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entrada.Teclado;

public class GestorCine {

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
			e.printStackTrace();
		}catch (SQLException sqle) {
			System.out.println(sqle.getMessage());
		}
	}
	/*
	 * input: Lista de Prestacion a imprimir
	 * Descripción: Recorre la lista con un for-each e imprime cada elemento con el método toString() de la clase
	 */
	public static void imprimirLista(List<Prestacion> listaPrestaciones) {
		for(Prestacion prestacion: listaPrestaciones) {
			System.out.println(prestacion.toString());
		}
	}
	/* 
	 * Descripción: Método que crea una lista de salas
	 * Output: ArrayList de tipo salas con las salas dadas en el examen
	 */
	public static List<Sala> crearColeccionSalas(){
		List<Sala> listaSalas = new ArrayList<>();
		listaSalas.add(new Sala("uno",90,3.00,2.50));
		listaSalas.add(new Sala("dos",125,4.50,4.00));
		listaSalas.add(new Sala("tres",250,5.75,5.25));
		listaSalas.add(new Sala("cuatro",400,7.90,7.40));
		return listaSalas;
	}
	/*
	 * Opción 1 del menú
	 * Input: Lista de salas generada en el método crearColeccionesSalas()
	 * Descripción: Inserta todas las salas de la lista introducida por parámetro.
	 * 	Accede al método insertar(Lista<Sala>) de la clase AccesoDatos. Crea una conexión con la base de datos y crea la sentencia sql
	 * 	de inserción. Con un forEach recorre la lista de salas y las inserta en la base de datos. Por último imprime cuántas
	 * 	salas han sido insertados.
	 */
	public static void insertarSalas(List<Sala> listaSalas) throws ClassNotFoundException, SQLException, IOException {
		int salasInsertadas = AccesoDatos.insertar(listaSalas);
		System.out.println("Se han insertado " + salasInsertadas + " salas en la base de datos.");
	}
	/*
	 * Opción 2 del menú
	 * Descripción: Imprime todas las prestaciones mediante el método imprimirLista(List <Prestacion>).
	 * Pide el código para las eliminaciones. Si esas prestaciones tienen salas referidas, pregunta si se quiere borrar todo.
	 * Si la respuesta es diferente "Si", elimina todas las prestaciones y sus prestaciones-salas.
	 * 
	 */
	public static void eliminarPrestacion() throws ClassNotFoundException, SQLException {
		imprimirLista(AccesoDatos.consultarTodasPrestaciones());
		int codigo = Teclado.leerEntero("Código de la prestación a eliminar: ");
		int prestacionesSalas = AccesoDatos.consultarPrestacionesSalas(codigo);
		boolean eliminar = true;
		int eliminados = 0;
		if(prestacionesSalas > 0) {
			System.out.println("La prestación está referida en " + prestacionesSalas + " prestaciones-salas de la base de datos.");
			String preguntaEliminar = Teclado.leerCadena("¿Eliminar todos los datos? Si/No: ");
			if((preguntaEliminar.equals("Si"))) {
				eliminados = AccesoDatos.eliminarPrestacion(codigo);
				if(eliminados != 0) {
					System.out.println("Se ha eliminado una prestación de la base de datos.");
				}
				else {
					System.out.println("No existe ninguna prestación con ese código en la base de datos.");
				}	
			}
		}else {
			eliminados = AccesoDatos.eliminarPrestacion(codigo);
			if(eliminados != 0) {
				System.out.println("Se ha eliminado una prestación de la base de datos.");
			}
			else {
				System.out.println("No existe ninguna prestación con ese código en la base de datos.");
			}	
		}
			
	}
	public static void consultarPeliculas() throws ClassNotFoundException, SQLException {
		List<Pelicula> listaPeliculas = AccesoDatos.consultarTodasPelis();
		for(Pelicula peli: listaPeliculas) {
			System.out.println(peli.toString());
		}
	}
	/*
	 * Descripción: Describe las opciones del menú
	 */
	public static void imprimirMenu() {
		System.out.println("0) Salir del programa.\n"
				+ "1) Insertar SALAS desde una colección con sentencia preparada.\n"
				+ "2) Eliminar una PRESTACIÓN mediante una transacción, por código, de la base de datos.\n"
				+ "3) Consultar todas las PELLÍCULAS, ordenadas por título, de la base de datos.");
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
			insertarSalas(crearColeccionSalas());
			break;
		case 2: 
			eliminarPrestacion();
			break;
		case 3: 
			consultarPeliculas();
			break;
		
		default:
			System.out.println("La opcion de menu debe estar comprendida entre 0 y 3.");
		}
	}
}
