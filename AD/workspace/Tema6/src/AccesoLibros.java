import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Sorts.descending;
import static com.mongodb.client.model.Updates.combine;
import static com.mongodb.client.model.Updates.set;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;

import entrada.Teclado;

public class AccesoLibros {
	
	public static void insertarLibro(Libro libro) {
		MongoClient cliente = new MongoClient();
		MongoDatabase bd = cliente.getDatabase("biblioteca");
		MongoCollection<Document> libros = bd.getCollection("libros");
		
		Document libroDoc = new Document();
			libroDoc.put("codigo", libro.getCodigo());
			libroDoc.put("titulo", libro.getTitulo());
			libroDoc.put("autor", libro.getAutor());
			libroDoc.put("agno", libro.getAgno());
			libroDoc.put("genero", libro.getGenero());
			libroDoc.put("partes", libro.getPartes());
			libroDoc.put("numero_paginas", libro.getNumPaginas());
			libroDoc.put("personajes", libro.getPersonajes());
			libros.insertOne(libroDoc);
		
		cliente.close();
	}
	public static Libro consultarLibroPorCodigo(int codigo) {
		MongoClient cliente = new MongoClient();
		MongoDatabase bd = cliente.getDatabase("biblioteca");
		MongoCollection<Document> libros = bd.getCollection("libros");
		Document libroDoc = libros.find(eq("codigo", codigo))
		                       .first();
		Libro libro = null;
		if(libroDoc != null) {
			String titulo = libroDoc.getString("titulo");
			String autor = libroDoc.getString("autor");
			int agno = libroDoc.getInteger("agno");
			String genero = libroDoc.getString("genero");
			List<String> partes = libroDoc.getList("partes", null);
			int numPaginas = libroDoc.getInteger("numero_paginas");
			List<String> personajes = libroDoc.getList("personajes", null);
			libro = new Libro(codigo, titulo, autor, agno, genero, partes, numPaginas, personajes);
		}
		
		cliente.close();
		return libro;
	}
	public static ArrayList<Libro> consultarTodos(){
		ArrayList<Libro> listaLibros = new ArrayList<>();
		Libro libro;
		MongoClient cliente = new MongoClient();
		MongoDatabase bd = cliente.getDatabase("biblioteca");
		MongoCollection<Document> libros = bd.getCollection("libros");
		MongoCursor<Document> cursor = libros.find()
		                                     .sort(descending("codigo"))
		                                     .iterator();
		
		while (cursor.hasNext()) {
			Document libroDoc = cursor.next();
		
			int codigo = libroDoc.getInteger("codigo");
			String titulo = libroDoc.getString("titulo");
			String autor = libroDoc.getString("autor");
			int agno = libroDoc.getInteger("agno");
			String genero = libroDoc.getString("genero");
			List<String> partes = libroDoc.getList("partes", null);
			int numPaginas = libroDoc.getInteger("numero_paginas");
			List<String> personajes = libroDoc.getList("personajes", null);
			libro = new Libro(codigo, titulo, autor, agno, genero, partes, numPaginas, personajes);
			
			listaLibros.add(libro);
		}
		
		cliente.close();
		return listaLibros;
		
	}
	// ARREGLAR A PARTIR DE AQUI
	public static long actualizarLibro(Libro libro) {
		int codigo = libro.getCodigo();
		String titulo = libro.getTitulo();
		String autor = libro.getAutor();
		int agno = libro.getAgno();
		String genero = libro.getGenero();
		MongoClient cliente = new MongoClient();
		MongoDatabase bd = cliente.getDatabase("biblioteca");
		MongoCollection<Document> libros = bd.getCollection("libros");
		Bson filtro = eq("codigo", codigo);
		Bson modificaciones = combine(set("titulo", titulo),
		                              set("autor", autor),
		                              set("agno", agno),
		                              set("genero", genero));
		UpdateResult resultado = libros.updateOne(filtro, modificaciones);
		long librosActualizados = resultado.getModifiedCount();
		cliente.close();
		return librosActualizados;
	}
	public static long eliminarLibro(int codigo) {
		MongoClient cliente = new MongoClient();
		MongoDatabase bd = cliente.getDatabase("biblioteca");
		MongoCollection<Document> amigos = bd.getCollection("libros");
		DeleteResult resultado = amigos.deleteOne(eq("codigo", codigo));
		long librosEliminados = resultado.getDeletedCount();
		
		cliente.close();
		return librosEliminados;
	}
}
