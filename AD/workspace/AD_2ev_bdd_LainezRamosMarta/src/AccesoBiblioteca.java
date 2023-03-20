import java.util.ArrayList;

import org.xmldb.api.DatabaseManager;
import org.xmldb.api.base.Collection;
import org.xmldb.api.base.Database;
import org.xmldb.api.base.Resource;
import org.xmldb.api.base.ResourceIterator;
import org.xmldb.api.base.ResourceSet;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.XPathQueryService;

public class AccesoBiblioteca {
	public static Collection conectar(String nombreColeccion) throws ClassNotFoundException, InstantiationException, 
	IllegalAccessException, XMLDBException {
		Class cl = Class.forName("org.exist.xmldb.DatabaseImpl");
		Database database = (Database) cl.newInstance();
		DatabaseManager.registerDatabase(database);
		String url = "xmldb:exist://localhost:8080/exist/xmlrpc/db/" + nombreColeccion;
		Collection coleccion = DatabaseManager.getCollection(url, "admin", "admin");
		return coleccion;
	}


	public static void desconectar(Collection coleccion) 
			throws XMLDBException {
		if (coleccion != null) {
			coleccion.close();
		}
	}
	// Consultar todos los libros
	public static ArrayList<Libro> consultar() throws ClassNotFoundException, InstantiationException, IllegalAccessException, XMLDBException {
		Collection coleccion = null;
		try {
			coleccion = conectar("biblioteca");

			ArrayList<Libro> libros = new ArrayList<Libro>();
			String sentenciaBuscarLibro = 
					"for $libro in /libros/libro " 
							+ "order by $libro/@agno"
							+ " return <item>{$libro/codigo/text()"
							+ "},{"+ "$libro/titulo/text() "
							+ "},{"+ "$libro/escritor/text() "
							+ "},{"+ "$libro/agno/text() "
							+ "},{"+ "$libro/idioma_origen/text() "
							+ "},{"+ "$libro/numero_paginas/text()}</item>";
			XPathQueryService servicio = 
					(XPathQueryService) coleccion.getService("XPathQueryService", "1.0");
			ResourceSet resultados = servicio.query(sentenciaBuscarLibro);

			ResourceIterator iterador = resultados.getIterator();
			while (iterador.hasMoreResources()) {
				Resource recurso = iterador.nextResource();
				String libroString = (String) recurso.getContent();
				libroString=libroString.replace("<item>", "");
				libroString=libroString.replace("</item>", "");
				String lista[] = libroString.split(",");
				Libro libro =new Libro(Integer.parseInt(lista[0]),lista[1],(lista[2]),Integer.parseInt(lista[3]),(lista[4]),Integer.parseInt(lista[5]));
				libros.add(libro);
			}
			return libros;
		}finally {
			desconectar(coleccion);
		}
	}
	
	// Consultar un socio por dni
	public static Socio consultarDni(String dni) throws ClassNotFoundException, InstantiationException, IllegalAccessException, XMLDBException {
		Collection coleccion = null;
		try {
			coleccion = conectar("biblioteca");
			Socio socio = null;
			String sentenciaBuscarSocioPorDni = 
					"for $socio in /socios/socio " +
							" where $socio/dni = '" + dni + "'"+
							" return $socio";
			XPathQueryService servicio = 
					(XPathQueryService) coleccion.getService("XPathQueryService", "1.0");
			ResourceSet resultados = servicio.query(sentenciaBuscarSocioPorDni);

			ResourceIterator iterador = resultados.getIterator();
			while (iterador.hasMoreResources()) {
				Resource recurso = iterador.nextResource();
				String texto = (String) recurso.getContent();
				socio =new Socio(texto);

			}
			return socio;
		}finally {
			desconectar(coleccion);
		}
	}
	// Insertar un socio
	public static void insertar(Socio socio) throws ClassNotFoundException, InstantiationException, IllegalAccessException, XMLDBException {
		Collection coleccion = null;
		try {
			coleccion = conectar("biblioteca");

			XPathQueryService servicio = 
					(XPathQueryService) coleccion.getService("XPathQueryService", "1.0");
			
			String sentenciaInsertarSocio = 
						"update insert " +
								"<socio>" +
								"<dni>" + socio.getDni() + "</dni>" +
								"<nombre>" + socio.getNombre() + "</nombre>" +
								"<localidad>" + socio.getLocalidad() + "</localidad>" +
								"<telefono>" + socio.getTelefono() + "</telefono>" +
								"<correo>" + socio.getCorreo() + "</correo>" +
								"</socio> " +
								"into /socios";

			ResourceSet resultados = servicio.query(sentenciaInsertarSocio);
				
			
		}finally {
			desconectar(coleccion);
		}
	}
	// consultar prestamos de socio
	public static ArrayList<Prestamo> consultarPrestamos(String dni) throws ClassNotFoundException, InstantiationException, IllegalAccessException, XMLDBException {
		Collection coleccion = null;
		try {
			coleccion = conectar("biblioteca");

			ArrayList<Prestamo> prestamos = new ArrayList<>();
			String sentenciaBuscarPrestamos = 
						"for $prestamo in /prestamos/prestamo"
								+ " where $prestamo/dni_socio = '" + dni + "'"
								+ " return <item>{$prestamo/dni_socio/text()"
								+ "},{"+ "$prestamo/codigo_libro/text() "
								+ "},{"+ "$prestamo/fecha_inicio/text() "
								+ "},{"+ "$prestamo/fecha_fin/text() "
								+ "},{"+ "$prestamo/fecha_devolucion/text()}</item>";
			XPathQueryService servicio = 
					(XPathQueryService) coleccion.getService("XPathQueryService", "1.0");
			ResourceSet resultados = servicio.query(sentenciaBuscarPrestamos);

			ResourceIterator iterador = resultados.getIterator();
			while (iterador.hasMoreResources()) {
				Resource recurso = iterador.nextResource();
				String prestamoString = (String) recurso.getContent();
				prestamoString=prestamoString.replace("<item>", "");
				prestamoString=prestamoString.replace("</item>", "");
				String lista[] = prestamoString.split(",");
				Prestamo prestamo =new Prestamo((lista[0]),Integer.parseInt(lista[1]),(lista[2]),lista[3],lista[4]);
				prestamos.add(prestamo);
			}
				
			return prestamos;
		}finally {
			desconectar(coleccion);
		}
	}
	// Eliminar socio
	public static void eliminar(String dni) throws ClassNotFoundException, InstantiationException, IllegalAccessException, XMLDBException {
		Collection coleccion = null;
		try {
			coleccion= conectar("biblioteca");


			XPathQueryService servicio = 
					(XPathQueryService) coleccion.getService("XPathQueryService", "1.0");

			String sentenciaEliminarSocio = 
					"update delete " +
							"/socios/socio[dni = '" + dni + "']";
			servicio.query(sentenciaEliminarSocio);
		}finally {
			desconectar(coleccion);
		}
	}
}
