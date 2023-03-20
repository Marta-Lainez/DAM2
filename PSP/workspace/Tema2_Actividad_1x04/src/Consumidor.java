public class Consumidor extends Thread
	{
	    private Dato dato;
	 
	    public Consumidor(Dato dato) 
	    {
	        this.dato = dato;
	    }
	 
	    public void run() 
	    {
	    	for (int i=0; i<21;i++){
	    		dato.get();
	    	}
	    }
	}