package com.wmartinez.devep.petagram;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Mascota> mascotas;
    private RecyclerView rvMascotas, listaMascotas;
    public MascotaAdaptador adaptador;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Como cre una actionbar la debo declarar donde la este utilizando
        Toolbar miActionBar = (Toolbar)findViewById(R.id.miActionBar) ;
        setSupportActionBar(miActionBar);

        listaMascotas   = (RecyclerView)findViewById(R.id.rvMascotas);
        rvMascotas      = (RecyclerView)findViewById(R.id.rvMascotas);

        final LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(llm);
        inicializarListaMascotas();
        inicializarAdaptador();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_activity_bar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.actionLike:
                Toast.makeText(this, "Los cinco preferidos", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, SegundaActivity.class);
                startActivity(intent);
                return true;
            default:
                return true;
        }
    }

    public void inicializarAdaptador(){
        //ContactoAdaptador adaptador = new ContactoAdaptador(contactos);
        //listaContactos.setAdapter(adaptador);
        adaptador = new MascotaAdaptador(mascotas, this);
        rvMascotas.setAdapter(adaptador);
    }

    public void  inicializarListaMascotas(){
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota("Sack", 4 ,R.drawable.perro));
        mascotas.add(new Mascota("Ander", 2 ,R.drawable.perro2));
        mascotas.add(new Mascota("Aro", 3 ,R.drawable.perro3));
        mascotas.add(new Mascota("Bego", 2 ,R.drawable.perro4));
        mascotas.add(new Mascota("Barbie", 2 ,R.drawable.gata));
        mascotas.add(new Mascota("Ergo", 5 ,R.drawable.gato));
        mascotas.add(new Mascota("Bob", 5 ,R.drawable.pajaro));
    }
}
