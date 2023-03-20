import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class AccesoVideojuegoTexto {
	public static final String NOMBRE_FICHERO_VIDEOJUEGOS = "data/videojuegos.txt";
	
	private static void existeFichero() throws IOException {
		File fichero = new File(NOMBRE_FICHERO_VIDEOJUEGOS);
		fichero.createNewFile(); //crea el fichero solamente si no existia antes
	}
	
	public static List<Videojuego> leerVideojuegos() throws IOException{
		existeFichero();
		BufferedReader flujoEntrada = null;
		List<Videojuego> listaVideojuegos = new ArrayList<>();
		try {
			flujoEntrada = new BufferedReader(new FileReader(NOMBRE_FICHERO_VIDEOJUEGOS));
			String linea = flujoEntrada.readLine(); 
	  		while (linea != null) {  
	  			listaVideojuegos.add(new Videojuego(linea));
	  			linea = flujoEntrada.readLine();
	  		}
		}
		finally {
			if(flujoEntrada != null)
				flujoEntrada.close();	
		}
  		return listaVideojuegos;
	}
	
	public static void escribirVideojuegos(List<Videojuego> nuevaLista) throws IOException {
		existeFichero();
		List <Videojuego> lista = nuevaLista;
		BufferedWriter flujoSalida = null;
		try {
			flujoSalida = new BufferedWriter(new FileWriter(NOMBRE_FICHERO_VIDEOJUEGOS));
			for(Videojuego videojuego: lista) {
				flujoSalida.write(videojuego.toStringWithSeparators() + "\n");
			}
		}
		finally {
			if(flujoSalida != null)
				flujoSalida.close();	
		}
	}
	public static List<Videojuego> actualizarVideojuego(int codigo, String titulo, String plataforma, double precio) throws IOException, ClassNotFoundException{
		List <Videojuego> listaVideojuegos = leerVideojuegos();
		ListIterator <Videojuego> iterador = listaVideojuegos.listIterator();
		while(iterador.hasNext()) {
			Videojuego videojuegoIterador = iterador.next();
			if(videojuegoIterador.getCodigo() == codigo) {
				iterador.remove();
				iterador.add(new Videojuego(codigo, titulo, plataforma,precio));
			}
		}
		return listaVideojuegos;
	}
	
}
