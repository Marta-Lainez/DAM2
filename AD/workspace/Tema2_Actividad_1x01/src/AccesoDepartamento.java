import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.sqlite.SQLiteConfig;
import org.sqlite.SQLiteException;

import entrada.Teclado;

public class AccesoDepartamento {
	public static final String URL = "jdbc:sqlite:db\\\\personal.db";
	public static final String DRIVER = "org.sqlite.JDBC";
	
	/*
	 * Input: Nombre y ubicación del departamento
	 * Descripción: Crea la conexión con la base de datos e inserta un nuevo departamento con el nombre y ubicación
	 * que entra por parámetros.
	 */
	public static void InsertarDepartamento(String nombre, String ubicacion) throws ClassNotFoundException, SQLException {
		Connection conexion = null;
		try {
			Class.forName(DRIVER);
			conexion = DriverManager.getConnection(URL);
			String sentenciaInsertar = "INSERT INTO departamento (nombre, ubicacion) VALUES ('" + nombre + "', '" + ubicacion + "')";
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
	 * Descripción: Crea la conexión con la base de datos y lee todos sus registros pasandolos a una lista.
	 * Output: Lista de departamentos
	 */
	public static List<Departamento> consultarDepartamentos() throws ClassNotFoundException, SQLException {
		Connection conexion = null;
		List<Departamento> listaDepartamentos = new ArrayList<>();
		try {
			Class.forName(DRIVER);
			conexion = DriverManager.getConnection(URL);
			String sentenciaConsultar = "SELECT * FROM departamento";
			Statement sentencia = conexion.createStatement();
			ResultSet resultados = sentencia.executeQuery(sentenciaConsultar);	
			while (resultados.next()) {
				Departamento departamento = 
					new Departamento(resultados.getInt("codigo"),
					                 resultados.getString("nombre"),
					                 resultados.getString("ubicacion"));
				listaDepartamentos.add(departamento);
			}
		}
		finally {
			if (conexion != null) {
				conexion.close();
			}
		}
		return listaDepartamentos;
	}
	/*
	public static Departamento consultar1Departamento(int codigo) throws ClassNotFoundException, SQLException {
		List<Departamento> listaDepartamentos = consultarDepartamentos();
		for(Departamento departamento: listaDepartamentos) {
			if(departamento.getCodigo() == codigo)
				return departamento;
		}
		return null;
	}
	*/
	
	/*
	 * Input: código de departamento
	 * Descripción: Crea la conexión con la base de datos y busca el departamento de la base con ese código
	 * Output: Devuelve el departamento con ese código
	 */
	public static Departamento consultar1Departamento(int codigo) throws ClassNotFoundException, SQLException {
		Connection conexion = null;
		try {
			Class.forName(DRIVER);
			conexion = DriverManager.getConnection(URL);
			String sentenciaConsultar = "SELECT * FROM departamento WHERE codigo = " + codigo;
			Statement sentencia = conexion.createStatement();
			ResultSet resultados = sentencia.executeQuery(sentenciaConsultar);	
			while (resultados.next()) {
				if(resultados.getInt("codigo") == codigo) {
					return new Departamento(resultados.getInt("codigo"),resultados.getString("nombre"),resultados.getString("ubicacion"));
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
	 * Input: código, nombre y ubicación del departamento de la base de datos a actualizar
	 * Descripción: Crea la conexión con la base de datos y busca actualiza los valores del departamento con el código por parámetro con
	 * el nuevo nombre y ubicación introducidos por parámetro
	 * Output: Devuelve el numero de registros actualizados
	 */
	public static int actualizarDepartamento(int codigo, String nombre, String ubicacion) throws ClassNotFoundException, SQLException {
		Connection conexion = null;
		try {
			Class.forName(DRIVER);
			conexion = DriverManager.getConnection(URL);
			String sentenciaActualizar = "UPDATE departamento SET nombre = '" + nombre + "', ubicacion = '" + ubicacion + "' " +
			                             "WHERE codigo = " + codigo;
			Statement sentencia = conexion.createStatement();
			return sentencia.executeUpdate(sentenciaActualizar);
		}
		finally {
			if (conexion != null) {
				conexion.close();	
			} 
		}
	}
	
	/*
	 * Input: código de departamento
	 * Descripción: Crea la conexión con la base de datos y busca el departamento con el código introducido por parámetro para eliminar ese
	 * departamento
	 * Output: Devuelve el numero de registros borrados
	 */
	public static int eliminarDepartamento(int codigo) throws ClassNotFoundException, SQLException{
		Connection conexion = null;
		try {
			Class.forName(DRIVER);
			SQLiteConfig config = new SQLiteConfig();  
	        config.enforceForeignKeys(true);  // No deja eliminar un departamento si tiene empleados
			conexion = DriverManager.getConnection(URL, config.toProperties());
			String sentenciaEliminar = "DELETE FROM departamento WHERE codigo = " + codigo;
			Statement sentencia = conexion.createStatement();
			return sentencia.executeUpdate(sentenciaEliminar);
		}
		finally {
			if (conexion != null) {
				conexion.close();
			}
		}
	}
}
