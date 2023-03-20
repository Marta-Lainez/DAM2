import java.io.IOException;
import java.io.Serializable;

public class Libro implements Serializable{
	private static final long serialVersionUID = 1L;
	private int codigo, codigoEscritor, añoPublicacion;
	private double precio;
	private String titulo;
	public Libro(int codigo, int codigoEscritor, int añoPublicacion, double precio, String titulo) throws IOException {
		this.codigo = codigo;
		this.codigoEscritor = codigoEscritor;
		this.añoPublicacion = añoPublicacion;
		this.precio = Math.round(precio*100)/100;
		this.titulo = titulo;
		if(codigo < 0)
			throw new IOException("El código de empleado debe ser positivo");
	}
	
	@Override
	public String toString() {
		return "Libro [codigo=" + codigo + ", codigoEscritor=" + codigoEscritor + ", añoPublicacion=" + añoPublicacion
				+ ", precio=" + precio + ", titulo=" + titulo + "]";
	}

	public int getCodigo() {
		return codigo;
	}
}
