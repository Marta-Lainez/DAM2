
public class Alumno {
	private String nombre;
	private int edad;
	private String grado;
	private int curso;
	
	public Alumno(String nombre, int edad, String grado, int curso) {
		this.nombre = nombre;
		this.edad = edad;
		this.grado = grado;
		this.curso = curso;
	}

	@Override
	public String toString() {
		return "Alumno [nombre=" + nombre + " | edad=" + edad + " | grado=" + grado + " | curso=" + curso + "]";
	}
	
	
}
