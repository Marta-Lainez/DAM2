import java.io.IOException;

public class Departamento {
	private static final String SEPARADOR = ";";
	private int codigo;
	private String nombre;
	private String ubicacion;
	
	public Departamento(int codigo, String nombre, String ubicacion) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.ubicacion = ubicacion;
	}
	public Departamento(String nombre, String ubicacion) {
		this.nombre = nombre;
		this.ubicacion = ubicacion;
	}
	public Departamento(String cadenaAtributos) throws IOException{
		String[] datos = cadenaAtributos.split(SEPARADOR);
		nombre = datos[0];
		ubicacion = datos[1];
	}

	@Override
	public String toString() {
		return 
			"Departamento [Código = " + this.codigo + 
			", Nombre = " + this.nombre + 
			", Ubicación = " + this.ubicacion + 
			"]";
	}
	public String getNombre() {
		return nombre;
	}
	public String getUbicacion() {
		return ubicacion;
	}
}
