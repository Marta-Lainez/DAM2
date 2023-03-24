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

public class AccesoJuegos {

	public static void insertarJuego(Videojuego videojuego) {
		MongoClient cliente = new MongoClient();
		try {


			MongoDatabase bd = cliente.getDatabase("videojuegos");
			MongoCollection<Document> juegos = bd.getCollection("videojuegos");

			Document juegoDoc = new Document();
			juegoDoc.put("codigo", videojuego.getCodigo());
			juegoDoc.put("titulo", videojuego.getTitulo());
			juegoDoc.put("agno", videojuego.getAgno());
			juegoDoc.put("desarrollador", videojuego.getDesarrollador());
			juegoDoc.put("precio", videojuego.getPrecio());
			juegos.insertOne(juegoDoc);


		}finally {
			if(cliente != null) {
				cliente.close();
			}
		}
	}
	public static Videojuego consultarJuegoPorCodigo(int codigo) {
		MongoClient cliente = new MongoClient();
		try {
			MongoDatabase bd = cliente.getDatabase("videojuegos");
			MongoCollection<Document> juegos = bd.getCollection("videojuegos");
			Document juegoDoc = juegos.find(eq("codigo", codigo))
					.first();
			Videojuego juego = null;
			if(juegoDoc != null) {
				String titulo = juegoDoc.getString("titulo");
				int agno = juegoDoc.getInteger("agno");
				String desarrollador = juegoDoc.getString("desarrollador");
				double precio = juegoDoc.getDouble("precio");
				juego = new Videojuego(codigo, titulo, agno, desarrollador, precio);
			}
			return juego;
		}finally {
			if(cliente != null) {
				cliente.close();
			}
		}


	}
	public static ArrayList<Videojuego> consultarTodos(){
		MongoClient cliente = new MongoClient();

		try {

			ArrayList<Videojuego> listaJuegos = new ArrayList<>();
			Videojuego juego;

			MongoDatabase bd = cliente.getDatabase("videojuegos");
			MongoCollection<Document> libros = bd.getCollection("videojuegos");
			MongoCursor<Document> cursor = libros.find()
					.sort(descending("codigo"))
					.iterator();

			while (cursor.hasNext()) {
				Document juegoDoc = cursor.next();
				int codigo = juegoDoc.getInteger("codigo");
				String titulo = juegoDoc.getString("titulo");
				int agno = juegoDoc.getInteger("agno");
				String desarrollador = juegoDoc.getString("desarrollador");
				double precio = juegoDoc.getDouble("precio");

				juego = new Videojuego(codigo, titulo, agno, desarrollador, precio);

				listaJuegos.add(juego);
			}
			return listaJuegos;
		}finally {
			if(cliente != null) {
				cliente.close();
			}
		}


	}
	public static long actualizarJuego(Videojuego videojuego) {
		MongoClient cliente = new MongoClient();
		try {


			Integer codigo = videojuego.getCodigo();
			String titulo = videojuego.getTitulo();
			Integer agno = videojuego.getAgno();
			String desarrollador = videojuego.getDesarrollador();
			Double precio = videojuego.getPrecio();


			MongoDatabase bd = cliente.getDatabase("videojuegos");
			MongoCollection<Document> juegos = bd.getCollection("videojuegos");
			Bson filtro = eq("codigo", codigo);
			Bson modificaciones = combine(set("titulo", titulo),
					set("agno", agno),
					set("desarrollador", desarrollador),
					set("precio",precio)
					);
			UpdateResult resultado = juegos.updateOne(filtro, modificaciones);
			//UpdateResult resultado = libros.updateMany(filtro, modificaciones);
			long juegosActualizados = resultado.getModifiedCount();

			return juegosActualizados;
		}finally {
			if(cliente != null) {
				cliente.close();
			}
		}
	}
	public static long eliminarJuego(Integer codigo) {
		MongoClient cliente = new MongoClient();
		try {


			MongoDatabase bd = cliente.getDatabase("videojuegos");
			MongoCollection<Document> amigos = bd.getCollection("videojuegos");
			DeleteResult resultado = amigos.deleteOne(eq("codigo", codigo));
			//DeleteResult resultado = amigos.deleteMany(eq("codigo", codigo));
			long juegosEliminados = resultado.getDeletedCount();

			return juegosEliminados;
		}finally {
			if(cliente != null) {
				cliente.close();
			}
		}
	}
}
