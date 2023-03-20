import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import modelo.Equipo;
import modelo.Fecha;
import modelo.Jugador;

public class GestorJugadores {
	private static final String NOMBRE_BD = "data/campeonato.odb";
	
	public static void insertarJugador(Jugador jugador) {
		EntityManagerFactory EMF = Persistence.createEntityManagerFactory(NOMBRE_BD);
		EntityManager conexion = null;
		EntityTransaction transaccion = null;
		try {
			conexion = EMF.createEntityManager();
			transaccion = conexion.getTransaction();
			transaccion.begin();
			conexion.persist(jugador);
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
	public static List<Jugador> consultarJugadores() {
		EntityManagerFactory EMF = Persistence.createEntityManagerFactory(NOMBRE_BD);
		EntityManager conexion = null;
		try {
			conexion = EMF.createEntityManager();
			TypedQuery<Jugador> consulta = conexion.createQuery("SELECT j FROM Jugador j ORDER BY j.codigo ASC", 
			                                                    Jugador.class);
			List<Jugador> jugadores = consulta.getResultList();
			return jugadores;
			
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
	public static Jugador existeJugador(int codigo) {
		EntityManagerFactory EMF = Persistence.createEntityManagerFactory(NOMBRE_BD);
		EntityManager conexion = null;
		
		try {
			conexion = EMF.createEntityManager();
			Jugador jugador = conexion.find(Jugador.class, codigo); // Devuelve null si no existe
			return jugador;
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
	public static boolean actualizarJugador(int codigo, String nombre, Fecha fecha) {
		EntityManagerFactory EMF = Persistence.createEntityManagerFactory(NOMBRE_BD);
		EntityManager conexion = null;
		EntityTransaction transaccion = null;
		try {
			boolean actualizado = false;
			conexion = EMF.createEntityManager();
			Jugador jugador = conexion.find(Jugador.class, codigo); // Devuelve null si no existe
			if(jugador != null) {
				transaccion = conexion.getTransaction();
				transaccion.begin();
				jugador.setNombre(nombre);
				jugador.setFechaNacimiento(fecha);
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
	public static void eliminarJugador(int codigo) {
		EntityManagerFactory EMF = Persistence.createEntityManagerFactory(NOMBRE_BD);
		EntityManager conexion = null;
		EntityTransaction transaccion = null;
		try {
			conexion = EMF.createEntityManager();
			Jugador jugador = conexion.find(Jugador.class, codigo);
			transaccion = conexion.getTransaction();
			transaccion.begin();
			conexion.remove(jugador);
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
	
	public static Equipo buscarEquipoConJugador(int codigo) {
		EntityManagerFactory EMF = Persistence.createEntityManagerFactory(NOMBRE_BD);
		EntityManager conexion = null;
		Equipo equipo = null;
		try {
			conexion = EMF.createEntityManager();
			TypedQuery<Equipo> consulta = conexion.createQuery("SELECT e FROM Equipo e, Jugador j WHERE e.jugadores.contains(j) and j.codigo = " + codigo, 
			                                                    Equipo.class);
			List<Equipo> ListaEquipos = consulta.getResultList();
			for(Equipo equipos: ListaEquipos) {
				equipo = equipos;
			}
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
	
}
