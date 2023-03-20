import java.io.IOException;
import java.io.Serializable;

public class Videojuego implements Serializable{
	private static final long serialVersionUID = 1L;
	private static final String SEPARADOR = ";";
	private int codigo;
	private String titulo, plataforma;
	private double precio;
	public Videojuego(int codigo, String titulo, String plataforma, double precio) throws IOException {
		this.codigo = codigo;
		this.titulo = titulo;
		this.plataforma = plataforma;
		this.precio = Math.round(precio*100)/100;
		if(codigo < 0)
			throw new IOException("El codigo de empleado debe ser positivo");
	}
	public Videojuego(String cadenaAtributos) throws IOException {
		String[] datos = cadenaAtributos.split(SEPARADOR);
		codigo = Integer.parseInt(datos[0]);
		if(codigo < 0)
			throw new IOException("El codigo debe ser positivo");
		titulo = datos[1];
		plataforma = datos[2];
		precio = Double.parseDouble(datos[3]);
	}
	public int getCodigo() {
		return codigo;
	}
	@Override
	public String toString() {
		return "Videojuego [codigo=" + codigo + ", titulo=" + titulo + ", plataforma=" + plataforma + ", precio="
				+ precio + "]";
	}
	public String toStringWithSeparators() {
		return codigo + SEPARADOR + titulo + SEPARADOR + plataforma + SEPARADOR + precio;
	}
}
