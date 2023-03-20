import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.sqlite.SQLiteConfig;

public class AccesoDatos {
	private static final String NOMBRE_BD = "db/salas_de_cine.db";
	private static final String URL = "jdbc:sqlite:" + NOMBRE_BD;
	private static final String NOMBRE_CONTROLADOR_SQLITE = "org.sqlite.JDBC";
	
	/*
	 * Input: Lista de objetos Sala
	 * Descripción: Recoge una lista de Salas desde parámetro. Crea conexión con la base de datos salas_de_cine.db
	 * 	y con un forEach recorre la lista de salas y los inserta en la base de datos con una sentencia preparada sql de inserción.
	 * Output: int que responde al número de salas insertados en la base de datos
	 */
	public static int insertar(List<Sala> listaSalas) throws ClassNotFoundException, SQLException, IOException {
		List<Sala> listaDepartamentos = listaSalas;
		int contador = 0;
		Connection conexion = null;
		try {
			Class.forName(NOMBRE_CONTROLADOR_SQLITE);
			SQLiteConfig config = new SQLiteConfig();
			config.enforceForeignKeys(true); // Se asegura de respetar las foreign keys
			conexion = DriverManager.getConnection(URL,config.toProperties());
			conexion.setAutoCommit(false); // No hace commit hasta la linea de comando conexion.commit() para asegurarse de que o se inserta todo o nada
			String sql = "INSERT INTO sala (nombre, numero_butacas, precio_normal, precio_reducido) VALUES (?,?,?,?)"; // Inserta salas con los valores de los interrogantes
			PreparedStatement sentencia = conexion.prepareStatement(sql);
			for(Sala sala: listaSalas) {
				sentencia.setString(1,sala.getNombre()); // primer "?"
				sentencia.setInt(2,sala.getNumeroButacas()); // segundo "?" 
				sentencia.setDouble(3,sala.getPrecioNormal()); // tercer "?" 
				sentencia.setDouble(4,sala.getPrecioReducido()); // cuarto "?" 
				contador += sentencia.executeUpdate(); // Al ejecutar se suma 1 al contador, que lleva la cuenta de salas insertados
			}
			conexion.commit(); // Ejecuta todos los cambios
			return contador;
		}
		catch (SQLException sqle) {
			if(conexion != null) {
				conexion.rollback(); // Si algo sale mal durante la inserción, deshace los cambios
			}
			throw sqle;
		}
		finally {
			if (conexion != null) {
				conexion.close();
			}
		}
	}
	
