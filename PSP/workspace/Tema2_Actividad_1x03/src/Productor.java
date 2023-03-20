public class Productor extends Thread
{
    private Dato dato;
    private String cadena;
    private int turno;
 
   
    public Productor(Dato c,int turno, String cadena) 
    {
    	this.turno = turno;
        this.dato = c;
        this.cadena = cadena;
    }
 
    public void run() 
    {
    	for (int i=0; i<25;i++){
    			dato.set(cadena,turno);
    	}
        try{
        	sleep(100); // Ayuda a ver si hay errores ya que va mas lento
        }
        catch(InterruptedException e){
        	System.err.println(e.toString());
        }
    }
}