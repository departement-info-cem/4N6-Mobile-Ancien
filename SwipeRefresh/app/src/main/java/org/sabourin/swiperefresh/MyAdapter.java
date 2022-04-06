package org.sabourin.swiperefresh;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{

        public List<String> maListe;

        public static class MyViewHolder extends RecyclerView.ViewHolder {
            private final TextView textView;

            public MyViewHolder(View view) {
                super(view);
                textView = (TextView) view.findViewById(R.id.textView);
            }

        }

        public MyAdapter() {
            maListe = new ArrayList<>();
        }

        @Override
        public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LinearLayout v = (LinearLayout) LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item, parent, false);
            MyViewHolder vh = new MyViewHolder(v);

            return vh;
        }


        @Override
        public void onBindViewHolder(MyViewHolder holder, final int position) {

            holder.textView.setText(maListe.get(position));
        }

        @Override
        public int getItemCount() {
            return maListe.size();
        }
}

