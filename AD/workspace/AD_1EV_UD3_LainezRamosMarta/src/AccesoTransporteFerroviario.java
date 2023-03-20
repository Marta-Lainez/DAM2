import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import modulo.Billete;
import modulo.Estacion;
import modulo.HibernateUtil;
import modulo.Viajero;
import modulo.Clase;
public class AccesoTransporteFerroviario {
	
	// Consulta las estaciones de la base de datos
	public static ArrayList<Estacion> imprimirEstaciones() {
		ArrayList<Estacion> estaciones = new ArrayList<Estacion>();
		Session sesion = null;
		try {
			SessionFactory fabricaSesiones = HibernateUtil.getSessionFactory();
			sesion = fabricaSesiones.openSession();
			String sentenciaHQL = "select e from Estacion e order by agnoInauguracion desc";
			TypedQuery<Estacion> consulta = sesion.createQuery(sentenciaHQL);
			estaciones = (ArrayList<Estacion>) consulta.getResultList();
			return estaciones;
		}
		finally {
			if (sesion != null) {
				sesion.close();
			}	
		}
	}
	
	// Consulta las clases de la base de datos
	public static ArrayList<Clase> imprimeClases() {
		ArrayList<Clase> clases=new ArrayList<Clase>();
		Session sesion = null;
		try {
			SessionFactory fabricaSesiones = HibernateUtil.getSessionFactory();
			sesion = fabricaSesiones.openSession();
			String sentenciaHQL = "select c from Clase c";
			TypedQuery<Clase> consulta = sesion.createQuery(sentenciaHQL, Clase.class);
			clases = (ArrayList<Clase>) consulta.getResultList();
			return clases;
		}
		finally {
			if (sesion != null) {
				sesion.close();
			}	
		}
	}
	// Consulta una clase por codigo de la base de datos y la devuelve como objeto
	public static Clase consultarClase(int codigo) {
		Clase clase = null;
		Session sesion = null;
		try {
			SessionFactory fabricaSesiones = HibernateUtil.getSessionFactory();
			sesion = fabricaSesiones.openSession();
			clase = sesion.get(Clase.class, (short) codigo);
		}
		finally {
			if (sesion != null) {
				sesion.close();
			}
		}
		return clase;
	}
	// Insertar un viajero en la base de datos
	public static void insertarViajero(Viajero viajero) {
		Session sesion = null;
		Transaction transaccion = null;
		try {

			SessionFactory fabricaSesiones = HibernateUtil.getSessionFactory();
			sesion = fabricaSesiones.openSession();
			transaccion = sesion.beginTransaction();
			sesion.save(viajero);
			transaccion.commit();
		}
		catch (Exception e) {
			if (transaccion != null) {
				transaccion.rollback();
			}
		}
		finally {
			if (sesion != null) {
				sesion.close();
			}
		}
	}
	
	// Borrar clase que no tiene ningún viajero referenciado
	public static boolean eliminarClaseSinViajeros(int codigo) {
		Session sesion = null;
		Transaction transaccion = null;
		try {
			SessionFactory fabricaSesiones = HibernateUtil.getSessionFactory();
			sesion = fabricaSesiones.openSession();
			transaccion = sesion.beginTransaction();	
			Clase clase = sesion.get(Clase.class, (short) codigo);
			sesion.delete(clase);
			transaccion.commit();
		}
		catch (Exception e) {
			if (transaccion != null) {
				transaccion.rollback();
			}
			return false;
		}
		finally {
			if (sesion != null) {
				sesion.close();
			}
		}
		return true;
		
	}
	
	// Listar viajeros por clase
	public static ArrayList<Viajero> listarViajerosPorClase(int codigo) {
		ArrayList<Viajero> viajeros=new ArrayList<Viajero>();
		Session sesion = null;
		try {
			SessionFactory fabricaSesiones = HibernateUtil.getSessionFactory();
			sesion = fabricaSesiones.openSession();
			String sentenciaHQL = "select v from Viajero v INNER JOIN v.clase c where c.codigo = " + codigo;
			TypedQuery<Viajero> consulta = sesion.createQuery(sentenciaHQL, Viajero.class);
			viajeros = (ArrayList<Viajero>) consulta.getResultList();
			return viajeros;
			
			
		}
		finally {
			if (sesion != null) {
				sesion.close();
			}
		}
	}
}
