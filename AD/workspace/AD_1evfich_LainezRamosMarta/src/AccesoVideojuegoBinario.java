import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AccesoVideojuegoBinario {
	public static final String NOMBRE_FICHERO_VIDEOJUEGOS = "data/videojuegos.dat";
	public static List<Videojuego> leerVideojuegos() throws IOException, ClassNotFoundException{
		ObjectInputStream flujoEntrada = null;
		List<Videojuego> listaVideojuegos = new ArrayList<>();
		boolean finalFichero = false;
		try {
			flujoEntrada = new ObjectInputStream(new FileInputStream(NOMBRE_FICHERO_VIDEOJUEGOS));
			while (!finalFichero) {
				try {
					Videojuego videojuego = (Videojuego) flujoEntrada.readObject();
					listaVideojuegos.add(videojuego);
				}
				catch (EOFException eofe) {
					finalFichero = true;
				}
			}
		}
		finally {
			if(flujoEntrada != null)
				flujoEntrada.close();	
		}
  		return listaVideojuegos;
	}
	public static void escribirVideojuegos(List<Videojuego> nuevaLista) throws IOException {
		File fichero = new File(NOMBRE_FICHERO_VIDEOJUEGOS);
		List <Videojuego> lista = nuevaLista;
		ObjectOutputStream flujoSalida1 = null;
		try {
			flujoSalida1 = new ObjectOutputStream(new FileOutputStream(fichero));
			for(Videojuego videojuego: lista) {
				flujoSalida1.writeObject(videojuego);
			}
		}
		finally {
			if (flujoSalida1 != null) {
				flujoSalida1.close();
			}
		}
	}
	public static Videojuego existeVideojuego(int codigo) throws IOException, ClassNotFoundException{
		List <Videojuego> lista = leerVideojuegos();
		for(Videojuego videojuego: lista) {
			if(videojuego.getCodigo() == codigo)
				return videojuego;
		}
		return null;
	}
	public static List<Videojuego> eliminarVideojuego(int codigo) throws IOException, ClassNotFoundException{
		List <Videojuego> lista = leerVideojuegos();
		Iterator <Videojuego> iterador = lista.iterator();
		while(iterador.hasNext()) {
			Videojuego videojuegoIterador = iterador.next();
			if(videojuegoIterador.getCodigo() == codigo) {
				iterador.remove();
			}
		}
		return lista;
	}
}
