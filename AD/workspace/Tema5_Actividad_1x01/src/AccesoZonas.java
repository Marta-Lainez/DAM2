import org.xmldb.api.DatabaseManager;
import org.xmldb.api.base.Collection;
import org.xmldb.api.base.Database;
import org.xmldb.api.base.Resource;
import org.xmldb.api.base.ResourceIterator;
import org.xmldb.api.base.ResourceSet;
import java.util.ArrayList;

import org.xmldb.api.DatabaseManager;
import org.xmldb.api.base.Collection;
import org.xmldb.api.base.Database;
import org.xmldb.api.base.Resource;
import org.xmldb.api.base.ResourceIterator;
import org.xmldb.api.base.ResourceSet;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.XPathQueryService;

import entrada.Teclado;

public class AccesoZonas {
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
	public static void insertar(String nombre, String director) throws ClassNotFoundException, InstantiationException, IllegalAccessException, XMLDBException {
		Collection coleccion = null;
		try {
			coleccion = conectar("ColeccionPruebas");
			
			XPathQueryService servicio = 
					(XPathQueryService) coleccion.getService("XPathQueryService", "1.0");
			
			String sentenciaBuscarCodigo = 
					 "let $codigo_maximo := max(/zonas/zona/cod_zona)"+
					 "return $codigo_maximo";
		    ResourceSet resultados = servicio.query(sentenciaBuscarCodigo);
		   	ResourceIterator iterador = resultados.getIterator();

			Resource recurso = iterador.nextResource();
			String zonaCodigoGrande = (String) recurso.getContent();
			int codigoNuevo = Integer.parseInt(zonaCodigoGrande)+10;
			
			String sentenciaInsertarProducto = 
					"update insert " +
							"<zona>" +
							"<cod_zona>" + codigoNuevo + "</cod_zona>" +
							"<nombre>" + nombre + "</nombre>" +
							"<director>" + director + "</director>" +
							"</zona> " +
							"into /zonas";

				ResourceSet resultados2 = servicio.query(sentenciaInsertarProducto);
			
		}finally {
			desconectar(coleccion);
		}
	}
	
	public static ArrayList<Zona> consultar() throws ClassNotFoundException, InstantiationException, IllegalAccessException, XMLDBException {
		Collection coleccion = null;
		try {
			coleccion = conectar("ColeccionPruebas");

			ArrayList<Zona> zonas = new ArrayList<>();
			String sentenciaBuscarZonas = 
					"for $zona in /zonas/zona " +
							" return <item>{$zona/cod_zona/text()"
							+ "},{"+ "$zona/nombre/text() "
							+ "},{"+ "$zona/director/text()}</item>";
			XPathQueryService servicio = 
					(XPathQueryService) coleccion.getService("XPathQueryService", "1.0");
			ResourceSet resultados = servicio.query(sentenciaBuscarZonas);

			ResourceIterator iterador = resultados.getIterator();
			while (iterador.hasMoreResources()) {
				Resource recurso = iterador.nextResource();
				String zonaMal = (String) recurso.getContent();
				zonaMal=zonaMal.replace("<item>", "");
				zonaMal=zonaMal.replace("</item>", "");
				String lista[] = zonaMal.split(",");
				Zona zona =new Zona(Integer.parseInt(lista[0]),lista[1],lista[2]);
				zonas.add(zona);
			}
			return zonas;
		}finally {
			desconectar(coleccion);
		}
	}
	public static Zona consultarCodigo(int codigo) throws ClassNotFoundException, InstantiationException, IllegalAccessException, XMLDBException {
		Collection coleccion = null;
		try {
			coleccion = conectar("ColeccionPruebas");
			Zona zona = null;
			String sentenciaBuscarProductoPorCodigo = 
					"for $zona in /zonas/zona " +
							" where $zona/cod_zona = " + codigo +
							" return $zona";
			XPathQueryService servicio = 
					(XPathQueryService) coleccion.getService("XPathQueryService", "1.0");
			ResourceSet resultados = servicio.query(sentenciaBuscarProductoPorCodigo);

			ResourceIterator iterador = resultados.getIterator();
			while (iterador.hasMoreResources()) {
				Resource recurso = iterador.nextResource();
				String texto = (String) recurso.getContent();
				zona =new Zona(texto);

			}
			return zona;
		}finally {
			desconectar(coleccion);
		}
	}
	public static void actualizar(Zona zona) throws ClassNotFoundException, InstantiationException, IllegalAccessException, XMLDBException {
		Collection coleccion = null;
		try {
			coleccion = conectar("ColeccionPruebas");
			XPathQueryService servicio = 
					(XPathQueryService) coleccion.getService("XPathQueryService", "1.0");

			String sentenciaActualizarProducto = 
					"update replace " +
							"/zonas/zona[cod_zona = " + zona.getCodigo() + "] with " +
							"<zona>" +
							"<cod_zona>" + zona.getCodigo() + "</cod_zona>" +
							"<nombre>" + zona.getNombre() + "</nombre>" +
							"<director>" + zona.getDirector() + "</director>" +
							"</zona>";		
			servicio.query(sentenciaActualizarProducto);
		}finally {
			desconectar(coleccion);
		}
	}
	public static void eliminar(int codigo) throws ClassNotFoundException, InstantiationException, IllegalAccessException, XMLDBException {
		Collection coleccion = null;
		try {
			coleccion= conectar("ColeccionPruebas");


			XPathQueryService servicio = 
					(XPathQueryService) coleccion.getService("XPathQueryService", "1.0");

			String sentenciaEliminarProducto = 
					"update delete " +
							"/zonas/zona[cod_zona = " + codigo + "]";
			servicio.query(sentenciaEliminarProducto);
		}finally {
			desconectar(coleccion);
		}
	}
}
