package com.example.sql_martalainez;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText et1;
    private EditText et2;
    private EditText et3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         et1 = findViewById(R.id.et1);
         et2 = findViewById(R.id.et2);
         et3 = findViewById(R.id.et3);
    }
    public void alta(View view){
        int codigo = Integer.parseInt(et1.getText().toString());
        String descripcion = et2.getText().toString();
        Double precio = Double.parseDouble(et3.getText().toString());

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"administracion", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("codigo",codigo);
        contentValues.put("descripcion",descripcion);
        contentValues.put("precio",precio);

        bd.insert("articulos", null, contentValues);
        bd.close();
        et1.setText("");
        et2.setText("");
        et3.setText("");
        Toast.makeText(this, "Alta de datos se efectuó en forma correcta", Toast.LENGTH_LONG).show();
    }
    public void consultaPorCodigo(View v) {
        int codigo = 0;
        codigo = Integer.parseInt(et1.getText().toString());
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String sentenciaSQL = "SELECT descripcion, precio FROM articulos WHERE codigo = " + codigo;
        Cursor fila = bd.rawQuery(sentenciaSQL, null);
        if (fila.moveToFirst()) {
            et2.setText(fila.getString(0));
            et3.setText(fila.getString(1));
        } else{
            Toast.makeText(this, "No existe un artículo con dicho código",Toast.LENGTH_SHORT).show(); }
        bd.close();
    }
    public void consultaPorDescripcion(View v) {
        String descripcion = et2.getText().toString();
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String sentenciaSQL = "SELECT codigo, precio FROM articulos WHERE descripcion = \"" + descripcion + "\"";
        Cursor fila = bd.rawQuery(sentenciaSQL, null);
        if (fila.moveToFirst()) {
            et1.setText(fila.getString(0));
            et3.setText(fila.getString(1));
        } else{
            Toast.makeText(this, "No existe un artículo con dicha descripcion",Toast.LENGTH_SHORT).show(); }
        bd.close();
    }

    public void bajaporCodigo(View v) {
        String codigo = "";
        codigo = et1.getText().toString(); //valor del campo de texto codigo;
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,
                "administracion", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        int cant = bd.delete("articulos", "codigo = " + codigo, null);
        bd.close();
        //borrar los campos de texto de la vista
        et1.setText("");
        et2.setText("");
        et3.setText("");
        //notificar sí se han borrado los datos o si por el contrario dicho código no existe
        if(cant == 1){
            Toast.makeText(this, "Registro borrado",Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "El registro no se ha borrado",Toast.LENGTH_SHORT).show();
        }
    }
    public void modificacion(View v) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,
                "administracion", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        //recoger datos de la vista
        int codigo = Integer.parseInt(et1.getText().toString());
        String descripcion = et2.getText().toString();
        Double precio = Double.parseDouble(et3.getText().toString());
        //crear objeto ContentValues
        ContentValues contentValues = new ContentValues();
        contentValues.put("codigo",codigo);
        contentValues.put("descripcion",descripcion);
        contentValues.put("precio",precio);
        //almacenar los datos recogidos
        int cant = bd.update("articulos", contentValues, "codigo = " + codigo, null);
        bd.close();
        //notificar sí se han borrado los datos o si por el contrario dicho código no existe
        if(cant == 1){
            Toast.makeText(this, "Registro actualizado",Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "El registro no se ha actualizado",Toast.LENGTH_SHORT).show();
        }
    }

}