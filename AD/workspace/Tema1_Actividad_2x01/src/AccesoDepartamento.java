import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AccesoDepartamento {
	public static final String NOMBRE_FICHERO_DEPARTAMENTOS = "data/departamento.txt";
	private static void existeFichero() throws IOException {
		File fichero = new File(NOMBRE_FICHERO_DEPARTAMENTOS);
		fichero.createNewFile(); //crea el fichero solamente si no existía antes
	}
	private static List deFicheroALista() throws IOException{
		existeFichero();
		BufferedReader flujoEntrada = null;
		List<Departamento> listaDepartamentos = new ArrayList<>();
		try {
			flujoEntrada = new BufferedReader(new FileReader(NOMBRE_FICHERO_DEPARTAMENTOS));
			String linea = flujoEntrada.readLine(); 
	  		while (linea != null) {  
	  			listaDepartamentos.add(new Departamento(linea));
	  			linea = flujoEntrada.readLine();
	  		}
		}
		finally {
			if(flujoEntrada != null)
				flujoEntrada.close();
		}
  		return listaDepartamentos;
	}
	public static List getDeFicheroALista() throws IOException {
		return deFicheroALista();
	}
	private static void deListaAFichero(List nuevaLista) throws IOException {
		existeFichero();
		List <Departamento> lista = nuevaLista;
		BufferedWriter flujoSalida = null;
		try {
			flujoSalida = new BufferedWriter(new FileWriter(NOMBRE_FICHERO_DEPARTAMENTOS));
			for(Departamento d: lista) {
				flujoSalida.write(d.toStringWithSeparators() + "\n");
			}
		}
		finally{
			if (flujoSalida != null)
				flujoSalida.close();
		}
	}
	public static void getDeListaAFichero(List nuevaLista) throws IOException {
		deListaAFichero(nuevaLista);
	}
	public static boolean existeDepartamento(Departamento departamento) throws IOException{
		List <Departamento> lista = deFicheroALista();
		for(Departamento d: lista) {
			if(d.getCódigo() == departamento.getCódigo()) {
				return true;
			}
		}
		return false;
	}
	public static boolean existeDepartamento(int código) throws IOException{
		List <Departamento> lista = deFicheroALista();
		for(Departamento d: lista) {
			if(d.getCódigo() == código)
				return true;
		}
		return false;
	}
	public static void insertarDepartamento(Departamento departamento) throws IOException{
		existeFichero();
		BufferedWriter flujoSalida = null;
		try {
			flujoSalida = new BufferedWriter(new FileWriter(NOMBRE_FICHERO_DEPARTAMENTOS, true));
			flujoSalida.write(departamento.toStringWithSeparators() + "\n");
		}
		finally {
			if (flujoSalida != null)
				flujoSalida.close();
		}
	}
	public static boolean estáVacio() throws IOException{
		existeFichero();
		boolean vacio = false;
		BufferedReader flujoEntrada = null;
		try {
			flujoEntrada = new BufferedReader(new FileReader(NOMBRE_FICHERO_DEPARTAMENTOS));
			String linea = flujoEntrada.readLine();
			if(linea == null) 
				vacio = true;
		}
		finally {
			if (flujoEntrada != null)
				flujoEntrada.close();
		}
		return vacio;
	}
	public static Departamento devuelveDepartamento(int código) throws IOException{
		List <Departamento> lista = deFicheroALista();
		for(Departamento d: lista) {
			if(d.getCódigo() == código)
				return d;
		}
		return null;
	}
	public static List eliminarDepartamento(int código) throws IOException{
		List <Departamento> lista = deFicheroALista();
		Iterator <Departamento> iterador = lista.iterator();
		while(iterador.hasNext()) {
			Departamento departamentoIterador = iterador.next();
			if(departamentoIterador.getCódigo() == código) {
				iterador.remove();
			}
		}
		return lista;
	}
}
