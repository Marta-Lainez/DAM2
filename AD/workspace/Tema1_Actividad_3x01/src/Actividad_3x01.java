import java.io.IOException;
import java.util.List;

import entrada.Teclado;

public class Actividad_3x01 {

	public static void main(String[] args) throws ClassNotFoundException {
		try {
			int opción = -1;
			do {
				imprimirMenú();
				opción = Teclado.leerEntero("Opción: ");
				menú(opción);
			}while(opción != 0);
		}
		catch (IOException ioe) {
			System.out.println("Error al leer del fichero:");
			System.out.println(ioe.getMessage());
			ioe.printStackTrace();
		}
	} 
	// Opcion 1 en menu
	public static void insertarEscritor(int código, String nombre, String nacimiento, String nacionalidad) throws IOException, ClassNotFoundException {
		if(AccesoEscritor.existeEscritor(código) != null)
			System.out.println("Ya existe otro escritor con ese código en el fichero binario.");
		else {
			AccesoEscritor.insertarEscritor(código, nombre, nacimiento, nacionalidad);
			System.out.println("Se ha insertado un escritor en el fichero binario.");
		}
	} 
	// Opcion 2 en menu
	public static void imprimirFichero() throws IOException, ClassNotFoundException{
		List <Escritor> lista = AccesoEscritor.leerEscritores();
		int tamaño = AccesoEscritor.numeroEscritores(lista);
		if(tamaño == 0)
			System.out.println("El fichero binario no tiene ningún escritor.");
		else {
			for(Escritor e: lista) {
				System.out.println(e.toString());
			}
			System.out.println("Se han consultado " + tamaño + " escritores del fichero de texto.");
		}
	} 
	// Opcion 3 en menu
	public static void consultarEscritor(int código) throws ClassNotFoundException, IOException {
		if(AccesoEscritor.existeEscritor(código) == null)
			System.out.println("No existe ningún escritor con ese código en el fichero binario.");
		else 
			System.out.println(AccesoEscritor.existeEscritor(código).toString());
	}
	// Opcion 4 del menu
	public static void actualizarEscritor(int código, String nombre, String nacimiento, String nacionalidad) throws ClassNotFoundException, IOException {
		if(AccesoEscritor.existeEscritor(código) == null)
			System.out.println("No existe ningún escritor con ese código en el fichero binario.");
		else {
			List<Escritor> lista = AccesoEscritor.eliminarEscritor(código);
			AccesoEscritor.escribirEscritores(lista);
			AccesoEscritor.insertarEscritor(código, nombre, nacimiento, nacionalidad);
			System.out.println("Se ha actualizado un escritor del fichero binario.");
		}
	}
	// Opcion 5 del menu
	public static void eliminarEscritor(int código) throws ClassNotFoundException, IOException {
		if(AccesoEscritor.existeEscritor(código) == null)
			System.out.println("No existe ningún escritor con ese código en el fichero binario.");
		else {
			List<Escritor> lista = AccesoEscritor.eliminarEscritor(código);
			AccesoEscritor.escribirEscritores(lista);
			System.out.println("Se ha eliminado un escritor del fichero binario.");
		}
	}
	public static void imprimirMenú() {
		System.out.println("0) Salir del programa.\n1) Insertar un escritor en el fichero binario.\n"
				+ "2) Consultar todos los escritores del fichero binario.\n"
				+ "3) Consultar un escritor, por código, del fichero binario.\n"
				+ "4) Actualizar un escritor, por código, del fichero binario.\n"
				+ "5) Eliminar un escritor, por código, del fichero binario");
	}
	
	public static void menú(int opción) throws IOException, ClassNotFoundException {
		int código;
		String nombre;
		String nacimiento;
		String nacionalidad;
		switch (opción) {
		case 0:
			break;
		case 1: // FUNCIONA
			código = Teclado.leerEntero("Código:");
			nombre = Teclado.leerCadena("Nombre: ");
			nacimiento = Teclado.leerCadena("Nacimiento: ");
			nacionalidad = Teclado.leerCadena("Nacionalidad: ");
			insertarEscritor(código, nombre, nacimiento, nacionalidad);
			break;
		case 2: // FUNCIONA
			imprimirFichero();
			break;
		case 3: // FUNCIONA
			código = Teclado.leerEntero("Código: ");
			consultarEscritor(código);
			break;
		case 4: // 
			código = Teclado.leerEntero("Código:");
			nombre = Teclado.leerCadena("Nombre: ");
			nacimiento = Teclado.leerCadena("Nacimiento: ");
			nacionalidad = Teclado.leerCadena("Nacionalidad: ");
			actualizarEscritor(código, nombre, nacimiento, nacionalidad);
			break;
		case 5: //
			código = Teclado.leerEntero("Código empleado:");
			eliminarEscritor(código);
			break;
		default:
			System.out.println("La opción de menú debe estar comprendida entre 0 y 5.");
		}
	}
}
