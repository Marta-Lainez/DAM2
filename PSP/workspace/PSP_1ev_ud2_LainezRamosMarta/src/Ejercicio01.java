import java.util.Random;
import java.util.concurrent.Semaphore;

public class Ejercicio01 {
	final static int PACIENTES = 5;
	public static void main(String[] args) {
		
		Semaphore atender = new Semaphore(0);
		Semaphore salir = new Semaphore(0);
		Medico medico = new Medico(atender,salir);
		medico.start();
		Paciente[] pacientes = rellenarPacientes(atender,salir);
		hacerJoin(pacientes);
		medico.interrupt();
		
	}
	public static Paciente[] rellenarPacientes(Semaphore atender, Semaphore salir) {
		Random random = new Random();
		Paciente[] pacientes = new Paciente[PACIENTES];
		for(int i = 0; i < pacientes.length; i++) {
			Paciente paciente = new Paciente(atender,salir,i+1);
			pacientes[i] = paciente;
			paciente.start();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return pacientes;
	}
	public static void hacerJoin(Paciente[] pacientes) {
		for(Paciente paciente: pacientes) {
			try {
				paciente.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
