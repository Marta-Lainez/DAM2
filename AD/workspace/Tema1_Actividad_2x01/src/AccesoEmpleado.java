import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AccesoEmpleado {
	public static final String NOMBRE_FICHERO_EMPLEADOS = "data/empleados.txt";
	
	private static void existeFichero() throws IOException {
		File fichero = new File(NOMBRE_FICHERO_EMPLEADOS);
		fichero.createNewFile(); //crea el fichero solamente si no existía antes
	}
	private static List deFicheroALista() throws IOException{
		existeFichero();
		BufferedReader flujoEntrada = null;
		List<Empleado> listaEmpleados = new ArrayList<>();
		try {
			flujoEntrada = new BufferedReader(new FileReader(NOMBRE_FICHERO_EMPLEADOS));
			;
			String linea = flujoEntrada.readLine(); 
	  		while (linea != null) {  
	  			listaEmpleados.add(new Empleado(linea));
	  			linea = flujoEntrada.readLine();
	  		}
		}
		finally {
			if(flujoEntrada != null)
				flujoEntrada.close();	
		}
  		return listaEmpleados;
	}
	public static List getDeFicheroALista() throws IOException {
		return deFicheroALista();
	}
	private static void deListaAFichero(List nuevaLista) throws IOException {
		existeFichero();
		List <Empleado> lista = nuevaLista;
		BufferedWriter flujoSalida = null;
		try {
			flujoSalida = new BufferedWriter(new FileWriter(NOMBRE_FICHERO_EMPLEADOS));
			for(Empleado e: lista) {
				flujoSalida.write(e.toStringWithSeparators() + "\n");
			}
		}
		finally {
			if(flujoSalida != null)
				flujoSalida.close();	
		}
	}
	public static void getDeListaAFichero(List nuevaLista) throws IOException {
		deListaAFichero(nuevaLista);
	}
	public static boolean existeEmpleado(int código) throws IOException{
		List <Empleado> lista = deFicheroALista();
		for(Empleado e: lista) {
			if(e.getCódigo() == código)
				return true;
		}
		return false;
	}
	public static void insertarEmpleado(int código, int códigoDepartamento, double salario, String nombre, String fechaAlta) throws IOException{
		BufferedWriter flujoSalida = null;
		try {
			flujoSalida = new BufferedWriter(new FileWriter(NOMBRE_FICHERO_EMPLEADOS, true));
			flujoSalida.write(new Empleado(código, códigoDepartamento, salario, nombre, fechaAlta).toStringWithSeparators() + "\n");
		}
		finally {
			if(flujoSalida != null)
				flujoSalida.close();	
		}
	}
	public static List eliminarEmpleado(int código) throws IOException{
		List <Empleado> lista = deFicheroALista();
		Iterator <Empleado> iterador = lista.iterator();
		while(iterador.hasNext()) {
			Empleado empleadoIterador = iterador.next();
			if(empleadoIterador.getCódigo() == código) {
				iterador.remove();
			}
		}
		return lista;
	}
	public static boolean estáVacio() throws IOException{
		existeFichero();
		boolean vacio = false;
		BufferedReader flujoEntrada = null;
		try {
			flujoEntrada = new BufferedReader(new FileReader(NOMBRE_FICHERO_EMPLEADOS));
			String linea = flujoEntrada.readLine();
			if(linea == null) 
				vacio = true;
		}
		finally {
			if(flujoEntrada != null)
				flujoEntrada.close();	
		}
		return vacio;
	}
	public static Empleado devuelveEmpleado(int código) throws IOException{
		List <Empleado> lista = deFicheroALista();
		for(Empleado e: lista) {
			if(e.getCódigo() == código)
				return e;
		}
		return null;
	}
	public static boolean EmpleadoEnDepartamento(int códigoDepartamento) throws IOException {
		List <Empleado> lista = deFicheroALista();
		for(Empleado e: lista) {
			if(e.getCódigoDepartamento() == códigoDepartamento)
				return true;
		}
		return false;
	}
	
	
	
	
	
	
}
