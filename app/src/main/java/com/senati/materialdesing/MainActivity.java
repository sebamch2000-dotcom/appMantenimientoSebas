package com.senati.materialdesing;

import android.os.Bundle;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
//Realizamos las impportaciones
import android.view.View;
import android.widget.*;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //Declaramos las variables
    private EditText txtCodigo, txtNombre, txtCelular, txtSueldo, txtDni;
    private Button btnGrabar;
    private ListView listEmpleados;
    ArrayList<Empleado> lista = new ArrayList<>();
    ArrayAdapter<Empleado> adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        //Implementacion de codigo : Funcionamiento del Mantenimiento de Java
        txtCodigo = findViewById(R.id.txtCodigo);
        txtNombre = findViewById(R.id.txtNombre);
        txtCelular = findViewById(R.id.txtCelular);
        txtSueldo = findViewById(R.id.txtSueldo);
        txtDni = findViewById(R.id.txtDni);
        btnGrabar = findViewById(R.id.btnGrabar);
        listEmpleados = findViewById(R.id.listEmpleados);
        adaptador = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, lista);
        listEmpleados.setAdapter(adaptador);

        // Inicio Boton Grabar
        btnGrabar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String codigo = txtCodigo.getText().toString();
                String nombre = txtNombre.getText().toString();
                String celular = txtCelular.getText().toString();
                String sueldoStr = txtSueldo.getText().toString();
                String dni = txtDni.getText().toString();
                if(codigo.isEmpty() || nombre.isEmpty() || celular.isEmpty() || sueldoStr.isEmpty() || dni.isEmpty()){
                    Toast.makeText(MainActivity.this, "Complete todos los campos", Toast.LENGTH_SHORT).show();
                    return;
                }
                double sueldo = Double.parseDouble(sueldoStr);
                Empleado emp = new Empleado(codigo, nombre, celular, sueldo, dni);
                lista.add(emp);
                adaptador.notifyDataSetChanged();
                // Limpiar campos
                txtCodigo.setText("");
                txtNombre.setText("");
                txtCelular.setText("");
                txtSueldo.setText("");
                txtDni.setText("");
                txtCodigo.requestFocus();
                Toast.makeText(MainActivity.this, "Empleado grabado", Toast.LENGTH_SHORT).show();
            }
        });
        //Fin Boton Grabar
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}