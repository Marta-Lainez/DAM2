import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Sorts.descending;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;

public class AccesoPersonal {
	public static ArrayList<Empleado> consultarTodos(){
		MongoClient cliente = new MongoClient();

		try {

			ArrayList<Empleado> listaEmpleados = new ArrayList<>();
			Empleado empleado;

			MongoDatabase bd = cliente.getDatabase("personal");
			MongoCollection<Document> empleados = bd.getCollection("empleados");
			MongoCursor<Document> cursor = empleados.find()
					.sort(descending("salario"))
					.iterator();

			while (cursor.hasNext()) {
				Document EmpleadoDoc = cursor.next();
				int codigo = EmpleadoDoc.getInteger("codigo");
				String nombre = EmpleadoDoc.getString("nombre");
				String fechaAlta = EmpleadoDoc.getString("fecha_alta");
				String departamento = EmpleadoDoc.getString("departamento");
				double salario = EmpleadoDoc.getDouble("salario");

				empleado = new Empleado(codigo, nombre, fechaAlta, departamento, salario);

				listaEmpleados.add(empleado);
			}
			return listaEmpleados;
		}finally {
			if(cliente != null) {
				cliente.close();
			}
		}
	}

	public static Empleado consultarCodigoMaximo() {
		MongoClient cliente = new MongoClient();
		try {


			MongoDatabase bd = cliente.getDatabase("personal");
			MongoCollection<Document> empleados = bd.getCollection("empleados");
			Document EmpleadoDoc = empleados.find().sort(descending("codigo"))
					.first();
			Empleado empleado = null;
			if(EmpleadoDoc != null) {
				int codigo = EmpleadoDoc.getInteger("codigo");
				String nombre = EmpleadoDoc.getString("nombre");
				String fechaAlta = EmpleadoDoc.getString("fecha_alta");
				String departamento = EmpleadoDoc.getString("departamento");
				double salario = EmpleadoDoc.getDouble("salario");

				empleado = new Empleado(codigo, nombre, fechaAlta, departamento, salario);

			}
			return empleado;
		}finally {
			if(cliente != null) {
				cliente.close();
			}
		}
	}
	public static void insertar(Empleado empleado) {
		MongoClient cliente = new MongoClient();
		try {

			MongoDatabase bd = cliente.getDatabase("personal");
			MongoCollection<Document> empleados = bd.getCollection("empleados");

			Document EmpleadoDoc = new Document();
			EmpleadoDoc.put("codigo", empleado.getCodigo());
			EmpleadoDoc.put("nombre", empleado.getNombre());
			EmpleadoDoc.put("fecha_alta", empleado.getFechaAlta());
			EmpleadoDoc.put("departamento", empleado.getDepartamento());
			EmpleadoDoc.put("salario", empleado.getSalario());

			empleados.insertOne(EmpleadoDoc);

		}finally {
			if(cliente != null) {
				cliente.close();
			}
		}
	}
	public static long eliminar(int codigo) {
		MongoClient cliente = new MongoClient();
		try {

			MongoDatabase bd = cliente.getDatabase("personal");
			MongoCollection<Document> empleados = bd.getCollection("empleados");
			DeleteResult resultado = empleados.deleteOne(eq("codigo", codigo));
			long empleadosEliminados = resultado.getDeletedCount();

			return empleadosEliminados;
		}finally {
			if(cliente != null) {
				cliente.close();
			}
		}
	}
}
