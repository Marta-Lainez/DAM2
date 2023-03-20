
public class Libro {
	private int codigo, agnoPublicacion;
	private String isbn, titulo, escritor;
	private double puntuacion;
	
	public Libro(int codigo, String isbn, String titulo, String escritor, int agnoPublicacion, double puntuacion) {
		this.codigo = codigo;
		this.isbn = isbn;
		this.titulo = titulo;
		this.escritor = escritor;
		this.agnoPublicacion = agnoPublicacion;
		this.puntuacion = puntuacion;
	}

	@Override
	public String toString() {
		return "Libro [codigo=" + codigo  + ", isbn=" + isbn + ", titulo=" + titulo + ", escritor="
				+ escritor + ", agnoPublicacion=" + agnoPublicacion+ ", puntuacion=" + puntuacion + "]";
	}
	
}
