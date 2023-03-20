import java.io.IOException;

public class Empleado {
	private static final String SEPARADOR = ";";
	private int código, códigoDepartamento;
	private double salario;
	private String nombre, fechaAlta;
	public Empleado(int código, int códigoDepartamento, double salario, String nombre, String fechaAlta) throws IOException {
		this.código = código;
		this.códigoDepartamento = códigoDepartamento;
		this.salario = Math.round(salario*100)/100;
		this.nombre = nombre;
		this.fechaAlta = fechaAlta;
		if(código < 0)
			throw new IOException("El código de empleado debe ser positivo");
	}
	public Empleado(String cadenaAtributos) throws IOException {
		String[] datos = cadenaAtributos.split(SEPARADOR);
		código = Integer.parseInt(datos[0]);
		if(código < 0)
			throw new IOException("El código debe ser positivo");
		códigoDepartamento = Integer.parseInt(datos[1]);
		salario = Math.round(Double.parseDouble(datos[2])*100)/100;
		nombre = datos[3];
		fechaAlta = datos[4];
	}
	@Override
	public String toString() {
		return "Empleado [código=" + código + ", códigoDepartamento=" + códigoDepartamento + ", salario=" + salario
				+ ", nombre=" + nombre + ", fechaAlta=" + fechaAlta + "]";
	}
	public String toStringWithSeparators() {
		return código + SEPARADOR + códigoDepartamento + SEPARADOR + salario + SEPARADOR + nombre + SEPARADOR + fechaAlta;
	}
	public int getCódigo() {
		return código;
	}
	public int getCódigoDepartamento() {
		return códigoDepartamento;
	}
	
	
}
