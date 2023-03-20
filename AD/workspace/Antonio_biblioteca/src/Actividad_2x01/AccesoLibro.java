package Actividad_2x01;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.sqlite.SQLiteConfig;

public class AccesoLibro {

	static Connection conexion = null;
	private static String direccion="jdbc:sqlite:db\\biblioteca.db";

	public static void insertar(Libro lib) throws SQLException, ClassNotFoundException {
		Class.forName("org.sqlite.JDBC");
		SQLiteConfig config = new SQLiteConfig();  
        config.enforceForeignKeys(true);
		try {
			conexion = DriverManager.getConnection(direccion,config.toProperties());
			Statement sentencia = conexion.createStatement();

			String sentenciaInsertar = "INSERT INTO libro (isbn, titulo, escritor, ano_publicacion, puntuacion)" +
					"VALUES ('" + lib.getIsbn() + 
					"', '" + lib.getTitulo() + "'"
				   +", '" + lib.getEscritor() + "'"
				   +", " + lib.getAno_publicacion()
				   +", " + lib.getPuntuacion() + ")";
			
			sentencia.executeUpdate(sentenciaInsertar);
		}finally {
			conexion.close();
		}
	}

	public static int eliminar(int codigo) throws IOException, ClassNotFoundException, SQLException {
		try {
			Class.forName("org.sqlite.JDBC");
			SQLiteConfig config = new SQLiteConfig();  
	        config.enforceForeignKeys(true); // Con esto no te deja eliminar un dep aunque tenga dentro empleados
			conexion = DriverManager.getConnection(direccion,config.toProperties());
			
			String sentenciaEliminar = "DELETE FROM libro WHERE codigo = "+codigo;
			
			Statement sentencia = conexion.createStatement();
			return sentencia.executeUpdate(sentenciaEliminar);

		}finally {
			if (conexion != null) {
				conexion.close();
			}
		}
	}
	

	public static ArrayList<Libro> consultarTodos() 
			throws ClassNotFoundException, SQLException {
		ArrayList<Libro> listaLibros = new ArrayList<Libro>();
		try {
			Class.forName("org.sqlite.JDBC");
			conexion = DriverManager.getConnection(direccion);
			String sentenciaConsultar = "SELECT * FROM libro";
			Statement sentencia = conexion.createStatement();
			ResultSet resultados = sentencia.executeQuery(sentenciaConsultar);	
			while (resultados.next()) {
				Libro libro = 
						new Libro(resultados.getInt("codigo"),
								resultados.getString("isbn"),
								resultados.getString("titulo"),
								resultados.getString("escritor"),
								resultados.getInt("ano_publicacion"),
								resultados.getDouble("puntuacion"));
				listaLibros.add(libro);
			}
			resultados.close();
			sentencia.close();
		}finally {
			if (conexion != null) {
				conexion.close();
			}
		}
		return listaLibros;
	}

	public static ArrayList<Libro> consultarAutor(String autor) 
			throws ClassNotFoundException, SQLException {
		ArrayList<Libro> listaLibros = new ArrayList<Libro>();
		try {
			Class.forName("org.sqlite.JDBC");
			conexion = DriverManager.getConnection(direccion);
			String sentenciaConsultar = "SELECT * FROM libro where escritor='"+autor+"' order by puntuacion desc";
			Statement sentencia = conexion.createStatement();
			ResultSet resultados = sentencia.executeQuery(sentenciaConsultar);	
			while (resultados.next()) {
				Libro empleado = 
						new Libro(resultados.getInt("codigo"),
								resultados.getString("isbn"),
								resultados.getString("titulo"),
								resultados.getString("escritor"),
								resultados.getInt("ano_publicacion"),
								resultados.getDouble("puntuacion"));
				listaLibros.add(empleado);
			}
			resultados.close();
			sentencia.close();
		}finally {
			if (conexion != null) {
				conexion.close();
			}
		}
		return listaLibros;
	}

	public static ArrayList<Libro> consultarNoPrestados() 
			throws ClassNotFoundException, SQLException {
		ArrayList<Libro> listaLibros = new ArrayList<Libro>();
		try {
			Class.forName("org.sqlite.JDBC");
			conexion = DriverManager.getConnection(direccion);
			String sentenciaConsultar = "SELECT * FROM libro l left join prestamo p on p.codigo_libro=l.codigo where fecha_inicio is null";
			Statement sentencia = conexion.createStatement();
			ResultSet resultados = sentencia.executeQuery(sentenciaConsultar);	
			while (resultados.next()) {
				Libro empleado = 
						new Libro(resultados.getInt("codigo"),
								resultados.getString("isbn"),
								resultados.getString("titulo"),
								resultados.getString("escritor"),
								resultados.getInt("ano_publicacion"),
								resultados.getDouble("puntuacion"));
				listaLibros.add(empleado);
			}
			resultados.close();
			sentencia.close();
		}finally {
			if (conexion != null) {
				conexion.close();
			}
		}
		return listaLibros;
	}
	
	public static ArrayList<Libro> consultarFecha(String fecha) 
			throws ClassNotFoundException, SQLException {
		ArrayList<Libro> listaLibros = new ArrayList<Libro>();
		try {
			Class.forName("org.sqlite.JDBC");
			conexion = DriverManager.getConnection(direccion);
			String sentenciaConsultar = "SELECT * FROM libro l inner join prestamo p on p.codigo_libro=l.codigo where fecha_devolucion = "+fecha;
			Statement sentencia = conexion.createStatement();
			ResultSet resultados = sentencia.executeQuery(sentenciaConsultar);	
			while (resultados.next()) {
				Libro empleado = 
						new Libro(resultados.getInt("codigo"),
								resultados.getString("isbn"),
								resultados.getString("titulo"),
								resultados.getString("escritor"),
								resultados.getInt("ano_publicacion"),
								resultados.getDouble("puntuacion"));
				listaLibros.add(empleado);
			}
			resultados.close();
			sentencia.close();
		}finally {
			if (conexion != null) {
				conexion.close();
			}
		}
		return listaLibros;
	}


}
