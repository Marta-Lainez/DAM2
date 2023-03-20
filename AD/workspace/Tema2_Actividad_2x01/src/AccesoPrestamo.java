import java.io.BufferedReader;
import java.io.FileReader;
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

public class AccesoPrestamo {
	private static final String NOMBRE_BD = "db/biblioteca.db";
	private static final String URL = "jdbc:sqlite:" + NOMBRE_BD;
	private static final String NOMBRE_CONTROLADOR_SQLITE = "org.sqlite.JDBC";
	/*
	 * Input: Int que representa el codigo del libro que queremos obtener en la consulta
	 * Descripción: Crea la conexión con la base de datos hace un select de aquellos prestamos cuyo codigo_libro es el introducido por parámetro,
	 * 	cuya fecha de devolución es nula y cuya fecha de inicio del prestamo existe
	 * Output: booleano. Si se devuelve algún préstamo en el select se devuelve false ya que el libro no está disponible. Si no devuelve ningún
	 * 	préstamo con esas condiciones el libro está disponible y devuelve true
	 */
	public static boolean estarPrestado(int codigoLibro) throws SQLException {
		Connection conexion = null;
		int contador = 0;
		try {
			SQLiteConfig config = new SQLiteConfig();
			config.enforceForeignKeys(true); // Se asegura de respetar las foreign keys
			conexion = DriverManager.getConnection(URL,config.toProperties());
			conexion.setAutoCommit(false); // No hace commit hasta la linea de comando conexion.commit() para asegurarse de que o se inserta todo o nada
			String sql = "SELECT * FROM prestamo WHERE fecha_devolucion IS NULL AND fecha_inicio IS NOT NULL AND codigo_libro = ?"; // Condición 1
			PreparedStatement sentencia = conexion.prepareStatement(sql);
			sentencia.setInt(1, codigoLibro);
			ResultSet rs = sentencia.executeQuery();
			while(rs.next()) {
				contador++;
			}
			if(contador == 0)
				return false;
			return true;
		}
		finally {
			if (conexion != null) {
				conexion.close();
			}
		}	
	}
	/*
	 * Input: Int que representa el codigo del socio que queremos obtener en la consulta
	 * Descripción: Crea la conexión con la base de datos hace un select de aquellos prestamos cuyo codigo_socio es el introducido por parámetro,
	 * 	cuya fecha de devolución es nula y cuya fecha de inicio del prestamo existe
	 * Output: booleano. Si se devuelve algún préstamo en el select se devuelve false ya que el socio ya tiene un libro. Si no devuelve ningún
	 * 	préstamo con esas condiciones el socio no tiene ningún libro y devuelve true
	 */
	public static boolean tenerLibro(int codigoSocio) throws SQLException {
		Connection conexion = null;
		int contador = 0;
		try {
			SQLiteConfig config = new SQLiteConfig();
			config.enforceForeignKeys(true); // Se asegura de respetar las foreign keys
			conexion = DriverManager.getConnection(URL,config.toProperties());
			String sql = "SELECT * FROM prestamo WHERE fecha_devolucion IS NULL AND fecha_inicio IS NOT NULL AND codigo_socio = ?"; // Condición 2
			PreparedStatement sentencia = conexion.prepareStatement(sql);
			sentencia.setInt(1, codigoSocio);
			ResultSet rs = sentencia.executeQuery();
			while(rs.next()) {
				contador++;
			}
			if(contador == 0)
				return false;
			return true;
		}
		finally {
			if (conexion != null) {
				conexion.close();
			}
		}	
	}
	/*
	 * Input: Parámetros del constructor de préstamo
	 * Descripción: Crea la conexión con la base de datos e inserta un nuevo prestamo con los parámetros introducidos
	 */
	public static int insertar(int codigoLibro, int codigoSocio, String fechaInicio, String fechaFin) throws ClassNotFoundException, SQLException {
		Connection conexion = null;
		int contador = 0;
		try {
			SQLiteConfig config = new SQLiteConfig();
			config.enforceForeignKeys(true); // Se asegura de respetar las foreign keys
			conexion = DriverManager.getConnection(URL,config.toProperties());
			String sql = "INSERT INTO prestamo (codigo_libro, codigo_socio, fecha_inicio, fecha_fin) VALUES (?,?,?,?)";
			PreparedStatement sentencia = conexion.prepareStatement(sql);
			sentencia.setInt(1,codigoLibro);
			sentencia.setInt(2,codigoSocio);
			sentencia.setString(3, fechaInicio);
			sentencia.setString(4, fechaFin);
			contador += sentencia.executeUpdate();
			return contador;
		}
		finally {
			if (conexion != null) {
				conexion.close();
			}
		}
	}
	public static boolean existePrestamo(int codigoLibro, int codigoSocio, String fechaInicio) throws SQLException {
		Connection conexion = null;
		int contador = 0;
		try {
			SQLiteConfig config = new SQLiteConfig();
			config.enforceForeignKeys(true); // Se asegura de respetar las foreign keys
			conexion = DriverManager.getConnection(URL,config.toProperties());
			String sql = "SELECT * FROM prestamo WHERE codigo_libro = ? AND codigo_socio = ? AND fecha_inicio = ?";
			PreparedStatement sentencia = conexion.prepareStatement(sql);
			sentencia.setInt(1, codigoLibro);
			sentencia.setInt(2, codigoSocio);
			sentencia.setString(3,fechaInicio);
			ResultSet rs = sentencia.executeQuery();
			while(rs.next()) {
				contador++;
			}
			if(contador == 0)
				return false;
			return true;
		}
		finally {
			if (conexion != null) {
				conexion.close();
			}
		}	
	}
	/*
	 * Input: Parámetros del constructor de préstamo
	 * Descripción: Crea la conexión con la base de datos y actualiza el prestamo adecuado según los datos introducidos por parámetro
	 */
	public static int actualizar(int codigoLibro, int codigoSocio, String fechaInicio, String fechaDevolucion) throws SQLException {
		Connection conexion = null;
		int contador = 0;
		try {
			SQLiteConfig config = new SQLiteConfig();
			config.enforceForeignKeys(true); // Se asegura de respetar las foreign keys
			conexion = DriverManager.getConnection(URL,config.toProperties());
			String sql = "UPDATE prestamo SET fecha_devolucion = ? WHERE codigo_libro = ? AND codigo_socio = ? AND fecha_inicio = ?";
			PreparedStatement sentencia = conexion.prepareStatement(sql);
			sentencia.setString(1,fechaDevolucion);
			sentencia.setInt(2,codigoLibro);
			sentencia.setInt(3, codigoSocio);
			sentencia.setString(4, fechaInicio);
			contador += sentencia.executeUpdate();
			return contador;
		}
		finally {
			if (conexion != null) {
				conexion.close();
			}
		}
	}
	public static int eliminar(int codigoLibro, int codigoSocio, String fechaInicio) throws ClassNotFoundException, SQLException {
		Connection conexion = null;
		try {
			Class.forName(NOMBRE_CONTROLADOR_SQLITE);
			SQLiteConfig config = new SQLiteConfig();
			config.enforceForeignKeys(true); // Se asegura de respetar las foreign keys
			conexion = DriverManager.getConnection(URL,config.toProperties());
			
			String sql = "DELETE FROM prestamo WHERE codigo_libro = ? AND codigo_socio = ? AND fecha_inicio = ?"; // Sentencia para borrar todos los empleados cuyo codigo de departamento es igual a ?
			PreparedStatement sentencia = conexion.prepareStatement(sql);
			sentencia.setInt(1, codigoLibro);
			sentencia.setInt(2, codigoSocio);
			sentencia.setString(3, fechaInicio);
			return sentencia.executeUpdate();
		}
		finally {
			if (conexion != null) {
				conexion.close();
			}
		}
	}
	/*
	 *
	 */
	public static List<Prestamo> listarTodos() throws IOException, SQLException {
		List<Prestamo> lista = new ArrayList<>();
		Connection conexion = null;
		int contador = 0;
		try {
			SQLiteConfig config = new SQLiteConfig();
			config.enforceForeignKeys(true); // Se asegura de respetar las foreign keys
			conexion = DriverManager.getConnection(URL,config.toProperties());
			String sql = "SELECT * FROM prestamo";
			PreparedStatement sentencia = conexion.prepareStatement(sql);
			ResultSet rs = sentencia.executeQuery();
			while(rs.next()) {
				lista.add(new Prestamo(rs.getInt("codigo_libro"),rs.getInt("codigo_socio"),rs.getString("fecha_inicio"), rs.getString("fecha_fin")
						,rs.getString("fecha_devolucion")));
			}
			return lista;
		}
		finally {
			if (conexion != null) {
				conexion.close();
			}
		}	
	}
}
