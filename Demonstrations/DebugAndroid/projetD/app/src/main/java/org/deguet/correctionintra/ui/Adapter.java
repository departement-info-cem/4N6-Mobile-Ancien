package org.deguet.correctionintra.ui;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import org.deguet.correctionintra.R;
import org.deguet.correctionintra.http.Anniv;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {
    public List<Anniv> list;

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public LinearLayout layout;
        public MyViewHolder(LinearLayout v) {
            super(v);
            layout = v;
        }
    }

    public Adapter() { list = new ArrayList<>(); }

    @Override
    public Adapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                         int viewType) {
        LinearLayout v = (LinearLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        Anniv anniv = list.get(position);
        TextView annee = holder.layout.findViewById(R.id.tvAnnee);
        annee.setText(anniv.annee+"");

        TextView mois = holder.layout.findViewById(R.id.tvMois);
        mois.setText(anniv.mois+"");

        TextView jour = holder.layout.findViewById(R.id.tvJour);
        jour.setText(anniv.jour+"");

        TextView jourSemaine = holder.layout.findViewById(R.id.tvJourSemaine);
        jourSemaine.setText(anniv.jourDeLaSemaine);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}