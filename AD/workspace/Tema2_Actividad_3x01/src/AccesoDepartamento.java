import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.sqlite.SQLiteConfig;

public class AccesoDepartamento {
	private static final String NOMBRE_FICHERO_DEPARTAMENTOS = "data/departamentos.txt";
	private static final String NOMBRE_BD = "db/personal.db";
	private static final String URL = "jdbc:sqlite:" + NOMBRE_BD;
	private static final String NOMBRE_CONTROLADOR_SQLITE = "org.sqlite.JDBC";
	
	/*
	 * Descripción: Lee un archivo txt que contiene información sobre departamentos. Con esa información crea objetos de Departamento
	 * 	 y los inserta en una lista de Departamento.
	 * Output: Lista de objetos Departamento
	 */
	public static List<Departamento> listar() throws IOException {
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
	
	/*
	 * Descripción: Recoge una lista de departamentos desde el método listar(). Crea conexión con la base de datos personal.db
	 * 	y con un forEach recorre la lista de departamentos y los inserta en la base de datos con una sentencia sql de inserción.
	 * Output: int que responde al número de departamentos insertados en la base de datos
	 */
	public static int insertar() throws ClassNotFoundException, SQLException, IOException {
		List<Departamento> listaDepartamentos = listar();
		int contador = 0;
		Connection conexion = null;
		try {
			Class.forName(NOMBRE_CONTROLADOR_SQLITE);
			SQLiteConfig config = new SQLiteConfig();
			config.enforceForeignKeys(true); // Se asegura de respetar las foreign keys
			conexion = DriverManager.getConnection(URL,config.toProperties());
			conexion.setAutoCommit(false); // No hace commit hasta la linea de comando conexion.commit() para asegurarse de que o se inserta todo o nada
			String sql = "INSERT INTO departamento (nombre, ubicacion) VALUES (?, ?)"; // Inserta departamentos con los valores ?1 y ?2
			PreparedStatement sentencia = conexion.prepareStatement(sql);
			for(Departamento departamento: listaDepartamentos) {
				sentencia.setString(1,departamento.getNombre()); // ?1 es el nombre del departamento en cada vuelta del forEach
				sentencia.setString(2,departamento.getUbicacion()); // ?2 es la ubicación de cada departamento en cada vuelta del forEach
				contador += sentencia.executeUpdate(); // Al ejecutar se suma 1 al contador, que lleva la cuenta de departamentos insertados
			}
			conexion.commit(); // Ejecuta los cambios
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
	public static int[] eliminar(int codigo) throws ClassNotFoundException, SQLException {
		// contador[0] = Empleados eliminados
		// contador[1] = Departamentos eliminados
		int[] contador = new int[2];
		Connection conexion = null;
		try {
			Class.forName(NOMBRE_CONTROLADOR_SQLITE);
			SQLiteConfig config = new SQLiteConfig();
			config.enforceForeignKeys(true); // Se asegura de respetar las foreign keys
			conexion = DriverManager.getConnection(URL,config.toProperties());
			conexion.setAutoCommit(false); // No hace commit hasta la linea de comando conexion.commit() para asegurarse de que o se inserta todo o nada
			
			String sqlEmpleado = "DELETE FROM empleado WHERE codigo_departamento = ?"; // Sentencia para borrar todos los empleados cuyo codigo de departamento es igual a ?
			PreparedStatement sentenciaEmpleado = conexion.prepareStatement(sqlEmpleado);
			
			String sqlDepartamento = "DELETE FROM departamento WHERE codigo = ?"; // Sentencia para borrar todos los departamentos cuyo codigo sea igual a ?
			PreparedStatement sentenciaDepartamento = conexion.prepareStatement(sqlDepartamento);
			
			sentenciaEmpleado.setInt(1, codigo); // ? en sentenciaEmpleado es el código introducido por parámetro
			sentenciaDepartamento.setInt(1, codigo); // ? en sentenciaDepartamento es el código introducido por parámetro
			
			// Cada vez que se ejecuta una de las sentencias se añaden al vector contador
			contador[0] += sentenciaEmpleado.executeUpdate();
			contador[1] += sentenciaDepartamento.executeUpdate();
			
			conexion.commit(); // Ejecuta los cambios
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
}
