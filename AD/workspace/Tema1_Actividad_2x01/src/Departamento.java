import java.io.IOException;

public class Departamento {
	private static final String SEPARADOR = ";";
	private int código;
	private String nombre, ubicación;
	
	public Departamento(int código, String nombre, String ubicación) throws IOException {
		this.nombre = nombre;
		this.ubicación = ubicación;
		this.código = código;
		if(código < 0)
			throw new IOException("El código debe ser positivo");
	}
	public Departamento(String cadenaAtributos) throws IOException{
		String[] datos = cadenaAtributos.split(SEPARADOR);
		código = Integer.parseInt(datos[0]);
		if(código < 0)
			throw new IOException("El código debe ser positivo");
		nombre = datos[1];
		ubicación = datos[2];
	}
	@Override
	public String toString() {
		return "Departamento [código=" + código + ", nombre=" + nombre + ", ubicación=" + ubicación + "]";
	}
	
	public String toStringWithSeparators() {
		return código + SEPARADOR + nombre + SEPARADOR + ubicación;
	}
	public int getCódigo() {
		return código;
	}
	
}
