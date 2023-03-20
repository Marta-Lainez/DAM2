
public class Socio {
	private int codigo;
	private String dni, nombre, domicilio, telefono, correo;
	
	public Socio(int codigo, String dni, String nombre, String domicilio, String telefono, String correo) {
		this.codigo = codigo;
		this.dni = dni;
		this.nombre = nombre;
		this.domicilio = domicilio;
		this.telefono = telefono;
		this.correo = correo;
	}
	@Override
	public String toString() {
		return "Socio [codigo=" + codigo + ", dni=" + dni + ", nombre=" + nombre + ", domicilio=" + domicilio
				+ ", telefono=" + telefono + ", correo=" + correo + "]";
	}
}
