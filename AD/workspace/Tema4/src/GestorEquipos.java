import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import modelo.Equipo;
import modelo.Fecha;
import modelo.Jugador;
import modelo.Partido;

public class GestorEquipos {
	private static final String NOMBRE_BD = "data/campeonato.odb";
	public static Equipo consultar(String nombre) {
		EntityManagerFactory EMF = Persistence.createEntityManagerFactory(NOMBRE_BD);
		EntityManager conexion = null;
		try {
			conexion = EMF.createEntityManager();
			Equipo equipo = conexion.find(Equipo.class, nombre); // Devuelve null si no existe
			return equipo;
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
	public static void insertarEquipo(Equipo equipo) {
		EntityManagerFactory EMF = Persistence.createEntityManagerFactory(NOMBRE_BD);
		EntityManager conexion = null;
		EntityTransaction transaccion = null;
		try {
			conexion = EMF.createEntityManager();
			transaccion = conexion.getTransaction();
			transaccion.begin();
			conexion.persist(equipo);
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
	public static List<Equipo> consultarEquipos() {
		EntityManagerFactory EMF = Persistence.createEntityManagerFactory(NOMBRE_BD);
		EntityManager conexion = null;
		try {
			conexion = EMF.createEntityManager();
			TypedQuery<Equipo> consulta = conexion.createQuery("SELECT e FROM Equipo e ORDER BY e.nombre ASC", 
			                                                    Equipo.class);
			List<Equipo> equipos = consulta.getResultList();
			return equipos;
			
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
	public static boolean actualizarEquipo(String nombre, String ciudad) {
		
		EntityManagerFactory EMF = Persistence.createEntityManagerFactory(NOMBRE_BD);
		EntityManager conexion = null;
		EntityTransaction transaccion = null;
		try {
			boolean actualizado = false;
			conexion = EMF.createEntityManager();
			Equipo equipo = conexion.find(Equipo.class, nombre); // Devuelve null si no existe
			if(equipo != null) {
				transaccion = conexion.getTransaction();
				transaccion.begin();
				equipo.setCiudad(ciudad);
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
	public static List<Jugador> buscarJugadoresPorEquipo(String nombre) {
		EntityManagerFactory EMF = Persistence.createEntityManagerFactory(NOMBRE_BD);
		EntityManager conexion = null;
		Equipo equipo = null;
		try {
			conexion = EMF.createEntityManager();
			TypedQuery<Jugador> consulta = conexion.createQuery("SELECT j FROM Equipo e, Jugador j WHERE e.jugadores.contains(j) AND e.nombre = '" + nombre + "' ORDER BY j.codigo ASC" , 
																	Jugador.class);                                    
			List<Jugador> listaJugadores = consulta.getResultList();
			return listaJugadores;
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
	public static List<Partido> buscarPartidosPorEquipo(String nombre) {
		EntityManagerFactory EMF = Persistence.createEntityManagerFactory(NOMBRE_BD);
		EntityManager conexion = null;
		Equipo equipo = null;
		try {
			conexion = EMF.createEntityManager();
			TypedQuery<Partido> consulta = conexion.createQuery("SELECT p FROM Partido p WHERE p.equipoLocal.nombre = '" + nombre + "' OR p.equipoVisitante.nombre = '" + nombre + "' ORDER BY p.fecha ASC", 
																	Partido.class);                                    
			List<Partido> listaPartidos = consulta.getResultList();
			return listaPartidos;
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
	
	public static void eliminarEquipo(String nombre) {
		EntityManagerFactory EMF = Persistence.createEntityManagerFactory(NOMBRE_BD);
		EntityManager conexion = null;
		EntityTransaction transaccion = null;
		try {
			conexion = EMF.createEntityManager();
			Equipo equipo = conexion.find(Equipo.class, nombre);
			transaccion = conexion.getTransaction();
			transaccion.begin();
			conexion.remove(equipo);
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
}
