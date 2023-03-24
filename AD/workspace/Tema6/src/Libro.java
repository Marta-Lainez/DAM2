import java.util.ArrayList;
import java.util.List;

public class Libro {
	private Integer codigo;
	private String titulo;
	private String autor;
	private Integer agno;
	private String genero;
	private List<String> partes;
	private Integer numPaginas;
	private List <String> personajes;
	public Libro(Integer codigo, String titulo, String autor, Integer agno, String genero, List<String> partes,
			Integer numPaginas, List<String> personajes) {
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

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
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

	public Integer getAgno() {
		return agno;
	}

	public void setAgno(Integer agno) {
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

	public void setPartes(List<String> partes) {
		this.partes = partes;
	}

	public Integer getNumPaginas() {
		return numPaginas;
	}

	public void setNumPaginas(Integer numPaginas) {
		this.numPaginas = numPaginas;
	}

	public List<String> getPersonajes() {
		return personajes;
	}

	public void setPersonajes(List<String> personajes) {
		this.personajes = personajes;
	}
	

	
}
