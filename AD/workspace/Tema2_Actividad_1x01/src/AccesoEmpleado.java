import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.sqlite.SQLiteConfig;

public class AccesoEmpleado {
	public static final String URL = "jdbc:sqlite:db\\\\personal.db";
	public static final String DRIVER = "org.sqlite.JDBC";
	/*
	 * Input: salario, codigo del departamento, nombre y fecha de alta del empleado a insertar
	 * Descripción: Crea la conexión con la base de datos e inserta un nuevo empleado con los datos metidos por parámetro
	 */
	public static void InsertarEmpleado(double salario, int codigoDepartamento, String nombre, String fechaAlta) throws ClassNotFoundException, SQLException {
		Connection conexion = null;
		try {
			Class.forName(DRIVER);
			conexion = DriverManager.getConnection(URL);
			String sentenciaInsertar = "INSERT INTO empleado (salario, codigo_departamento, nombre, fecha_alta) VALUES (" + salario + ", " + codigoDepartamento +
					", '" + nombre + "', '" + fechaAlta + "')"; 
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
	 * Output: Lista de empleados
	 */
	public static List<Empleado> consultarEmpleados() throws ClassNotFoundException, SQLException {
		Connection conexion = null;
		List<Empleado> listaEmpleados = new ArrayList<>();
		try {
			Class.forName(DRIVER);
			conexion = DriverManager.getConnection(URL);
			String sentenciaConsultar = "SELECT * FROM empleado";
			Statement sentencia = conexion.createStatement();
			ResultSet resultados = sentencia.executeQuery(sentenciaConsultar);	
			while (resultados.next()) {
				Empleado empleado = 
					new Empleado(resultados.getInt("codigo"),
					                 resultados.getString("nombre"),
					                 resultados.getString("fecha_alta"),
					                 resultados.getDouble("salario"),
					                 resultados.getInt("codigo_departamento"));
				listaEmpleados.add(empleado);
			}
		}
		finally {
			if (conexion != null) {
				conexion.close();
			}
		}
		return listaEmpleados;
	}
	/*
	 * Input: código de empleado
	 * Descripción: Crea la conexión con la base de datos y busca el empleado de la base con ese código
	 * Output: Devuelve el empleado con ese código
	 */
	public static Empleado consultar1Empleado(int codigo) throws ClassNotFoundException, SQLException {
		Connection conexion = null;
		try {
			Class.forName(DRIVER);
			conexion = DriverManager.getConnection(URL);
			String sentenciaConsultar = "SELECT * FROM empleado WHERE codigo = " + codigo;
			Statement sentencia = conexion.createStatement();
			ResultSet resultados = sentencia.executeQuery(sentenciaConsultar);	
			while (resultados.next()) {
				if(resultados.getInt("codigo") == codigo) {
					return new Empleado(resultados.getInt("codigo"),
			                 resultados.getString("nombre"),
			                 resultados.getString("fecha_alta"),
			                 resultados.getDouble("salario"),
			                 resultados.getInt("codigo_departamento"));
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
	 * Input: salario, codigoDepartamento, nombre, fechaAlta del empleado de la base de datos a actualizar
	 * Descripción: Crea la conexión con la base de datos y busca actualiza los valores del empleado con el código por parámetro con
	 * los otros valores introducidos por parametro
	 * Output: Devuelve el numero de registros actualizados
	 */
	public static int actualizarEmpleado(int codigo, double salario, int codigoDepartamento, String nombre, String fechaAlta) throws ClassNotFoundException, SQLException {
		Connection conexion = null;
		try {
			Class.forName(DRIVER);
			conexion = DriverManager.getConnection(URL);
			String sentenciaActualizar = "UPDATE empleado SET salario = " + salario + ", codigo_departamento = " + codigoDepartamento + ", nombre = '" +
			                             nombre + "', fecha_alta = '" + fechaAlta + "' WHERE codigo = " + codigo;
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
	 * Input: código de empleado
	 * Descripción: Crea la conexión con la base de datos y busca el empleado con el código introducido por parámetro para eliminar ese empleado
	 * Output: Devuelve el numero de registros borrados
	 */
	public static int eliminarEmpleado(int codigo) throws ClassNotFoundException, SQLException{
		Connection conexion = null;
		try {
			Class.forName(DRIVER);
			SQLiteConfig config = new SQLiteConfig();  
	        config.enforceForeignKeys(true);  // No deja eliminar un departamento si tiene empleados
			conexion = DriverManager.getConnection(URL, config.toProperties());
			String sentenciaEliminar = "DELETE FROM empleado WHERE codigo = " + codigo;
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
