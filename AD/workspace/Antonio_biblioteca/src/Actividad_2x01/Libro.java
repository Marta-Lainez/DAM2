package Actividad_2x01;

public class Libro {
	private int codigo;
	private String isbn;
	private String titulo;
	private String escritor;
	private int ano_publicacion;
	private double puntuacion;
	
	
	public Libro(int codigo, String isbn, String titulo, String escritor, int ano_publicacion, double puntuacion) {
		super();
		this.codigo = codigo;
		this.isbn = isbn;
		this.titulo = titulo;
		this.escritor = escritor;
		this.ano_publicacion = ano_publicacion;
		this.puntuacion = puntuacion;
	}
	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getEscritor() {
		return escritor;
	}

	public void setEscritor(String escritor) {
		this.escritor = escritor;
	}

	public int getAno_publicacion() {
		return ano_publicacion;
	}

	public void setAno_publicacion(int ano_publicacion) {
		this.ano_publicacion = ano_publicacion;
	}

	public double getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(double puntuacion) {
		this.puntuacion = puntuacion;
	}

	public Libro(String isbn, String titulo, String escritor, int ano_publicacion, double puntuacion) {
		super();
		this.isbn = isbn;
		this.titulo = titulo;
		this.escritor = escritor;
		this.ano_publicacion = ano_publicacion;
		this.puntuacion = puntuacion;
	}
	
	
	public String toString() {
		return "libro [codigo=" + codigo + ", isbn=" + isbn + ", titulo=" + titulo + ", escritor=" + escritor
				+ ", ano_publicacion=" + ano_publicacion + ", puntuacion=" + puntuacion + "]";
	}
	
	
}
