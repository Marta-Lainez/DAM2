public class Actividad_1x01 {

	public static void main(String[] args) {
		Fibonacci hilo1 = new Fibonacci(10);
		Fibonacci hilo2 = new Fibonacci(10);
		hilo1.start();
		try {
			hilo1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		hilo2.start();
	}
}

class Fibonacci extends Thread{
	private int n;
	private int num1;
	private int num2;
	
	public Fibonacci(int n) {
		this.n = n;
		num1 = 0;
		num2 = 1;
	}
	public void calcularFibonacci(){
	    for (int i = 1; i <= n; ++i) {
	      System.out.println(num1);

	      // compute the next term
	      int nextTerm = num1 + num2;
	      num1 = num2;
	      num2 = nextTerm;
	    }
	}	
	
	public void run() {
		calcularFibonacci();
	}
}
