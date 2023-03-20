package com.example.ud214_marta;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.TaskStackBuilder;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private LayoutInflater inflater;
    private View layout;
    private ImageView image;
    private TextView text;
    private NotificationManager notificador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Para el boton 4
        Button boton = (Button) findViewById(R.id.button4);
        notificador = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                notification(
                        1,
                        android.R.drawable.stat_sys_warning,
                        "Notificación personalizada c:",
                        "En proceso, ¡espere por favor!"
                );
            }
        });
    }
    // Ejercicio 1
    public void onClick1(View view){
        inflater = getLayoutInflater();
        layout = inflater.inflate(R.layout.toast_layout,(ViewGroup) findViewById(R.id.layoutToast));
        image = (ImageView) layout.findViewById(R.id.iv);
        image.setImageResource(R.drawable.frenchtoast);
        text = (TextView) layout.findViewById(R.id.tv2);
        text.setText("Holi este es mi toast personalizado");
        // Crea el toast
        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 150);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();
    }
    // Ejercicio 2
    public void onClick2(View view){
        final Calendar calen = Calendar.getInstance();
        int year = calen.get(Calendar.YEAR);
        int month = calen.get(Calendar.MONTH);
        int day = calen.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog fecha = new DatePickerDialog(this,new DatePickerDialog.OnDateSetListener(){
            public void onDateSet(DatePicker view,int year, int monthOfYear, int dayOfMonth){
                Toast notification = Toast.makeText(getApplicationContext(), "Fecha: " + dayOfMonth+1 + "/"
                        + monthOfYear + "/" + year, Toast.LENGTH_LONG);
                notification.setGravity(Gravity.TOP|Gravity.LEFT,250,0);
                notification.show();
            }
        }, year, month, day);
        fecha.show();
    }
    // Ejercicio 3
    public void onClick3(View view){
        final Calendar calen = Calendar.getInstance();
        int hour = calen.get(Calendar.HOUR_OF_DAY);
        int minute = calen.get(Calendar.MINUTE);
        TimePickerDialog hora = new TimePickerDialog(this,new TimePickerDialog.OnTimeSetListener(){
            public void onTimeSet(TimePicker view,int hourOfDay,int minute){
                Toast notification = Toast.makeText(getApplicationContext(), "Hora: " + hourOfDay + ":"
                        + minute , Toast.LENGTH_LONG);
                notification.setGravity(Gravity.TOP|Gravity.LEFT,250,0);
                notification.show();
            }
        },hour,minute,false);
        hora.show();
    }
    // Intento del ejercicio4, pno funciona :(
    public void onClick4(View view){
        notificador = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "Canal_ID")
                .setSmallIcon(android.R.drawable.stat_sys_warning)
                .setLargeIcon((((BitmapDrawable)getResources().getDrawable(R.mipmap.ic_launcher)).getBitmap()))
                .setContentTitle("ALERTAAAAAA")
                .setContentText("Ejemplo de notificacion")
                .setTicker("Aviso de notificacion");
        //TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        //stackBuilder.addParentStack(Notification.class);

        notificador.notify(1,builder.build());
        //builder.setFullScreenIntent()
    }
    // Ejercicio 4
    public void notification(final int id, int iconId, String titulo, String contenido) {

        final NotificationCompat.Builder builder =
                (NotificationCompat.Builder) new NotificationCompat.Builder(this)
                        .setSmallIcon(iconId)
                        .setLargeIcon(BitmapFactory.decodeResource(
                                        getResources(),
                                        R.mipmap.ic_launcher
                                )
                        )
                        .setContentTitle(titulo)
                        .setContentText(contenido)
                        .setColor(getResources().getColor(R.color.purple_700));

        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        int i;
                        // SIMULACIÓN DEL PROGRESO
                        for (i = 0; i <= 50; i += 5) {
                            // PONER 100 COMO MEDIDA MÁXIMA
                            builder.setProgress(100, i, false);
                            // Emitir la notificación
                            notificador.notify(id, builder.build());
                            // CREAR RETARDO DEL HILO
                            try {
                                // DEMORA 1 SEGUNDO
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                Log.d("ERROR", "Falló sleep(1000) ");
                            }
                        }
                        //ACTUALIZACIÓN DE LA NOTIFICACION
                        // INFORMAR DE FIN DE PROCESO
                        builder.setContentText("¡Proceso terminado! Gracias")
                                // ELIINAR BARRA DE PROGRESO
                                .setProgress(0, 0, false);
                        notificador.notify(id, builder.build());
                    }
                }
        ).start();
    }
    // Ejercicio 5
    public AlertDialog dialogo(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        // Add the buttons
        builder.setTitle("Haz click en 'ok' o en 'cancelar'");
        builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                Toast.makeText(getApplicationContext(),"Click en 'Ok'",Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                Toast.makeText(getApplicationContext(),"Click en 'Cancel'",Toast.LENGTH_SHORT).show();
            }
        });
        // Create the AlertDialog
        AlertDialog dialog = builder.create();
        return dialog;
    }
    public void onClick5(View view){
        dialogo().show();
    }
}