	/*
	 * Descripción: Crea la conexión con la base de datos y lee todos los registros de "prestacion" pasandolos a una lista.
	 * Output: Lista de pretaciones
	 */
	public static List<Prestacion> consultarTodasPrestaciones() throws ClassNotFoundException, SQLException {
		Connection conexion = null;
		List<Prestacion> listaPrestaciones = new ArrayList<>();
		try {
			Class.forName(NOMBRE_CONTROLADOR_SQLITE);
			conexion = DriverManager.getConnection(URL);
			String sentenciaConsultar = "SELECT * FROM prestacion";
			Statement sentencia = conexion.createStatement();
			ResultSet resultados = sentencia.executeQuery(sentenciaConsultar);
			while (resultados.next()) {
				listaPrestaciones.add(new Prestacion(resultados.getInt("codigo"),
					          resultados.getString("descripcion")));
				
			}
			return listaPrestaciones;
		}
		finally {
			if (conexion != null) {
				conexion.close();
			}
		}
	}
	/*
	 * Input: Localidad de los socios que se buscan
	 * Descripción: Crea la conexión con la base de datos y busca todos los socios de la base de datos que tengan
	 * la localidad introducida por parámetro
	 * Output: Devuelve la lista de socios con esa localidad
	 */
	public static int consultarPrestacionesSalas(int codigo) throws ClassNotFoundException, SQLException {
		Connection conexion = null;
		int contador = 0;
		try {
			Class.forName(NOMBRE_CONTROLADOR_SQLITE);
			conexion = DriverManager.getConnection(URL);
			String sentenciaConsultar = "SELECT * FROM prestacion_sala WHERE codigo_prestacion = " + codigo;
			Statement sentencia = conexion.createStatement();
			ResultSet resultados = sentencia.executeQuery(sentenciaConsultar);	
			while (resultados.next()) {
				contador++;
			}
			return contador;
		}
		finally {
			if (conexion != null) {
				conexion.close();
			}
		}
	}
	/*
	 * input: código de eliminación para las prestaciones y las prestaciones de salas
	 * Descripción: Crea la conexión con la base de datos y elimina las prestaciones y prestaciones de salas con el
	 * código introducido por parámetro. Si algo sale mal durante el proceso se deshacen todos los cambios
	 */
	public static int eliminarPrestacion(int codigo) throws ClassNotFoundException, SQLException {
		Connection conexion = null;
		try {
			Class.forName(NOMBRE_CONTROLADOR_SQLITE);
			SQLiteConfig config = new SQLiteConfig();
			config.enforceForeignKeys(true); // Se asegura de respetar las foreign keys
			conexion = DriverManager.getConnection(URL,config.toProperties());
			conexion.setAutoCommit(false); // No hace commit hasta la linea de comando conexion.commit() para asegurarse de que o se elimina todo o nada
			
			String sqlPrestacionSala = "DELETE FROM prestacion_sala WHERE codigo_prestacion = ?";
			PreparedStatement sentenciaPrestacionSala = conexion.prepareStatement(sqlPrestacionSala);
			
			String sqlPrestacion = "DELETE FROM prestacion WHERE codigo = ?";
			PreparedStatement sentenciaPrestacion = conexion.prepareStatement(sqlPrestacion);
			
			sentenciaPrestacionSala.setInt(1, codigo); // primer "?"
			sentenciaPrestacion.setInt(1, codigo); // segundo "?"
			int prestacionesEliminadas = sentenciaPrestacionSala.executeUpdate();
			int prestacionSalasEliminadas = sentenciaPrestacion.executeUpdate();
			
			conexion.commit(); // Ejecuta los cambios
			return prestacionesEliminadas;
		}
		catch (SQLException sqle) {
			if(conexion != null) {
				conexion.rollback(); // Si algo sale mal durante la inserción, deshace los cambios
			}
			throw sqle;
		}
		finally {
			if (conexion != null) {
				conexion.close();
			}
		}
	}
	/*
	 * Descripción: Crea la conexión con la base de datos e imprime sus registros pasandolos a una lista.
	 * Output: Lista de socios
	 */
	public static List<Pelicula> consultarTodasPelis() throws ClassNotFoundException, SQLException {
		Connection conexion = null;
		List<Pelicula> lista = new ArrayList<>();
		try {
			Class.forName(NOMBRE_CONTROLADOR_SQLITE);
			conexion = DriverManager.getConnection(URL);
			String sentenciaConsultar = "SELECT * FROM pelicula";
			Statement sentencia = conexion.createStatement();
			ResultSet resultados = sentencia.executeQuery(sentenciaConsultar);
			while (resultados.next()) {
				lista.add(new Pelicula(resultados.getInt("codigo"),
					          resultados.getString("titulo"),
					          resultados.getString("sinopsis"),
					          resultados.getInt("duracion"),
					          resultados.getString("fecha_estreno"),
					          null));
			}
			return lista;
		}
		finally {
			if (conexion != null) {
				conexion.close();
			}
		}
	}
	public static int consultarSalasPelis(int codigo) throws ClassNotFoundException, SQLException {
		List<Pelicula> lista = new ArrayList<>();
		Connection conexion = null;
		int contador = 0;
		try {
			Class.forName(NOMBRE_CONTROLADOR_SQLITE);
			conexion = DriverManager.getConnection(URL);
			String sentenciaConsultar = "SELECT codigo_sala FROM pelicula";
			Statement sentencia = conexion.createStatement();
			ResultSet resultados = sentencia.executeQuery(sentenciaConsultar);	
			while (resultados.next()) {
				lista.add(new Pelicula(resultados.getInt("codigo"),
				          resultados.getString("titulo"),
				          resultados.getString("sinopsis"),
				          resultados.getInt("duracion"),
				          resultados.getString("fecha_estreno"),
				          null));
			}
			return contador;
		}
		finally {
			if (conexion != null) {
				conexion.close();
			}
		}
	}
}
