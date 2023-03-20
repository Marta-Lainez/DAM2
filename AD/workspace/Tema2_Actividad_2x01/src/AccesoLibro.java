import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.sqlite.SQLiteConfig;

public class AccesoLibro {
	public static final String URL = "jdbc:sqlite:db\\\\biblioteca.db";
	public static final String DRIVER = "org.sqlite.JDBC";
	
	/*
	 * Input: Parámetros del constructor de libro
	 * Descripción: Crea la conexión con la base de datos e inserta un nuevo libro con los parámetros introducidos
	 */
	public static void insertar(String isbn, String titulo, String escritor, int agnoPublicacion, double puntuacion) throws ClassNotFoundException, SQLException {
		Connection conexion = null;
		try {
			Class.forName(DRIVER);
			conexion = DriverManager.getConnection(URL);
			String sentenciaInsertar = "INSERT INTO libro (isbn, titulo, escritor, año_publicacion, puntuacion)"
					+ " VALUES ('" + isbn + "', '" + titulo + "' , '" + escritor + "' , '" + agnoPublicacion + "', '" + puntuacion + "')";
			Statement sentencia = conexion.createStatement();
			sentencia.executeUpdate(sentenciaInsertar);
		}
		finally {
			if (conexion != null) {
				conexion.close();
			}
		}
	}
	/*
	 * Input: Código del libro
	 * Descripción: Crea la conexión con la base de datos y la recorre buscando un libro con el código introducido por parámetro
	 * Output: Devuelve un objeto libro si existe el libro con el código introducido por parámetro. Si no existe devuelve null
	 */
	public static Libro existe(int codigo) throws ClassNotFoundException, SQLException {
		Connection conexion = null;
		try {
			Class.forName(DRIVER);
			conexion = DriverManager.getConnection(URL);
			String sentenciaConsultar = "SELECT * FROM libro WHERE codigo = " + codigo;
			Statement sentencia = conexion.createStatement();
			ResultSet resultados = sentencia.executeQuery(sentenciaConsultar);	
			while (resultados.next()) {
				if(resultados.getInt("codigo") == codigo) {
					return new Libro(resultados.getInt("codigo"),resultados.getString("isbn"),resultados.getString("titulo"), resultados.getString("escritor"),
										resultados.getInt("año_publicacion"), resultados.getDouble("puntuacion"));
				}
			}
		}
		finally {
			if (conexion != null) {
				conexion.close();
			}
		}
		return null;
	}
	
