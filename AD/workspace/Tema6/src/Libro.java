import java.util.ArrayList;
import java.util.List;

public class Libro {
	private int codigo;
	private String titulo;
	private String autor;
	private int agno;
	private String genero;
	private List<String> partes;
	private int numPaginas;
	private List <String> personajes;
	public Libro(int codigo, String titulo, String autor, int agno, String genero, List<String> partes,
			int numPaginas, List<String> personajes) {
		super();
		this.codigo = codigo;
		this.titulo = titulo;
		this.autor = autor;
		this.agno = agno;
		this.genero = genero;
		this.partes = partes;
		this.numPaginas = numPaginas;
		this.personajes = personajes;
	}
	
	@Override
	public String toString() {
		return "Libro [codigo=" + codigo + ", titulo=" + titulo + ", autor=" + autor + ", agno=" + agno + ", genero="
				+ genero + ", partes=" + partes + ", numero_paginas=" + numPaginas + ", personajes=" + personajes
				+ "]";
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

	public List<String> getPartes() {
		return partes;
	}

	public void setPartes(ArrayList<String> partes) {
		this.partes = partes;
	}

	public int getNumPaginas() {
		return numPaginas;
	}

	public void setNumPaginas(int numPaginas) {
		this.numPaginas = numPaginas;
	}

	public List<String> getPersonajes() {
		return personajes;
	}

	public void setPersonajes(ArrayList<String> personajes) {
		this.personajes = personajes;
	}
	
	

	
}
