
public class Departamento {

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

	@Override
	public String toString() {
		return 
			"Departamento [Código = " + this.codigo + 
			", Nombre = " + this.nombre + 
			", Ubicación = " + this.ubicacion + 
			"]";
	}
	public int getCodigo() {
		return codigo;
	}
	
}
