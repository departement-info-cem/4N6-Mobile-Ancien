package org.sabourin.swiperefresh;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class TrucAdapteur extends RecyclerView.Adapter<TrucAdapteur.MyViewHolder> {
    public List<Truc> list;

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView tvNom;
        public MyViewHolder(LinearLayout v) {
            super(v);
            tvNom = v.findViewById(R.id.tv);
        }
    }

    public TrucAdapteur() {
        list = new ArrayList<>();
    }

    @Override
    public TrucAdapteur.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                     int viewType) {
        // create a new view
        LinearLayout v = (LinearLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        Log.i("DEBOGAGE", "appel a onCreateViewHolder");
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Truc courant = list.get(position);
        holder.tvNom.setText(courant.b+ "  " +courant.c.size() + " " + courant.a);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}