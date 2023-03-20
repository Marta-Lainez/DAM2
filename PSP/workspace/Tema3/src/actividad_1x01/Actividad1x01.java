package actividad_1x01;
import java.net.InetAddress;
import java.net.UnknownHostException;

import entrada.Teclado;

public class Actividad1x01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InetAddress dir = null; 
		System.out.println("==========================================="); 
		System.out.println("SALIDA: ");
		
		try { 
			//LOCALHOST 
			String direccion=Teclado.leerCadena("Dime el nombre o direccion del que quieres ver informacion");
			dir = InetAddress.getByName(direccion); 
			pruebaMetodos(dir);
			System.out.println("=========================================="); 
		} catch (UnknownHostException e1) {
			e1.printStackTrace();
		} 
	
	}// main 
	
	private static void pruebaMetodos(InetAddress dir) { 
		
		System.out.println("\tMetodo getByName(): " + dir); 
		InetAddress dir2; 
		try { 
			dir2 = InetAddress.getLocalHost(); 
			System.out.println("\tMetodo getLocalHost(): " + dir2); 
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} 
		
		//USAMOS METODOS DE LA CLASE 
		System.out.println("\tMetodo getHostName(): "+dir.getHostName()); 
		System.out.println("\tMetodo getHostAddress(): "+ dir.getHostAddress()); 
		System.out.println("\tMetodo toString(): " + dir.toString()); 
		System.out.println("\tMetodo getCanonicalHostName(): " + dir.getCanonicalHostName());   

	}

}
