import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.sqlite.SQLiteConfig;

public class AccesoSocio {
	public static final String URL = "jdbc:sqlite:db\\\\biblioteca.db";
	public static final String DRIVER = "org.sqlite.JDBC";
	
	/*
	 * Input: Parámetros del constructor de socio
	 * Descripción: Crea la conexión con la base de datos e inserta un nuevo socio con los parámetros introducidos
	 */
	public static void insertar(String dni, String nombre, String domicilio, String telefono, String correo) throws ClassNotFoundException, SQLException {
		Connection conexion = null;
		try {
			Class.forName(DRIVER);
			conexion = DriverManager.getConnection(URL);
			String sentenciaInsertar = "INSERT INTO socio (dni, nombre, domicilio, telefono, correo)"
					+ " VALUES ('" + dni + "', '" + nombre + "' , '" + domicilio + "' , '" + telefono + "', '" + correo + "')";
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
	 * Input: código de socio
	 * Descripción: Crea la conexión con la base de datos y busca el socio con el código introducido por parámetro para eliminarlo
	 * Output: Devuelve el numero de registros borrados
	 */
	public static int eliminar(int codigo) throws ClassNotFoundException, SQLException{
		Connection conexion = null;
		try {
			Class.forName(DRIVER);
			SQLiteConfig config = new SQLiteConfig();  
	        config.enforceForeignKeys(true);  // No deja eliminar un departamento si tiene empleados
			conexion = DriverManager.getConnection(URL, config.toProperties());
			String sentenciaEliminar = "DELETE FROM socio WHERE codigo = " + codigo;
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
	 * Output: Lista de socios
	 */
	public static List<Socio> consultarTodos() throws ClassNotFoundException, SQLException {
		Connection conexion = null;
		List<Socio> listaSocios = new ArrayList<>();
		try {
			Class.forName(DRIVER);
			conexion = DriverManager.getConnection(URL);
			String sentenciaConsultar = "SELECT * FROM socio";
			Statement sentencia = conexion.createStatement();
			ResultSet resultados = sentencia.executeQuery(sentenciaConsultar);	
			while (resultados.next()) {
				listaSocios.add(new Socio(resultados.getInt("codigo"),
					          resultados.getString("dni"),
					          resultados.getString("nombre"),
					          resultados.getString("domicilio"),
					          resultados.getString("telefono"),
					          resultados.getString("correo")));
				
			}
			return listaSocios;
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
	public static List<Socio> consultarVarios(String localidad) throws ClassNotFoundException, SQLException {
		Connection conexion = null;
		List<Socio> listaSocios = new ArrayList<>();
		try {
			Class.forName(DRIVER);
			conexion = DriverManager.getConnection(URL);
			String sentenciaConsultar = "SELECT * FROM socio WHERE domicilio = " + localidad + " ORDER BY nombre ASC";
			Statement sentencia = conexion.createStatement();
			ResultSet resultados = sentencia.executeQuery(sentenciaConsultar);	
			while (resultados.next()) {
				if(resultados.getString("domicilio").equals(localidad)) {
					listaSocios.add(new Socio(resultados.getInt("codigo"),
					          resultados.getString("dni"),
					          resultados.getString("nombre"),
					          resultados.getString("domicilio"),
					          resultados.getString("telefono"),
					          resultados.getString("correo")));
				}
			}
			return listaSocios;
		}
		finally {
			if (conexion != null) {
				conexion.close();
			}
		}
	}
	/*
	 * Descripción: Crea la conexión con la base de datos y lee todos sus registros pasando a una lista los socios que no tienen préstamos.
	 * Output: Lista de socios
	 */
	public static List<Socio> consultarNoPrestados() throws ClassNotFoundException, SQLException {
		Connection conexion = null;
		List<Socio> listaSocios = new ArrayList<>();
		try {
			Class.forName(DRIVER);
			conexion = DriverManager.getConnection(URL);
			String sentenciaConsultar = "SELECT * FROM socio so "
									  + "LEFT JOIN prestamo pr "
									  + "ON so.codigo = pr.codigo_socio "
									  + "WHERE pr.fecha_inicio IS NULL";
			Statement sentencia = conexion.createStatement();
			ResultSet resultados = sentencia.executeQuery(sentenciaConsultar);	
			while (resultados.next()) {
				listaSocios.add(new Socio(resultados.getInt("codigo"),
				          resultados.getString("dni"),
				          resultados.getString("nombre"),
				          resultados.getString("domicilio"),
				          resultados.getString("telefono"),
				          resultados.getString("correo")));
			}
			return listaSocios;
		}
		finally {
			if (conexion != null) {
				conexion.close();
			}
		}
	}
	/*
	 * Input: Fecha en la que los socios deben tener un préstamo
	 * Descripción: Crea la conexión con la base de datos y lee todos sus registros pasando a una lista los socios que tienen prestamos en esa fecha.
	 * Output: Lista de socios
	 */
	public static List<Socio> consultarFecha(String fecha) throws ClassNotFoundException, SQLException {
		Connection conexion = null;
		List<Socio> listaSocios = new ArrayList<>();
		try {
			Class.forName(DRIVER);
			conexion = DriverManager.getConnection(URL);
			String sentenciaConsultar = "SELECT * FROM socio so "
									  + "INNER JOIN prestamo pr "
									  + "ON so.codigo = pr.codigo_socio "
									  + "WHERE pr.fecha_inicio <= '" + fecha + "' AND pr.fecha_fin >= '" + fecha + "'";
			Statement sentencia = conexion.createStatement();
			ResultSet resultados = sentencia.executeQuery(sentenciaConsultar);	
			while (resultados.next()) {
				listaSocios.add(new Socio(resultados.getInt("codigo"),
				          resultados.getString("dni"),
				          resultados.getString("nombre"),
				          resultados.getString("domicilio"),
				          resultados.getString("telefono"),
				          resultados.getString("correo")));
			}
			return listaSocios;
		}
		finally {
			if (conexion != null) {
				conexion.close();
			}
		}
	}
}
