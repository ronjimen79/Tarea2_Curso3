package com.ronicode.tarea2_curso3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ConfirmacionDatos extends AppCompatActivity {

    private Button btnEditar;
    private TextView tvNombre;
    private TextView tvFecha;
    private TextView tvTelefono;
    private TextView tvEmail;
    private TextView tvDescripcion;

    private String nombre;
    private String fecha;
    private String telefono;
    private String email;
    private String descripcion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmacion_datos);

        tvNombre = (TextView) findViewById(R.id.tvNombre);
        tvFecha = (TextView) findViewById(R.id.tvFecha);
        tvTelefono = (TextView) findViewById(R.id.tvTelefono);
        tvEmail = (TextView) findViewById(R.id.tvEmail);
        tvDescripcion = (TextView) findViewById(R.id.tvDescripcion);

        Bundle parametros = getIntent().getExtras();
        if (parametros != null){
            nombre = parametros.getString(getResources().getString(R.string.pnombre));
            fecha = parametros.getString(getResources().getString(R.string.pfecha));
            telefono = parametros.getString(getResources().getString(R.string.ptelefono));
            email = parametros.getString(getResources().getString(R.string.pemail));
            descripcion = parametros.getString(getResources().getString(R.string.pdescripcion));

            tvNombre.setText(nombre);
            tvFecha.setText(getResources().getString(R.string.abrirFecha) + " " + fecha);
            tvTelefono.setText(getResources().getString(R.string.abrirTel) + " " + telefono);
            tvEmail.setText(getResources().getString(R.string.abrirEmail) + " " + email);
            tvDescripcion.setText(getResources().getString(R.string.abrirDescripcion) + " " + descripcion);
        }

        btnEditar = (Button) findViewById(R.id.btnEditar);
        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ConfirmacionDatos.this, MainActivity.class);

                i.putExtra(getResources().getString(R.string.pnombre), nombre);
                i.putExtra(getResources().getString(R.string.pfecha), fecha);
                i.putExtra(getResources().getString(R.string.ptelefono), telefono);
                i.putExtra(getResources().getString(R.string.pemail), email);
                i.putExtra(getResources().getString(R.string.pdescripcion), descripcion);

                startActivity(i);
                finish();

            }
        });
    }
}
