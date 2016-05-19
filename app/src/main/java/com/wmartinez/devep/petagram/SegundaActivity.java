package com.wmartinez.devep.petagram;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import java.util.ArrayList;

public class SegundaActivity extends AppCompatActivity {

    ArrayList<Mascota> mascotas;
    private RecyclerView rvMascotas1, listaMascotas;
    public MascotaAdaptador adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

        Toolbar miActionBar = (Toolbar)findViewById(R.id.miActionBar) ;
        setSupportActionBar(miActionBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listaMascotas   = (RecyclerView)findViewById(R.id.rvLikeMascotas);
        rvMascotas1      = (RecyclerView)findViewById(R.id.rvLikeMascotas);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(llm);
        inicializarListaMascotas2();
        inicializarAdaptador2();
        Toast.makeText(this, "Segunda Activity", Toast.LENGTH_SHORT).show();

    }

    public void inicializarAdaptador2(){
        adaptador = new MascotaAdaptador(mascotas, this);
        rvMascotas1.setAdapter(adaptador);
    }

    public void  inicializarListaMascotas2(){
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota("Sack", 4 ,R.drawable.perro));
        mascotas.add(new Mascota("Ergo", 5 ,R.drawable.gato));
        mascotas.add(new Mascota("Bob", 5 ,R.drawable.pajaro));
        mascotas.add(new Mascota("Aro", 3 ,R.drawable.perro3));
        mascotas.add(new Mascota("Ander", 2 ,R.drawable.perro2));
    }
}
