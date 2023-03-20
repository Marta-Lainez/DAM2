
public class Prestamo {
	private int codigoLibro, codigoSocio;
	private String fechaInicio, fechaFin, fechaDevolucion;
	public Prestamo(int codigoLibro, int codigoSocio, String fechaInicio, String fechaFin, String fechaDevolucion) {
		this.codigoLibro = codigoLibro;
		this.codigoSocio = codigoSocio;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.fechaDevolucion = fechaDevolucion;
	}
	@Override
	public String toString() {
		return "Prestamo [codigoLibro=" + codigoLibro + ", codigoSocio=" + codigoSocio + ", fechaInicio=" + fechaInicio
				+ ", fechaFin=" + fechaFin + ", fechaDevolucion=" + fechaDevolucion + "]";
	}
}
