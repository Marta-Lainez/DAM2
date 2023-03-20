import java.io.Serializable;

public class Escritor implements Serializable{
	private static final long serialVersionUID = 1L;
	private int código;
	private String nombre, nacimiento, nacionalidad;
	public Escritor(int código, String nombre, String nacimiento, String nacionalidad) {
		this.código = código;
		this.nombre = nombre;
		this.nacimiento = nacimiento;
		this.nacionalidad = nacionalidad;
	}
	@Override
	public String toString() {
		return "Escritor [código=" + código + ", nombre=" + nombre + ", nacimiento=" + nacimiento + ", nacionalidad="
				+ nacionalidad + "]";
	}
	public int getCódigo() {
		return código;
	}
}
