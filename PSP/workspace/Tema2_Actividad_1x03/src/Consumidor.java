public class Consumidor extends Thread
	{
	    private Dato dato;
	 
	    public Consumidor(Dato c) 
	    {
	        this.dato = c;
	    }
	 
	    public void run() 
	    {
	    	for (int i=0; i<50;i++){
	    		dato.get();
	    	}
	    }
	}