	/*
	 * Input: código de libro
	 * Descripción: Crea la conexión con la base de datos y busca el libro con el código introducido por parámetro para eliminarlo
	 * Output: Devuelve el numero de registros borrados
	 */
	public static int eliminar(int codigo) throws ClassNotFoundException, SQLException{
		Connection conexion = null;
		try {
			Class.forName(DRIVER);
			SQLiteConfig config = new SQLiteConfig();  
	        config.enforceForeignKeys(true);  // No deja eliminar un departamento si tiene empleados
			conexion = DriverManager.getConnection(URL, config.toProperties());
			String sentenciaEliminar = "DELETE FROM libro WHERE codigo = " + codigo;
			Statement sentencia = conexion.createStatement();
			return sentencia.executeUpdate(sentenciaEliminar);
		}
		finally {
			if (conexion != null) {
				conexion.close();
			}
		}
	}
	/*
	 * Descripción: Crea la conexión con la base de datos y lee todos sus registros pasandolos a una lista.
	 * Output: Lista de libros
	 */
	public static List<Libro> consultarTodos() throws ClassNotFoundException, SQLException {
		Connection conexion = null;
		List<Libro> listaLibros = new ArrayList<>();
		try {
			Class.forName(DRIVER);
			conexion = DriverManager.getConnection(URL);
			String sentenciaConsultar = "SELECT * FROM libro";
			Statement sentencia = conexion.createStatement();
			ResultSet resultados = sentencia.executeQuery(sentenciaConsultar);	
			while (resultados.next()) {
				Libro libro = 
					new Libro(resultados.getInt("codigo"),
					          resultados.getString("isbn"),
					          resultados.getString("titulo"),
					          resultados.getString("escritor"),
					          resultados.getInt("año_publicacion"),
					          resultados.getDouble("puntuacion"));
				listaLibros.add(libro);
			}
			return listaLibros;
		}
		finally {
			if (conexion != null) {
				conexion.close();
			}
		}
	}
	/*
	 * Input: Escritor de los libros que se buscan
	 * Descripción: Crea la conexión con la base de datos y busca todos los libros de la base de datos que tengan
	 * el escritor introducido por parámetro
	 * Output: Devuelve la lista de libros con ese escritor
	 */
	public static List<Libro> consultarVarios(String escritor) throws ClassNotFoundException, SQLException {
		Connection conexion = null;
		List<Libro> listaLibros = new ArrayList<>();
		try {
			Class.forName(DRIVER);
			conexion = DriverManager.getConnection(URL);
			String sentenciaConsultar = "SELECT * FROM empleado WHERE escritor = " + escritor + " ORDER BY escritor DESC";
			Statement sentencia = conexion.createStatement();
			ResultSet resultados = sentencia.executeQuery(sentenciaConsultar);	
			while (resultados.next()) {
				if(resultados.getString("escritor").equals(escritor)) {
					listaLibros.add(new Libro(resultados.getInt("codigo"),
					          resultados.getString("isbn"),
					          resultados.getString("titulo"),
					          resultados.getString("escritor"),
					          resultados.getInt("año_publicacion"),
					          resultados.getDouble("puntuacion")));
				}
			}
			return listaLibros;
		}
		finally {
			if (conexion != null) {
				conexion.close();
			}
		}
	}
	/*
	 * Descripción: Crea la conexión con la base de datos y lee todos sus registros pasando a una lista los libros que no están prestados.
	 * Output: Lista de libros
	 */
	public static List<Libro> consultarNoPrestados() throws ClassNotFoundException, SQLException {
		Connection conexion = null;
		List<Libro> listaLibros = new ArrayList<>();
		try {
			Class.forName(DRIVER);
			conexion = DriverManager.getConnection(URL);
			String sentenciaConsultar = "SELECT * FROM libro li "
									  + "LEFT JOIN prestamo pr "
									  + "ON li.codigo = pr.codigo_libro "
									  + "WHERE pr.fecha_inicio IS NULL";
			Statement sentencia = conexion.createStatement();
			ResultSet resultados = sentencia.executeQuery(sentenciaConsultar);	
			while (resultados.next()) {
				Libro libro = 
					new Libro(resultados.getInt("codigo"),
					          resultados.getString("isbn"),
					          resultados.getString("titulo"),
					          resultados.getString("escritor"),
					          resultados.getInt("año_publicacion"),
					          resultados.getDouble("puntuacion"));
				listaLibros.add(libro);
			}
			return listaLibros;
		}
		finally {
			if (conexion != null) {
				conexion.close();
			}
		}
	}
	/*
	 * Input: Fecha de devolución del libro
	 * Descripción: Crea la conexión con la base de datos y lee todos sus registros pasando a una lista los libros que no están prestados.
	 * Output: Lista de libros
	 */
	public static List<Libro> consultarDevueltos(String fechaDevolucion) throws ClassNotFoundException, SQLException {
		Connection conexion = null;
		List<Libro> listaLibros = new ArrayList<>();
		try {
			Class.forName(DRIVER);
			conexion = DriverManager.getConnection(URL);
			String sentenciaConsultar = "SELECT * FROM libro li "
									  + "LEFT JOIN prestamo pr "
									  + "ON li.codigo = pr.codigo_libro "
									  + "WHERE pr.fecha_devolucion = '" + fechaDevolucion + "'";
			Statement sentencia = conexion.createStatement();
			ResultSet resultados = sentencia.executeQuery(sentenciaConsultar);	
			while (resultados.next()) {
				Libro libro = 
					new Libro(resultados.getInt("codigo"),
					          resultados.getString("isbn"),
					          resultados.getString("titulo"),
					          resultados.getString("escritor"),
					          resultados.getInt("año_publicacion"),
					          resultados.getDouble("puntuacion"));
				listaLibros.add(libro);
			}
			return listaLibros;
		}
		finally {
			if (conexion != null) {
				conexion.close();
			}
		}
	}
}
