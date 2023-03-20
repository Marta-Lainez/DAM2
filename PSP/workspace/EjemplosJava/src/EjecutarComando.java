import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class EjecutarComando {

	public static void main(String[] args) {
		//Ejecutar comando: cmd /c comando
		String line;
		ProcessBuilder pb = new ProcessBuilder(args);
		pb.redirectErrorStream(true);
		InputStream is = null;
		try{
			Process shell = pb.start();
			is = shell.getInputStream();
			BufferedReader bf = new BufferedReader(new InputStreamReader(is, "UTF-8"));
			System.out.println("Salida del proceso " + Arrays.toString(args));
			while((line = bf.readLine()) != null)
				System.out.println(line);
			is.close();
		}
		catch (IOException ex){
			System.err.println("Error de Entrada/Salida");
			System.exit(-1);
		}
		finally {
			if(is != null) {
				try {
					is.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
