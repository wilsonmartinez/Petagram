package com.wmartinez.devep.petagram;

import android.app.Activity;
import android.content.Intent;
import android.renderscript.Element;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by WilsonMartinez on 5/18/2016.
 */
public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder> {
    ArrayList<Mascota> mascotas;
    Activity activity;
    public int puntos;

    public MascotaAdaptador(ArrayList<Mascota> mascotas, Activity activity) {
        this.mascotas = mascotas;
        this.activity = activity;
    }

    //Infrar el layuot y lo pasara al viewHolder para que obtenga los views

    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Inflar o darle vida al Layout cardview_contactos.xml (asociarlo al RecyclerView del Activity_Main)
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota, parent, false);

        return new MascotaViewHolder(view);
    }
    //Asocia cada elemento de la lista con cada view
    @Override
    public void onBindViewHolder(final MascotaViewHolder mascotaViewHolder, int position) {
        //Pasar la lista de contactos ArrayList<Contacto> contactos; a cada elemento
        final Mascota mascota = mascotas.get(position);
        mascotaViewHolder.imgFotoCV.setImageResource(mascota.getFoto());
        mascotaViewHolder.tvNombreCV.setText(mascota.getNombre());
        mascotaViewHolder.tvPuntosCV.setText(String.valueOf(mascota.getPuntuacion()));
        /*
        mascotaViewHolder.imgFotoCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, mascota.getNombre(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(activity, SegundaActivity.class);
                intent.putExtra("nombre", mascota.getNombre());
                intent.putExtra("puntos", mascota.getPuntuacion());
                activity.startActivity(intent);
            }
        });*/

        mascotaViewHolder.imgBtnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, "Diste Like a " + mascota.getNombre(), Toast.LENGTH_SHORT).show();
                puntos = mascota.getPuntuacion() + 1;
                mascotaViewHolder.tvPuntosCV.setText(String.valueOf(puntos));
            }
        });
    }


    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder {
        //Declarar todos los view ubicados en el cardview_contacto.xml
        private ImageView imgFotoCV;
        private TextView tvNombreCV;
        private TextView tvPuntosCV;
        private ImageButton imgBtnLike;

        public MascotaViewHolder(View itemView) {
            super(itemView);
            //Asociar los objetos con su respectivo View:
            imgFotoCV = (ImageView) itemView.findViewById(R.id.imgFotoCV);
            tvNombreCV = (TextView) itemView.findViewById(R.id.tvNombreCV);
            tvPuntosCV = (TextView) itemView.findViewById(R.id.tvPuntosCV);
            imgBtnLike = (ImageButton) itemView.findViewById(R.id.imgBtnLike);
        }
    }
}
