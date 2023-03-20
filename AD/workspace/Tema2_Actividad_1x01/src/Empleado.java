
public class Empleado {
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
	
}
