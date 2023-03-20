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

public class AccesoEmpleado {
	private static final String NOMBRE_FICHERO_EMPLEADOS = "data/empleados.txt";
	private static final String NOMBRE_BD = "db/personal.db";
	private static final String URL = "jdbc:sqlite:" + NOMBRE_BD;
	private static final String NOMBRE_CONTROLADOR_SQLITE = "org.sqlite.JDBC";
	
	/*
	 * Descripción: Lee un archivo txt que contiene información sobre empleados. Con esa información crea objetos de Empleado
	 * 	 y los inserta en una lista de Empleado.
	 * Output: Lista de objetos Empleado
	 */
	public static List<Empleado> listar() throws IOException {
		BufferedReader flujoEntrada = null;
		List<Empleado> listaEmpleados = new ArrayList<>();
		try {
			flujoEntrada = new BufferedReader(new FileReader(NOMBRE_FICHERO_EMPLEADOS));
			String linea = flujoEntrada.readLine(); 
	  		while (linea != null) {  
	  			listaEmpleados.add(new Empleado(linea));
	  			linea = flujoEntrada.readLine();
	  		}
		}
		finally {
			if(flujoEntrada != null)
				flujoEntrada.close();
		}
  		return listaEmpleados;
	}
	/*
	 * Descripción: Recoge una lista de empleados desde el método listar(). Crea conexión con la base de datos personal.db
	 * 	y con un forEach recorre la lista de empleados y los inserta en la base de datos con una sentencia sql de inserción.
	 * Output: int que responde al número de empleados insertados en la base de datos
	 */
	public static int insertar() throws ClassNotFoundException, SQLException, IOException {
		List<Empleado> listaEmpleados = listar();
		int contador = 0;
		String fecha = "02132022";
		Connection conexion = null;
		try {
			Class.forName(NOMBRE_CONTROLADOR_SQLITE);
			SQLiteConfig config = new SQLiteConfig();
			config.enforceForeignKeys(true); // Se asegura de respetar las foreign keys
			conexion = DriverManager.getConnection(URL,config.toProperties());
			conexion.setAutoCommit(false); // No hace commit hasta la linea de comando conexion.commit() para asegurarse de que o se inserta todo o nada
			String sql = "INSERT INTO empleado (nombre, fecha_alta, salario, codigo_departamento) VALUES (?, ?, ?, ?)"; // Inserta empleados con los valores ?1, ?2, ?3, ?4
			PreparedStatement sentencia = conexion.prepareStatement(sql);
			sentencia.setString(2,fecha); // ?2 es String fecha
			for(Empleado empleado: listaEmpleados) {
				sentencia.setString(1,empleado.getNombre()); // ?1 es el nombre del empleado en cada vuelta del forEach
				sentencia.setDouble(3,empleado.getSalario()); // ?3 es el salario de cada empleado en cada vuelta del forEach
				sentencia.setInt(4, empleado.getCodigoDepartamento()); // ?4 es el codigo de departamento de cada empleado en cada vuelta del forEach
				contador += sentencia.executeUpdate(); // Cada vez que se ejecuta un insert se añade 1 al contador
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
	/*
	 * Descripción: Crea una conexión con la base de datos personal.db. Actualiza los salarios de los empleados dependiendo de su código de departamento.
	 * 	Lo hace a través de una sentencia sql.
	 * Output: int que responde al número de empleados cuyo salario se ha actualizado
	 */
	public static int actualizar() throws ClassNotFoundException, SQLException {
		int contador = 0;
		Connection conexion = null;
		double[] multiplicadorSalario = {1.01,1.02,1.03};
		int[] departamento = {2,4,6};
		try {
			Class.forName(NOMBRE_CONTROLADOR_SQLITE);
			SQLiteConfig config = new SQLiteConfig();
			config.enforceForeignKeys(true); // Se asegura de respetar las foreign keys
			conexion = DriverManager.getConnection(URL,config.toProperties());
			conexion.setAutoCommit(false); // No hace commit hasta la linea de comando conexion.commit() para asegurarse de que o se inserta todo o nada
			String sql = "UPDATE empleado SET salario = salario*? WHERE codigo_departamento = ?"; // ?1 y ?2 obtienen valor dentro del bucle for
			PreparedStatement sentencia = conexion.prepareStatement(sql);
			
			/* Este for da como condición al update el codigo del departamento del array "departamento"
			y multiplica por el elemento con mismo index del array "multiplicadorSalario"*/
			for(int i = 0; i < 3; i++) {
				sentencia.setDouble(1,multiplicadorSalario[i]); // ?1 es el multiplicadorSalario[i]
				sentencia.setInt(2, departamento[i]); // ?2 es departamento[i]
				contador += sentencia.executeUpdate(); // Cada vez que se ejecuta un update se añade 1 en el contador
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
}
