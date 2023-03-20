import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import modelo.Departamento;
import modelo.Empleado;

public class AccesoFichajes {
	private static final String NOMBRE_BD = "data/fichajes.odb";
	/*
	 * Input: int codigo, siendo este la clave primaria del objeto Departamento
	 * Descripción: Colsulta si en la base de datos existe un departamento con el código introducido por parámetro
	 * Output: Devuelve null si el departamento no existe o el objeto Departamento con el código introducido por parámetro si este existe
	 */
	public static Departamento consultarDepartamento(int codigo) {
		EntityManagerFactory EMF = Persistence.createEntityManagerFactory(NOMBRE_BD);
		EntityManager conexion = null;
		try {
			conexion = EMF.createEntityManager();
			Departamento departamento = conexion.find(Departamento.class, codigo); // Devuelve null si no existe
			return departamento;
		}
		finally {
			if (conexion != null) {
				conexion.close();
			}
			if(EMF != null) {
				EMF.close();
			}
		}
	}
	/*
	 * Input: string nombre, siendo este la clave primaria del objeto Empleado
	 * Descripción: Colsulta si en la base de datos existe un empleado con el nombre introducido por parámetro
	 * Output: Devuelve null si el empleado no existe o el objeto Empleado con el código introducido por parámetro si este existe
	 */
	public static Empleado consultarEmpleado(String nombre) {
		EntityManagerFactory EMF = Persistence.createEntityManagerFactory(NOMBRE_BD);
		EntityManager conexion = null;
		try {
			conexion = EMF.createEntityManager();
			Empleado empleado = conexion.find(Empleado.class, nombre); // Devuelve null si no existe
			return empleado;
		}
		finally {
			if (conexion != null) {
				conexion.close();
			}
			if(EMF != null) {
				EMF.close();
			}
		}
	}
	/*
	 * Input: Objeto Departamento que se quiere insertar en la base de datos
	 * Descripción: Inserta el departamento introducido por parámetro en la base de datos señalada
	 */
	public static void insertarDepartamento(Departamento departamento) {
		EntityManagerFactory EMF = Persistence.createEntityManagerFactory(NOMBRE_BD);
		EntityManager conexion = null;
		EntityTransaction transaccion = null;
		try {
			conexion = EMF.createEntityManager();
			transaccion = conexion.getTransaction();
			transaccion.begin();
			conexion.persist(departamento);
			transaccion.commit();
		}
		catch(Exception e){
			transaccion.rollback();
			throw e;
		}
		finally {
			if (conexion != null) {
				conexion.close();
			}
			if(EMF != null) {
				EMF.close();
			}
		}
	}
	/*
	 * Input: int codigo, siendo este la clave primaria del objeto Departamento
	 * Descripción: Colsulta si en la base de datos existe un empleado cuyo departamento tenga el código introducido por parámetro
	 * Output: Devuelve una lista de empleados cuyos departamentos tienen el código introducido por parámetro
	 */
	public static List<Empleado> consultarEmpleadosPorDepartamento(int codigo) {
		EntityManagerFactory EMF = Persistence.createEntityManagerFactory(NOMBRE_BD);
		EntityManager conexion = null;
		Departamento departamento = null;
		try {
			conexion = EMF.createEntityManager();
			TypedQuery<Empleado> consulta = conexion.createQuery("SELECT e FROM Empleado e WHERE e.departamento.codigo = " + codigo, 
																	Empleado.class);                                    
			List<Empleado> listaEmpleados = consulta.getResultList();
			return listaEmpleados;
		}
		finally {
			if (conexion != null) {
				conexion.close();
			}
			if(EMF != null) {
				EMF.close();
			}
		}
	}
	/*
	 * Input: int codigo, siendo este la clave primaria del objeto Departamento
	 * Descripción: Elimina el departamento de la base de datos cuyo código es el introducido por parámetro
	 */
	public static void eliminarDepartamento(int codigo) {
		EntityManagerFactory EMF = Persistence.createEntityManagerFactory(NOMBRE_BD);
		EntityManager conexion = null;
		EntityTransaction transaccion = null;
		try {
			conexion = EMF.createEntityManager();
			Departamento departamento = conexion.find(Departamento.class, codigo);
			transaccion = conexion.getTransaction();
			transaccion.begin();
			conexion.remove(departamento);
			transaccion.commit();
		}
		catch(Exception e){
			transaccion.rollback();
			throw e;
		}
		finally {
			if (conexion != null) {
				conexion.close();
			}
			if(EMF != null) {
				EMF.close();
			}
		}
	}
	/*
	 * Input: String nombre, siendo este la clave primaria del empleado, y Departamento departamento siendo uno de sus atributos
	 * Descripción: Trata de actualizar un empleado dada su clave primaria, cambiando su atributo departamento
	 * Output: Devuelve un boolean que será true si la actualización ha tenido exito o false si no se logra actualizar
	 */
	public static boolean actualizarEmpleado(String nombre, Departamento departamento) {
		EntityManagerFactory EMF = Persistence.createEntityManagerFactory(NOMBRE_BD);
		EntityManager conexion = null;
		EntityTransaction transaccion = null;
		try {
			boolean actualizado = false;
			conexion = EMF.createEntityManager();
			Empleado empleado = conexion.find(Empleado.class, nombre); // Devuelve null si no existe
			if(empleado != null) {
				transaccion = conexion.getTransaction();
				transaccion.begin();
				empleado.setDepartamento(departamento);
				transaccion.commit();
				actualizado = true;
			}
			return actualizado;
			
		}
		catch(Exception e){
			transaccion.rollback();
			throw e;
		}
		finally {
			if (conexion != null) {
				conexion.close();
			}
			if(EMF != null) {
				EMF.close();
			}
		}
	}
}
