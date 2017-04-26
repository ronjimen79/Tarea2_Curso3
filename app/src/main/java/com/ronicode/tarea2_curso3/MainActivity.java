package com.ronicode.tarea2_curso3;

import android.app.DialogFragment;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private Button btnSiguiente;
    private EditText etNombre;
    private TextView tvFecha;
    private EditText etTelefono;
    private EditText etEmail;
    private EditText etDescripcion;

    private String nombre;
    private String fecha;
    private String telefono;
    private String email;
    private String descripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSiguiente = (Button) findViewById(R.id.btnSiguiente);
        etNombre = (EditText) findViewById(R.id.etNombre);
        tvFecha = (TextView) findViewById(R.id.tvFecha);
        etTelefono = (EditText) findViewById(R.id.etTelefono);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etDescripcion = (EditText) findViewById(R.id.etDescripcion);

        Bundle parametros = getIntent().getExtras();
        if (parametros != null){
            nombre = parametros.getString(getResources().getString(R.string.pnombre));
            fecha = parametros.getString(getResources().getString(R.string.pfecha));
            telefono = parametros.getString(getResources().getString(R.string.ptelefono));
            email = parametros.getString(getResources().getString(R.string.pemail));
            descripcion = parametros.getString(getResources().getString(R.string.pdescripcion));

            etNombre.setText(nombre);
            tvFecha.setText(fecha);
            etTelefono.setText(telefono);
            etEmail.setText(email);
            etDescripcion.setText(descripcion);
        }

        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, ConfirmacionDatos.class);

                i.putExtra(getResources().getString(R.string.pnombre), etNombre.getText().toString());
                i.putExtra(getResources().getString(R.string.pfecha), tvFecha.getText().toString());
                i.putExtra(getResources().getString(R.string.ptelefono), etTelefono.getText().toString());
                i.putExtra(getResources().getString(R.string.pemail), etEmail.getText().toString());
                i.putExtra(getResources().getString(R.string.pdescripcion), etDescripcion.getText().toString());

                startActivity(i);
                finish();
            }
        });
    }

    public void showDatePickerDialog (View v){
        DialogFragment newFragment = new Calendario();
        newFragment.show(getFragmentManager(), "datePicker");
    }

}
