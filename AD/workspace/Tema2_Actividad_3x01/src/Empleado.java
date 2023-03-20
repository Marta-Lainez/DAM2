import java.io.IOException;

public class Empleado {
	private static final String SEPARADOR = ";";
	private int codigo, codigoDepartamento;
	private double salario;
	private String nombre, fechaAlta;
	public Empleado(int codigo, String nombre, String fechaAlta, double salario, int codigoDepartamento) {
		this.codigo = codigo;
		this.salario = salario;
		this.codigoDepartamento = codigoDepartamento;
		this.nombre = nombre;
		this.fechaAlta = fechaAlta;
	}
	@Override
	public String toString() {
		return "Empleado [codigo=" + codigo + ", codigoDepartamento=" + codigoDepartamento + ", salario=" + salario
				+ ", nombre=" + nombre + ", fechaAlta=" + fechaAlta + "]";
	}	
	public Empleado(String cadenaAtributos) throws IOException{
		String[] datos = cadenaAtributos.split(SEPARADOR);
		codigoDepartamento = Integer.parseInt(datos[0]);
		nombre = datos[1];
		salario = Double.parseDouble(datos[2]);
		
	}
	public int getCodigoDepartamento() {
		return codigoDepartamento;
	}
	public double getSalario() {
		return salario;
	}
	public String getNombre() {
		return nombre;
	}
	public String getFechaAlta() {
		return fechaAlta;
	}
}
