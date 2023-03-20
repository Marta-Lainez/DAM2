
public class Libro {
	private int codigo;
	private String titulo;
	private String autor;
	private int agno;
	private String genero;
	
	public Libro(int codigo, String titulo, String autor, int agno, String genero) {
		this.codigo = codigo;
		this.titulo = titulo;
		this.autor = autor;
		this.agno = agno;
		this.genero = genero;
	}

	@Override
	public String toString() {
		return "Libros [codigo=" + codigo + ", titulo=" + titulo + ", autor=" + autor + ", agno=" + agno + ", genero="
				+ genero + "]";
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getAgno() {
		return agno;
	}

	public void setAgno(int agno) {
		this.agno = agno;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	
}
