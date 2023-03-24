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
		try {


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

		}finally {
			if(cliente != null) {
				cliente.close();
			}
		}
	}
	public static Libro consultarLibroPorCodigo(Integer codigo) {
		MongoClient cliente = new MongoClient();
		try {


			MongoDatabase bd = cliente.getDatabase("biblioteca");
			MongoCollection<Document> libros = bd.getCollection("libros");
			Document libroDoc = libros.find(eq("codigo", codigo))
					.first();
			Libro libro = null;
			if(libroDoc != null) {
				String titulo = libroDoc.getString("titulo");
				String autor = libroDoc.getString("autor");
				Integer agno = libroDoc.getInteger("agno");
				String genero = libroDoc.getString("genero");
				List<String> partes = libroDoc.getList("partes", String.class);
				Integer numPaginas = libroDoc.getInteger("numero_paginas");
				List<String> personajes = libroDoc.getList("personajes", String.class);
				libro = new Libro(codigo, titulo, autor, agno, genero, partes, numPaginas, personajes);
			}
			return libro;
		}finally {
			if(cliente != null) {
				cliente.close();
			}
		}


	}
	public static ArrayList<Libro> consultarTodos(){
		MongoClient cliente = new MongoClient();

		try {

			ArrayList<Libro> listaLibros = new ArrayList<>();
			Libro libro;

			MongoDatabase bd = cliente.getDatabase("biblioteca");
			MongoCollection<Document> libros = bd.getCollection("libros");
			MongoCursor<Document> cursor = libros.find()
					.sort(descending("codigo"))
					.iterator();

			while (cursor.hasNext()) {
				Document libroDoc = cursor.next();

				Integer codigo = libroDoc.getInteger("codigo");
				String titulo = libroDoc.getString("titulo");
				String autor = libroDoc.getString("autor");
				Integer agno = libroDoc.getInteger("agno");
				String genero = libroDoc.getString("genero");
				List<String> partes = libroDoc.getList("partes", String.class);
				Integer numPaginas = libroDoc.getInteger("numero_paginas");
				List<String> personajes = libroDoc.getList("personajes", String.class);
				libro = new Libro(codigo, titulo, autor, agno, genero, partes, numPaginas, personajes);

				listaLibros.add(libro);
			}
			return listaLibros;
		}finally {
			if(cliente != null) {
				cliente.close();
			}
		}


	}
	public static long actualizarLibro(Libro libro) {
		MongoClient cliente = new MongoClient();
		try {


			Integer codigo = libro.getCodigo();
			String titulo = libro.getTitulo();
			String autor = libro.getAutor();
			Integer agno = libro.getAgno();
			String genero = libro.getGenero();
			List<String> partes = libro.getPartes();
			Integer numPaginas = libro.getNumPaginas();
			List <String> personajes = libro.getPersonajes();


			MongoDatabase bd = cliente.getDatabase("biblioteca");
			MongoCollection<Document> libros = bd.getCollection("libros");
			Bson filtro = eq("codigo", codigo);
			Bson modificaciones = combine(set("titulo", titulo),
					set("autor", autor),
					set("agno", agno),
					set("genero", genero),
					set("partes",partes),
					set("numero_paginas", numPaginas),
					set("personajes",personajes)
					);
			UpdateResult resultado = libros.updateOne(filtro, modificaciones);
			//UpdateResult resultado = libros.updateMany(filtro, modificaciones);
			long librosActualizados = resultado.getModifiedCount();

			return librosActualizados;
		}finally {
			if(cliente != null) {
				cliente.close();
			}
		}
	}
	public static long eliminarLibro(Integer codigo) {
		MongoClient cliente = new MongoClient();
		try {


			MongoDatabase bd = cliente.getDatabase("biblioteca");
			MongoCollection<Document> amigos = bd.getCollection("libros");
			DeleteResult resultado = amigos.deleteOne(eq("codigo", codigo));
			//DeleteResult resultado = amigos.deleteMany(eq("codigo", codigo));
			long librosEliminados = resultado.getDeletedCount();

			return librosEliminados;
		}finally {
			if(cliente != null) {
				cliente.close();
			}
		}
	}
}
