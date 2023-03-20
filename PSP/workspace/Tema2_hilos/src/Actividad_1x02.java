
public class Actividad_1x02 {

	public static void main(String[] args) {
		Tic hilo1 = new Tic();
		Tac hilo2 = new Tac();
		hilo1.start();
		hilo2.start();
	}

}
class Tic extends Thread{
	private String output;

	public Tic() {
		
		output = "Tic";
	}
	public void run() {
		for(int i = 1; i < 100; i++) {
			System.out.println(output);
			try {
				sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
class Tac extends Thread{
	private String output;

	public Tac() {
		
		output = "Tac";
	}
	public void run() {
		for(int i = 1; i < 100; i++) {
			System.out.println(output);
			try {
				sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}