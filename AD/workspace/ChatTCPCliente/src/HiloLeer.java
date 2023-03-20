
import java.io.BufferedReader;
import javax.swing.JTextArea;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author alu
 */
public class HiloLeer extends Thread{
    private JTextArea texto;
    private BufferedReader fEntrada;

    public HiloLeer(JTextArea texto, BufferedReader fEntrada) {
        this.texto = texto;
        this.fEntrada = fEntrada;
    }
    public void run(){
        try{
            String respuesta;
            respuesta = fEntrada.readLine();
            while(respuesta != null && !respuesta.equals("FIN")){
                System.out.println("Recibido: " + respuesta);
                texto.setText(texto.getText() + respuesta + "\n");
                respuesta = fEntrada.readLine();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
